

pragma solidity ^0.8.0;

/// @title Asset
/// @dev Store & retrieve value of a property

contract ImmobillierContract {
    address public creatorAdmin;
    enum Status {NotExist, Pending, Approved, Rejected}
    enum Role {Visitor, User, Admin, SuperAdmin}

    // Struct to store all property related details
    struct PropertyDetail {
        Status status;
        string value;
        address currOwner;
    }

    mapping(string => PropertyDetail) public properties; // Stores all properties propId -> property Detail
    mapping(string => address) public propOwnerChange; // Keeps track of property owner propId -> Owner Address
    mapping(address => Role) public userRoles; // Keeps track of user roles
    mapping(address => bool) public verifiedUsers; // Keeps track of verified user, userId -> verified (true / false)

    // Modifier to ensure only the property owner access
    // a specific property
    modifier onlyOwner(string memory _propId) {
        require(properties[_propId].currOwner == msg.sender);
        _;
    }

    // Modifier to ensure only the verified user access
    // a specific property
    modifier verifiedUser(address _user) {
        require(verifiedUsers[_user]);
        _;
    }

    // Modifier to ensure only the verified admin access a function
    modifier verifiedAdmin() {
        require(
            userRoles[msg.sender] >= Role.Admin && verifiedUsers[msg.sender]
        );
        _;
    }

    // Modifier to ensure only the verified super admin admin access a function
    modifier verifiedSuperAdmin() {
        require(
            userRoles[msg.sender] == Role.SuperAdmin &&
            verifiedUsers[msg.sender]
        );
        _;
    }

    // Initializing the Contract.
    constructor() public {
        creatorAdmin = msg.sender;
        userRoles[creatorAdmin] = Role.SuperAdmin;
        verifiedUsers[creatorAdmin] = true;
    }

    /// @dev Function to create property
    /// @param _propId Identifier for property
    /// @param _value Property Price
    /// @param _owner Ownwe address property
    function createProperty(
        string memory _propId,
        string memory _value,
        address _owner
    ) external verifiedAdmin verifiedUser(_owner) returns (bool) {
        properties[_propId] = PropertyDetail(Status.Pending, _value, _owner);
        return true;
    }

    /// @dev Approve property
    /// @param _propId Identifier for property
    function approveProperty(string memory _propId)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(properties[_propId].currOwner != msg.sender);
        properties[_propId].status = Status.Approved;
        return true;
    }

    /// @dev Function to reject property
    /// @param _propId Identifier for property
    function rejectProperty(string memory _propId)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(properties[_propId].currOwner != msg.sender);
        properties[_propId].status = Status.Rejected;
        return true;
    }

    /// @dev Function to change property ownership
    /// @param _propId Identifier for property
    /// @param _newOwner new Owner address for property
    function changeOwnership(string memory _propId, address _newOwner)
    external
    onlyOwner(_propId)
    verifiedUser(_newOwner)
    returns (bool)
    {
        require(properties[_propId].currOwner != _newOwner);
        require(propOwnerChange[_propId] == address(0));
        propOwnerChange[_propId] = _newOwner;
        return true;
    }

    /// @dev Function to approve change of ownership
    /// @param _propId Identifier for property
    function approveChangeOwnership(string memory _propId)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(propOwnerChange[_propId] != address(0));
        properties[_propId].currOwner = propOwnerChange[_propId];
        propOwnerChange[_propId] = address(0);
        return true;
    }

    /// @dev Function to change property value
    /// @param _propId Identifier for property
    /// @param _newValue New Property Price
    function changeValue(string memory _propId, string memory _newValue)
    external
    onlyOwner(_propId)
    returns (bool)
    {
        require(propOwnerChange[_propId] == address(0));
        properties[_propId].value = _newValue;
        return true;
    }

    /// @dev Function to create property
    /// @param _propId Identifier for property
    function getPropertyDetails(string memory _propId)
    public
    view
    returns (
        Status,
        string memory,
        address
    )
    {
        return (
        properties[_propId].status,
        properties[_propId].value,
        properties[_propId].currOwner
        );
    }

    /// @dev Function to add a new user
    /// @param _newUser new user address
    function addNewUser(address _newUser)
    external
    verifiedAdmin
    returns (bool)
    {
        require(userRoles[_newUser] == Role.Visitor);
        require(verifiedUsers[_newUser] == false);
        userRoles[_newUser] = Role.User;
        return true;
    }

    /// @dev Function to add a new admin
    /// @param _newAdmin new admin user address
    function addNewAdmin(address _newAdmin)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(userRoles[_newAdmin] == Role.Visitor);
        require(verifiedUsers[_newAdmin] == false);
        userRoles[_newAdmin] = Role.Admin;
        return true;
    }

    /// @dev Function to add a new admin
    /// @param _newSuperAdmin new super admin user address
    function addNewSuperAdmin(address _newSuperAdmin)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(userRoles[_newSuperAdmin] == Role.Visitor);
        require(verifiedUsers[_newSuperAdmin] == false);
        userRoles[_newSuperAdmin] = Role.SuperAdmin;
        return true;
    }

    /// @dev Function to add a new admin
    /// @param _newUser user address to approve
    function approveUsers(address _newUser)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(userRoles[_newUser] != Role.Visitor);
        verifiedUsers[_newUser] = true;
        return true;
    }
}

pragma solidity ^0.8.0;


contract ImmobilierContract {
    address public creatorAdmin;
    enum Status {NotExist, Pending, Approved, Rejected}
    enum Role {Visitor, User, Admin, SuperAdmin}
    uint public totalImmobilierCounter;
    uint public totalApprovedImmobilierCounter;

    // Struct to store all property related details
    struct ImmobilierDetail {
        Status status;
        uint256 price;
        string location;
        string category;
        bool forSell;
        address currOwner;
    }

    mapping(uint256 => ImmobilierDetail) public immobiliers; // Stores all properties propId -> property Detail
    mapping(uint256 => address) public immoOwnerChange; // Keeps track of property owner propId -> Owner Address
    mapping(address => Role) public userRoles; // Keeps track of user roles
    mapping(address => bool) public verifiedUsers; // Keeps track of verified user, userId -> verified (true / false)

    // Modifier to ensure only the property owner access
    // a specific property
    modifier onlyOwner(uint256 _immoId) {
        require(immobiliers[_immoId].currOwner == msg.sender);
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
        totalImmobilierCounter = 0;
        totalApprovedImmobilierCounter=0;
    }


    function createImmobilier(
        uint256 _immoId,
        uint256 _price,
        string memory _location,
        string memory _category,
        address _owner
    ) external verifiedAdmin verifiedUser(_owner) returns (bool) {
        immobiliers[_immoId] = ImmobilierDetail(Status.Pending, _price,_location,_category,false,_owner);
        totalImmobilierCounter=totalImmobilierCounter+1;
        return true;
    }

    function approveImmobilier(uint256 _immoId)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(immobiliers[_immoId].currOwner != msg.sender);
        immobiliers[_immoId].status = Status.Approved;
        totalApprovedImmobilierCounter = totalApprovedImmobilierCounter+1;
        return true;
    }


    function rejectImmobilier(uint256 _immoId)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(immobiliers[_immoId].currOwner != msg.sender);
        immobiliers[_immoId].status = Status.Rejected;
        totalImmobilierCounter = totalImmobilierCounter-1;
        return true;
    }


    function changeOwnership(uint256 _immoId, address _newOwner)
    external
    onlyOwner(_immoId)
    verifiedUser(_newOwner)
    returns (bool)
    {
        require(immobiliers[_immoId].currOwner != _newOwner);
        require(immoOwnerChange[_immoId] == address(0));
        immoOwnerChange[_immoId] = _newOwner;
        return true;
    }


    function approveChangeOwnership(uint256 _immoId)
    external
    verifiedSuperAdmin
    returns (bool)
    {
        require(immoOwnerChange[_immoId] != address(0));
        immobiliers[_immoId].currOwner = immoOwnerChange[_immoId];
        immoOwnerChange[_immoId] = address(0);
        return true;
    }


    function changePrice(uint256 _immoId, uint256 _newPrice)
    external
    onlyOwner(_immoId)
    returns (bool)
    {
        require(immoOwnerChange[_immoId] == address(0));
        immobiliers[_immoId].price = _newPrice;
        return true;
    }
    function changeCategory(uint256 _immoId, string memory _newCategory)
    external
    onlyOwner(_immoId)
    returns (bool)
    {
        require(immoOwnerChange[_immoId] == address(0));
        immobiliers[_immoId].category = _newCategory;
        return true;
    }



    function getImmobilierDetails(uint256 _immoId)
    public
    view
    returns (
        Status,
        uint256,
        string memory,
        string memory,
        bool,
        address
    )
    {
        return (
        immobiliers[_immoId].status,
        immobiliers[_immoId].price,
        immobiliers[_immoId].location,
        immobiliers[_immoId].category,
        immobiliers[_immoId].forSell,
        immobiliers[_immoId].currOwner
        );
    }


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

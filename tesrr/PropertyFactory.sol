pragma solidity ^0.8.0;
// pragma experimental ABIEncoderV2;

contract PropertyFactory {

    struct Property {
        uint256 price; // en wei
        uint256 size;
        string geoAddress;
        string description;
        string documents;
        uint256 nbRooms;
        bool selling;
        address payable owner;
    }

    Property[] public properties;

    // mettre en vente (non adapté de renvoyer un objet)
    function post(uint256 _price, uint256 _size, string calldata _geoAddress,
        string calldata _description, string calldata _documents, uint256 _nbRooms) external {
        properties.push(Property(
                _price,
                _size,
                _geoAddress,
                _description,
                _documents,
                _nbRooms,
                true,
                    payable(msg.sender)
            ));
    }

    // achat d'une property
    function buy(uint256 _propertyId) external payable {
        require(msg.value == properties[_propertyId].price, "Erreur prix"); // vérif
        properties[_propertyId].owner.transfer(msg.value); // transfert
        properties[_propertyId].owner = payable(msg.sender); // changement proprio
        properties[_propertyId].selling = false; // plus en vente
    }

    function getNbProperties() external view returns (uint) {
        return properties.length;
    }

    function clearAllProperties() external {
        delete properties;
    }
}

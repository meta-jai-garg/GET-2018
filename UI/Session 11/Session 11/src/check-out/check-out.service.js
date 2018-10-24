(function () {
    angular
        .module('GroceryStore')
        .factory("CheckOut", ["$http", function ($http) {

            /**
             * function to save checkout details
             * 
             * @param {string} name 
             * @param {string} address 
             * @param {string} city 
             * @param {Cart} Cart 
             */
            var save = function (name, address, city, Cart) {
                var cart = Cart.getItem();
                var itemIds = [];
                var itemQuantity = [];

                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth() + 1; //January is 0!

                var yyyy = today.getFullYear();
                today = dd + '-' + mm + '-' + yyyy;

                for (var item in cart) {
                    itemIds.push(cart[item].id);
                    itemQuantity.push(cart[item].quantity);
                }

                var order = {
                    name: name,
                    address: address,
                    city: city,
                    date: today,
                    itemId: itemIds,
                    quantity: itemQuantity
                };

                return $http({
                    method: 'POST',
                    url: 'http://localhost:3001/orders',
                    data: order,
                    dataType: 'application/json'
                });
            };

            return {
                "save": save
            };
        }]);
}());
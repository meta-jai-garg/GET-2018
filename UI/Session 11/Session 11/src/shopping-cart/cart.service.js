(function () {
    angular
        .module('GroceryStore')
        .factory("Cart", ["Item", "$http", function (Item, $http) {
            var cartItem = {};
            var cartItemCount = 0;
            var itemsInStore = Item.getItems();


            $http.get('http://localhost:3000/cart').then(function (response) {

                response.data.forEach(data => {
                    cartItem[data.id] = data;
                    cartItemCount += data.quantity;
                });
            });

            /**
             * function to insert item into cart
             * 
             * @param {number} id of item 
             */
            var insert = function (id) {
                var method;
                if (!cartItem[id]) {
                    cartItem[id] = { id: id, quantity: 1 };
                    method = "POST";
                } else {
                    cartItem[id].quantity++;
                    method = "PUT";
                }
                $http({
                    method: method,
                    url: 'http://localhost:3000/cart/' + (cartItem[id].quantity > 1 ? ("/" + id) : ""),
                    data: cartItem[id],
                    dataType: 'json'
                });
                cartItemCount++;
            };

            /**
             * function to remove item from cart
             * @param {number} id of item
             */
            var remove = function (id) {
                var method;
                var item;
                cartItem[id].quantity--;
                if (!cartItem[id].quantity) {
                    delete cartItem[id];
                    method = "DELETE";
                } else {
                    method = "PUT";
                    item = cartItem[id];
                }
                $http({
                    method: method,
                    url: 'http://localhost:3000/cart/' + id,
                    data: item,
                    dataType: 'json'
                });
                cartItemCount--;
            };

            /**
             * Function to get quantity of item
             * @param {number} id of item 
             */
            var getQuantity = function (id) {
                if (cartItem[id]) {
                    return cartItem[id].quantity;
                } else {
                    return 0;
                }
            };

            /**
             * function to get total price of cart
             */
            var getTotalPrice = function () {
                var totalPrice = 0;
                for (var id in cartItem) {
                    totalPrice += cartItem[id].quantity * itemsInStore[id].price;
                }
                return totalPrice;
            };

            /**
             * function to empty the cart
             */
            var empty = function () {
                totalPrice = 0;
                cartItemCount = 0;
                for (var i in cartItem) {
                    $http.delete('http://localhost:3000/cart/' + cartItem[i].id);
                }
                cartItem = {};
            };

            return {
                "insert": insert,
                "getQuantity": getQuantity,
                "getCartCount": function () { return cartItemCount; },
                "getItem": function () { return cartItem; },
                "getTotalPrice": getTotalPrice,
                "remove": remove,
                "empty": empty
            };
        }]);
}());
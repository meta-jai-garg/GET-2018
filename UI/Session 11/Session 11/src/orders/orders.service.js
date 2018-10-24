(function () {
    angular
        .module('GroceryStore')
    .factory('Order', ['$http', 'Item', function ($http, Item) {

        var orderData = {};
        var orderDetail = {};
        var itemsInStore = Item.getItems();

        /**
         * function to populate orders
         */
        var orders = function () {
            $http.get('http://localhost:3001/orders').then(function (response) {
                response.data.forEach(data => {
                    orderData[data.id] = data;
                });
            });
            return orderData;
        };

        /**
         * function to get order by id
         * @param {number} id 
         */
        var getOrder = function (id) {
            orderDetail = {};
            var itemIds = orderData[id].itemId;
            var itemQuantity = orderData[id].quantity;

            for (var i = 0; i < itemIds.length; i++) {
                orderDetail[i] = {
                    id: itemIds[i],
                    quantity: itemQuantity[i]
                };
            }
            return orderData[id];
        };

        /**
         * function to get Total Price of Cart
         */
        var getTotalPrice = function () {
            var totalPrice = 0;
            for (var id in orderDetail) {
                totalPrice += orderDetail[id].quantity * itemsInStore[orderDetail[id].id].price;
            }
            return totalPrice;
        };

        /**
         * function to get quantity of item 
         * @param {number} id 
         */
        var getQuantity = function (id) {
            if (orderDetail[id]) {
                return orderDetail[id].quantity;
            } else {
                return 0;
            }
        };

        return {
            "orders": orders,
            "getOrder": getOrder,
            "getTotalPrice": getTotalPrice,
            "getQuantity": getQuantity,
            "getOrderDetail": function () { return orderDetail; }
        };
    }]);
}());
(function () {
    angular
        .module('GroceryStore')
        .factory("Item", ["$http", function ($http) {

            var items = {};

            $http.get('http://localhost:3000/items').then(function (response) {
                response.data.forEach(data => {
                    items[data.id] = data;
                });
            });

            /**
             * function to get items object
             */
            var getItems = function () {
                return items;
            };

            /**
             * function to get items as array
             */
            var getItemsArray = function () {
                return $http.get('http://localhost:3000/items').then(function (response) {
                    return response.data;
                });
            };

            /**
             * function to get categories
             */
            var getCategories = function () {
                return $http.get('http://localhost:3000/categories').then(function (response) {
                    return response.data;
                });
            };

            return {
                "getItems": getItems,
                "getItemsArray": getItemsArray,
                "getCategories": getCategories
            };
        }]);
}());
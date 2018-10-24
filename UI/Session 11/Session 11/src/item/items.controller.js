angular.module('GroceryStore').controller('mainController', ["$scope", "$routeParams", "Item", "Cart", function ($scope, $routeParams, Item, Cart) {

    $scope.cart = Cart;
    
    Item.getItemsArray().then(function (data) {
        $scope.items = data;
    });

    Item.getCategories().then(function (response) {
        $scope.categories = response;
    });

    $scope.addToCart = function (item) {
        console.log(item);
    };

    $scope.categoryName = $routeParams.categoryName;
}]);
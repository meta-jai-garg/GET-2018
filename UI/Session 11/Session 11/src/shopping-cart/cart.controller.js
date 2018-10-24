angular
    .module('GroceryStore')
    .controller('cartController', ["Cart", "Item", "$scope", function (Cart, Item, $scope) {
        $scope.cart = Cart;
        $scope.items = Item.getItems();
    }]);
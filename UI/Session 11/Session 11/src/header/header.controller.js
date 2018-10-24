/**
 * Controller for Header
 */

angular
    .module('GroceryStore')
    .controller('headerController', ["Cart", "$scope", function (Cart, $scope) {
        $scope.cart = Cart;
    }]);
angular
    .module('GroceryStore')
    .controller('checkOutController', ["Cart", "Item", "CheckOut", "$scope", "$window", function (Cart, Item, CheckOut, $scope, $window) {
        $scope.cart = Cart;
        $scope.items = Item.getItems();
        $scope.checkOut = CheckOut;
        $scope.placeOrder = function () {
            if ($scope.name === undefined && $scope.address1 === undefined && $scope.address2 === undefined && $scope.city === undefined) {
                return false;
            }
            $scope.checkOut.save($scope.name, $scope.address1 + ' ' + $scope.address2, $scope.city, $scope.cart).then(function () {
                Cart.empty();
                $window.location.href = "#!/order-success";
            });
            return true;
        };
    }]);
/**
 * order controller
 */
angular
	.module('GroceryStore')
	.controller('orderController', ['Item', 'Order', '$scope', function(Item, Order, $scope){
		$scope.orderData = Order;
		$scope.items = Item.getItems();
		$scope.orders = $scope.orderData.orders();
	}]);
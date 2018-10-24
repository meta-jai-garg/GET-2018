var app = angular.module("GroceryStore", ['ngRoute']);
/**
 * Routing Configuration
 */
app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: "src/item/items.template.html",
            controller: 'mainController'
        })
        .when('/category/:categoryName', {
            templateUrl: "src/item/items.template.html",
            controller: 'mainController'
        })
        .when('/shopping-cart', {
            templateUrl: "src/shopping-cart/cart.template.html",
            controller: 'cartController'
        })
        .when('/check-out', {
            templateUrl: 'src/check-out/check-out.template.html',
            controller: 'checkOutController'
        })
        .when('/order-success', {
            templateUrl: 'src/order-success/order-success.template.html'
        })
        .when('/admin/orders', {
            templateUrl: 'src/orders/orders.template.html',
            controller: 'orderController'
        });
});
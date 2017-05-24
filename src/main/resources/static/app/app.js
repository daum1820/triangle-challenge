angular.module('tradeshift', [
    'ngRoute',
    'tradeshift.components',
    'tradeshift.services',
    'tradeshift.controllers'
])

.config(function($routeProvider) {
    $routeProvider
        .when('/triangle', {
            templateUrl: 'app/views/triangle.html'
        })
        .otherwise(
            { redirectTo: '/triangle' }
        );
});

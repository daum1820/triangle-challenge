(function() {
    'use strict';

    var app = angular.module('tradeshift', ['ngRoute', 'ngResource']);

    app.config(function($routeProvider) {
        $routeProvider
            .when('/triangle', {
                templateUrl: '/views/triangle.html',
                controller : 'triangleController'
            })
            .otherwise(
                { redirectTo: '/triangle' }
            );
    });
})
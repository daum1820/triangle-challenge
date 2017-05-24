(function(angular) {
    'use strict';

    angular.module('tradeshift.services', [])
    .factory('triangleService',['$http', function($http) {

        return {
            //Build the Triangle Object as expected at the server side.
            build : function(sideOne, sideTwo, sideThree){
                return {
                    sides: [
                        {side : sideOne},
                        {side : sideTwo},
                        {side : sideThree},
                    ],
                }
            },

            //Call server side to validate the given triangle.
            checkTriangle : function(triangle){
               return $http.post('./triangle', triangle).then((response) => {
                   return Promise.resolve(response.data.message);
               },(response) => {
                   console.error(response);
                   return Promise.reject(response.data.message);
               });
            }
        };

    }]);
})(angular);


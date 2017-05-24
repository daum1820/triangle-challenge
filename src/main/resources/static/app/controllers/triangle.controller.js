(function(angular) {
    'use strict';

    angular.module('tradeshift.controllers', [])
    .controller('TriangleController', ['triangleService', '$timeout',
                                       function(triangleService, $timeout) {
        var vm = this;
        vm.state = {
            notifications : [],
            sideOne: null,
            sideTwo: null,
            sideThree: null,
        };

        vm.submit = function(form){
            form.$submitted = true;

            if(form.$valid){
                var triangle = triangleService.build(vm.state.sideOne,vm.state.sideTwo, vm.state.sideThree);
                triangleService.checkTriangle(triangle).then((response) => {
                    notify(response, 'success');
                    clearNotification(5000);
                    form.$submitted = false;
                }, (err) => {
                    notify(err, 'danger');
                    clearNotification(5000);
                    form.$submitted = false;
                });
            }
        };

        vm.clear = function(form){
            form.$submitted = false;
            vm.state = {
                notifications : [],
                sideOne: null,
                sideTwo: null,
                sideThree: null,
            };
        };

        function notify(message, type){
            vm.state.notifications.unshift({message, type});
        }

        function clearNotification(timeout){
            $timeout(function(){
                vm.state.notifications = [];
            }, timeout)
        }
    }]);

})(angular);


(function(angular) {
    'use strict';

    angular.module('tradeshift.controllers', [])
    .controller('TriangleController', ['triangleService', '$timeout',
                                       function(triangleService, $timeout) {
        var vm = this;

        //Controller initial state
        vm.state = {
            notifications : [],
            sideOne: null,
            sideTwo: null,
            sideThree: null,
            timeout: null
        };

        vm.submit = function(form){
            form.$submitted = true;
            if(form.$valid){

                //Check if exists some notification
                if(vm.state.timeout){
                    $timeout.cancel(vm.state.timeout);
                    clearNotification(0);
                }
                //Build triangle object to check.
                var triangle = triangleService.build(vm.state.sideOne,vm.state.sideTwo, vm.state.sideThree);
                triangleService.checkTriangle(triangle).then((response) => {
                    notify(response, 'success');
                    vm.state.timeout = clearNotification(5000);
                    form.$submitted = false;
                }, (err) => {
                    notify(err, 'danger');
                    vm.state.timeout = clearNotification(5000);
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
                timeout: null,
            };
        };

        function notify(message, type){
            vm.state.notifications.unshift({message, type});
        }

        function clearNotification(timeout){
            return $timeout(function(){
                vm.state.notifications = [];
                vm.state.timeout = null;
            }, timeout)
        }
    }]);

})(angular);


(function(angular) {
    'use strict';

    angular.module('tradeshift.components', [])
           .component('tdNotification', {
               templateUrl: 'app/components/notification.html',
               bindings   : {
                   notifications: '='
               }
           })
           .component('tdInputRequired', {
               templateUrl: 'app/components/input-required.html',
               bindings   : {
                   model: '=',
                   label: '<',
                   form:  '=',
               }
           });
})(angular);


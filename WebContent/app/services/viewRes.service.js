(function() {
    'use strict';

    angular
        .module('plunker')
        .service('viewResService', viewResService);

    viewResService.$inject = ['$q', '$http'];

    function viewResService($q, $http) {
        var self = this;

        self.getViewRes = getViewRes;
        self.getResById = getResById;
        self.updateRes = updateRes;
        
        //private members
        function getViewRes() {

            var defer = $q.defer();

            $http
                .get('http://localhost:8080/RestaurantReservation_RESTApp/api/reservations/')
                .then(successFn, errorFn);

            function successFn(response) {
                defer.resolve(response.data);
            }

            function errorFn(error) {
                defer.reject(error.statusText);
            }

            return defer.promise;
        }
        
        function getResById(resId) {
            var defer = $q.defer();

            $http
              .get('http://localhost:8080/RestaurantReservation_RESTApp/api/reservations/' + resId)
              .then(successFn, errorFn);

            function successFn(response) {
              defer.resolve(response.data);
            }

            function errorFn(error) {
              defer.reject(error.statusText);
            }

            return defer.promise;
          }
        
       
        
        function updateRes (confid) {
        	var defer = $q.defer();

            $http
              .put('http://localhost:8080/RestaurantReservation_RESTApp/api/reservations/', confid)
              .then(successFn, errorFn);

            function successFn(response) {
              defer.resolve(response.data);
            }

            function errorFn(error) {
              defer.reject(error.statusText);
            }

            return defer.promise;
        }
    }
})();
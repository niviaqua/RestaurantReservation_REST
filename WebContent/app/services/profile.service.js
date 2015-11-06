(function() {
    'use strict';

    angular
        .module('plunker')
        .service('profileService', profileService);

    profileService.$inject = ['$q', '$http'];

    function profileService($q, $http) {
        var self = this;
        self.getProfile = getProfile;
        self.updateProfile = updateProfile;
        
        //private members
        
        function getProfile() {
            var defer = $q.defer();
            $http
                .get('http://localhost:8080/RestaurantReservation_RESTApp/api/restaurant/')
                .then(successFn, errorFn);
            function successFn(response) {
            	console.log(response.data[0]);
                defer.resolve(response.data[0]);
            }
            function errorFn(error) {
                defer.reject(error.statusText);
            }
            return defer.promise;
        }
        
        
        function updateProfile() {
        	var defer = $q.defer();

            $http
              .put('http://localhost:8080/RestaurantReservation_RESTApp/api/restaurant/')
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
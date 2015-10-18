(function() {
    'use strict';

    angular
        .module('plunker')
        .service('profileService', profileService);

    profileService.$inject = ['$q', '$http'];

    function profileService($q, $http) {
        var self = this;

        self.updateProfile = updateProfile;
        
        //private members
   
        function updateProfile (confid) {
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
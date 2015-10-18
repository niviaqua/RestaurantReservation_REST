(function() {
    'use strict';

    angular
        .module('plunker')
        .service('createResService', createResService);

    createResService.$inject = ['$q', '$http'];

    function createResService($q, $http) {
        var self = this;
       
        self.createRes = createRes;
    
   			function createRes(res) {
           
   				var defer = $q.defer();
      
            $http
                .post('http://localhost:8080/RestaurantReservation_RESTApp/api/reservations/', res)
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
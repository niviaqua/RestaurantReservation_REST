(function() {
    'use strict';

    angular
        .module('plunker')
        .service('customerService', customerService);

    customerService.$inject = ['$q', '$http'];

    function customerService($q, $http) {
    	var self = this;
    
        	self.createRes = createRes;
        	self.getResById = getResById;
        	self.getViewRes = getViewRes;
        	self.updateRes = updateRes;
        	
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
  }
})();
(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('CustomerController', CustomerController);

   CustomerController.$inject = ['customerService'];
  
    function CustomerController  (customerService) {
    	
    	var createResVm = this;
    
        
    	createResVm.res= {};
   
    	createResVm.createRes =  function() {
    		customerService
    	   .createRes(createResVm.res)
    	   .then(function (response) {
             console.log(response); //Object{};
             createResVm.res= null;
           }, function (error) {
               console.log(error);
           });
        }
    }
   
})();
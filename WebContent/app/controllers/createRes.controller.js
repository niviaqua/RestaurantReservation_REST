(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('CreateResController', CreateResController);

    CreateResController.$inject = ['createResService'];
  
    function CreateResController (createResService) {
    	
    	
    	var createResVm = this;
    	createResVm.res= {};
   
    	createResVm.createRes =  function() {
    	   createResService
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
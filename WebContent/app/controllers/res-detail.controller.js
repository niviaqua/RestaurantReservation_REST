(function() {
  'use strict';

  angular
    .module('plunker')
    .controller('ResDetailController', ResDetailController);

  ResDetailController.$inject = ['viewResService', '$routeParams'];

  function ResDetailController(viewResService, $routeParams) {
    var resDetailVm = this;
   
  init();
    
    function init() {
    	
      viewResService
        .getResById($routeParams.resId)
        .then(function(res) {
          resDetailVm.res = res;
         
        }, function(error) {
          console.log(error);
        });
    }
    
  resDetailVm.res= {};
    
	resDetailVm.updateRes =  function() {
		
		viewResService
	   .updateRes(resDetailVm.res)
	   .then(function (response) {
		
       }, function (error) {
           console.log(error);
       });
    }
	
  }
  
  
})();



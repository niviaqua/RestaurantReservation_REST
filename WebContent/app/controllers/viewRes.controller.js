(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('ViewResController', ViewResController);

    ViewResController.$inject = ['viewResService'];
  
    function ViewResController (viewResService) {
    	
    	
    	var viewResVm = this;
        viewResVm.res= [];
        viewResVm.newRes= null;
        viewResVm.createRes = createRes;

        init();

       function init() {
            viewResService
              .getViewRes()
            .then(function (viewRes) {
                    viewResVm.viewRes = viewRes;
                }, function (error) {
                    console.log(error);
                });
        }
  
       function createRes()  {
           viewResService
           .createRes()
       .then(function (response) {
    	  
           }, function (error) {
               console.log(error);
           });
  
            }
    }
   
})();
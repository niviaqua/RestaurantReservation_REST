(function() {
  'use strict';

  angular
    .module('plunker')
    .controller('ProfileController', ProfileController);

  ProfileController.$inject = ['profileService'];

  function ProfileController(profileService) {
    var resDetailVm = this;
   
    init();

    function init() {
    	profileService
        .getResById(resId)
        .then(function(res) {
          profileVm.res = res;
          console.log(resDetailVm.res); //Object{};
        }, function(error) {
          console.log(error);
        });
    }
    
  resDetailVm.res= {};
    
	resDetailVm.updateProfile =  function() {
		 console.log(resDetailVm.res); 
		 profileService
	   .updateProfile(resDetailVm.res)
	   .then(function (response) {
		  console.log(resDetailVm.res);  //Object{};
         
       }, function (error) {
           console.log(error);
       });
    }
	
  }
  
  
})();



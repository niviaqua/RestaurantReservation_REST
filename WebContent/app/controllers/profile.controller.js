(function() {
  'use strict';

  angular
    .module('plunker')
    .controller('ProfileController', ProfileController);

  ProfileController.$inject = ['profileService'];

  function ProfileController(profileService) {
    
	  var profileVm = this;
	profileVm.pro = {};
	  init();
	  
	  function init() {
    	profileService
        .getProfile()
        .then(function(pro) {
          profileVm.pro = pro;
         // console.log(profileVm.pro);
        }, function(error) {
          console.log(error);
        });
    }
	  
	  profileVm.pro= {};
	  profileVm.updateProfile =  function() {
			profileService
		   .updateProfile(profileVm.pro)
		   .then(function (response) {
	       }, function (error) {
	           console.log(error);
	       });
	    }
		

  }
  
  
})();



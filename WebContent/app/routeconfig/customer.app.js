(function() {
    'use strict';

    angular
        .module('plunker', ['ngRoute'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig ($routeProvider) {
    	
        $routeProvider
          
           .when('/home', {
                templateUrl: 'home.tmpl.html'
            })
            .when('/menu', {
                templateUrl: 'menu.tmpl.html'
                   
            }) 
            .when('/reservation', {
                templateUrl: 'createRes.tmpl.html',
            	controller: 'CustomerController',
            	 controllerAs: 'createResVm'  
            })
          
              .when('/modifyres', {
		          templateUrl: 'modifyres.tmpl.html',
		          controller: 'ResDetailController',
		          controllerAs: 'resDetailVm'
		            
             })
             
              .when('/modifyres/:resId', {
                  templateUrl: 'res-detail.tmpl.html',
		          controller: 'ResDetailController',
		          controllerAs: 'resDetailVm'       
             })
            
             .when('/gallery', {
                templateUrl: 'gallery.tmpl.html',
                	controller: 'CustomerController'                  
            })
             
             .when('/login', {
                templateUrl: 'login.tmpl.html',
                controller: 'LoginController',
   		        controllerAs: 'loginVm'
   		       	                
            })
           
            .otherwise({
                redirectTo: '/home'
            });
    }
})();
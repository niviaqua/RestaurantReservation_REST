(function() {
    'use strict';

    angular
        .module('plunker', ['ngRoute'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig ($routeProvider) {

        $routeProvider
            .when('/viewRes', {
                templateUrl: 'viewRes.tmpl.html',
                controller: 'ViewResController',
                controllerAs: 'viewResVm'
            })
             .when('/viewRes/:resId', {
		          templateUrl: 'res-detail.tmpl.html',
		          controller: 'ResDetailController',
		          controllerAs: 'resDetailVm'
		            
             })
           .when('/createRes', {
                templateUrl: 'createRes.tmpl.html',
                controller: 'CreateResController',
                controllerAs: 'createResVm'
            })
              .when('/viewSeating', {
                templateUrl: 'viewSeating.tmpl.html'
            })
           .when('/profile', {
                templateUrl: 'profile.tmpl.html',
                controller: 'ProfileController',
                controllerAs: 'profileVm'
            })
            .when('/allcontacts', {
                templateUrl: 'allcontacts.tmpl.html',
                controller: 'ViewResController',
                controllerAs: 'viewResVm'
            })
     
            .otherwise({
                redirectTo: '/viewRes'
            });
    }
})();
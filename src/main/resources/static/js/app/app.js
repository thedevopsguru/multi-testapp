var app = angular.module('crudApp',['ui.router','ngStorage']);

var host = location.hostname;

app.constant('urls', {
    BASE: 'http://'+ host +':9090/demo',
    USER_SERVICE_API : 'http://' + host + ':9090/demo/api/user/'
    	
});



app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'UserController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, UserService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);


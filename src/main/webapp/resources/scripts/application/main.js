(function (angular) {

    var application = angular.module("quotepad", ['ui.router']);

    application.run(function ($http) {

        $http.defaults.headers.post = {
            'Content-Type': 'application/json'
        };
    });

    application.config(["$locationProvider", function($locationProvider) {
        $locationProvider.html5Mode(true);
    }]);

    application.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
 
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('home', {
                url:'/',
                templateUrl: 'resources/templates/home',
                controller: 'homeController'
            })
            .state('authors', {
                url:'/authors',
                templateUrl: 'resources/templates/authors',
                controller: 'authorController'
            })
            .state('works', {
                url:'/works',
                templateUrl: 'resources/templates/works',
                controller: 'workController'
            });
    }]);

    application.controller("homeController", function ($scope, $http) {});

    application.controller("authorController", function ($scope, $http) {

        $scope.authors = [];

        $scope.add = function (name, country) {
            $http.post("resources/models/authors", {
                name: name,
                country: country
            }).success(function (author) {
                $scope.authors.push(author);
            });
        };

        $scope.renew = function () {
            $http.get("resources/models/authors")
                    .success(function (authors) {
                        $scope.authors.length = 0;
                        $scope.authors.push.apply($scope.authors, authors);
                    });
        };

        $scope.renew();
    });

    application.controller("workController", function ($scope, $http) {});
})(angular);

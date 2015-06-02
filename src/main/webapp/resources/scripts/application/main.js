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
            .state('root', {
                url:'/',
                views: {
                    header: {
                        templateUrl: 'resources/templates/header'
                    },
                    content: {
                        templateUrl: 'resources/templates/home'
                    },
                    footer: {
                        templateUrl: 'resources/templates/footer'
                    }
                }
            })

            .state('root.authors', {
                url:'authors',
                views: {
                    'content@': {
                        templateUrl: 'resources/templates/authors',
                        controller: 'authorController'
                    }
                }
            })

            .state('root.quotes', {
                url:'quotes',
                views: {
                    'content@': {
                        templateUrl: 'resources/templates/quotes'
                    }
                }
            })

            .state('root.works', {
                url:'works',
                views: {
                    'content@': {
                        templateUrl: 'resources/templates/works',
                        controller: 'workController'
                    }
                }
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

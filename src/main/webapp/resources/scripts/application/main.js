(function (angular) {

    var application = angular.module("quotepad", ['ngRoute']);

    application.run(function ($http) {

        $http.defaults.headers.post = {
            'Content-Type': 'application/json'
        };
    });


    application.config(['$routeProvider', function($routeProvider, $locationProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'resources/templates/home',
                controller: 'homeController'
            }).
            when('/authors', {
                templateUrl: 'resources/templates/authors',
                controller: 'authorController'
            }).
            when('/works', {
                templateUrl: 'resources/templates/works',
                controller: 'workController'
            }).
            otherwise({
                redirectTo: '/'
            });

            $locationProvider.html5Mode(true);
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

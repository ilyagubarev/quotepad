(function (angular) {

    var application = angular.module("quotepad", []);

    application.run(function ($http) {

        $http.defaults.headers.post = {
            'Content-Type': 'application/json'
        };
    });

    application.controller("authorController", function ($scope, $http) {

        $scope.authors = [];

        $scope.add = function (author) {
            $http.post("resources/models/authors", author)
                    .success(function () {
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
})(angular);

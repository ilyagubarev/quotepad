(function (angular) {

    var application = angular.module("quotepad", []);


        application.controller("controller", function ($scope) {

            $scope.authors = [
                {
                    id: 1,
                    name: 'Shakespeare, William',
                    country: 'England',
                    birth: 0,
                    death: 0
                },
                {
                    id: 2,
                    name: 'Huxley, Aldous',
                    country: 'England',
                    birth: 0,
                    death: 0
                }
            ];
        });
})(angular);

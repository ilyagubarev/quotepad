(function (angular) {

    angular.module('quotepad.authors')

            .config(['$stateProvider', function (states) {

                states

                        .state('quotepad.authors', {
                            url: 'authors',
                            views: {
                                'content@': {
                                    templateUrl: 'resources/templates/authors',
                                    controller: 'authorController'
                                }
                            }
                        });
            }]);
})(angular);

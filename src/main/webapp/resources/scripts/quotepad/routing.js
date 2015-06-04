(function (angular) {

    angular.module('quotepad')

            .config(['$stateProvider', function (states) {

                states

                        .state('quotepad', {
                            url: '/',
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
                        });
            }])

            .config(['$urlRouterProvider', function (provider) {

                provider.otherwise('/');
            }])

            .config(['$locationProvider', function (provider) {

                provider.html5Mode(true);
            }]);
})(angular);

(function (angular) {

    angular.module('quotepad.quotes')

            .config(['$stateProvider', function (states) {

                states

                        .state('quotepad.quotes', {
                            url: 'quotes',
                            views: {
                                'content@': {
                                    templateUrl: 'resources/templates/quotes'
                                }
                            }
                        });
            }]);
})(angular);

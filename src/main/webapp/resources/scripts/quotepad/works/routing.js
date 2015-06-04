(function (angular) {

    angular.module('quotepad.works')

            .config(['$stateProvider', function (states) {

                states

                        .state('quotepad.works', {
                            url: 'works',
                            views: {
                                'content@': {
                                    templateUrl: 'resources/templates/works'
                                }
                            }
                        })

                        .state('quotepad.works.exclusives', {
                            url: '/exclusives',
                            views: {
                                'exclusives@quotepad.works': {
                                    templateUrl: 'resources/templates/exclusives'
                                }
                            }
                        });
            }]);
})(angular);

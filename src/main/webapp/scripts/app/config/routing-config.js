var routingConfig = function ($stateProvider, $urlRouterProvider, RoutingState) {
    $urlRouterProvider.otherwise('/' + RoutingState.ORDER_MANAGEMENT);

    $stateProvider
        .state(RoutingState.ORDER_MANAGEMENT, {
            url: '/' + RoutingState.ORDER_MANAGEMENT,
            views: {
                'leftPanel': {
                    templateUrl: 'scripts/app/components/order-management/views/OrderTableTemplate.html',
                    controller: 'OrderTableController'
                },
                'centerPanel': {
                    templateUrl: '',
                    controller: ''
                },
                'rightPanel': {
                    templateUrl: '',
                    controller: ''
                }
            }
        });
};

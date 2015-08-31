var routingConfig = function ($stateProvider, $urlRouterProvider, RoutingState) {
    $urlRouterProvider.otherwise('/' + RoutingState.ORDER_MANAGEMENT);

    $stateProvider
        .state(RoutingState.ORDER_MANAGEMENT, {
            url: '/' + RoutingState.ORDER_MANAGEMENT,
            views: {

                'topPanel': {
                    templateUrl: 'scripts/app/components/order-management/views/NavBar.html',
                    controller: ''
                },
                'leftPanel': {
                    templateUrl: 'scripts/app/components/order-management/views/OrderTableTemplate.html',
                    controller: 'OrderTableController'
                },
                'centerPanel': {
                    templateUrl: 'scripts/app/components/order-management/views/FrameOrderTreeTemplate.html',
                    controller: 'FrameOrderTreeController'
                },
                'rightPanel': {
                    templateUrl: '',
                    controller: ''
                }
            }
        });
};

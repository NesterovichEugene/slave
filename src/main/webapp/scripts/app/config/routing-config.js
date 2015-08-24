/**
 * Created by sergei.svirepa on 17.12.2014.
 */
var routingConfig = function ($stateProvider, $urlRouterProvider, RoutingState) {
    $urlRouterProvider.otherwise('/' + RoutingState.ORDER_MANAGEMENT);

    $stateProvider
        .state(RoutingState.ORDER_MANAGEMENT, {
            url: '/' + RoutingState.ORDER_MANAGEMENT,
            views: {
                'savePanel': {
                    templateUrl: 'views/common/SavePanelTemplate.html',
                    controller: 'OrderManagementSaveController',
                    controllerAs: 'controller'
                },
                'leftPanel': {
                    templateUrl: 'scripts/app/components/order-management/views/PlannedOrdersTemplate.html',
                    controller: 'PlannedOrdersController'
                },
                'centerPanel': {
                    templateUrl: 'views/common/FrameOrdersTemplate.html',
                    controller: 'FrameOrdersController'
                },
                'rightPanel': {
                    templateUrl: 'views/common/OrdersDetailsTemplate.html',
                    controller: 'OrderManagementDetailsController'
                }
            }
        })
        .state(RoutingState.CURRENT_ORDERS, {
            url: '/' + RoutingState.CURRENT_ORDERS,
            views: {
                'savePanel': {
                    templateUrl: 'views/common/SavePanelTemplate.html',
                    controller: 'CurrentOrderSaveController',
                    controllerAs: 'controller'
                },
                'leftPanel': {
                    templateUrl: 'views/common/UnderConstructionTemplate.html'
                },
                'centerPanel': {

                    templateUrl: 'scripts/app/components/current-orders/views/CurrentOrdersTemplate.html',
                    controller: 'CurrentOrdersController'
                },
                'rightPanel': {
                    templateUrl: 'scripts/app/components/current-orders/views/CurrentOrdersDetailsTemplate.html',
                    controller: 'CurrentOrdersDetailsController'
                }
            }
        })
        .state(RoutingState.SITEMAP, {
            url: '/' + RoutingState.SITEMAP,
            views: {
                'leftPanel': {
                    templateUrl: 'views/common/UnderConstructionTemplate.html'
                },
                'centerPanel': {
                    templateUrl: 'views/site-map/SiteMapTemplate.html',
                    controller: 'SiteMapController'
                },
                'rightPanel': {
                    templateUrl: 'views/site-map/SiteMapDetailsTemplate.html',
                    controller: 'SiteMapDetailsController'
                }
            }
        })
        .state(RoutingState.SHEET_PLAN, {
            url: '/' + RoutingState.SHEET_PLAN,
            views: {
                'leftPanel': {
                    templateUrl: 'views/common/UnderConstructionTemplate.html'
                },
                'centerPanel': {
                    templateUrl: 'views/sheet-plan/SheetPlanTemplate.html',
                    controller: 'ArcPlanTableController'
                },
                'rightPanel': {
                    templateUrl: 'views/site-map/SiteMapDetailsTemplate.html',
                    controller: 'SiteMapDetailsController'
                }
            }
        })
        .state(RoutingState.CALENDAR, {
            url: '/' + RoutingState.CALENDAR,
            views: {
                'leftPanel': {
                    templateUrl: 'views/calendar/CalendarFilterTemplate.html',
                    controller: 'FilterCalendarController'
                },
                'centerPanel': {
                    templateUrl: 'views/calendar/CalendarTemplate.html',
                    controller: 'CalendarController'
                },
                'leftBottomPanel': {
                    templateUrl: 'views/calendar/CalendarFilterDatePickerTemplate.html',
                    controller: 'FilterDatePickerCalendarController'
                }
            }
        })
        .state(RoutingState.FAKO_TOOL, {
            url: '/' + RoutingState.FAKO_TOOL,
            views: {
                'leftPanel': {
                    templateUrl: 'views/fako-tool/FakoToolDistributeTemplate.html',
                    controller: 'FakoToolDistributeController'
                },
                'centerPanel': {
                    templateUrl: 'views/fako-tool/FakoToolTemplate.html',
                    controller: 'FakoToolController'
                },
                'rightPanel': {
                    templateUrl: 'views/site-map/SiteMapDetailsTemplate.html',
                    controller: 'SiteMapDetailsController'
                }
            }
        })
        .state(RoutingState.MY_TODOS, {
            url: '/' + RoutingState.MY_TODOS,
            views: {
                'leftPanel': {
                    templateUrl: 'views/todo/TodoFilterTemplate.html',
                    controller: 'FilterTodoController'
                },
                'centerPanel': {
                    templateUrl: 'views/todo/TodoTemplate.html',
                    controller: 'TodoController'
                },
                'rightPanel': {
                    templateUrl: 'views/site-map/SiteMapDetailsTemplate.html',
                    controller: 'SiteMapDetailsController'
                }
            }
        })
        .state(RoutingState.REPORTS, {
            url: '/' + RoutingState.REPORTS,
            views: {
                'leftPanel': {
                    templateUrl: 'views/reports/ReportsTemplate.html',
                    controller: 'ReportsController'
                }
            }
        })
        .state(RoutingState.REPORT_INVOICING, {
            url: '/' + RoutingState.REPORTS,
            views: {
                'leftPanel': {
                    templateUrl: 'views/reports/ReportsTemplate.html',
                    controller: 'ReportsController'
                },
                'centerPanel': {
                    templateUrl: 'views/reports/ReportInvoicingTemplate.html',
                    controller: 'ReportInvoicingController'
                }
            }
        })
        .state(RoutingState.REPORT_OPERATORS_PERFORMANCE, {
            url: '/' + RoutingState.REPORTS,
            views: {
                'leftPanel': {
                    templateUrl: 'views/reports/ReportsTemplate.html',
                    controller: 'ReportsController'
                },
                'centerPanel': {
                    templateUrl: 'views/reports/ReportOperatorsPerformanceTemplate.html',
                    controller: 'ReportOperatorsPerformanceController'
                }
            }
        })
        .state(RoutingState.NEWS, {
            url: '/' + RoutingState.NEWS,
            views: {
                'leftPanel': {
                    templateUrl: 'views/news/NewsFilterTemplate.html',
                    controller: 'NewsFilterController'
                },
                'centerPanel': {
                    templateUrl: 'views/news/NewsTemplate.html',
                    controller: 'NewsController'
                }
            }
        })
        .state(RoutingState.ORDER_ARCHIVE, {
            url: '/' + RoutingState.ORDER_ARCHIVE,
            views: {
                'leftTopPanel': {
                    templateUrl: 'views/order-archive/OrderArchiveSearchTemplate.html',
                    controller: 'OrdersArchiveSearchController'
                },
                'leftPanel': {
                    templateUrl: 'views/common/FrameOrdersTemplate.html',
                    controller: 'FrameOrdersController'
                },
                'centerPanel': {
                    templateUrl: 'views/common/OrdersDetailsTemplate.html',
                    controller: 'OrderArchiveManagementDetailsController'
                }
            }
        });
};

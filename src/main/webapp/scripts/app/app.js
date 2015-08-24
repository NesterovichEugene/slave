'use strict';
/**
 * @namespace com_klingel_ko
 */
var app = angular.module('orgatool',
    [
        'ui.bootstrap',
        'ui.router',
        'ngHandsontable',
        'notifications',
        'localytics.directives',
        'general-module',
        'order-management-module',
        'angularSpectrumColorpicker',
        'angularFileUpload',
        'ngGrid',
        'ui.date',
        'current-orders-module',
        'site-map-module',
        'frame-orders-module',
        'calendar-module',
        'sheet-plan-module',
        'fako-tool-module',
        'my-todo-module',
        'order-archive-module',
        'reports-module',
        'news-module'
    ]);

app.config(routingConfig);
app.config(HttpConfig);

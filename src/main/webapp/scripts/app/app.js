'use strict';
var app = angular.module('app',
    [
        'ui.bootstrap',
        'ui.router',
        'notifications',
        'ngTable',
        'general-module',
        'frame-order-management-module',
        'order-management-module'

    ]);

app.config(routingConfig);
app.config(HttpConfig);

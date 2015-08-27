angular.module('notifications').run(['$templateCache', Notifications]);

    /**
     * @param $templateCache
     * @constructor
     */
    function Notifications($templateCache) {
        $templateCache.put('/notifications/error.html', '<div class="alert alert-danger" role="alert" ng-bind-html="message"></div>');
        $templateCache.put('/notifications/success.html', '<div class="alert alert-success" role="alert" ng-bind-html="message"></div>');
    }

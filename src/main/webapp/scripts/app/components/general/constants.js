angular.module('general-module').constant("GeneralConstants", new GeneralConstants());

/**
 * @constructor
 */
function GeneralConstants() {
    this.SAVE = 'saveButtonClick';
    this.REFRESH = 'refreshButtonClick';
}

angular.module('general-module').constant("RoutingState", new RoutingState());
/**
 * @constructor
 */
function RoutingState() {
    this.ORDER_MANAGEMENT = 'order_management';
}

angular.module('general-module').constant("MenuItem", new MenuItem());
/**
 * @constructor
 */
function MenuItem() {
    this.ORDER_MANAGEMENT = 'blabla';

}

angular.module('general-module').constant("HttpMethods", new HttpMethods());
/**
 * @constructor
 */
function HttpMethods() {
    this.GET = 'GET';
    this.HEAD = 'HEAD';
    this.POST = 'POST';
    this.PUT = 'PUT';
    this.DELETE = 'DELETE';
    this.JSONP = 'JSONP';
    this.PATCH = 'PATCH';
}
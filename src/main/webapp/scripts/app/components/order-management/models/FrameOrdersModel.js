angular.module('frame-order-management-module').service('frameOrdersModel', FrameOrdersModel);

/**
 * @param $rootScope
 * @constructor
 */
function FrameOrdersModel($rootScope) {

    var NAME = 'FrameOrdersModel';
    var CHANGED = 'changed';
    this.$rootScope = $rootScope;
    this.FRAME_ORDERS_CHANGED = NAME + ':frameOrders:' + CHANGED;
    this.frameOrders = [];

}

FrameOrdersModel.prototype = {

    get frameOrders() {
        return this._frameOrders;
    },
    set frameOrders(val) {
        this._frameOrders = val;
        this.$rootScope.$broadcast(this.FRAME_ORDERS_CHANGED);
    }
};

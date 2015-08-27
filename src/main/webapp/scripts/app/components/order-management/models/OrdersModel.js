angular.module('order-management-module').service('ordersModel', OrdersModel);

/**
 * @param $rootScope
 * @constructor
 */
function OrdersModel($rootScope) {

    var NAME = 'OrdersModel';
    var CHANGED = 'changed';
    this.$rootScope = $rootScope;
    this.ORDERS_CHANGED = NAME + ':orders:' + CHANGED;
    this.orders = [];

}

OrdersModel.prototype = {

    get orders() {
        return this._orders;
    },
    set orders(val) {
        this._orders = val;
        this.$rootScope.$broadcast(this.ORDERS_CHANGED);
    }
};

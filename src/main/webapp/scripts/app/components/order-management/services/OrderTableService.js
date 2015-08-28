angular.module('order-management-module').service('orderTableService', OrderTableService);

/**
 *
 * @param $q
 * @param remoteService
 * @constructor
 */
function OrderTableService($q, remoteService, ordersModel) {
    var service = this;


    service.loadAll = function () {
        return remoteService.loadPromise('/service/orders/loadOrders').then(function (orders) {
            ordersModel.orders = orders;
        });
    };

    service.update = function (order) {
        return remoteService.updatePromise('/service/orders/update', order).then(function (orders) {
        });
    };

    service.remove = function (order) {
        return remoteService.deletePromise('/service/orders/delete', order).then(function (orders) {
        });
    };

}
angular.module('frame-order-management-module').service('frameOrderTreeService', FrameOrderTreeService);

/**
 *
 * @param $q
 * @param remoteService
 * @constructor
 */
function FrameOrderTreeService($q, remoteService, frameOrdersModel) {
    var service = this;


    service.loadAll = function () {
        return remoteService.loadPromise('/service/frame_order/loadFrameOrders').then(function (frameOrders) {
            frameOrdersModel.frameOrders = frameOrders;
        });
    };

    service.update = function (frameOrder) {
        return remoteService.updatePromise('/service/frame_order/editFrameOrder', frameOrder).then(function (frameOrders) {
        });
    };

    service.create = function (frameOrder) {
        return remoteService.createPromise('service/frame_order/createFrameOrder', frameOrder).then(function (frameOrders) {
        });
    };

    service.remove = function (frameOrder) {
        return remoteService.loadPromise('/service/frame_order/deleteFrameOrder/' + frameOrder.identity).then(function (frameOrders) {
        });
    };

}

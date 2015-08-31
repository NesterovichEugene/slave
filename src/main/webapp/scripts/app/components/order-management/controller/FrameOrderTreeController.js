angular.module('frame-order-management-module').controller('FrameOrderTreeController', FrameOrderTreeController);

/**
 * @type {BaseController}
 */
/**
 * @param $injector
 * @param $scope
 * @param $rootScope
 * @constructor
 * @extends BaseController
 * @param {FrameOrdersModel} frameOrdersModel
 */
function FrameOrderTreeController($injector, $scope, $rootScope, frameOrdersModel) {
    var self = this;
    BaseController.call(self, $injector, $scope);
    /**
     *
     * @type {FrameOrderTreeService}
     */
    var frameOrderTreeService = self.getDependency('frameOrderTreeService');
    registerAll.call(this);

    /**
     * All register events
     */
    function registerAll() {
        this.register(frameOrdersModel.FRAME_ORDERS_CHANGED, frameOrdersChangedHandler);
    }

    initController();

    $scope.removeFrameOrder = function (frameOrder) {
        frameOrderTreeService.remove(frameOrder);
        $scope.frameOrders = _.reject($scope.frameOrders, frameOrder);
    };

    $scope.editFrameOrder = function (frameOrder) {
        frameOrder.$edit = true;
    };

    $scope.save = function (frameOrder) {
        //coll server
        frameOrderTreeService.update(frameOrder);
        frameOrder.$edit = false
    };

    $scope.create = function () {
        var frameOrder = {frameOrderName: $scope.frameOrderName, frameOrderStartTime: $scope.frameOrderStartTime, frameOrderExecutionTime: $scope.frameOrderExecutionTime, frameOrderComment: $scope.frameOrderComment};
        $scope.frameOrders.push(frameOrder);
        frameOrderTreeService.create(frameOrder);
    }

    function initController() {
        frameOrderTreeService.loadAll();
    }

    function frameOrdersChangedHandler() {
        $scope.frameOrders = frameOrdersModel.frameOrders;
    }


}
FrameOrderTreeController.prototype = Object.create(BaseController.prototype);
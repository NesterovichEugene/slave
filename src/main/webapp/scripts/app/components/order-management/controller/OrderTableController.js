angular.module('order-management-module').controller('OrderTableController', OrderTableController);

/**
 * @type {BaseController}
 */
/**
 * @param $injector
 * @param $scope
 * @param $rootScope
 * @constructor
 * @extends BaseController
 * @param {OrdersModel} ordersModel
 */
function OrderTableController($injector, $scope, $rootScope, ordersModel) {
    var self = this;
    BaseController.call(self, $injector, $scope);
    $scope.tableParams = {
        page: 1,
        count: 5
    };
    /**
     *
     * @type {OrderTableService}
     */
    var orderTableService = self.getDependency('orderTableService');
    registerAll.call(this);

    /**
     * All register events
     */
    function registerAll() {
        this.register(ordersModel.ORDERS_CHANGED, ordersChangedHandler);
    }

    initController();

    $scope.removeOrder = function (order) {
        orderTableService.remove(order);
        //$scope.orders = _.reject($scope.orders, order);
    };

    $scope.editOrder = function (order) {
        order.$edit = true;
    };

    $scope.save = function (order) {
        //coll server
        orderTableService.update(order);
        order.$edit = false
    };

    $scope.create = function () {
        var order = {orderName: '', orderStartTime: '', orderExecutionTime: '', orderComment: ''};
        $scope.orders.push(order);
        order.$edit = true;
    }

    function initController() {
        orderTableService.loadAll();
    }

    function ordersChangedHandler() {
        $scope.orders = ordersModel.orders;
    }


}
OrderTableController.prototype = Object.create(BaseController.prototype);
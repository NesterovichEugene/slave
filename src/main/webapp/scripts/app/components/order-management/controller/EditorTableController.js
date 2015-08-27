angular.module('order-management-module').controller('InlineEditorController', InlineEditorController);

function InlineEditorController($injector, $scope, $rootScope) {
// $scope is a special object that makes
// its properties available to the views as
// variables. Here we set some default values:

    $scope.showtooltip = false;
    $scope.showtooltipEast = false;
    $scope.showtooltipWork = false;
    $scope.showtooltipCenter = false;
    $scope.orderName = '';
    $scope.workName = '';
    $scope.startDate = '';
    $scope.executeDate = '';
    $scope.comment = '';
    $scope.description = '';

// Some helper functions that will be
// available in the angular declarations

    $scope.hideTooltip = function () {

        // When a model is changed, the views will be automatically
        // updated by by AngularJS. In this case it will hide the tooltip.

        $scope.showtooltip = false;
        $scope.showtooltipEast = false;
        $scope.showtooltipWork = false;
        $scope.showtooltipCenter = false;
    };

    $scope.toggleTooltip = function (e) {
        e.stopPropagation();
        $scope.showtooltip = !$scope.showtooltip;
    };

    $scope.toggleTooltipCenter = function (e) {
        e.stopPropagation();
        $scope.showtooltipCenter = !$scope.showtooltipCenter;
    };

    $scope.toggleTooltipEast = function (e) {
        e.stopPropagation();
        $scope.showtooltipEast = !$scope.showtooltipEast;
    };

    $scope.toggleTooltipWork = function (e) {
        e.stopPropagation();
        $scope.showtooltipWork = !$scope.showtooltipWork;
    }
}
angular.module('frame-order-management-module').controller('TreeEditorController', InlineEditorController);

function InlineEditorController($injector, $scope, $rootScope) {
// $scope is a special object that makes
// its properties available to the views as
// variables. Here we set some default values:

    $scope.showtooltipCenter = false;
    $scope.frameOrderName = '';
    $scope.frameOrderStartTime = '';
    $scope.frameOrderExecutionTime = '';
    $scope.frameOrderComment = '';

// Some helper functions that will be
// available in the angular declarations

    $scope.hideTooltip = function () {
        $scope.showtooltipCenter = false;
    };

    $scope.toggleTooltipCenter = function (e) {
        e.stopPropagation();
        $scope.showtooltipCenter = !$scope.showtooltipCenter;
    };
}

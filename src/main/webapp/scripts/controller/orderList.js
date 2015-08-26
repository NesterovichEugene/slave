var app= angular.module('orderList', [])
	.controller('orderListCtrl', function($http, $scope) {
	$scope.orderList = this;
	$http.get('/service/orders/loadOrders').success(function(data) {
		$scope.orderList.orders = data
	});
});


/**
 * Created by neste on 14.08.2015.
 */

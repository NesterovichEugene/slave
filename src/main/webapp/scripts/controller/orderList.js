angular.module('orderList', []).controller('orderListCtrl', function($http) {
	var orderList = this;
	$http.get('/service/orders/loadOrders').success(function(data) {
		orderList.orders = data
	});
});


/**
 * Created by neste on 14.08.2015.
 */

var orderRemoveId = "order_remove";

$(document).ready(function() {

	$("#open_orders").unbind().click(showOrderTab);
	$("#reload_orders").unbind().click(reloadOrderTable);

	function showOrderTab() {
		closeAll();
		$("#orders_tab").show();
	}
});

function reloadOrderTable() {
	var tableName = "";

	$.get(domainUrl + "order/all", function(response) {
		fillOrderTable(response);
	});
}

function fillOrderTable(data) {
	$("#order_table>tr").remove();
	for (var i = 0; i < data.length; i++) {
		var order = data[i];
		
		var quantity = getOrderQuantity(order);
		$("#order_table").append(
				createTableRow(order.id, order.user.username, order.date, quantity, 
						order.status, order.fullPrice, orderRemoveId));
		removeEventHandler(orderRemoveId, removeOrder);
		setCssToTableRow("#order_table");
	}
}

function removeOrder(id) {
	console.log("Remove order ID: " + id);
}

function getOrderQuantity(order) {
	var quantity = 0;
	for (var i = 0; i < order.orderPerProduct.length; i++) {
		quantity = quantity + order.quantity;
	}
	
	return quantity; 
}

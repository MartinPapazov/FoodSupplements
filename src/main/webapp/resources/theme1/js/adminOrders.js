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

}

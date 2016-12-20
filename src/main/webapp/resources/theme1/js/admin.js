var domainUrl = "http://localhost:8085/store/";
var brandImages = {};
var categoryRemove = "category_remove";
var subCatRemove = "subcate_remove";
var brandRemove = "brand_remove";
var productRemove = "productRemove";
var productTasteRemove = "product_taste_remove";
$(document).ready(function() {

	$("#toggle_quantity_add").unbind().click(toggleAddQuantity);

	$("#upload_brand").unbind().click(uploadBrand);

	$("#add_category_button").unbind().click(addCategory);

	// Event handler - load all categorys
	$("#reload_categorys").unbind().click(loadAllCategorys);

	$("#reload_products").unbind().click(loadAllProducts);

	// Event handler - load all subcategorys
	$("#reload_subcategories").unbind().click(loadAllSubcategorys);

	// Hide add category div + event handler for add category button
	$("#add_category").hide();
	$("#show_add_category").unbind().click(toggleAddCategory);

	$("#send_upload_product").unbind().click(uploadProduct);

	// Event handler
	$("#close_category_add").unbind().click(function() {
		$("#add_category").hide();
		$("#show_add_category").toggle();
	});

	// Event handler
	$("#open_category").unbind().click(function() {
		closeAll();
		$("#category_tab").show();
	});

	// Event handler
	$("#open_brand").unbind().click(function() {
		closeAll();
		$("#brand_tab").toggle();
	});

	openTab("open_product", "product_tab");

	$("#show_subcategory_add").unbind().click(function() {
		toggleSubcategoryAdd();
	});

	$("#upload_category").unbind().click(function() {
		addSubCategory()
	});

	$("#reload_brands").unbind().click(function() {
		loadAllBrands();
	});

	$("#detail_infos").unbind().change(function() {
		$("#detail_infos > option").removeAttr("selected");
		$(this).attr("selected");
		loadProductDetailsLables($(this).val());
	});

	$("#add_quantity").unbind().click(addProductInfo);

	$("#show_taste_prd").unbind().click(toggleTasteProductAdd);

	$("#toggle_products_uploader").unbind().click(toggleProductUploader);

	$("#remove_quantity").unbind().click(function() {
		var id = $('#detail_infos').find(":selected").val();
		removeProductDetails(id);
	});

	$("#add_one_taste").unbind().click(addTasteToProduct);
	toggleSubcategoryAdd();

	closeAll();

	disableProductFields();

	toggleTasteProductAdd();

	toggleProductUploader();

});

function loadAllBrands() {
	$.get(domainUrl + "brand/all", function(response) {
		fillBrandTable(response);
	});
}

function loadAllCategorys() {
	uploadCategoryOption();
	$.get(domainUrl + "category/all", function(response) {
		fillCategoryTable(response);
	});
}

function loadAllSubcategorys() {
	$.get(domainUrl + "category/sub/all", function(response) {
		fillSubcategoryTable(response);

	});
}

function loadAllProducts() {
	$.get(domainUrl + "product/all", function(response) {
		fillProductTable(response);
	});
}

function fillCategoryTable(data) {
	$("#category_table>tr").remove();
	for (var i = 0; i < data.length; i++) {
		var category = data[i];
		$("#category_table").append(
				createTableRow(category.id, category.name,
						category.description, categoryRemove));
		removeEventHandler(categoryRemove, removeCategory);
		setCssToTableRow("#category_table");
	}
	;
}

function fillSubcategoryTable(data) {
	$("#subcategory_table>tr").remove();
	for (var i = 0; i < data.length; i++) {
		var subcategory = data[i];
		console.log(subcategory);
		$("#subcategory_table").append(
				createTableRow(subcategory.id, subcategory.name,
						subcategory.description, subcategory.category.name,
						subCatRemove));
		removeEventHandler(subCatRemove, removeSubcategory);
		setCssToTableRow("#subcategory_table");
	}
}

function fillBrandTable(data) {
	var brandIdtag = "#brand_table";
	$(brandIdtag + ">tr").remove();
	for (var i = 0; i < data.length; i++) {
		var brand = data[i];
		var id = brand.id;
		var name = brand.name;
		var image = brand.image;
		var description = brand.description;

		brandImages[id] = brand;
		$(brandIdtag)
				.append(createTableRow(id, name, description, brandRemove));
		removeEventHandler(brandRemove, removeBrand);
		setEventHandlerBrands();
	}
}

function fillProductTable(data) {
	var productTable = "#product_table";
	$(productTable + ">tr").remove();
	for (var i = 0; i < data.length; i++) {
		var product = data[i];
		var id = product.id;
		var name = product.name;
		var brandName = product.brand.name;
		var subCatName = product.subcategery.name;
		var catName = product.subcategery.category.name;
		$(productTable).append(
				createTableRow(id, name, brandName, subCatName, catName,
						productRemove));
		removeEventHandler(productRemove, removeProduct);
		// Add event handler
		setEventHandlerProducts();
	}
}

// Last element is the removeId
function createTableRow() {
	var i;
	var tableRow = "<tr>";
	for (i = 0; i < arguments.length - 1; i++) {
		var text = arguments[i];
		if (i == 0) {
			tableRow = tableRow + "<td class='eid'>" + text + "</td>";
		} else {
			tableRow = tableRow + "<td>" + text + "</td>";
		}
	}

	var removeId = arguments[arguments.length - 1];

	tableRow = tableRow + createOptionButtons(removeId);

	return tableRow + "</tr>"
}

function closeAll() {
	$("#orders_tab").hide();
	$("#category_tab").hide();
	$("#brand_tab").hide();
	$("#product_tab").hide();
	$("#toggle_quantity_add").hide();
}

function setCssToTableRow(tableName) {
	$(tableName + ">tr>td:not(:last-child)").unbind().click(function() {
		markRow(tableName, this);
	});
}

function markRow(tableName, element) {
	$(tableName + ">tr").css("background-color", "");
	$($($(element).parent()).get(0)).css("background-color", "#c4caff");
}

function setEventHandlerBrands() {
	var tableName = "#brand_table";

	$(tableName + ">tr").unbind().click(function() {
		$(tableName + ">tr").css("background-color", "");
		$(this).css("background-color", "#c4caff");
		var id = $(this).children().first().text();
		updateBrandById(id);
	});
}

function setEventHandlerProducts() {
	var tableName = "#product_table";

	$(tableName + ">tr").unbind().click(function() {
		$(tableName + ">tr").css("background-color", "");
		$(this).css("background-color", "#c4caff");
		var id = $(this).children().first().text();
		updateProductById(id);
	});
}

function addCategory() {
	var isEligeble = checkForEmptyValue("#category_name");
	if (!isEligeble) {
		return;
	}
	var name = $("#category_name").val();
	var description = $("#category_description").val();
	var data = {
		name : name,
		description : description
	};
	$.ajax({
		url : domainUrl + "category/add",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			$("#category_name").val("");
			$("#category_description").val("");
			loadAllCategorys();
		},
		error : function() {
			alert("error");
		}
	});
}

function addSubCategory() {
	var isEligeble = checkForEmptyValue("#subcategory_name");
	if (!isEligeble) {
		return;
	}
	var name = $("#subcategory_name").val();
	var description = $("#subcategory_description").val();
	var option = $("#options_category").val();
	console.log(option);
	var data = {
		name : name,
		description : description,
		category : {
			id : option
		}
	};

	$.ajax({
		url : domainUrl + "category/sub/add",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			$("#subcategory_name").val("");
			$("#subcategory_description").val("");

			loadAllSubcategorys();
			uploadCategoryOption();
		},
		error : function() {
			alert("error");
		}
	});
}

function createOptionButtons(id) {

	var line = "<td><div><a src='#' class='remove_button " + id
			+ "' style='float: left;'></a></div></td>";
	return line;
	// <div id='change_button' style='float: left;'></div>
}

function toggleSubcategoryAdd() {
	$("#add_subcategory").toggle();
}

function toggleAddCategory() {
	$("#add_category").toggle();
}

function toggleAddQuantity() {
	$("#detail_info_add").toggle();
	if ($("#product_info").hasClass("product_info_wide")) {
		$("#product_info").removeClass("product_info_wide");
		$("#product_info").addClass("product_info_short");
	} else if ($("#product_info").hasClass("product_info_short")) {
		$("#product_info").removeClass("product_info_short");
		$("#product_info").addClass("product_info_wide");
	}
}

function uploadCategoryOption() {
	$("#options_category>option").remove();
	$.get(domainUrl + "category/all", function(response) {
		for (var i = 0; i < response.length; i++) {
			var category = response[i];
			$("#options_category").append(
					"<option value=" + category.id + ">" + category.name
							+ "</option>");
		}
	});
}

function addProductInfo() {
	if (!checkForNumbers()) {
		return;
	}

	var formData = new FormData($('#product_info_form')[0]);
	$.ajax({
		url : domainUrl + "product/details/add",
		type : "POST",
		dataType : 'text',
		contentType : false,
		processData : false,
		cache : false,
		data : formData,
		success : function(response) {

			var productId = JSON.parse(response).productId;
			console.log("ProductID: " + productId);
			loadProductDetailsInfo(productId);
			clearProductDetails();
		},
		error : function() {
			alert("unable to create the record");
		}
	});

}
function checkForNumbers() {
	var oldPriceValue = $("#old_price_val").val();
	var currentPriceValue = $("#current_price_val").val();

	if (!isNumber(oldPriceValue)) {
		alert("Old price need to be number.");
		return false;
	}

	if (!isNumber(currentPriceValue)) {
		alert("Current price need to be number.");
		return false;
	}

	return true;
}
function uploadBrand() {

	var formData = new FormData($('#brand_form')[0]);

	$.ajax({
		url : domainUrl + "brand/add",
		type : "POST",
		dataType : 'text',
		contentType : false,
		processData : false,
		cache : false,
		data : formData,
		success : function(response) {
			loadAllBrands();
			clearBrandForm();
		},
		error : function() {
			alert("unable to create the record");
		}
	});

}

function updateProductById(id) {
	var data = {
		id : id
	};
	$.ajax({
		url : domainUrl + "product/byId",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			reloadPorductInfo(response);

		},
		error : function() {
			alert("error");
		}
	});
}

function updateBrandById(id) {
	var brandName = "#brand_name";
	var brandDesc = "#brand_desc";
	var brandImage = "#brand_image";
	var data = {
		id : id
	};
	$.ajax({
		url : domainUrl + "brand/get/byid",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			$(brandName).text(response.name);
			$(brandDesc).text(response.description);
			$(brandImage + ">img").remove();
			$(brandImage).append(
					'<img src="data:image/jpeg;base64,' + response.image
							+ '" />');
		},
		error : function() {
			alert("error");
		}
	});
}

function reloadPorductInfo(response) {

	var productName = "#product_detail_name";
	var productDesc = "#product_description";
	var supplements = "#product_suplements";

	$("#current_prd_id").val(response.id);
	$(productName).val(response.name);
	$(productDesc).val(response.description);
	loadProductSubcat(response.subcategery);
	loadProductBrand(response.brand);
	loadProductDetailsInfo(response.id);
	loadProductTasteTable(response.tastes);
	$(supplements).val(response.supplements);
	loadAllTastes();

}

function loadProductSubcat(subcategory) {
	var subcategoryName = "#subcategory_option";

	$(subcategoryName + ">option").remove();
	$.get(domainUrl + "category/sub/all", function(response) {
		for (var i = 0; i < response.length; i++) {
			var currentSubcat = response[i];

			if (subcategory.id === currentSubcat.id) {
				$(subcategoryName).append(
						"<option value=" + currentSubcat.id + " selected >"
								+ currentSubcat.name + "</option>");
			} else {
				$(subcategoryName).append(
						"<option value=" + currentSubcat.id + ">"
								+ currentSubcat.name + "</option>");
			}
		}

	});
}

function loadProductDetailsInfo(productId) {
	$("#toggle_quantity_add").show();

	var details = "#detail_infos";
	$("#prd_id").val(productId);
	$(details + ">option").remove();
	var data = {
		id : productId
	};
	$.ajax({
		url : domainUrl + "product/details/byProductId",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			for (var i = 0; i < response.length; i++) {
				var productDetails = response[i];
				var id = productDetails.id;
				var quantity = productDetails.quantity;

				$(details).append(
						"<option value=" + id + ">" + quantity + "</option>");
			}

			var currentId = $(details).val();

			loadProductDetailsLables(currentId);
		},
		error : function() {
			alert("error");
		}
	});
}

function loadProductBrand(brand) {
	var brandOption = "#brand_option";

	$(brandOption + ">option").remove();
	$.get(domainUrl + "brand/all", function(response) {
		for (var i = 0; i < response.length; i++) {
			var currentBrand = response[i];

			if (brand.id === currentBrand.id) {
				$(brandOption).append(
						"<option value=" + currentBrand.id + " selected >"
								+ currentBrand.name + "</option>");
			} else {
				$(brandOption).append(
						"<option value=" + currentBrand.id + ">"
								+ currentBrand.name + "</option>");
			}
		}
	});
}

function loadProductDetailsLables(id) {
	var oldPrice = "#old_price";
	var currentPrice = "#current_price";
	var productImage = "#product_image";

	var data = {
		id : id
	};
	$.ajax({
		url : domainUrl + "product/details/getById",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			$(oldPrice).val(response.oldPrice);
			$(currentPrice).val(response.currentPrice);
			$(productImage + ">img").remove();
			$(productImage).append(
					'<img src="data:image/jpeg;base64,' + response.image
							+ '" />');
		},
		error : function() {
			alert("error");
		}
	});
}

function removeEventHandler(id, func) {
	$("." + id).unbind().click(
			function() {
				var id = $(
						$($($($(this).parent()).parent()).parent())
								.find(".eid")).text();
				var name = $(
						$($($($(this).parent()).parent()).parent()).find(
								"td:nth-child(2)")).text();
				var willDelete = confirm("Do you want to delete? " + name);
				if (willDelete) {
					func(id);
				}
			});
}

function removeSubcategory(id) {
	var data = {
		id : id
	};

	$.ajax({
		url : domainUrl + "category/sub/remove",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {

			loadAllSubcategorys();
		},
		error : function() {
			alert("error");
		}
	});
}

function removeCategory(id) {
	var data = {
		id : id
	};

	$.ajax({
		url : domainUrl + "category/remove",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {

			loadAllCategorys();
		},
		error : function() {
			alert("error");
		}
	});
}

function removeBrand(id) {
	var data = {
		id : id
	};

	$.ajax({
		url : domainUrl + "brand/remove",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {

			loadAllBrands();
		},
		error : function() {
			alert("error");
		}
	});
}

function removeProduct(id) {
	var data = {
		id : id
	};

	$.ajax({
		url : domainUrl + "product/remove",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {

			loadAllProducts();
		},
		error : function() {
			alert("error");
		}
	});
}

function clearBrandForm() {
	$("#brand_form>input").val('');
}

// Restrictions
function checkForEmptyValue(element) {
	if ($(element).val().length === 0) {
		$(element).addClass('warning');
		return false;
	} else {
		$(element).addClass('');
		return true;
	}
}

function openTab(tabNameMenu, tabName) {
	$("#" + tabNameMenu).unbind().click(function() {
		closeAll();
		$("#" + tabName).show();
	});
}

function disableProductFields() {
	$("#product_detail_name").prop('disabled', true);
	$("#product_description").prop('disabled', true);
	$("#product_suplements").prop('disabled', true);
	$("#brand_option").prop('disabled', true);
	$("#old_price").prop('disabled', true);
	$("#current_price").prop('disabled', true);
	$("#subcategory_option").prop('disabled', true);
}

function enableProductFields() {
	$("#product_detail_name").prop('disabled', false);
	$("#product_description").prop('disabled', false);
	$("#product_suplements").prop('disabled', false);
	$("#brand_option").prop('disabled', false);
	$("#old_price").prop('disabled', false);
	$("#current_price").prop('disabled', false);
	$("#subcategory_option").prop('disabled', false);
}

function clearProductDetails() {
	$("#quantity_val").val("");
	$("#old_price_val").val("");
	$("#current_price_val").val("");
	$("#det_image_val").val("");
}

function isNumber(n) {
	return !isNaN(parseFloat(n)) && isFinite(n);
}

function toggleProductUploader() {
	$("#add_products").toggle();
	reloadProductAddOptions();
}

function toggleTasteProductAdd() {
	$("#detail_info_add").toggle();
	$("#product_info .taste_prd_add").toggle();
	if ($("#product_info").hasClass("product_info_wide")) {
		$("#product_info").removeClass("product_info_wide");
		$("#product_info").addClass("product_info_short");
	} else if ($("#product_info").hasClass("product_info_short")) {
		$("#product_info").removeClass("product_info_short");
		$("#product_info").addClass("product_info_wide");
	}
}

function uploadProduct() {
	var name = $("#product_uploader_name").val();
	var subcategoryId = $("#product_subcat_add").val();
	var brandId = $("#product_brand_add").val();
	var description = $("#product_description_add").val();
	var supplements = $("#product_suplements_add").val();

	var data = {
		name : name,
		subcategery : {
			id : subcategoryId
		},
		brand : {
			id : brandId
		},
		description : description
	};

	$.ajax({
		url : domainUrl + "product/add",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			$("#product_uploader_name").val("");
			$("#product_subcat_add").val("");
			$("#product_suplements_add").val("");
			loadAllProducts();
		},
		error : function() {
			alert("error");
		}
	});
}

function reloadProductAddOptions() {
	loadAllSubcatProductAdd();
	loadAllProductBrands();
}

function loadAllSubcatProductAdd() {
	$.get(domainUrl + "category/sub/all", function(response) {
		for (var i = 0; i < response.length; i++) {
			var category = response[i];
			$("#product_subcat_add").append(
					"<option value=" + category.id + ">" + category.name
							+ "</option>");
		}
	});
}

function loadAllProductBrands() {
	$.get(domainUrl + "brand/all", function(response) {
		for (var i = 0; i < response.length; i++) {
			var brand = response[i];
			$("#product_brand_add").append(
					"<option value=" + brand.id + ">" + brand.name
							+ "</option>");
		}
	});
}

function loadProductTasteTable(tastes) {
	var table = "#product_taste_table";
	$(table + ">tr").remove();
	for (var i = 0; i < tastes.length; i++) {
		var taste = tastes[i];
		var id = taste.id;
		var name = taste.name;

		$(table).append(createTableRow(id, name, productTasteRemove));
		removeEventHandler(productTasteRemove, removeProductTaste);
	}
}

function loadAllTastes() {
	$("#left_taste_product > option").remove();
	$.get(domainUrl + "taste/all", function(response) {
		for (var i = 0; i < response.length; i++) {
			var taste = response[i];
			$("#left_taste_product").append(
					"<option value=" + taste.id + ">" + taste.name
							+ "</option>");
		}
	});
}

function removeProductTaste(id) {
	console.log("Rmoving taste! = " + id);
	var productId = $("#current_prd_id").val();
	var data = {
		tasteId : id,
		productId : productId
	};
	console.log(data);
	$.ajax({
		url : domainUrl + "product/taste/remove",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			console.log("Del");
			updateProductById(productId);
		},
		error : function() {
			alert("error");
		}
	});
}

function removeProductDetails(id) {
	var productId = $("#prd_id").val();
	var data = {
		id : id
	};

	$.ajax({
		url : domainUrl + "	product/details/remove",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			loadProductDetailsInfo(productId);
		},
		error : function() {
			alert("error");
		}
	});
}

function addTasteToProduct() {
	var id = $('#left_taste_product').find(":selected").val();
	var productId = $("#current_prd_id").val();
	var data = {
		tasteId : id,
		productId : productId
	};

	$.ajax({
		url : domainUrl + "product/taste/add",
		type : 'POST',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(data),
		success : function(response) {
			updateProductById(productId);
		},
		error : function() {
			alert("error");
		}
	});
}

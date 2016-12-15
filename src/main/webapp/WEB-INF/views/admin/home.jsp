
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fs" uri="http://fs.com/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>
<script
	src="${pageContext.request.contextPath}/resources/theme1/js/admin.js"></script>
	<script
	src="${pageContext.request.contextPath}/resources/theme1/js/adminOrders.js"></script>

<link
	href="${pageContext.request.contextPath}/resources/theme1/css/main.css"
	rel="stylesheet">
	
<link
	href="${pageContext.request.contextPath}/resources/theme1/css/orders.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/theme1/css/jquery.mCustomScrollbar.css">
</head>
<body>

	<div id="wrapper">

		<nav class="horizontal-nav full-width horizontalNav-notprocessed">
		<ul>
			<li><a id="open_category" href="#">Category</a></li>
			<li><a id="open_brand" href="#">Brand</a></li>
			<li><a id="open_product" href="#">Product</a></li>
			<li><a href="#">User</a></li>
			<li><a id="open_orders" href="#">Orders</a></li>
		</ul>
		</nav>


		<div id="category_tab" class="tab">
			<p class="title">Category</p>
			<div class="panel">
				<div id="content-1" class=" table_panel content mCustomScrollbar">
					<table>
						<thead>
							<tr>
								<td>Id</td>
								<td>Name</td>
								<td>Description</td>
								<td>Options</td>
							</tr>
						</thead>
						<tbody id="category_table">
						</tbody>
					</table>
				</div>
				<button id="reload_categorys">Load categories</button>
				<button id="show_add_category">Toggle add category</button>

				<div id="add_category">
					<fieldset>
						<legend> Add Category </legend>
						</br> Name: <input type="text" id="category_name"> </br>
						Description: </br>
						<textarea id="category_description" style="resize: none" rows="12"
							cols="120" name="description" form="category"></textarea>

						</br>
						<button id="add_category_button">Add category</button>
					</fieldset>
				</div>
			</div>
			<p class="title">Subcategory</p>
			<div class="panel">
				<div id="content-1" class=" table_panel content mCustomScrollbar">
					<table>
						<thead>
							<tr>
								<td>id</td>
								<td>Name</td>
								<td>Description</td>
								<td>Category name</td>
								<td>Options</td>
							</tr>
						</thead>
						<tbody id="subcategory_table">
						</tbody>
					</table>
				</div>
				<button id="reload_subcategories">Load sub-categories</button>
				<button id="show_subcategory_add">Toggle add subcategory</button>
				<div id="add_subcategory">
					<fieldset>
						<legend> Add Subcategory </legend>
						</br> Name: <input type="text" name="name" id="subcategory_name">
						</br> Description: </br>
						<textarea style="resize: none" rows="12" cols="120"
							name="description" form="category" id="subcategory_description"></textarea>
						</br> <select id="options_category">

						</select>
						<script>
							uploadCategoryOption();
						</script>
						<button id="upload_category">Add subcategory</button>
					</fieldset>

				</div>
			</div>
		</div>

		<div id="brand_tab" class="tab">
			<p class="title">Brand</p>
			<div id="panel">
				<div id="content-1" class=" table_panel content mCustomScrollbar">
					<table>
						<thead>
							<tr>
								<td>Id</td>
								<td>Name</td>
								<td>Description</td>
								<td>Options</td>
							</tr>
						</thead>
						<tbody id="brand_table">
						</tbody>
					</table>
				</div>
			</div>
			<button id="reload_brands">Load brands</button>
			<div id="brand_details">
				<div id="info">
					<div id="info_name">
						<p>Name:</p>
						<p id="brand_name"></p>
					</div>
					<p>Description:</p>
					<div id="brand_desc" class="content mCustomScrollbar"></div>
				</div>
				<div id="brand_image"></div>
			</div>
			<div id="brand_add_panel">
				<form id="brand_form">
					<label> Name: </label> <input type="text" name="name"><br />
					<label> Description: </label> <br />
					<textarea style="resize: none" rows="12" cols="120"
						name="description" form="brand_form" id="brand_description"></textarea>
					<br /> <label> Picture: </label> <input type="file" name="myimage"
						accept="image/*" />
				</form>
				<br />
				<button id="upload_brand">Upload brand</button>
			</div>
		</div>

		<div id="product_tab" class="tab">
			<p class="title">Product</p>
			<div id="panel">

				<div id="content-1" class=" table_panel content mCustomScrollbar">
					<table>
						<thead>
							<tr>
								<td>Id</td>
								<td>Name</td>
								<td>Brand</td>
								<td>Subcategory</td>
								<td>Category</td>
								<td>Options</td>
							</tr>
						</thead>
						<tbody id="product_table">
						</tbody>
					</table>
				</div>
				<button id="reload_products">Load products</button>
				<button id="toggle_products_uploader">Product uploader</button>
				<div id="add_products">
					<p>Product uploader</p>
					
					<label> Name: </label> <br /> <input type="text" name="name"
						id="product_uploader_name"><br /> <label>
						Subcategory: </label> <br /> <select id="product_subcat_add"></select> <br />
					<label> Brand </label><br /> <select id="product_brand_add">
					</select><br />
										
					<button id="send_upload_product">Upload</button>
					
					<div class="text_area_prd_add">
						<p>Description:</p>
						<textarea style="resize: none" rows="12" cols="110"
							name="description" id="product_description_add"></textarea>
					</div>
					<div class="text_area_prd_add">
						<p>Supplements:</p>
						<textarea style="resize: none" rows="12" cols="110"
							name="supplements" id="product_suplements_add"></textarea>
					</div>
				</div>

				<div id="product_info" class="product_info_wide">
				<input type="hidden" id="current_prd_id">
					<p>Product details</p>
					<div id="name">
						<p>Name:</p>
						<input type="text" name="name" id="product_detail_name">
					</div>
					<div id="product_image"></div>
					<div id="subc">
						<p>Subcategory</p>
						<select id="subcategory_option">
						</select>
					</div>
					<div id="brand">
						<p>Brand</p>
						<select id="brand_option">
						</select>
					</div>
				
					<div id="detail_info_panel">
						<p>Quantity</p>
						<select id="detail_infos">
						</select>

						<p>Old price:</p>
						<input type="text" name="name" id="old_price">
						<p>Current price:</p>
						<input type="text" name="name" id="current_price"><br />

						<button id="remove_quantity">Remove Quantity</button>
					</div>


					<div id="detail_info_add">
						<form id="product_info_form" accept-charset="utf-8">
							<!-- Product Id for tastes! -->
							<input type="hidden" name="product_id" id="prd_id">
							<p>Quantity</p>
							<input type="text" name="quantity" id="quantity_val">
							<p>Old price:</p>
							<input type="text" name="old_price" id="old_price_val">
							<p>Current price:</p>
							<input type="text" name="current_price" id="current_price_val">
							<br /> <input type="file" name="image_product" accept="image/*"
								id="det_image_val" />
						</form>
						<button id="add_quantity">Add Quantity</button>
					</div>
					<button id="show_taste_prd">Add quantity and taste panels</button>

					<div id="content-1"
						class=" table_panel content mCustomScrollbar taste_prd_add">
						<label>Tastes</label>
						<table>
							<thead>
								<tr>
									<td>Id</td>
									<td>Name</td>
									<td>Options</td>
								</tr>
							</thead>
							<tbody id="product_taste_table">
							</tbody>
						</table>

					</div>
					
					<select id="left_taste_product">
					</select>
					<button id="add_one_taste">Add taste</button>
					<div id="desc">
						<p>Description:</p>
						<textarea style="resize: none" rows="12" cols="110"
							name="description" id="product_description"></textarea>
					</div>
					<div id="suppl">
						<p>Supplements:</p>
						<textarea style="resize: none" rows="12" cols="110"
							name="supplements" id="product_suplements"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div id="orders_tab" class="tab">
			<p class="title">Orders</p>
			<div id="panel">
					<fs:AdminPanelOrders></fs:AdminPanelOrders>
			</div>
		</div>

	</div>
	<script
		src="${pageContext.request.contextPath}/resources/theme1/js/jquery.mCustomScrollbar.concat.min.js"></script>

	<script>
		(function($) {
			$(window).on("load", function() {

				$("#content-1").mCustomScrollbar({
					theme : "minimal"
				});

			});
		})(jQuery);
	</script>
</body>
</html>


function addToCart(pid,pimg,pname,pprice){
	
	let cart = localStorage.getItem("cart");
	
	if(cart == null){
		//cart is empty
		
		let products = [];
		
		let product = {productId : pid, productImg : pimg, productName : pname, productPrice : pprice};
		
		products.push(product);
		
		localStorage.setItem("cart", JSON.stringify(products));
		console.log("product s added first time")
	}
	else{
		//cart is already present
		
		let pcart = JSON.parse(cart);
		
		
		let oldproduct = pcart.find((item)  => item.productId == pid)
		
		if(oldproduct){
			//we have to increase the quantity
			oldproduct.productQuantity = oldproduct.productQuantity + 1;
			
			pcart.map((item) =>{
				if(item.productId == oldproduct.productId){
					item.productQuantity = oldproduct.productQuantity;
				}
			})
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("product s quantity is ncreasess")
		}
		
		
		else{
			//we have to add the quantity
			
			let product = {productId : pid, productImg : pimg, productName : pname, productPrice : pprice};
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("product s added")
		}
	}
	updatCart();
}



//Update Cart

function updatCart(){
	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);
	
	if(cart == null || cart.length == 0){
		console.log("cart is empty")
		$(".cart-item-count").html("0");
		$(".cart-body").html("<h3>Your Cart is Empty </h3>");
		$(".checkout-btn").addClass('disabled');
	}
	else{
		console.log("cart")
		
		$(".cart-item-count").html(`${cart.length}`);
		
		let table = `<table class='table'>
						<thead class='thead'>
							<tr>
								<th>Image</th>
								<th>Name</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Total Price</th>
								<th>Action</th>
							</tr>
						</thead>
					 
		
		`;
		
		cart.map((item) =>{
			
			table += `<tr>
						  <td> ${item.productImg} </td>
						  <td> ${item.productName} </td>
						  <td> ${item.productPrice} </td
						  <td> ${item.productQuantity} </td>
						  <td> ${item.productQuantity * item.productPrice} </td>
						  <td> ${item.productPrice} </td> 
					  </tr>
			
			
			
			`
		})
		
		table = table + `</table>`
		
		$(".cart-body").html(table);
	}
}

$(document).ready(function(){
	updatCart();
})


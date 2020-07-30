export class Data {
}
export class orderInformation{
    
        orderId:number;
        recipientName:String;
        recipientPhoneNumber:String;
        streetAddress:String;
        city:String;
        zipCode:number;
        country:String;
        shippingAddress:String;
	    quantity:number;
	    totalPrice:number;
	    orderStatus:String;
	    paymentMethod:String;
	    orderDate:Date;
	    cart:CartInformation[];
	    customer:CustomerInformation;
}

export class BookInformation{

	bookId:number;
	title:String;
	author:String;
	description:String;
	rating:number;
	isbnNumber:String;
	publishDate:Date;
	lastUpdateTime:Date;
	price:number;
	category:BookCategory  
}
export class CustomerInformation{
	customerId:number;
	emailAddress:String;
	fullName:String;
	password:String;
	phoneNumber:String;
	address:String;
	city:String;
	zipCode:number;
	country:String;
	registerDate:Date;
}
export class BookCategory{
    categoryId:number;
	categoryName:String;
}

export class CartInformation{

    cartId:number;
   customerId:number;
    quantity:number;
    status:String;
	book:BookInformation;
	subTotal:number;
}
export class CustomerReview{
    
	reviewId:number;
	customerId:number;
	bookRating:number;
	reviewHeadline:String;
	reviewComment:String;
	book:BookInformation ;
}
export class Admin{
     adminId:number;
	 email:string;
	 fullName:string;
	 password:string;
}

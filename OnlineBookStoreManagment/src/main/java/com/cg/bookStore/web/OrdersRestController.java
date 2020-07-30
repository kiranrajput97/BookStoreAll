package com.cg.bookStore.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.OrderInformation;
import com.cg.bookStore.exceptions.UserDefineException;
import com.cg.bookStore.service.BookService;
import org.springframework.http.HttpStatus;


/************************************************************************************
*          @author          Satyam Sinha 
*          Description      It is a controller class that process action for 
*                           listing, deleting, cancel and view orders
*          Version          1.0
*          Created Date     18-Jul-2020
************************************************************************************/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrdersRestController {

	@Autowired
	public BookService service;
	
	/************************************************************************************
	 * @author                      Satyam Sinha 
	 * Method:                      view orders
     * Description:                 To cancel order
	 * @mapping GetMapping          Make HTTP request to get view order 
	************************************************************************************/
	@GetMapping("/viewOrderDetailsById/{orderId}")
	public OrderInformation viewOrderDetails(@PathVariable int orderId) throws UserDefineException
	{
		return service.viewOrderDetails(orderId);	
	}


	
	/************************************************************************************
	 * @author                       Himanshu Rai
	 * Method:                       remove book
     * Description:                  To cancel order
	 * @throws UserDefineException 
	 * @mapping GetMapping           Make HTTP request to get cancle order 
	************************************************************************************/
	
	@DeleteMapping("/removebook/{orderId}/{cartId}")
	public String removeBook(@PathVariable("orderId")int orderId,@PathVariable("cartId")int cartId) throws UserDefineException
	{
		service.removeCartBook(orderId,cartId);
		return "Book Removed Sucessfully";
		
	}
	
	/************************************************************************************
	 *  @author                     Satyam Sinha 
	 * Method:                      cancel orders
     * Description:                  To cancel order
	 * @throws UserDefineException 
	 * @mapping GetMapping           Make HTTP request to get cancle order 
	************************************************************************************/
	
	@GetMapping("/cancelOrder/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable int orderId) throws UserDefineException
		{
		/*String order_Id=Integer.toString(orderId);
		if(!(order_Id.matches("[0-9]+")))
		{
			throw new OrdersException("Order Id must be digit");
		}*/
		String result="Order Id Not Found";
		if(service.findOrderById(orderId))
		{			
			result=service.cancleOrder(orderId);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	
	/************************************************************************************
	 *  @author                      Kiran Rajput
	 * Method:                       List all orders
     * Description:                  To List all orders
	 * @param listOrders	         List all orders
	 * @throws UserDefineException 
	 * @mapping GetMapping           Make HTTP request to get all appointments 
	************************************************************************************/
	@GetMapping("/listOrders")
	public List<OrderInformation> showOrder() throws UserDefineException
	{
		
		List<OrderInformation> orders = service.showOrderList();
		/*if(orders==null)
		{
			throw new OrdersException("order list is null");
		}*/
		return orders;	
	}
	
	
	/************************************************************************************
	 *  @author                      Apurv verma
	 * Method:                       Update orderDetails
     * Description:                  To cancel order
	 * @throws UserDefineException 
	 * @mapping GetMapping           Make HTTP request to get cancle order 
	************************************************************************************/
	@PutMapping("/update_order/{orderId}")
	public void updateShippingAddress(@PathVariable int orderId, @RequestBody OrderInformation orderInfo) throws UserDefineException    
	{
		service.updateOrder(orderId, orderInfo);
    }
	
/*
 * Login Module 
 */
	
	@GetMapping("/adminlogin/{email}/{password}")
	public ResponseEntity<String> adminlogin(@PathVariable("email")String email, @PathVariable("password")String password) throws UserDefineException {
		
		Admin admin=service.loginAdmin(email, password);
		
		return new ResponseEntity<String>("LoggedIn Succesfully", HttpStatus.OK);
	}


}

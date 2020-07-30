package com.cg.bookStore.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.OrderInformation;

/************************************************************************************
 *          @author          Satyam Sinha
 *          Description      It is a dao class that provides the methods for listing,
 *          deleting, cancel and view orders
 *          Version             1.0
 *          Created Date     18-JUL-2020
 ************************************************************************************/
@Repository
public interface BookDao {

	/************************************************************************************
	 * @author                        Satyam Sinha
	 * Method:                        view order 
	 * Description:                   To view the particular Order Details
	 * Process                        using orderId we fetch the order Information.
	 ************************************************************************************/
	public OrderInformation viewOrderDetails(int orderId);
	
	
	/************************************************************************************
	 * @author                        Satyam Sinha
	 * Method:                        cancel order 
	 * Description:                   To cancel the order first check order id exists or not.
	 * Process                        using orderId we check order is present or not in database.
	 ************************************************************************************/
	 public boolean findOrder(int orderId);
		
		/************************************************************************************
		 * @author                        Satyam Sinha
		 * Method:                        cancel order 
		 * Description:                   To cancel the order first check get the order details.
		 * Process                        using orderId we get the Order details and check the OrderStatus.
		 ************************************************************************************/
		public OrderInformation getOrderDetails(int orderId);
		/************************************************************************************
		 * @author                        Satyam Sinha
		 * Method:                        cancel order 
		 * Description:                   To cancel the order we have to change the Order Status.
		 * Process                        using orderId and orderstatus we update the status to cancled.
		 ************************************************************************************/
		public void updateOrderStatus(int orderId,String orderStatus);
		
		/************************************************************************************
		 * @author                        Kiran Rajput
		 * Method:                        List order information
	     * Description:                   To fetch the details of the order 
		 * Process                        By select the OrderInformation all details.          
		 ************************************************************************************/
		public List<OrderInformation> showListOrder();
		
		/************************************************************************************
		 * @author                        Apurv verma
		 * Method:                        Update Order Information 
	     * Description:                   Update orderstatus,recipient name, mobile number and shipping address.
		 * Process                        Using orderId and .          
		 ************************************************************************************/
				
		 public boolean updateOrderInfo(OrderInformation orderInfo);
		
		/************************************************************************************
		 * @author                        Himanshu Rai
		 * Method:                        Remove Book 
	     * Description:                   remove Book from Order
		 * Process                        Using orderId and CartId we fetch the order and remove the cart.          
		 ************************************************************************************/
		public boolean removeCartBook(int orderId,int cartId);
		
		
		
		/*
		 * Login Module Function
		 */
		boolean checkAdminByEmail(String email);
		Admin getAdminByEmail(String email);
	
	
    
}

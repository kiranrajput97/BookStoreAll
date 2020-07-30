package com.cg.bookStore.service;

import java.util.List;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.OrderInformation;
import com.cg.bookStore.exceptions.UserDefineException;


/************************************************************************************
*          @author          Satyam Sinha
*          Description      It is a service class that provides the services for 
*                           Listing , cancel and update order Information
*          Version          1.0
*          Created Date     18-JUL-2020
************************************************************************************/
public interface BookService {
	public OrderInformation viewOrderDetails(int orderId)throws UserDefineException;
	
	/************************************************************************************
	 * @author                        Satyam Sinha
	 * Method:                        find Order
     * Description:                   to check Order is present or not
	************************************************************************************/
	public boolean findOrderById(int orderId);
	/************************************************************************************
	 * @author                        Satyam Sinha
	 * Method:                        cancel Order
     * Description:                   to cancel orders 
	************************************************************************************/
	public String cancleOrder(int orderId)throws UserDefineException;
	
	/************************************************************************************
	 * @author                        Kiran Rajput
	 * Method:                        List Order
     * Description:                   to list all the orders 
	************************************************************************************/
	public List<OrderInformation> showOrderList()throws UserDefineException;
	/************************************************************************************
	 * @author                        Apurv verma
	 * Method:                        update Order Information
     * Description:                   to update the order details 
	************************************************************************************/
	public boolean updateOrder(int orderId,OrderInformation order)throws UserDefineException;
	/************************************************************************************
	 * @author                        Himanshu Rai
	 * Method:                        remove book from Order
     * Description:                   to remove book from order 
	************************************************************************************/
	public boolean removeCartBook(int orderId,int cartId)throws UserDefineException;
	
	
	/*
	 * Login Module Function
	 */
	public Admin loginAdmin(String email, String password) throws UserDefineException;
	
	
}
 

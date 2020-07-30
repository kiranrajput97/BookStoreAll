package com.cg.bookStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.bookStore.dao.BookDao;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.OrderInformation;
import com.cg.bookStore.exceptions.UserDefineException;

/************************************************************************************
 *          @author         Satyam Sinha
 *          Description      It is a A Book service Interface class that provides Interface for the, 
                             service class and all its components  
  *         Version             1.0
  *         Created Date    18-JUL-2020
 ************************************************************************************/
@Service("Orderser")
@Transactional
public class BookServiceImpl implements BookService{


	@Autowired
	private BookDao bookDao;
	
	
	/************************************************************************************
	 * Method:                        view order 
     * Description:                   To view the  details of the order using orderId
	 ************************************************************************************/
	@Override
	public OrderInformation viewOrderDetails(int orderId) throws UserDefineException {
	
		OrderInformation order = bookDao.viewOrderDetails(orderId);
		if(order==null)
			throw new UserDefineException("Order Is Not Found");
		return order;
	}
	
	/************************************************************************************
	 * Method:                        check order 
     * Description:                   To check the details of the order using orderId
	 ************************************************************************************/

	@Override
	public boolean findOrderById(int orderId) {
		// TODO Auto-generated method stub
		return bookDao.findOrder(orderId);
	}
	/************************************************************************************
	 * Method:                        cancel order 
     * Description:                   To cancel the details of the order using orderId
	 ************************************************************************************/
	@Override
	public String cancleOrder(int orderId)throws UserDefineException {
		// TODO Auto-generated method stub
		OrderInformation orderDetails=new OrderInformation();
		orderDetails=bookDao.getOrderDetails(orderId);
		
		if(orderDetails.getOrderStatus().equals("Processing"))
		{
			bookDao.updateOrderStatus(orderId, "Cancelled");
			return "Order is Cancelled";
		}
		else if(orderDetails.getOrderStatus().equals("Cancelled"))
		{
			return "Order is already Cancelled";
		}
		else if(orderDetails.getOrderStatus().equals("Shipped"))
		{
			return "Cannot Cancelled Order, Order is already Shipped";
		}
		else if(orderDetails.getOrderStatus().equals("Delivered"))
		{
			return "Cannot Cancelled Order, Order is already Delivered";
		}
		throw new UserDefineException("Order Is Not Found");
	}



	/************************************************************************************
	 * Method:                        List order information
     * Description:                   To fetch the details of the order 
	 ************************************************************************************/
	@Override
	public List<OrderInformation> showOrderList()throws UserDefineException {
		// TODO Auto-generated method stub
		return bookDao.showListOrder();
	}


	

	/************************************************************************************
	 * Method:                         Update Customer Information
     * Description:                   To update the details of the order using orderId and order Information
	 ************************************************************************************/

	@Override
	public boolean updateOrder(int orderId, OrderInformation order)throws UserDefineException {
		
		if(bookDao.findOrder(orderId))
		{
			bookDao.updateOrderInfo(order);
			return true;	
		}
		else
			throw new UserDefineException("Order Is Not Found");
		
	}

	/************************************************************************************
	 * @author                        Himanshu Rai
	 * Method:                         remove Customer Information
     * Description:                   To rmeove the details of book in order using orderId and cartId
	 ************************************************************************************/
	@Override
	public boolean removeCartBook(int orderId, int cartId) throws UserDefineException{
		
		if(bookDao.findOrder(orderId))
		{
			bookDao.removeCartBook(orderId, cartId);
			return true;	
		}
		else
			throw new UserDefineException("Order Is Not Found");
	}
	
	
	/*
	 * Login Module Function
	 */
	
	@Override
	public Admin loginAdmin(String email, String password)throws UserDefineException {
		if(!bookDao.checkAdminByEmail(email))
				throw new UserDefineException("Admin is not registered with this email");
		
		Admin admin=bookDao.getAdminByEmail(email);
		
		if(!(admin.getPassword().equals(password)))
				throw new UserDefineException("Admin is not registered with this email");
		
		return admin;
	}
	
	
}
package com.cg.bookStore.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.CartInformation;
import com.cg.bookStore.entity.OrderInformation;


/************************************************************************************
 *          @author          Satyam Sinha
 *          Description      It is a A Book Dao Interface class that provides Interface for the, 
                             DAo class and all its components  
  *         Version             1.0
  *         Created Date    18-JUL-2020
 ************************************************************************************/
@Transactional
@Repository
public class BookDaoImpl implements BookDao{

	@PersistenceContext
	private EntityManager entityManager;
		

	/************************************************************************************
	 * Method:                        view order information
     * Description:                   To view order details by order id. 
	 ************************************************************************************/
	@Override
	public OrderInformation viewOrderDetails(int orderId) {
		return entityManager.find(OrderInformation.class,orderId);
	}
	

	/************************************************************************************
	 * Method:                        find order information
     * Description:                   Check Order is exits or not.
	 ************************************************************************************/
			@Override
			public boolean findOrder(int orderId) {
				// TODO Auto-generated method stub
				return entityManager.contains(entityManager.find(OrderInformation.class, orderId));
				
			}
			/************************************************************************************
			 * Method:                        Update orderStatus 
		     * Description:                   Update Orderstatus in Order Infromation
			 ************************************************************************************/
			@Override
			public void updateOrderStatus(int orderId, String orderStatus) {
				// TODO Auto-generated method stub
				entityManager.find(OrderInformation.class, orderId).setOrderStatus(orderStatus);
			}

			/************************************************************************************
			 * Method:                        get Order Details
		     * Description:                   get  Order Infromation details by orderId
			 ************************************************************************************/
			@Override
			public OrderInformation getOrderDetails(int orderId) {
				// TODO Auto-generated method stub
				return entityManager.find(OrderInformation.class, orderId);
			}
			
			/************************************************************************************
			 * Method:                        List order information
		     * Description:                   To fetch the details of the order 
			 ************************************************************************************/
			@Override
			public List<OrderInformation> showListOrder() {
				// TODO Auto-generated method stub
				Query query= entityManager.createQuery("from OrderInformation o");
				List<OrderInformation> orders = query.getResultList();
				return orders;
			}
			
			
			/************************************************************************************
			 * Method:                        Update OrderInformation
		     * Description:                   Update OrderInformation using inbuilt merge function.
			 ************************************************************************************/			
			@Override
			public boolean updateOrderInfo(OrderInformation orderInfo) 
			{
				entityManager.merge(orderInfo);
				return false;
			}

			/************************************************************************************
			 * @author                        Himanshu Rai
			 * Method:                        Remove Book From Order
		     * Description:                   To fetch the details of the order and remove book
			 ************************************************************************************/
			@Override
			public boolean removeCartBook(int orderId, int cartId) {
				List<CartInformation> cartlist=new ArrayList<CartInformation>();
				cartlist=entityManager.find(OrderInformation.class, orderId).getCart();
				for(CartInformation cart :cartlist )
				{
				    if(cart.getCartId()==cartId)
				    {
				    	entityManager.find(OrderInformation.class, orderId).setQuantity(entityManager.find(OrderInformation.class, orderId).getQuantity()-cart.getQuantity());
				    	entityManager.find(OrderInformation.class, orderId).setTotalPrice(entityManager.find(OrderInformation.class, orderId).getTotalPrice()-cart.getSubTotal());
				    	cartlist.remove(cart);
				    	break;
				    }
				}
				
				entityManager.find(OrderInformation.class, orderId).setCartId(cartlist);
			
				return true;
			}
			
			
			
			/*
			 * Login Module Function
			 */
			

			@Override
			public Admin getAdminByEmail(String email) {
				String findquery="Select admin FROM Admin admin WHERE admin.email= :email";
				TypedQuery<Admin> query=entityManager.createQuery(findquery,Admin.class).setParameter("email",email);
				return query.getSingleResult();
			}
			/*
			 * Login Module Function
			 */
			
			@Override
			public boolean checkAdminByEmail(String email) {
				String checkquery="Select admin.email FROM Admin admin WHERE admin.email= :email";
				TypedQuery<String> query=entityManager.createQuery(checkquery,String.class).setParameter("email",email);
				try {
					
					query.getSingleResult();
					
				} catch(Exception exception) {
					
					return false;
				}
				
				return true;
			}

	}








		








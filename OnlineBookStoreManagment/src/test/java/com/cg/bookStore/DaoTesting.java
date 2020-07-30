package com.cg.bookStore;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.bookStore.dao.BookDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTesting {

		@Autowired
		BookDao cancleDao;
		 /*
         * Cancle Order 
         */
		@Test
		public void checkOrderNotExist()
		{
			boolean expectedValue=false;
			boolean actualValue=cancleDao.findOrder(100);
			assertEquals(expectedValue,actualValue);
		}
		 /*
         * Cancle Order 
         */
		@Test
		public void checkOrderExist()
		{
			boolean expectedValue=true;
			boolean actualValue=cancleDao.findOrder(1000);
			assertEquals(expectedValue,actualValue);
		}
		
	}


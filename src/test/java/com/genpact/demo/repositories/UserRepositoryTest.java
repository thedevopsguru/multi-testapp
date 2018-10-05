package com.genpact.demo.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.genpact.demo.model.User;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {



	@Autowired

	private UserRepository userRepository;



	/*private Long userId;



	@Before

	public void setup() throws Exception {

		

		User user = userRepository.save(new User(1L,"Jerry",11, 11000)); 

		userId = user.getId();

	}



	@Test

	public void findById() {

		User user = userRepository.getOne(userId);

		assertEquals(true, user.getId() != null);

	}*/

	 @Test
	  public void saveUser() {
	    User user = new User(1L,"Jerry",11, 11000);
	    userRepository.save(user);
	    Assert.assertNotNull(userRepository.getOne(1L));
	  }


	

}

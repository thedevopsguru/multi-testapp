package com.genpact.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.genpact.demo.DemoApplication;
import com.genpact.demo.model.User;
import com.genpact.demo.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
public class UserServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindAllUsers(){
		List<User> userList = new ArrayList<User>();
		userList.add(new User(11L,"Xyz",2, 21));
		userList.add(new User(12L,"Abc",3, 31));
		userList.add(new User(13L,"User",4, 41));
		when(userRepository.findAll()).thenReturn(userList);
		
		List<User> result = userService.findAllUsers();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testFindById(){
		User user = new User(11L,"Xyz",2, 21);
		when(userRepository.getOne(11L)).thenReturn(user);
		User result = userService.findById((long) 11);
		assertEquals(11, result.getId().longValue());
		assertEquals("Xyz", result.getName());
		assertEquals(2, result.getAge().intValue());
		assertEquals(21.0, result.getSalary(), 0);
	}
	
	@Test
	public void saveUser(){
		User user = new User(14L,"Xyzq",20, 200);
		
		when(userRepository.save(user)).thenReturn(user);
		userService.saveUser(user);		
		when(userRepository.getOne(14L)).thenReturn(user);
		User result = userService.findById((long) 14);
		assertEquals(14, result.getId().longValue());
		assertEquals("Xyzq", result.getName());
		assertEquals(20, result.getAge().intValue());
		assertEquals(200.0, result.getSalary(), 0);
	}
	
	
	
	@Test
	public void deleteUserById(){
		User user = new User(11L,"Xyz",2, 21);
		userService.deleteUserById(11L);
        verify(userRepository, times(1)).delete(11L);
	}
	


	

}
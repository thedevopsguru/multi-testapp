package com.genpact.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.genpact.demo.model.User;
import com.genpact.demo.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationIntegrationTest {
  
    @Autowired
    private UserRepository userRepository;
 
    @Test
    public void givenUserRepository_whenSaveAndRetreiveEntity_thenOK() {
        User user = userRepository
          .save(new User("Sam",11, 11000));
        User foundEntity = userRepository
          .findOne(user.getId());
  
        Assert.assertNotNull(foundEntity);
        Assert.assertEquals(user.getName(), foundEntity.getName());
    }
}
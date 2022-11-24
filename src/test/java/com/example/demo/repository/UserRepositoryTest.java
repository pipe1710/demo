package com.example.demo.repository;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.PersistenceContext;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void elRepositorioExiste() {
        System.out.println("perfet");
        assertNotNull(userRepository);
    }

    @Test
    void getUserByEmail() {
        User user = userRepository.findByEmail("agperezb@ufpso.edu.co");
        assertEquals("agperezb@ufpso.edu.co", user.getEmail());
    }

    @Test
    @DisplayName("test para guardar usuarios")
    void testSaveUser(){
        User user1 = new User();
        user1.setEmail("agperezb@ufpso.edu.co");
        user1.setPassword("1256");
        user1.setFirstName("Angel");
        user1.setLastName("Perez");
        user1.setAddress("Rio de oro");
        user1.setPhoneNumber("3101");

        User savedUser = userRepository.save(user1);

        User existUser = testEntityManager.find(User.class, savedUser.getId());
        System.out.println(existUser.getEmail());
        assertEquals(savedUser.getEmail(), existUser.getEmail());

    }

}

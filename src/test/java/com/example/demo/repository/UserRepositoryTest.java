package com.example.demo.repository;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void existRepository() {
        assertNotNull(userRepository);
    }

    @Test
    void existPassEncoder() {
        assertNotNull(passwordEncoder);
    }

    @Test
    void should_find_no_users_if_repository_is_empty() {
        List<User> users = userRepository.findAll();
        assertThat(users).isEmpty();
    }

    @Test
    void should_store_a_user() {
        User user = new User();
        user.setEmail("agperezb@ufpso.edu.co");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setFirstName("Angel");
        user.setLastName("Perez");
        user.setAddress("Rio de oro");
        user.setPhoneNumber("3101");

        User userSaved = userRepository.save(user);

        assertThat(userSaved).hasFieldOrPropertyWithValue("email", "agperezb@ufpso.edu.co");
    }

}

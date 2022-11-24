package com.example.demo.repository;



import static org.assertj.core.api.Assertions.assertThat;
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
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRespositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @DisplayName("test para guardar usuarios")
    @Test
    void testSaveUser(){
        User user1 = new User();
        user1.setEmail("afmontanos@ufpso.edu.co");
        user1.setPassword(passwordEncoder.encode("1256"));
        user1.setFirstName("Andres");
        user1.setLastName("Montaño");
        user1.setAddress("milanes");
        user1.setPhoneNumber("310");


        User savedUser = userRepository.save(user1);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertEquals(user1.getEmail(), existUser.getEmail());

    }

}

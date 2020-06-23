package mk.springframework.springrestclientexamples.services;

import mk.springframework.api.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getUsers() throws Exception {
        List<User> users = apiService.getUsers(1);
        assertEquals(1, users.size());
    }
}
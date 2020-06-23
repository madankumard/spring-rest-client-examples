package mk.springframework.springrestclientexamples.services;

import mk.springframework.api.domain.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ApiService {
    List<User> getUsers(Integer limit) throws IOException;
}

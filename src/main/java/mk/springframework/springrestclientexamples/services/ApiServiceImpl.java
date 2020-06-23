package mk.springframework.springrestclientexamples.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mk.springframework.api.domain.User;
import mk.springframework.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    @Value("classpath:user.json")
    Resource resourceFile;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(resourceFile.getURI()), StandardCharsets.UTF_8);

        String content = lines.collect(Collectors.joining(""));

        log.debug(content);

        ObjectMapper mapper = new ObjectMapper();
        UserData userData = mapper.readValue(content, UserData.class);
        return userData.getData();
    }

}

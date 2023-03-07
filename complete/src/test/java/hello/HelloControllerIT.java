package hello;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort
    private int port;

    private URL home;
    private URL greeting;
    private URL test;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.home = new URL("http://localhost:" + port + "/");
        this.greeting = new URL("http://localhost:" + port + "/greeting");
        this.test = new URL("http://localhost:" + port + "/test");
    }


    @Test
    public void getHome() throws Exception {
        ResponseEntity<String> response = template.getForEntity(home.toString(),
                String.class);
        assertEquals(response.getBody(), equalTo("Welcome home *"));
    }

    @Test
    public void getGreeting() throws Exception {
        ResponseEntity<String> response = template.getForEntity(greeting.toString(),
                String.class);
        assertEquals(response.getBody(), equalTo("Greetings from Spring Boot! I am J @.@"));
    }

    @Test
    public void getTest() throws Exception {
        ResponseEntity<String> response = template.getForEntity(test.toString(),
                String.class);
        assertEquals(response.getBody(), equalTo("This is Julie Testing *_*"));
    }

}

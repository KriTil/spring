package lv.accenture.bootcamp;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {


    @GetMapping("/hello")  //http://127.0.0.1:8080/hello - pieejams web lapā
    public String helloWorld() {


        return "Hello, World!";
    }


}

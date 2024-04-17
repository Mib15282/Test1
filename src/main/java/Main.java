import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    @Autowired
    SignUpService signUpService;
    public static void main(String[] args) {


    }
}


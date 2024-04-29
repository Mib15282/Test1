package rootPackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import rootPackage.services.SignUpService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        SignUpService signUpService = applicationContext.getBean(SignUpService.class);
        signUpService.signUp("email","password",AccountType.Viz);
        signUpService.signUp("email1","password1", AccountType.Admin);
        signUpService.signUp("email2","password2",AccountType.User);

    }
}



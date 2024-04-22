import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        LogInService logInService = LogInService.instance.getInstance();
        SignUpService signUpService = new SignUpService(logInService);
        //creez script care creeaza cont de fiecare tip
        signUpService.signUp("email","password",AccountType.Viz);
        signUpService.signUp("email1","password1",AccountType.Admin);
        signUpService.signUp("email2","password2",AccountType.User);

    }
}


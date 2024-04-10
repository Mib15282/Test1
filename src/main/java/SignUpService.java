import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Component
@Service
public class SignUpService {

    private LogInService logInService;

    public SignUpService(LogInService logInService) {
        this.logInService = logInService.getInstance();
    }

    public boolean signUp(String email, String password, AccountType accountType) {
        if (logInService.accountAlreadyExists(email)) {
            return false;
        }
        /*
        if (accountType == AccountType.Viz) {
            ContViz contViz = new ContViz(email, password);
            logInService.addContLista(contViz);
            return true;
        }
        if (accountType == AccountType.Admin) {
            ContAdmin contAdmin = new ContAdmin(email, password, new ArrayList<Cont>());
            logInService.addContLista(contAdmin);
            return true;
        }
        if (accountType == AccountType.User) {
            String id = UUID.randomUUID().toString();
            Cont contUser = new Cont(email, password, id);
            logInService.addContLista(contUser);
            return true;
        }

        Identic cu ce e mai joc - cateva linii + switch
        */

        switch (accountType) {
            case Viz -> {
                ContViz contViz = new ContViz(email, password);
                logInService.addContLista(contViz);
                return true;
            }
            case Admin -> {
                ContAdmin contAdmin = new ContAdmin(email, password, new ArrayList<Cont>());
                logInService.addContLista(contAdmin);
                return true;
            }
            case User -> {
                String id = UUID.randomUUID().toString();
                Cont contUser = new Cont(email, password, id);
                logInService.addContLista(contUser);
                return true;
            }
        }
        return false;
    }

}

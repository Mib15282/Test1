import data.Cont;
import data.ContAdmin;
import data.ContViz;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Component //cod intretinut in mod direct de sping boot
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
            data.ContViz contViz = new data.ContViz(email, password);
            logInService.addContLista(contViz);
            return true;
        }
        if (accountType == AccountType.Admin) {
            data.ContAdmin contAdmin = new data.ContAdmin(email, password, new ArrayList<data.Cont>());
            logInService.addContLista(contAdmin);
            return true;
        }
        if (accountType == AccountType.User) {
            String id = UUID.randomUUID().toString();
            data.Cont contUser = new data.Cont(email, password, id);
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

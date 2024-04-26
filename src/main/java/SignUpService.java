import data.Cont;
import data.ContAdmin;
import data.ContViz;
import data.repositories.ContAdminRepository;
import data.repositories.ContRepository;
import data.repositories.ContVizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Component //cod intretinut in mod direct de sping boot
@Service
public class SignUpService {
    ContRepository contRepository;
    ContVizRepository contVizRepository;
    ContAdminRepository contAdminRepository;

    private LogInService logInService;

    @Autowired
    public SignUpService(LogInService logInService,ContRepository contRepository, ContVizRepository contVizRepository, ContAdminRepository contAdminRepository) {
        this.logInService = logInService;
        this.contVizRepository = contVizRepository;
        this.contRepository = contRepository;
        this.contAdminRepository = contAdminRepository;
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
                contVizRepository.save(contViz);
                return true;
            }
            case Admin -> {
                ContAdmin contAdmin = new ContAdmin(email, password, new ArrayList<Cont>());
                contAdminRepository.save(contAdmin);
                return true;
            }
            case User -> {
                String id = UUID.randomUUID().toString();
                Cont contUser = new Cont(email, password, id);
                contRepository.save(contUser);
                return true;
            }
        }
        return false;
    }

}

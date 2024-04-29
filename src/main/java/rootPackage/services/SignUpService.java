package rootPackage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rootPackage.AccountType;
import rootPackage.data.Cont;
import rootPackage.data.ContAdmin;
import rootPackage.data.ContViz;
import rootPackage.data.repositories.ContAdminRepository;
import rootPackage.data.repositories.ContRepository;
import rootPackage.data.repositories.ContVizRepository;

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
        if (accountType == rootPackage.AccountType.Viz) {
            rootPackage.data.ContViz contViz = new rootPackage.data.ContViz(email, password);
            logInService.addContLista(contViz);
            return true;
        }
        if (accountType == rootPackage.AccountType.Admin) {
            rootPackage.data.ContAdmin contAdmin = new rootPackage.data.ContAdmin(email, password, new ArrayList<rootPackage.data.Cont>());
            logInService.addContLista(contAdmin);
            return true;
        }
        if (accountType == rootPackage.AccountType.User) {
            String id = UUID.randomUUID().toString();
            rootPackage.data.Cont contUser = new rootPackage.data.Cont(email, password, id);
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

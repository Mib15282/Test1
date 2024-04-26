import data.Cont;
import data.repositories.ContRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LogInService {
    ContRepository contRepository;

    @Autowired
    public LogInService (ContRepository contRepository){
        this.contRepository = contRepository;
    }

    public boolean logIn(String email, String password){
        Cont cont = new Cont();
        cont = contRepository.findAll().stream().filter(contTeoretic -> contTeoretic.getEmail().equals(email)).findFirst().orElse(cont);//nume teoretic de var
        if (cont.getEmail() == null) {
            return false;
        } else {
            for (int i = 0; i < 3; i++) {
                if (cont.checkPassword(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean accountAlreadyExists(String email){
        return (contRepository.findAll().stream().anyMatch(contTeoretic -> contTeoretic.getEmail().equals(email)));
        //^da true daca nu e, false daca e, asa ca inversam cu "!" sau inlocuim isEmpty() cu isPresent()
    }
}

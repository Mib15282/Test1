import java.util.ArrayList;
import java.util.List;

public class LogInService {
    public static LogInService instance;
    //la var daca e initiaizata nu poate fii modificata;

    List<Cont> lista = new ArrayList<>();
    public LogInService getInstance(){
        if(instance == null){
            instance = new LogInService();
        }
        return instance;
    }
    public void addContLista(Cont contExtern){
        this.lista.add(contExtern);
    }
    public boolean logIn(String email, String password){

        Cont cont = new Cont();
        cont = lista.stream().filter(contTeoretic -> contTeoretic.getEmail().equals(email)).findFirst().orElse(cont);//nume teoretic de var
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

}
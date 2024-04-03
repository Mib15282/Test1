import java.util.ArrayList;
import java.util.List;

public class ContAdmin extends Cont {
    List<Cont> listaConturiAdministrate = new ArrayList<>();

    public ContAdmin(String email, String password, List<Cont> listaConturiAdministrate) {
        super(email, password);
        this.listaConturiAdministrate = listaConturiAdministrate;
    }

    public void addContLista(Cont cont){
        this.listaConturiAdministrate.add(cont);
    }

    public void removeContLista(Cont cont){
        this.listaConturiAdministrate.remove(cont);
    }
}

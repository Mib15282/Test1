package rootPackage.data;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "tAdmin")
public class ContAdmin extends Cont {//conexiune intre 2 tabele one to many
    @OneToMany(mappedBy = "tUser")//tUser numele tabelului cu care seconecteaza
    List<Cont> listaConturiAdministrate = new ArrayList<>();

    public ContAdmin(String email, String password, List<Cont> listaConturiAdministrate) {
        super(email, password, "");
        this.listaConturiAdministrate = listaConturiAdministrate;
    }

    public void addContLista(Cont cont){
        this.listaConturiAdministrate.add(cont);
    }

    public void removeContLista(Cont cont){
        this.listaConturiAdministrate.remove(cont);
    }
}

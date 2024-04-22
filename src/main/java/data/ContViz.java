package data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tViz")
public class ContViz extends Cont {
    public ContViz(String email, String password){
        super(email, password, "");
    }
}

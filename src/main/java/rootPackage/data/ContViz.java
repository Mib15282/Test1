package rootPackage.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@NoArgsConstructor
@Component
@Entity
@Table(name = "tViz")
public class ContViz extends Cont {
    public ContViz(String email, String password){
        super(email, password, UUID.randomUUID().toString());
    }
}

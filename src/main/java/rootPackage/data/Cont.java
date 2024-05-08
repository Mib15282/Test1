package rootPackage.data;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "tUser")
public class Cont {
    @Id
    @Column(name = "userId")//O COLOANA poate avea si proprietatile unic si nullable(accepta null)
    private String id;
    @Column(name = "userEmail")
    private String email;
    @Column(name = "userPassword")
    private String password;
    @ManyToOne
    private ContAdmin admin;

    public Cont(String email, String password, String id){
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public Cont(){//constructor gol fara mail/parola
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getId(){return id;}
    public void setPassword(String password){
        this.password = password;
    }
    public void setMail(String email){this.email = email;}


    public boolean checkPassword(String password){
        if(this.password.equals(password))
            return true;
        else
            return false;
    }


}

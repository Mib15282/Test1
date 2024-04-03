public class Cont {
    private String email;
    private String password;

    public Cont(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Cont(){
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
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

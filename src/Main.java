import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cont> lista = new ArrayList<>();

        Cont contLogat;

        String idPersonal;
        boolean ok = false;
        boolean logat = false;

        while (ok == false) {
            System.out.println("Ai cont?");
            String imput = scanner.nextLine();//CIN
            if (imput.equals("Da")) {
                //introduce userul contul, citim contul, introduce parola citim parola

                System.out.println("Introdu Email");
                String email = scanner.nextLine();
                //Trecem prin lista sa vedem daca este

                Cont cont = new Cont();
                cont = lista.stream().filter(contTeoretic -> contTeoretic.getEmail().equals(email)).findFirst().orElse(cont);//nume teoretic de var

                /* for-ul acesta este echivalent cu stream-ul de mai sus
                for (int i = 0; i < lista.size(); i++) {
                    if(lista.get(i).getEmail().equals(mail)){
                        cont = lista.get(i);
                    }
                    else cont = cont;
                }
                 */
                if (cont.getEmail() == null) {
                    System.out.println("Contul nu exista");
                    ok = false;
                } else {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Introdu parola");
                        String password = scanner.nextLine();
                        if (cont.checkPassword(password)) {
                            System.out.println("GG");
                            ok = true;
                            logat = true;
                            break;
                            //Verificam daca parola e corecta de 3 ori,daca nu e trimis inapoi la inceput
                        } else {
                            System.out.println("Nein");
                            ok = false;
                        }
                    }
                }
            } else if (imput.equals("Nu")) {
                System.out.println("Ce cont vrei sa faci: admin/viz");
                imput = scanner.nextLine();

                if (imput.equals("admin")) {

                    System.out.println("Introdu email");
                    String email = scanner.nextLine();
                    System.out.println("Introdu parola");
                    String password = scanner.nextLine();
                    //+ai nevoie de security shit

                    List<Cont> listaAdministrare = new ArrayList<>();
                    ContAdmin cont = new ContAdmin(email, password, listaAdministrare);
                    lista.add(cont);

                    idPersonal = String.valueOf(UUID.randomUUID());



                } else if (imput.equals("viz")) {

                    //Create new account nevoie de mail si parola
                    System.out.println("Arunca mail");
                    String email1 = scanner.nextLine();

                    System.out.println("Arunca parolaa");
                    String password1 = scanner.nextLine();

                    //num clasa   num var  =  new  num constructor(variabile)
                    ContViz cont = new ContViz(email1, password1);
                    lista.add(cont);
                    System.out.println("Cont creat cu suces");
                    ok = false;
                } else {
                    ok = false;
                }
            }
        }
        System.out.println("Ce vrei sa faci in cont");
        System.out.println("log out, modifica cont, sterge cont");
        while(logat == true){
            String imput = scanner.nextLine();
            if(imput.equals("log out")){
                System.out.println("GG you're out");
                logat = false;
                //REMINDER: SA TE INTREBE DACA VREI SA REINTRI(PT A TESTA CONTUL MODIFICAT)


            } else if (imput.equals("modifica cont")) {
                System.out.println("Ce vrei sa modifici: mail, password");
                imput = scanner.nextLine();

                if (imput.equals("mail")) {
                    Cont contTemp = new Cont();
                    System.out.println("Introdu mail");
                    String mail = scanner.nextLine();

                    contTemp = lista.stream().filter(contTeoretic -> contTeoretic.getEmail().equals(mail)).findFirst().orElse(contTemp);
                    System.out.println("Introdu mail nou");
                    String mailNou = scanner.nextLine();
                    contTemp.setMail(mailNou);
                    System.out.println("Mailul a fost Modificat");

                    System.out.println("Ce vrei sa faci in cont");
                    System.out.println("log out, modifica cont, sterge cont");

                } if (imput.equals("password")) {
                    Cont contTemp = new Cont();
                    System.out.println("Introdu password");
                    String password = scanner.nextLine();

                    contTemp = lista.stream().filter(contTeoretic -> contTeoretic.getPassword().equals(password)).findFirst().orElse(contTemp);
                    System.out.println("Introdu password nou");
                    String passwordNou = scanner.nextLine();
                    contTemp.setPassword(passwordNou);
                    System.out.println("Parola a fost modificata");

                    System.out.println("Ce vrei sa faci in cont");
                    System.out.println("log out, modifica cont, sterge cont");
                    //CUM E MODIFICA IN ARRAY LIST(CRISTI)
                }

            } else if (imput.equals("sterge cont")) {
                System.out.println("Introdu Email");
                String email = scanner.nextLine();
                System.out.println("Introdu parola");
                String password = scanner.nextLine();

                //Cont temporar pentru stergere
                Cont contTemp = new Cont(email, password);
                //Cautam contul in lista
                contTemp = lista.stream().filter(contTeoretic -> contTeoretic.getEmail().equals(email)).findFirst().orElse(contTemp);

                lista.remove(contTemp);
                System.out.println("Contul a fost sters");
                logat = false;
                }
            }
        }
    }
    //CRISTI NU A STIUT SA MA INVETE SA MODIFIC IN LISTA ASA CA NU A IEST CE VOIAM :DDD but I did my best
//azi am invatat cum sa dam cu pietre in set-ul ala (saracul) pana schimba contul :DDDDDDDDDD btw e 12:54
//and i'm having the fun of my life :D
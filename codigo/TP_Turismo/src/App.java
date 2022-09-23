import java.beans.JavaBean;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

     /**
     * teste funcionalidade das classe
     * 
     */
        Trecho trecho = new Trecho();
        trecho.addTrecho("parana", "curitiba", "4552");
        Voo voo =  new Voo();
        Date data = new Date(122, 04, 1);
        voo.addTrecho(trecho);
        voo.addData(data);
        Bilhete bilhete = new Bilhete();
        bilhete.addVoo(voo);
        System.out.println(bilhete.showVoo());
    }
}

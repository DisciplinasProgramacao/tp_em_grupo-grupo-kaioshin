import java.util.Date;

public class Voo {
    private static String ID_VOO = "7845";
    private Trecho trecho;
    private Date data;

    public void addTrecho(Trecho trecho){
        this.trecho = trecho;
    }

    public Trecho removeTrecho(String idTrecho){
        Trecho aux;
        aux = this.trecho;
        this.trecho = null;
        return aux;
    }

    public void addData(Date data){
        this.data = data;
    }
    
    public String toString(){
        String s;
        StringBuilder str = new StringBuilder("Voo : " + ID_VOO + " || " + data + " || ");
        str.append(trecho.toString());
        s = str.toString();
        return s;
    }
}

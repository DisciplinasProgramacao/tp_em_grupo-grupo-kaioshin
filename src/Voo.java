import java.sql.Date;

public class Voo {
    private static int ID_VOO = 0;
    private static String voo;
    private Date data_voo;
    private Trecho trecho;

    public Voo(Date data_voo, Trecho trecho) {
        this.ID_VOO = ++ID_VOO;
        this.data_voo = data_voo;
    }

    public void addTrecho(Trecho trecho) {
        this.trecho = trecho;
    }

    public void addData(Date data_voo) {
        this.data_voo = data_voo;
    }
}
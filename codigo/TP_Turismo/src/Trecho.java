import java.util.ArrayList;

public class Trecho {
    private ArrayList<String> conexoes = new ArrayList<String>();
    private int id;
    private String origem;
    private String destino;
    private int cont = 1;

    public void addTrecho(String origem, String destino, int idTrecho, ArrayList conexao){
        this.origem = origem;
        this.destino = destino;
        this.id = idTrecho;
        this.conexoes = conexao;
        calcTrechos();
    }

    public int idTrecho() {
        return this.id;
    }

    public void calcTrechos() {
        for (String c : conexoes) {
            this.cont++;
        }
        this.cont--;
    }

    public String toString() {
        String s;
        StringBuilder str = new StringBuilder("Trecho : " + id);
        str.append(" || Origem: " + origem);
        
        for (String c : conexoes) {
            str.append(" || Conexão: " + c);
        }
        
        str.append(" || Destinho : " + destino + "\n");
        s = str.toString();
        return s;
    }

    public int getQtdTrechos() {
        return this.cont;
    }
}

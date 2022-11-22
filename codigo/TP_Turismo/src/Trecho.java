import java.util.ArrayList;

public class Trecho {
    private ArrayList<String> conexoes = new ArrayList<String>();
    private int id;
    private String origem;
    private String destino;

    public void addTrecho(String origem, String destino, int idTrecho, ArrayList conexao){
        this.origem = origem;
        this.destino = destino;
        this.id = idTrecho;
        this.conexoes = conexao;
    }

    public int idTrecho() {
        return this.id;
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
}

import java.util.ArrayList;

public class Trecho {
    private ArrayList<String> conexoes = new ArrayList<String>();
    private int id;
    private String origem;
    private String destino;
    private int cont = 0;

    public Trecho(String origem, String destino, int idTrecho, ArrayList<String> conexao){
        this.origem = origem;
        this.destino = destino;
        this.id = idTrecho;
        this.conexoes = conexao;
        this.calcTrechos();
    }

    public int idTrecho() {
        return this.id;
    }

    public void calcTrechos() {
        if(conexoes.isEmpty()){
            return;
        } else {
            for (String c : this.conexoes) {
                if(c == null){
                    return;
                } 
                
                this.cont++;
            }
                
        }
        
    }

    public String toString() {
        String s;
        StringBuilder str = new StringBuilder("Trecho: " + id);
        str.append(" || Origem: " + origem);
        
        for (String c : conexoes) {
            str.append(" || Conexão: " + c);
        }
        
        str.append(" || Destinho: " + destino + "\n");
        s = str.toString();
        return s;
    }

    public int getQtdTrechos() {
        return this.cont;
    }
}

public class Trecho {
    
    private int id;
    private String origem;
    private String destino;

    public void addTrecho(String origem, String destino, int idTrecho){
        this.origem = origem;
        this.destino = destino;
        this.id = idTrecho;
    }

    public int idTrecho() {
        return this.id;
    }

    public String toString() {
        String s;
        StringBuilder str = new StringBuilder("Trecho : " + id);
        str.append(" || origem : " + origem + " || destinho : " + destino + "\n");
        s = str.toString();
        return s;
    }
}

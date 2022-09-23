public class Trecho {
    
    private String id;
    private String origem;
    private String destino;

    public void addTrecho(String origem, String destino, String idTrecho){
        this.origem = origem;
        this.destino = destino;
        this.id = idTrecho;
    }

    public String idTrecho(){
        return id;
    }

    public String toString(){
        String s;
        StringBuilder str = new StringBuilder("Trecho : " + id);
        str.append(" || origem : " + origem + " || destinho : " + destino);
        s = str.toString();
        return s;
    }
}

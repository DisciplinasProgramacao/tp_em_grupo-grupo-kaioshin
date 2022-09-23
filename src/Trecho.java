public class Trecho {
    private static int id = 0;
    private String origem;
    private String destino;

    
    public Trecho(String origem, String destino) {
        this.id = ++this.id;
        this.origem = origem;
        this.destino = destino;
    }
}

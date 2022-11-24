public enum Acelerador {
    PRATA(12.99, "Prata", true),
    PRETO(19.99, "Preto", true),
    PADRAO(0.0, "Não possui Acelerador", false);

    double custo;
    String descricao;
    boolean ativo;

    Acelerador(double custo, String desc, boolean ativo) {
        this.custo = custo;
        this.descricao = desc;
        this.ativo = ativo;
    }

    public double multiplicator(double pontos) {
        return pontos * 1.25;
    }

    public void activate() {
        this.ativo = true;
    }

    public void cancelAcelerator() {
        this.ativo = false;
    }

    double getCusto(){
        return this.custo;
    }

    @Override
    public String toString(){
        return this.descricao+ " - R$ "+this.custo;
    }
    
}
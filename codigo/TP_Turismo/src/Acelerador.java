public enum Acelerador {
    PRATA(12.99, "Prata", 1.25),
    PRETO(19.99, "Preto",1.5),
    PADRAO(0.0, "Não possui Acelerador", 1);

    double custo;
    String descricao;
    double multiplicador;

    Acelerador(double custo, String desc, double multiplicador) {
        this.custo = custo;
        this.descricao = desc;
        this.multiplicador = multiplicador;
    }

    public double multiplicator(double pontos) {
        return pontos * this.multiplicador;
    }

    double getCusto() {
        return this.custo;
    }

    @Override
    public String toString() {
        return this.descricao+ " - R$ "+this.custo;
    }
    
}
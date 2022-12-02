import java.util.ArrayList;
import java.util.*;

//Sprint 3
/**
 * Na fase 3 será implementado o processo de compra efetiva dos bilhetes pelos clientes. 
 * 
 * Um cliente precisa ter todas as suas compras armazenadas por ordem cronológica de data de voo. As compras
 * obedecem às regras anteriores de venda de bilhetes, as quais são complementadas por estas:
 * • A cada 10.500 pontos acumulados em um período de 12 meses, o cliente ganha o próximo
 * bilhete de graça. Lembre-se que este bilhete não dá direito a pontos.
 * • Um cliente pode contratar um acelerador de pontos. Um acelerador dá direito a um
 * multiplicador de pontos originalmente obtidos em qualquer bilhete enquanto estiver ativo.
 * Temos dois tipos de aceleradores: prata, com multiplicador 1.25 e preto, com multiplicador 1.5
 * Cada acelerador tem um custo mensal e pode ser trocado ou desativado a qualquer momento.
 */
public class Cliente {
    private static int ID = 0;
    private String cpf;
    private ArrayList<Compra> compras = new ArrayList<Compra>();
    private double pontos = 0;
    private String nome;
    private Acelerador acelerador = Acelerador.PADRAO;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.ID = ++Cliente.ID;        
    }

    
    //calcular os pontos

    public void disabledAcelerator() {
        this.acelerador.disabled();
    }

    /**
     * Recebe como parametro uma String com a descrição do acelerador
     * e altera para o tipo escolhido pelo cliente
     * @param desc String
     */
    public void changeAcelerator(String desc) {
        this.acelerador = Acelerador.PADRAO;
        this.acelerador = desc.equals("Prata") ?  Acelerador.PRATA : Acelerador.PRETO;
    }

    /**
     * Calcula os pontos adiquiridos até o momento
     */
    
    public double calculatePoints() {
       double soma = compras.stream()
                            .mapToDouble(p -> p.getValue())
                            .sum();
        return this.pontos = soma/500;
    }
    

    public void showShopping() {
        compras.stream()
            .sorted()
            .forEach(p-> System.out.println(p.toString()));
    }
    /**
     * Adiciona na lista de compras 
     * @param c
     */
    public void addListCompras(Compra c) {
        this.compras.add(c);
        this.ordenaCompra();
        //ordenar por data
    }

    public void ordenaCompra(){
        this.compras.stream()
                    .sorted((c1,c2) -> c1.getData().compareTo(c2.getData()));
    }

    // public Bilhete last12months() {
    //     this.compras.stream()
    //                 .filter((b,b1) -> b.getData().compareTo(b1))
    // }

    /**
     * Cria o acelerador de pontos do cliente
     * @param desc
     */
    public void pointsAccelerator(Acelerador a) {
        try{
            this.acelerador = a;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void relatorio() {
        System.out.println("Relatório");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Total de pontos: " + this.pontos);
        System.out.println("Acelerador de pontos do tipo: " + acelerador.descricao);

    }

    public void showTickets() {
        System.out.println("Histórico de bilhetes: ");

        Data d = new Data();
        
            // System.out.println(this.compras.stream()
            // .filter(c -> c.getData()) + "\n\n");
        
    }
    public String getTypeAcelerator() {
        return this.acelerador.descricao;
    }
    public ArrayList getCompras() {
        return this.compras;
    }

    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
}

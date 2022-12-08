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



 //                                      Sprint 4
/**
 * A fase 4 é definida pela finalização dos testes e implementação do protótipo para a empresa cliente.
 * Este protótipo precisa ter as funcionalidades básicas de cadastro de cliente, localização de voos e
 * compra de bilhetes. A companhia precisa, também, das informações abaixo:
 * • Relatório dos dados de um cliente específico.
 * • Quais são os bilhetes de um cliente nos últimos 12 meses? Ele ganhou uma passagem grátis?
 * • Quem é o cliente com mais pontos acumulados nos últimos 12 meses?
 * • Quais são os voos para uma cidade, em uma data, com mais de 100 reservas?
 * • Qual o total valor arrecadado com bilhetes em todo o período de funcionamento da empresa,
 * podendo ainda filtrar o valor por um mês escolhido?
 * 
 *  * Para a apresentação do protótipo ao cliente, espera-se que o sistema carregue e salve dados em
 * quantidade suficiente para que a validação dos requisitos acima possa ser demonstrada com segurança.
 * A finalização formal da sprint 3 está prevista para 19/11. A implementação dos demais requisitos será
 * observada ao longo da sprint 4 e a apresentação do protótipo está agendada para 05/12, com a
 * possibilidade de ajustes finais até 09/12. 
 */
public class Cliente {
    private String cpf;
    private ArrayList<Compra> compras = new ArrayList<Compra>();
    private double pontos = 0;
    private String nome;
    private Acelerador acelerador = Acelerador.PADRAO;
    
    /**
     * Construtor
     * @param nome String
     * @param cpf String
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;        
    }

    /**
     * Desabilita o Acelerador de pontos que o cliente havia comprado
     */
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
        this.acelerador = Acelerador.valueOf(desc);
    }

    /**
     * Calcula os pontos adiquiridos até o momento
     */
    private double calculatePoints() {
        double soma = compras.stream()
                            .map(b -> b.getBilhete())
                            .mapToDouble(v -> v.getValue())
                            .sum();
        return this.pontos = (500 * ((int)soma/500)) * acelerador.multiplicador;
    }
    /**
     * Mostra na tela as compras do cliente
     */
    public void showShopping() {
        compras.stream()
            .sorted((d1,d2) -> d1.getData().compareTo(d2.getData()))
            .forEach(p -> System.out.println(p.toString()));
    }
    /**
     * Adiciona na lista de compras 
     * @param c Compra
     */
    public void addListCompras(Compra c) {
        c.setPreco(acelerador.custo);
        this.compras.add(c);
        this.ordenaCompra();
        calculatePoints();

    }
    /**
     * Verifica se o cliente recebeu bilhete fidelidade
     * @return boolean
     */
    public boolean checkFreeTicket() {
       for (Compra c : compras) {
            if(c.getFreeTicket() == true)
                return true;
       }
       return false;
    }
    /**
     * Método para ordenar compra
     */
    private void ordenaCompra(){
        this.compras.stream()
                    .sorted((c1,c2) -> c1.getData().compareTo(c2.getData()));
    }
    /**
     * Filtra as compras feitas nos ultimos 12 meses e exibe na tela
     */
    public void last12months() {
        this.compras.stream()
                    .filter(c -> c.getData().compareTo(App.umAnoAtras) == 1)
                    .forEach(b -> System.out.println(b.getBilhete().showVoo()));
    }
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
    /**
     * Exibe na tela os dados do cliente
     */
    public void relatorio() {
        App.clear();
        System.out.println("Relatório:");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Total de pontos: " + this.pontos);
        System.out.println("Acelerador de pontos do tipo: " + this.acelerador.descricao + "\n");
        this.showShopping();

    }

    public void showTickets() {
        System.out.println("Histórico de bilhetes: ");

        Data d = new Data();
        
            // System.out.println(this.compras.stream()
            // .filter(c -> c.getData()) + "\n\n");
        
    }
    /**
     * Retorna qual o Acelerador de pontos do cliente
     * @return String
     */
    public String getTypeAcelerator() {
        return this.acelerador.descricao;
    }
    /**
     * Retorna as compras do cliente
     * @return ArrayList<Compra>
     */
    public ArrayList<Compra> getCompras() {
        return this.compras;
    }    
    /**
     * Retorna o Nome do Cliente
     * @return String
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * Retorna o CPF do cliente
     * @return String
     */
    public String getCpf() {
        return this.cpf;
    }
    /**
     * Retorna os pontos do cliente
     * @return double
     */
    public double getPoints(){
        return this.pontos;
    }
}

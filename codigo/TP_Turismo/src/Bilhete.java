/**
 * • Um bilhete pode conter reservas para diversos voos. 
 * Por exemplo, um bilhete de viagem de Belo Horizonte para Paris pode ser formado pelos trechos Belo
 * Horizonte/Barcelona e Barcelona/Paris.
 */

/**
 * • Cada voo possui um valor-base de tarifa. Este valor será usado para compor
 * os preços dos bilhetes, da seguinte maneira:
 * 
 *  Se um bilhete é composto por um único voo, seu valor será o valor do voo
 * com um acréscimo de 10%;
 * 
 *  Se o bilhete tem vários voos, seu valor será a soma do preço do voo mais
 * caro com 50% do preço dos voos restantes.
 * 
 *  A cada R$500 do valor do bilhete, são gerados 500 pontos de fidelidade, sem valores
 * fracionários (por exemplo, um bilhete de R$1000 gera 1000 pontos, um bilhete
 * de valor  R$1500 gera 1500 pontos. Um bilhete de R$1300 gera somente 1000 pontos).
 * 
 *  Por fim, bilhetes sofrem alterações de preços e pontuação nos casos
 * especiais:
 * 
 *   ▪ Bilhetes promocionais: 60% do valor e 50% dos pontos.
 *   ▪ Bilhetes de fidelidade: não são cobrados e não geram pontos.
 * 
 * A companhia aérea forneceu um arquivo com alguns dados de voos e bilhetes possíveis para que você
 * teste as novas funcionalidades. Foi afirmado que, caso o sistema consiga formar bilhetes diferentes dos
 * que já foram fornecidos, haverá um bônus no pagamento do projeto.
 * Neste momento,
 */

import java.util.ArrayList;
import java.util.List;

public class Bilhete implements IPromocao {
    
    private String id = "263478";
    private List<Voo> voos = new ArrayList<Voo>();
    private double valorVooMaisCaro = 0;
    private double valorDoBilhete = 0;
    private int pontos = 0;

    /**
     * Este método adiciona um registro de voo no bilhete
     * @param voo Object
     */
    public void addVoo(Voo voo) {
        this.voos.add(voo);
        this.init();
    }

    /**
     * Sempre que adicionar um voo esta classe inicia as funções excenciais 
     */
    private void init() {
        this.findTheMostExpensiveFlight();
        this.calculatePrice();
        this.calculatePoints();
    }

    /**
     * Este método removo um voo do bilhete
     * @param voo Object
     */
    public void removeVoo(Voo voo) {
        this.voos.remove(voo);
    }

    
    public String showVoo() {
        String s;        
        StringBuilder str = new StringBuilder("Bilhete : " + id + " || ");
        for (Voo voo : voos) {
            if(!voo.toString().isEmpty() && voo.toString() != null)
            str.append(voo.toString());
        }
        s = str.toString();
        return s;
        
    }

    /**
     * Este método verifica qual o voo mais caro e atribui a variável
     */
    private void findTheMostExpensiveFlight() {
        for (Voo voo : voos) {
            if(this.valorVooMaisCaro > voo.getBaseValue()) 
                this.valorVooMaisCaro = voo.getBaseValue();
        }
    }

    /**
     * 
     * @return Double preço do bilhete com base na regra da quantidade de voos
     */
    private void calculatePrice() {
        int cont = 0;
        double aux = 0;
        for (Voo voo : voos) {
            cont++;
            aux += voo.getBaseValue();
        }
        if(cont > 1)
            this.valorDoBilhete = (double)(aux * 50/100) + this.valorVooMaisCaro;
        else
            this.valorDoBilhete = (double)aux + (10/100 * aux);
    }

    /**
     * Este método calcula os pontos gerado a partir do valor do bilhete,
     * seguindo a regra que a cada R$500,00 gera 500 pontos; 
     */
    private void calculatePoints() {
        int cont = 0;
        double aux = this.valorDoBilhete;

        while(aux >= 500) {
            aux -= 500;
            this.pontos += 500;
        }        
    }

    @Override
    public void ticketDiscount() {
        this.valorDoBilhete = (Double)this.valorDoBilhete * 60/100;
        this.pontos = this.pontos * 50/100;
    }

    @Override
    public void ticketFaithfulness() {
        this.valorDoBilhete = 0;
        this.pontos = 0;
    }

}

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

public abstract class Bilhete {
    
    protected String id = "263478";
    protected List<Voo> voos = new ArrayList<Voo>();
    protected double valorVooMaisCaro = 0;
    protected double valorDoBilhete = 600;
    protected double pontos = 0.0;
    protected String desc;
    /**
     * Este método adiciona um registro de voo no bilhete
     * @param voo Object
     */
    public abstract void addVoo(Voo voo);

    /**
     * Este método removo um voo do bilhete
     * @param voo Object
     */
    public abstract void removeVoo(Voo voo);

    
    public abstract String showVoo();

    /**
     * Este método calcula os pontos gerado a partir do valor do bilhete,
     * seguindo a regra que a cada R$500,00 gera 500 pontos; 
     */
    
    public abstract double calculatePoints();


    public abstract double getValue();

}

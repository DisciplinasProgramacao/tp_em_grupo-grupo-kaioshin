/**
 * • Um bilhete pode conter reservas para diversos voos. Por exemplo, um bilhete
 * de viagem de
 * Belo Horizonte para Paris pode ser formado pelos trechos Belo
 * Horizonte/Barcelona e
 * Barcelona/Paris.
 */

/**
 * • Cada voo possui um valor-base de tarifa. Este valor será usado para compor
 * os preços dos
 * bilhetes, da seguinte maneira:
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
 */

import java.util.ArrayList;
import java.util.List;

public class Bilhete {
    
    private String id = "263478";
    private List<Voo> voos = new ArrayList<Voo>();
    private double valorVooMaisCaro = 0;


    public void addVoo(Voo voo){
        this.voos.add(voo);
    }

    public void removeVoo(Voo voo){
        this.voos.remove(voo);
    }

    public String showVoo(){
        String s;        
        StringBuilder str = new StringBuilder("Bilhete : " + id + " || ");
        for(int i = 0; i < voos.size(); i++ ){
            Voo aux;
            aux = voos.get(i);
            str.append(aux.toString());
        }
        s = str.toString();
        return s;
        
    }
    /**
     * 
     * @return Double A soma do preço do voo mais caro com 50% do preço dos voos restantes
     */
    public double calculatePrice() {
        double aux = 0;
        for (Voo voo : voos) {
            aux += voo.getBaseValue();
        }

        return (double)(aux * 50/100) + this.valorVooMaisCaro;
    }

    

}

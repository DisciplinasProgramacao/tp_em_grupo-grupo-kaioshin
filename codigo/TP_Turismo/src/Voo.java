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

import java.util.Date;

public class Voo {
    private static String ID_VOO = "7845";
    private Trecho trecho;
    private Data data;
    private double baseValue = 600.00;
    private double vooValue;

    public void addTrecho(Trecho trecho) {
        this.trecho = trecho;
        this.vooValue = this.baseValue * trecho.getQtdTrechos()-1;
    }

    public Trecho removeTrecho(String idTrecho) {
        Trecho aux;
        aux = this.trecho;
        this.trecho = null;
        return aux;
    }

    public void addData(int[] data) {
        this.data = new Data(data[0],data[1],data[2]);
    }
    
    public String toString() {
        String s;
		
        StringBuilder str = new StringBuilder("Voo: " + ID_VOO + " || " + this.data.dataFormatada() + " || ");
        str.append(trecho.toString());
        s = str.toString();
        return s;
    }
    
    public double getVooValue() {
        return vooValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public double getBaseValue() {
        return this.baseValue;
    }
}

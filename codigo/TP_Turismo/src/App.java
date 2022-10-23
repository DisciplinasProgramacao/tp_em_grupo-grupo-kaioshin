/**
 * Na fase 2, começará o processo de formação de bilhetes para venda, com suas
 * respectivas regras.
 * Descobrimos vários requisitos nas reuniões com os clientes:
 * 
 * • Um bilhete pode conter reservas para diversos voos. Por exemplo, um bilhete
 * de viagem de
 * Belo Horizonte para Paris pode ser formado pelos trechos Belo
 * Horizonte/Barcelona e
 * Barcelona/Paris.
 * 
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
 * 
 *      ▪ Bilhetes promocionais: 60% do valor e 50% dos pontos.
 *      ▪ Bilhetes de fidelidade: não são cobrados e não geram pontos.
 *      A companhia aérea forneceu um arquivo com alguns dados de voos e bilhetes
 *      possíveis para que você
 *      teste as novas funcionalidades. Foi afirmado que, caso o sistema consiga
 *      formar bilhetes diferentes dos
 *      que já foram fornecidos, haverá um bônus no pagamento do projeto.
 *      Neste momento, portanto, seu grupo precisa:
 * a) adaptar o diagrama de classes original para os novos requisitos; UML que
 *    modele corretamente o que foi descrito;
 * b) implementar as regras para os novos requisitos;
 * c) criar um protótipo de sistema para que os futuros clientes possam usar e
 *      testar o sistema.
 *      Esta primeira etapa do trabalho está prevista para terminar, no máximo, em
 *      24/10. As etapas
 *      posteriores estão previstas para 27/11 e 15/12.
 */

import java.beans.JavaBean;
import java.util.Date;

public class App {
    /**
     * Método para "limpar" tela console
     */
    public static void clear(){ 

        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    } 
    public static void main(String[] args) throws Exception {
        /**
         * teste funcionalidade das classe
         * 
         */
        clear();
        Trecho trecho = new Trecho();
        trecho.addTrecho("parana", "curitiba", "4552");
        Voo voo = new Voo();
        Date data = new Date(122, 04, 1);
        voo.addTrecho(trecho);
        voo.addData(data);
        Bilhete bilhete = new Bilhete();
        bilhete.addVoo(voo);
        System.out.println(bilhete.showVoo());
    }
}

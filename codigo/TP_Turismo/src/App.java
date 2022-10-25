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
 * c) criar um protótipo de sistema para que os futuros clientes possam usar e testar o sistema.
 *      Esta primeira etapa do trabalho está prevista para terminar, no máximo, em
 *      24/10. As etapas
 *      posteriores estão previstas para 27/11 e 15/12.
 */

import java.beans.JavaBean;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    /**
     * Método para "limpar" tela console
     */
    public static void clear(){ 

        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    }
    public static void menu() {
        System.out.println(" ------------------------- ");
        System.out.println("|   SELECIONE UMA OPÇÃO:  |");
        System.out.println(" ========================= ");
        System.out.println("|1º - Informar Trecho     |");
        System.out.println("|2º - Adicionar Voo       |");
        System.out.println("|3º -                     |");
        System.out.println("|4º -                     |");
        System.out.println("|5º -                     |");
        System.out.println("|6º - Sair                |");
        System.out.println("|                         |");
        System.out.println("|                         |");
        System.out.println(" ------------------------- ");

        System.out.print("\nOpção: ");
    } 
    public static void main(String[] args) throws Exception {
        Scanner key = new Scanner(System.in);
        Trecho trecho = new Trecho();
        Voo voo = new Voo();
        Bilhete bilhete = new Bilhete();
        clear();
        menu();
        int opcao = key.nextInt();
        do{
            switch(opcao){
                case 1:
                    String origem = "", destino = "", id = ""; 
                    clear();
                    System.out.println();
                    System.out.print("Local de Origem: ");               
                    origem = key.nextLine();//Não sei porque não está pedindo para inserir o valor só com 1 por isso coloquei 2
                    origem = key.nextLine();

                    System.out.print("Local de Destino: ");
                    destino = key.nextLine();

                    System.out.print("Local de Id: ");
                    id = key.nextLine();

                    
                    trecho.addTrecho(origem, destino, id);
                    clear();
                    
                    System.out.println("Intinerário inserido com sucesso!");
                    TimeUnit.SECONDS.sleep(2);

                    clear();
                    menu();
                    opcao = key.nextInt();
                break;
    
                case 2:
                    clear();
                    System.out.println("Informe a data do voo");
                    System.out.print("Ano: ");
                    int ano = key.nextInt(); 
                    System.out.print("Mês: ");
                    int mes = key.nextInt(); 
                    System.out.print("Dia: ");
                    int dia = key.nextInt(); 
                    Date data = new Date(ano, mes, dia);
                    voo.addTrecho(trecho);
                    voo.addData(data);

                    System.out.println("\n\nVoo inserido com sucesso!");
                    TimeUnit.SECONDS.sleep(2);

                    clear();
                    menu();
                    opcao = key.nextInt();
                break;

                case 3:
                    clear();
                    bilhete.addVoo(voo);
                    System.out.println(bilhete.showVoo());

                    // clear();
                    // menu();
                    // opcao = key.nextInt();
                break;

                case 4:
                    clear();
                    System.out.println("Opção 4");
                    TimeUnit.SECONDS.sleep(2);

                    clear();
                    menu();
                    opcao = key.nextInt();
                break;

                case 5:
                    clear();
                    System.out.println("Opção 5");
                    TimeUnit.SECONDS.sleep(2);

                    clear();
                    menu();
                    opcao = key.nextInt();
                break;

                case 6:
                    clear();
                    System.out.println("Obrigado e volte sempre!");
                    opcao = -1;
                    TimeUnit.SECONDS.sleep(2);
                    clear();
                    break;

                    default:
                    System.out.println("O valor informado é invalido!\nEscolha um valor entre 1 e 5.");
                    System.out.println("\n\n\n");
                    menu();
                break;
            }
        
        }while(opcao > 0);
        /**
         * teste funcionalidade das classe
         * 
         */
        
        // Voo voo = new Voo();
        // Date data = new Date(122, 04, 1);
        // voo.addTrecho(trecho);
        // voo.addData(data);
        // Bilhete bilhete = new Bilhete();
        // bilhete.addVoo(voo);
        // System.out.println(bilhete.showVoo());
    }
}

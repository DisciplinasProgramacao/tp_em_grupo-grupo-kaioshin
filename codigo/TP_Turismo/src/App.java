//                                      Sprint 2
/**
 * Na fase 2, começará o processo de formação de bilhetes para venda, com suas
 * respectivas regras.
 * Descobrimos vários requisitos nas reuniões com os clientes:
 * 
 * • Um bilhete pode conter reservas para diversos voos. Por exemplo, um bilhete
 * de viagem de Belo Horizonte para Paris pode ser formado pelos trechos Belo
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
 *      modele corretamente o que foi descrito;
 * b) implementar as regras para os novos requisitos;
 * c) criar um protótipo de sistema para que os futuros clientes possam usar e testar o sistema.
 *      Esta primeira etapa do trabalho está prevista para terminar, no máximo, em
 *      24/10. As etapas
 *      posteriores estão previstas para 27/11 e 15/12.
 */

//                                      Sprint 3
/**
 * Na fase 3 será implementado o processo de compra efetiva dos bilhetes pelos clientes.
 * 
 *  Um cliente precisa ter todas as suas compras armazenadas por ordem cronológica de data de voo. As compras
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
 * • Qual o total arrecadado com bilhetes em todo o período de funcionamento da empresa,
 * podendo ainda filtrar o valor por um mês escolhido?
 * 
 *  * Para a apresentação do protótipo ao cliente, espera-se que o sistema carregue e salve dados em
 * quantidade suficiente para que a validação dos requisitos acima possa ser demonstrada com segurança.
 * A finalização formal da sprint 3 está prevista para 19/11. A implementação dos demais requisitos será
 * observada ao longo da sprint 4 e a apresentação do protótipo está agendada para 05/12, com a
 * possibilidade de ajustes finais até 09/12. 
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class App {
    static int opicao = 0;
    static int posicaoNaLista = -1;
    static String nome, cpf;
    static Scanner key = new Scanner(System.in);
    static Random aleat = new Random(42);
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); //Cliente cadastrado no sistema
    static Cliente cliente;
    static LocalDateTime now = LocalDateTime.now();
    public static Data hoje;
    public static Data umAnoAtras;
    /**
     * Método para "limpar" tela console
     */
    
    public static void clear() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean checkCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf))
            return true;
        }
        return false;
    }   

    public static int compareTo(Cliente f, Cliente f2) {
        if(f.getPoints() > f2.getPoints())
            return 1;
        else if(f.getPoints() < f2.getPoints())
            return -1;
        
            return 0;
    }

    public static int getPosition(String cpf) {
        for (int i=0; i<=clientes.size(); i++) {
            try{
                if(clientes.get(i).getCpf().equals(cpf)){
                    return i;
                }
            }catch(Exception e) {
                return -1;
            }
            
        }

        return -1;
    }

    public static void umAnoAtrass(int[] hoje) {
        umAnoAtras = new Data(hoje[0],hoje[1],hoje[2]-1);

    }

    public static void relatorio(String cpf) {
        clientes.get(getPosition(cpf)).relatorio();
    }

    public static void totalArrecadado() {
        System.out.println("Total em compras: " + 
        clientes.stream()
                .mapToDouble(
                    c->c.getCompras()
                    .stream()
                    .mapToDouble(b->b.getValue())
                    .sum()
                ).sum()
        );                
    }
    
    public static void menu() {
        System.out.println(" -------------------------- ");
        System.out.println("|   SELECIONE UMA OPÇÃO:   |");
        System.out.println(" ========================== ");
        System.out.println("|1º - Comprar Bilhete      |");
        System.out.println("|2º - Acelerador de Pontos |");
        System.out.println("|3º - Voos para uma cidade |");
        System.out.println("|4º - Maior pontuação      |");
        System.out.println("|5º - Relatório Cliente    |");
        System.out.println("|6º - Total Arrecadado     |");
        System.out.println("|7º - Sair                 |");
        System.out.println(" -------------------------- ");

        System.out.print("\nOpção: ");
    }

    public static void cadastrar() {
       

        do {
            clear();
            System.out.println(" -------------------------- ");
            System.out.println("|   SELECIONE UMA OPÇÃO:   |");
            System.out.println(" ========================== ");
            System.out.println("|1º - Login                |");
            System.out.println("|2º - Cadastrar            |");
            System.out.println(" -------------------------- ");
            
            System.out.print("\n\nOpição: ");
    
            try {
                opicao = Integer.parseInt(key.nextLine());
            }catch(Exception e) {
                opicao = -1;
            }
            
            String cpf;
            clear();
            switch(opicao) {
                case 1:
                    System.out.print("Informe por gentileza o CPF cadastrado: ");
                    cpf = key.nextLine();
                    int aux1 = getPosition(cpf);
                        if(aux1 >= 0){
                            posicaoNaLista = getPosition(cpf);
                            clear();
                            System.out.println("Bem Vindo Sr(a). " + clientes.get(posicaoNaLista).getNome());
                            pressEnter();
                            opicao = -1;
                        } else {
                            System.out.println("Não foi identificado cadastro para o CPF " + cpf + "! Realize o cadastro e tente novamente.");
                            opicao = 2;
                        }
                break;
    
                case 2:
                        System.out.print("Informe o Nome: ");
                        String nome = key.nextLine();
                        System.out.print("\nInforme o CPF: ");
                         cpf = key.nextLine();
                        if(!checkCPF(cpf)) {
                            cliente = new Cliente(nome, cpf);
                            clientes.add(cliente);
                            opicao = 1;
                        } else {
                            System.out.println("\n\nO CPF inserido já está cadastrado!\n\n");

                            opicao = 2;
                        }
                        
                    break;
    
                default:
                    
                    System.out.println("O valor informado é invalido!\nEscolha um valor entre 1 e 2.");
                    System.out.println("\n\n\n");
                    opicao = 0;
                    break;
            }
        } while (opicao >= 0);        
    }


    public static int[] formatDate(String DataText) {
        if(DataText.contains("/")){
            String[] aux = DataText.split("/");
            int[] auxI = {Integer.parseInt(aux[0]), Integer.parseInt(aux[1]),Integer.parseInt(aux[2])};
            return auxI;
        } else {
            String[] aux = DataText.split("-");
            int[] auxI = {Integer.parseInt(aux[0]), Integer.parseInt(aux[1]),Integer.parseInt(aux[2])};
            return auxI;
        }
    }
    public static void pressEnter() {
        System.out.print("\n\nPressione enter para continuar: ");
        String aux = key.nextLine();

    }

    public static String inverteData(String data) {
        String inversor[] = data.split("-");
        
        return inversor[2] + "-" + inversor[1] + "-" + inversor[0]; 
    }
    
    public static void main(String[] args) throws Exception {
        String auxStr[] = now.toString().split("T");
        int[] auxI = formatDate(inverteData(auxStr[0]));
        umAnoAtrass(auxI);
        hoje = new Data(auxI[0],auxI[1],auxI[2]);
       
        clear();
        opicao = 0;
        cadastrar();

        do {
            clear();
            menu();
            try {
                opicao = Integer.parseInt(key.nextLine());
            }catch(Exception e) {
                opicao = -1;
            }
            clear();

            switch (opicao) {
                case 1:
                    ArrayList<String> conexoes = new ArrayList<String>();
                    int num = 0;
                    
                    Bilhete bilhete = null;
                    do{
                        System.out.println("Qual bilhete deseja?\n\n1- Bilhete Comum\n2- Bilhete com desconto\n3- Bilhete gratis usando os pontos");
                        System.out.print("\n\nOpição: ");
                        num = Integer.parseInt(key.nextLine());
                        clear();
                        switch(num) {
                            case 1:
                                bilhete = new BilheteComum();
                                num = -1;
                            break;
                
                            case 2: 
                                bilhete = new BilhetePromocional();
                                num = -1;
                            break;
                
                            case 3:
                                
                                if(clientes.get(posicaoNaLista).getPoints() >= 10.500) {
                                    bilhete = new BilheteFidelidade();
                                    num = -1;
                                } else {
                                    System.out.println(clientes.get(posicaoNaLista).getNome() + " não possui pontos suficientes para adquirir o bilhete fidelidade\nPontos:\n" + clientes.get(posicaoNaLista).getPoints());
                                    pressEnter();
                                    clear();
                                }
    
                            break;
                            default:

                                    clear();
                                    System.out.println("O valor informado é invalido!\nEscolha um valor entre 1 e 3.");
                                    System.out.println("\n\n\n");
                                    num = 0;
                                    break;
                            }
                        } while(num != -1);
                    
                    
                    
                     
                    String origem = "", destino = "";
                    int id;
                                       
                    
                    System.out.println();
                    System.out.println("Informe o intinerário dos voos\n");
                    System.out.print("Local de Origem: ");
                    origem = key.nextLine();

                    System.out.print("Local de Destino: ");
                    destino = key.nextLine();
                    id = aleat.nextInt(999999999);

                    clear();
                    
                    System.out.print("1 - A viagem é direta\n2 - Há conexão(ões) no voo\n\nOpição: ");
                    int auxOption = Integer.parseInt(key.nextLine());
                    do{
                        if(auxOption > 2 || auxOption < 1){
                            System.out.println("O valor informado é invalido!\nEscolha um valor entre 1 e 2.");
                        }
                        if(auxOption == 2) {
                            String aux;
                            System.out.print("A viagem será de " + origem + " para: ");
                            aux = key.nextLine();

                            while(!aux.equals(destino)) {
                                conexoes.add(aux);
                                System.out.print("De " + aux + " para: ");
                                aux = key.nextLine();
                            }
                        } 
                    } while(auxOption != 2 && auxOption != 1);

                    Trecho trecho = new Trecho(origem, destino, id, conexoes);
                    clear();

                    System.out.println("Intinerário inserido com sucesso!");
                    TimeUnit.SECONDS.sleep(1);

                    clear();
                    System.out.print("Informe a data do voo: ");
                    int[] data = formatDate(key.nextLine());
                    Voo voo = new Voo(); 
                    voo.addTrecho(trecho);
                    voo.addData(data);
                    bilhete.addVoo(voo);
                    System.out.print("Informe a data da compra: ");
                    int[] dataAux = formatDate(key.nextLine());
                    
                    clear();


                    Compra c = new Compra();
                    c.buyToTicket(bilhete, dataAux);
                    clientes.get(posicaoNaLista).addListCompras(c);

                    
                    System.out.println("\n\nVoo inserido com sucesso!");
                    TimeUnit.SECONDS.sleep(1);
                    clear();

                    System.out.println(trecho.toString());
                    System.out.println(voo.toString());
                    System.out.println("O valor do bilhete é: R$" + bilhete.getValue());

                    pressEnter();


                    break;

                case 2:
                    clear();
                        System.out.println(" --------------------------------- ");
                        System.out.println("|      SELECIONE UMA OPÇÃO:       |");
                        System.out.println(" ================================= ");
                        System.out.println("| 1º - Adiquirir                  |");
                        System.out.println("| 2º - Desabilitar                |");
                        System.out.println("| 3º - Ver meu pacote             |");
                        System.out.println(" --------------------------------- ");
                        
                        System.out.print("\n\nOpição: ");
                        opicao = Integer.parseInt(key.nextLine());

                        switch(opicao) {
                            case 1:
                                do{
                                    clear();
                                    if(opicao<1 || opicao>2){
                                        System.out.println("O valor informado é invalido!\nEscolha um valor entre 1 e 2. ");
                                        TimeUnit.SECONDS.sleep(1);
                                        clear();
                                    }
                                    System.out.println(" --------------------------------- ");
                                    System.out.println("|      SELECIONE UMA OPÇÃO:       |");
                                    System.out.println(" ================================= ");
                                    System.out.println("|1º - Prata x1.25 - R$12,99 p/mês |");
                                    System.out.println("|2º - Preto x1.50 - R$19,99 p/mês |");
                                    System.out.println(" --------------------------------- ");
                                    System.out.print("\n\nOpição: ");
                                    opicao = Integer.parseInt(key.nextLine());

                                }while(opicao<1 || opicao>2);
                                
                                String auxString = opicao == 1 ? "Prata" : "Preto";
                                clientes.get(posicaoNaLista).changeAcelerator(auxString);

                                System.out.println("\nAcelerador adquirido com sucesso!");
                                TimeUnit.SECONDS.sleep(1);
                                clear();
                                opicao = 0;
                            break;
                            case 2:
                                clientes.get(posicaoNaLista).disabledAcelerator();
                                System.out.println("Acelerador desabilitado com sucesso!");
                                TimeUnit.SECONDS.sleep(1);
                                opicao = 0;
                            break;
                            case 3:
                                System.out.println("\nAcelerador de pontos: " + clientes.get(posicaoNaLista).getTypeAcelerator());
                                pressEnter();
                                opicao = 0;
                            break;
                        }
                    break;

                case 3:
                    clear();
                        clientes.get(posicaoNaLista).last12months();
                        if(clientes.get(posicaoNaLista).checkFreeTicket()){
                            System.out.println("\nO cliente recebeu bilhete fidelidade");
                        }
                            
                        System.out.println("\nO cliente não recebeu bilhete fidelidade");
                        
                        pressEnter();
                    
                    opicao = 0;
                    break;

                case 4://Quem é o cliente com mais pontos acumulados nos últimos 12 meses?
                    clear();
                    System.out.println(
                        clientes.stream()
                                .max((f1,f2) -> App.compareTo(f1, f2))
                                .map(cliente -> cliente.getCompras().stream()
                                                                    .filter(compra -> compra.getData().compareTo(App.umAnoAtras) == 1)
                                ).toString()
                    );
                       
                            
                    TimeUnit.SECONDS.sleep(1);

                    clear();
                    opicao = 0;
                    break;

                case 5:
                    clear();
                    boolean auxBool = false;
                    String aux;
                    do{
                        System.out.print("Informe o CPF do cliente desejado: ");
                        aux = key.nextLine();
                        auxBool = checkCPF(aux);
                        if(!auxBool){
                            clear();
                            System.out.print("O CPF informado não está cadastrado! Tente novamente.");
                            pressEnter();
                        }
                    } while(!auxBool);
                    relatorio(aux);

                    pressEnter();

                    clear();
                    opicao = 0;
                    break;
                
                case 6:
                    clear();
                    totalArrecadado();
                    pressEnter();
                    clear();
                    
                break;

                case 7:
                    clear();
                    System.out.println("Obrigado e volte sempre!");
                    opicao = -1;
                    TimeUnit.SECONDS.sleep(1);
                    clear();
                break;

                default:
                    clear();
                    System.out.println("O valor informado é invalido!\nEscolha um valor entre 1 e 6.");
                    System.out.println("\n\n\n");
                    opicao = 0;
                    break;
            }

        } while (opicao >= 0);
 
    }
}

// Bilhetes promocionais: 60% do valor e 50% dos pontos
public class BilhetePromocional extends Bilhete {
    final String DESC = "Promocional";


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
        StringBuilder str = new StringBuilder("Bilhete Comum: " + id + " || ");
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
    public void calculatePrice() {
        int cont = 0;
        double aux = 0;
        for (Voo voo : voos) {
            cont++;
            aux += voo.getVooValue();
        }
        if(cont > 1)
            this.valorDoBilhete = (double)aux * 0.5 + this.valorVooMaisCaro;
        else {
            this.valorDoBilhete = (double)0.1 * aux + aux;
            this.valorDoBilhete += (double)-0.4 * this.valorDoBilhete; //aplicando desconto
        }
    }

    /**
     * Este método calcula os pontos gerado a partir do valor do bilhete,
     * seguindo a regra que a cada R$500,00 gera 500 pontos; 
     */
    
    public double calculatePoints() {
         this.pontos = (((int)this.valorDoBilhete/500) * 500);

         return this.pontos  - (50/100 * this.pontos);
    }


    public double getValue() {
        return this.valorDoBilhete;
    }

    public String getType() {
        return this.DESC;
    }
    
}

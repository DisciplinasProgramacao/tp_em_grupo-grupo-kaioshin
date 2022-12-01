public class BilheteFidelidade extends Bilhete {
    
    final String DESC = "Fidelidade";

    public void addVoo(Voo voo) {
        this.voos.add(voo);
        this.init();
    }
    public String showVoo() {
        String s;        
        StringBuilder str = new StringBuilder("Bilhete Fidelidade: " + id + " || ");
        for (Voo voo : voos) {
            if(!voo.toString().isEmpty() && voo.toString() != null)
            str.append(voo.toString());
        }
        s = str.toString();
        return s;
    }

    public void removeVoo(Voo voo) {
        this.voos.remove(voo);
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
     * Este método verifica qual o voo mais caro e atribui a variável
     */
    private void findTheMostExpensiveFlight() {
        for (Voo voo : voos) {
            if(this.valorVooMaisCaro > voo.getBaseValue()) 
                this.valorVooMaisCaro = voo.getBaseValue();
        }
    }

    private void calculatePrice() {
        this.valorDoBilhete += 0;
    } 

    public double calculatePoints() {
        return this.pontos += 0;
   }
   
    public double getValue() {
        return this.valorDoBilhete;
    }
    public String getType() {
        return this.DESC;
    }
}

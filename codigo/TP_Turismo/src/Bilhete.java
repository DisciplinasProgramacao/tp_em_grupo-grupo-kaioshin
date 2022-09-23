import java.util.ArrayList;
import java.util.List;

public class Bilhete {
    
    private String id = "263478";
    private List<Voo> voos = new ArrayList<Voo>();


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

}

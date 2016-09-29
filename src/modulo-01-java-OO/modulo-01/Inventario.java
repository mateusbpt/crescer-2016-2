import java.util.*;

public class Inventario {

    ArrayList<Item> itens = new ArrayList<>();

    public ArrayList<Item> getItens(){
        return itens;    
    }

    public void adicionarItem (Item item){
        itens.add(item);
    }

    public void removerItem (Item item){
        itens.remove(item);
    }
}

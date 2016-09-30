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

    public String getDescricoesItens(){
        String retorno = "";
        int ultimo = itens.size()-1;
        for(int i = 0; i < ultimo; i++){
            retorno += itens.get(i).getDescricao() + ", ";    
        } 
        return retorno + itens.get(ultimo).getDescricao();
    }
}
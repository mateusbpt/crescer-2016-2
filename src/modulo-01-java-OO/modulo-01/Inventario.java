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
        if(!itens.isEmpty()){
            String retorno = "";
            int ultimo = itens.size()-1;
            for(int i = 0; i < ultimo; i++){
                retorno += itens.get(i).getDescricao() + ", ";    
            } 
            return retorno + itens.get(ultimo).getDescricao();
        }
        return null;
    }

    public Item retornaItemMaiorQuantidade(){
        if(!itens.isEmpty()){
            int compara = 0;
            int retorno = 0;
            for(int i = 0; i < itens.size(); i++){
                if(compara <= itens.get(i).getQuantidade()){   
                    retorno = i;
                    compara = itens.get(i).getQuantidade();
                }
            } 
            return itens.get(retorno);
        }
        return null;
    }
}
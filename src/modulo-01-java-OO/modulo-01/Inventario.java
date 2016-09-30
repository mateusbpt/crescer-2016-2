import java.util.ArrayList;

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
            String retorno = itens.get(0).getDescricao();
            for(int i = 1; i < itens.size(); i++){
                retorno = retorno + "," + itens.get(i).getDescricao();    
            } 
            return retorno;
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
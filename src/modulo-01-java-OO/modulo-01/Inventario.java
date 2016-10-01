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
                retorno += String.format(",%s", itens.get(i).getDescricao());    
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

    public void aumentarUnidadesDosItens(int unidades){
        for(Item item : itens){
            item.aumentarUnidades(unidades);
        }    
    }

    public void aumentarUnidadesDosItensVezes1000(){
        for(Item item : itens){
            item.aumentarUnidades(item.aumentarUnidadesVezes1000());
        }    
    }

    public void ordenarItens(){
        int i, j;
        for (i = 1; i < itens.size(); i++) {
            Item auxiliar = itens.get(i);
            j = i;
            while ((j > 0) && (itens.get(j - 1).getQuantidade() > auxiliar.getQuantidade())) { //Para lista descendente, getQuantidade() < auxiliar.getQuantidade()
                itens.set(j, itens.get(j - 1));
                j--;
            }
            itens.set(j, auxiliar);
        }
    } 

    public void ordenarItens(TipoOrdenacao ordenacao){
        boolean ascendente = ordenacao == TipoOrdenacao.ASCENDENTE;
        if(!ascendente){
            int i, j;
            for (i = 1; i < itens.size(); i++) {
                Item auxiliar = itens.get(i);
                j = i;
                while ((j > 0) && (itens.get(j - 1).getQuantidade() < auxiliar.getQuantidade())) { 
                    itens.set(j, itens.get(j - 1));
                    j--;
                }
                itens.set(j, auxiliar);
            }
        } else{
            ordenarItens();
        }
    }
}
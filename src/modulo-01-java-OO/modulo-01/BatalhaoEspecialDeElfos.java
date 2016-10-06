import java.util.*;

public class BatalhaoEspecialDeElfos {

    HashMap<String,Elfo> batalhaoDeElfos = new HashMap<>();  

    //Nos testes, pode acontecer de não ficar na posicao correta, pois o Hash guarda em posições definidas pela key 
    public Elfo[] getExercitoDeElfosArray(){
        return (Elfo[])batalhaoDeElfos.values().toArray(new Elfo[batalhaoDeElfos.values().size()]);   
    }
   
    //Adicionado pelo problema acima
    public HashMap<String,Elfo> getExercitoDeElfos(){
        return batalhaoDeElfos;   
    }

    //Tratar para que o HashMap não receba elfos com o nome igual, evitando a substituição
    public void alistarElfo(Elfo elfo){
        boolean tipoSoldadoPossivel = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        boolean chaveEmUso = batalhaoDeElfos.containsKey(elfo.getNome());
        if(tipoSoldadoPossivel && !chaveEmUso){
            batalhaoDeElfos.put(elfo.getNome(), elfo);
        }
    }

    public Elfo buscarPeloNome(String chave){
        return batalhaoDeElfos.get(chave);  
    }

    public ArrayList<Elfo> buscarPeloStatus (Status status){
        ArrayList<Elfo> retorno = new ArrayList<>();
        for(Map.Entry<String,Elfo> elfoAtual : batalhaoDeElfos.entrySet()) {  
            if(elfoAtual.getValue().getStatus().equals(status)){
                retorno.add(elfoAtual.getValue());
            }
        }
        return retorno;   
    }

}
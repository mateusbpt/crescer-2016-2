import java.util.*;

public class BatalhaoEspecialDeElfos {

    HashMap<String,Elfo> batalhaoDeElfos = new HashMap<>();  

    //Nos testes, pode acontecer de não ficar na posicao correta, pois o Hash guarda em posições definidas pela key 
    public Elfo[] getExercitoDeElfosArray(){
        return (Elfo[])batalhaoDeElfos.values().toArray(new Elfo[batalhaoDeElfos.values().size()]);   
    }

    public HashMap<String,Elfo> getExercitoDeElfos(){
        return batalhaoDeElfos;   
    }

    public void alistarElfo(Elfo elfo){
        boolean tipoSoldadoPossivel = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(tipoSoldadoPossivel){
            batalhaoDeElfos.put(elfo.getNome(), elfo);
        }
    }

    //Ajustar: problema se vários elfos tiverem o mesmo nome
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
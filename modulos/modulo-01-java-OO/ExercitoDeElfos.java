import java.util.*;

public class ExercitoDeElfos implements Exercito{

    ArrayList<Elfo> exercito = new ArrayList<>();    

    public Elfo[] getExercitoDeElfos(){
        return exercito.toArray(new Elfo[exercito.size()]);    
    }

    public void alistarElfo(Elfo soldado){
        boolean tipoSoldadoPossivel = soldado instanceof ElfoVerde || soldado instanceof ElfoNoturno;
        if(tipoSoldadoPossivel){
            exercito.add(soldado);
        }
    }

    public Elfo buscarPeloNome(String nome){
        for(Elfo elfoAtual : exercito){
            if(nome.equals(elfoAtual.getNome())){   
                return elfoAtual;
            }
        }
        return null;
    }

    public ArrayList<Elfo> buscarPeloStatus (Status status){
        ArrayList<Elfo> retorno = new ArrayList<>();
        for(Elfo elfoAtual : exercito){
            if(status.equals(elfoAtual.getStatus())){   
                retorno.add(elfoAtual);    
            }        
        }
        return retorno;        
    }
}
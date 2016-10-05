import java.util.*;

public class ExercitoDeElfos {

    ArrayList<Elfo> exercito = new ArrayList<>();    

    public Elfo[] getExercitoDeElfos(){
        return exercito.toArray(new Elfo[exercito.size()]);    
    }

    public void alistarSoldado(Elfo soldado){
        boolean tipoSoldadoPossivel = soldado instanceof ElfoVerde || soldado instanceof ElfoNoturno;
        if(tipoSoldadoPossivel){
            exercito.add(soldado);
        }
    }

    public Elfo buscarPeloNome(String nome){
        boolean exercitoVazio = exercito.size() == 0;
        if(!exercitoVazio){
            for(Elfo elfoAtual : exercito){
                if(nome.equals(elfoAtual.getNome())){   
                    return elfoAtual;
                }
            }
        }
        return null;
    }

    public ArrayList<Elfo> buscarPeloStatus (Status status){
        boolean exercitoVazio = exercito.size() == 0;
        ArrayList<Elfo> retorno = new ArrayList<>();
        if(!exercitoVazio){
            for(Elfo elfoAtual : exercito){
                if(status.equals(elfoAtual.getStatus())){   
                    retorno.add(elfoAtual);    
                }        
            }
            return retorno;
        }
        return null;
    }
}
import java.util.*;

public class EstrategiaAtaqueIntercalado implements Estrategia {

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ElfosDesproporcionalException {
        Estrategia auxiliar = new EstrategiaNoturnosPorUltimo();
        List<Elfo> retorno = new ArrayList<>(); 
        if(!exercitoProporcional(atacantes)){
            throw new ElfosDesproporcionalException();
        }    
        List<Elfo> organizada = auxiliar.getOrdemDeAtaque(atacantes);
        while(organizada.size() != 0){
            retorno.add(organizada.remove(0));
            retorno.add(organizada.remove(organizada.size()-1));  
        }     
        return retorno;
    }

    private boolean exercitoProporcional(List<Elfo> atacantes){
        int contadorElfosVerdes = 0;
        int contadorElfosNoturnos = 0;
        for(Elfo elfoAtual : atacantes){
            boolean elfoVivo = elfoAtual.getStatus().equals(Status.VIVO);
            if(elfoVivo){
                boolean ehElfoVerde = elfoAtual instanceof ElfoVerde;
                boolean ehElfoNoturno = elfoAtual instanceof ElfoNoturno;
                if(ehElfoVerde){
                    contadorElfosVerdes++;
                }
                if(ehElfoNoturno){
                    contadorElfosNoturnos++;
                }
            }
        }
        return contadorElfosNoturnos == contadorElfosVerdes ? true : false;
    }

}
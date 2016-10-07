import java.util.*;

public class EstrategiaOrdenacaoDeElfos implements Estrategia{

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        LinkedList<Elfo> retorno = new LinkedList<>();
        for(Elfo elfoAtual : atacantes){
            boolean elfoVivo = elfoAtual.getStatus().equals(Status.VIVO);
            if(elfoVivo){
                boolean ehElfoVerde = elfoAtual instanceof ElfoVerde;
                if(ehElfoVerde){
                    retorno.addFirst(elfoAtual);
                }else{
                    retorno.addLast(elfoAtual);
                }
            }
        }
        return retorno;
    }
}
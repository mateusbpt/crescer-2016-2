import java.util.*;

public class EstrategiaNoturnosPorUltimo implements Estrategia{

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        LinkedList<Elfo> retorno = new LinkedList<>();
        for(Elfo elfoAtual : atacantes){
            boolean elfoVivo = elfoAtual.getStatus().equals(Status.VIVO);
            if(elfoVivo){
                boolean ehElfoVerde = elfoAtual instanceof ElfoVerde;
                boolean ehElfoNoturno = elfoAtual instanceof ElfoNoturno;
                if(ehElfoVerde){
                    retorno.addFirst(elfoAtual);
                }else if(ehElfoNoturno){
                    retorno.addLast(elfoAtual);
                }
            }
        }
        return retorno;
    }
}
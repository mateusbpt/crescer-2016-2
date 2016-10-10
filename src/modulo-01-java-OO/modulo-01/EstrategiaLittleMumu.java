import java.util.*;

public class EstrategiaLittleMumu implements Estrategia{
    
    //TO-DO - Ajustes: tentar diminuir o uso de iterações.
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List <Elfo> retorno = new ArrayList<>();
        List<Elfo> auxiliar = elfosVivosEComFlecha(atacantes);
        int elfosNoturnosRestantes = (auxiliar.size()*30)/100;  
        for(Elfo elfoAtual : auxiliar){
            boolean ehElfoVerde = elfoAtual instanceof ElfoVerde;
            boolean ehElfoNoturno = elfoAtual instanceof ElfoNoturno;
            boolean aindaPodeAdicionar = elfosNoturnosRestantes > 0;
            if(ehElfoVerde){
                retorno.add(elfoAtual);
            }else if(ehElfoNoturno && aindaPodeAdicionar){
                retorno.add(elfoAtual);
                elfosNoturnosRestantes--;
            }
        }
        return ordenarPorQuantidadeDeFlechas(retorno);
    }

    private List<Elfo> elfosVivosEComFlecha(List<Elfo> atacantes){
        List <Elfo> retorno = new ArrayList<>();
        for(Elfo elfoAtual : atacantes){
            boolean elfoVivo = elfoAtual.getStatus().equals(Status.VIVO);
            boolean elfoComFlecha = elfoAtual.getFlecha().getQuantidade() > 0;
            if(elfoVivo && elfoComFlecha){
                retorno.add(elfoAtual);
            }
        }
        return retorno;
    }

    private List<Elfo> ordenarPorQuantidadeDeFlechas(List<Elfo> atacantes){
        int i,j;
        for (i = 1; i < atacantes.size(); i++) {
            Elfo auxiliar = atacantes.get(i);
            j = i;
            while ((j > 0) && atacantes.get(j - 1).getFlecha().getQuantidade() <
            auxiliar.getFlecha().getQuantidade()) { 
                atacantes.set(j, atacantes.get(j - 1));
                j--;
            }
            atacantes.set(j, auxiliar);
        }
        return atacantes;
    }
}
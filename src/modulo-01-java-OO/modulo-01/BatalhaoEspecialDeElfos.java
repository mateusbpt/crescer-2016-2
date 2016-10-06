import java.util.*;

public class BatalhaoEspecialDeElfos {
    private HashMap<String,ArrayList<Elfo>> batalhaoDeElfos = new HashMap<>();
    private HashMap<Status,ArrayList<Elfo>> batalhaoDeElfosPeloStatus = new HashMap<>();  

    public Elfo[] getExercitoDeElfos(){
        ArrayList<Elfo> resultado = new ArrayList<>();
        for(ArrayList<Elfo> lista : batalhaoDeElfos.values()){
            resultado.addAll(lista);
        }
        return resultado.toArray(new Elfo[resultado.size()]);   
    }

    public void alistarElfo(Elfo elfo){
        boolean tipoSoldadoPossivel = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(tipoSoldadoPossivel){
            ArrayList<Elfo> elfosComEsseNome = batalhaoDeElfos.get(elfo.getNome());
            boolean aindaNaoContemElfoComEsseNome = elfosComEsseNome == null;
            if(aindaNaoContemElfoComEsseNome){
                elfosComEsseNome = new ArrayList<>();
                batalhaoDeElfos.put(elfo.getNome(), elfosComEsseNome);
            }
            elfosComEsseNome.add(elfo);
        }
    }

    public Elfo buscarPeloNome(String chave){
        return batalhaoDeElfos.containsKey(chave) ? batalhaoDeElfos.get(chave).get(0) : null;  
    }

}
/** to-do: Ajustar esses métodos 
public ArrayList<Elfo> buscarPeloStatus (Status status){
ArrayList<Elfo> retorno = new ArrayList<>();
for(Map.Entry<String,Elfo> elfoAtual : batalhaoDeElfos.entrySet()) {  
if(elfoAtual.getValue().getStatus().equals(status)){
retorno.add(elfoAtual.getValue());
}
}
return retorno;   
}

public void agruparPorStatus(){
for(Map.Entry<String,ArrayList<Elfo>> elfoAtual : batalhaoDeElfos.entrySet()){ 
ArrayList<Elfo> elfo = par.getValue();
boolean aindaNaoAgrupouPorEsseStatus = elfos == null;

if(aindaNaoAgrupouPorEsseStatus){
elfos = new ArrayList<>();

}
}

}
 **/
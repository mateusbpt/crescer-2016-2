public class ElfoNoturno extends Elfo{

    public ElfoNoturno(String nome){
        super(nome);
    }

    public ElfoNoturno(String nome, int quantidadeFlechas){
        super(nome,quantidadeFlechas);      
    }

    //5.2 Sem o ajuste do item 5.3 não é possivel chegar a vida a 0, pois o double vai dividir muitas vezes e 
    //sempre aumentará a casas de 0, mas nunca chegará a 0.0. Exemplo: 0.0000001 => 000000000.1  

    public void atirarFlecha(Dwarf dwarf) {
        if(status == Status.VIVO){
            atirarFlecha(dwarf, 3);
            vida-=(vida*0.05);
            status = vida > 1.0 ? Status.VIVO : Status.MORTO;
        }
    }    
}
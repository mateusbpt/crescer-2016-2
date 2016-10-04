public class ElfoVerde extends Elfo {

    public ElfoVerde(String nome){
        super(nome);
    }

    public ElfoVerde(String nome, int quantidadeFlechas){
        super(nome,quantidadeFlechas);      
    }

    public void ganharItem(Item item) {
        boolean itensPossiveis = "Espada de aço valiriano".equals(item.getDescricao()) || "Arco e Flecha de Vidro".equals(item.getDescricao());
        if(itensPossiveis){
            inventario.adicionarItem(item);
        }
    }

    public void atirarFlecha(Dwarf dwarf) {
        int quantidadeFlechas = getFlecha().getQuantidade();
        if(quantidadeFlechas > 0){ 
            getFlecha().setQuantidade(quantidadeFlechas - 1);   
            dwarf.perderVida(); 
            experiencia+=2;
        }
    }
}
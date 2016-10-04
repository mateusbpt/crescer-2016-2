public class Item {
    private String descricao;
    private int quantidade;

    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void aumentarUnidades(int unidades) {
        quantidade += unidades;
    }

    public int aumentarUnidadesVezes1000(){
        if(quantidade != 0){
            int auxiliar = Math.abs(quantidade);
            int retorno = 0;
            while(auxiliar != 0){
                retorno+=auxiliar;
                auxiliar--;
            }
            return retorno*1000;
        }
        return 0;
    }
}    
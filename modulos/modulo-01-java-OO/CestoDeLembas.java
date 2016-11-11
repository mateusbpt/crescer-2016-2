public class CestoDeLembas {

    private int quantidadeLembas;

    public CestoDeLembas (int quantidadeLembas) {
        this.quantidadeLembas = quantidadeLembas;
    }

    public boolean podeDividirEmPares() {
        if(quantidadeLembas > 2 && quantidadeLembas <= 100) { 
            if(quantidadeLembas%2 == 0) {
                return true;   
            }
        }
        return false;
    }    
}
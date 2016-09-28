public class CestoDeLembas {

    private int quantidadeLembas;
    private boolean divisaoLembas;

    public CestoDeLembas (int quantidadeLembas) {
        this.quantidadeLembas = quantidadeLembas;
    }

    public boolean podeDividirEmPares() {
        if(quantidadeLembas >= 2 && quantidadeLembas <= 100) { 
            if(quantidadeLembas%2 == 0) {
                return true;   
            }
        }
        return false;
    }    
}
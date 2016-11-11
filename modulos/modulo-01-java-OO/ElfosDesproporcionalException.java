public class ElfosDesproporcionalException extends Exception{
    
    public ElfosDesproporcionalException(){
        System.out.println("O exército está desproporcional (ツ)");
    }
    
    public ElfosDesproporcionalException(String mensagem){
        super(mensagem);
    }
}


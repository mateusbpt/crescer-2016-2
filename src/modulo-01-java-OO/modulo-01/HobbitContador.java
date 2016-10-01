import java.util.*;

public class HobbitContador
{
    ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();

    
    
    
    
    public int calculaMMC(int num1, int num2){
        int resultado = 1;
        int auxiliar = 2;
        if(num1 != 0 && num2 != 0){
            while (num1 != 1 || num2 != 1) {
                while (num1 % auxiliar != 0 && num2 % auxiliar != 0) {
                    auxiliar++;
                }    
                if (num1 % auxiliar == 0) {
                    num1 = num1 / auxiliar;
                }
                if (num2 % auxiliar == 0) {
                    num2 = num2 / auxiliar;
                }
                resultado = resultado*auxiliar;
            }
            return resultado;
        }
        return 0;
    }
}

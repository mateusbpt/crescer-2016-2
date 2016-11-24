/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author mateus.teixeira
 */
public class Data {
   Calendar cal = new GregorianCalendar(); 
   


public String exibeDataAtual(){
    return cal.getTime().toString(); 
}

public String exibeDataFormatada(){
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      return formato.format(cal.getTime());
}

public String exibeDiaDaSemanaDoNascimento(String data){
    int diaDaSemana = 0;
    
    try {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal1 = Calendar.getInstance(); 
    cal1.setTime(formato.parse(data)); 
    diaDaSemana = cal1.get(Calendar.DAY_OF_WEEK);
   } catch (Exception e) {
       System.out.println(e);
   } 
   
  
   String aux = "";
   
   switch(diaDaSemana){
       case 1:
           aux = "Domingo";
           break;
        case 2:
           aux = "Segunda-Feira";
            break;
         case 3:
           aux = "Terca-Feira";
            break;
         case 4:
           aux = "Quarta-Feira";
            break;
          case 5:
           aux = "Quinta-Feira";
            break;
          case 6:
           aux = "Sexta-Feira";
            break;
            case 7:
           aux = "Sabado";
            break;
   
   }
   
    return aux;
}

}

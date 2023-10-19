package jackpot;
import java.util.ArrayList;
import org.apache.commons.lang3.RandomStringUtils;

public class Jugador {
    
    private int saldo;
    private String premio;
    private String VerPremioEnviar;
    private  ArrayList<String>nPremio;
    
    public Jugador(){
        saldo = 0;
        premio = "";
        VerPremioEnviar = "";
        nPremio =  new ArrayList<String>();
    }
    
    public String Juego(){

        String total = "";
        String premioTxt = "Su premio es ";
        if (saldo >= 1){
            for (int i = 0; i < 3; i++) {
                String letra = RandomStringUtils.randomAlphabetic(1).toUpperCase();
                total= total+letra;
            }
            if(total == "PPP"){
                premio = total +premioTxt+"Primer Premio 25.000€ ENHORABUENA !";
                saldo = saldo+25000;
                nPremio.add(";1erPremio 25.000€");
            }
            else if (total == "AAA"){
                premio = total +premioTxt+"Segundo Premio 10.000€";
                saldo = saldo+10000;
                nPremio.add(";2doPremio 10.000€");
            } 
            else if (total == "MMM"){
                premio = total +premioTxt+"Tercer Premio 5.000€";
                saldo = saldo+5000;
                nPremio.add(";3erPremio 5.000€");
            }
            else if (total.substring(0,2)== "AA"){
                premio = total +premioTxt+"Cuarto Premio 500€";
                saldo = saldo+500;
                nPremio.add(";4toPremio 500€");
            }
            else if (total.substring(0,2)== "OO"){
                premio = total +premioTxt+"Quinto Premio 250€;";
                saldo = saldo+250;
                nPremio.add(";5toPremio 250€");
            }
            else if (total.contains("A")| total.contains("E")| total.contains("U")== true){
                premio = total +premioTxt+"Sexto Premio 10€";
                saldo = saldo+10;
                nPremio.add(";6toPremio 10€");
            }
            else{
                premio=total+premioTxt+"0";
            }
            saldo = saldo -1;
        }
        else {
            premio="No tiene saldo suficiente para jugar.";
        }
        return premio;
    }   
    public String toString(){
        boolean valorArray = nPremio.isEmpty();
        if (valorArray){
            VerPremioEnviar=";Sin premios";
        }
        else 
            VerPremioEnviar = String.join("", nPremio);;
        return VerPremioEnviar;
    }
    public int verSaldo(){
        return saldo;
    }
    public void ingresaSaldo(int nSaldo) {
        saldo = saldo + nSaldo;
    }
    public void retiraSaldo(int nSaldo) {
        saldo = saldo - nSaldo; 
    }
}

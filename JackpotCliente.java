package jackpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class JackpotCliente {
    /**
    * Puerto
    * */
    private final static int PORT = 8500;
    /**
    * Host
    * */
    private final static String SERVER = "localhost";
    
    public static String creaTrama(String tr) {
        
        String trama="";
        
        //Funcion que crea la trama y TODA la lógica del envio al servidor.
        //Esta función confecciona la trama (String) pero no lo envia, es fuera, donde 
        //se llama. Despues se envia.
        //USO Obligatorio de Swith Case
    
        int depositar, extraer;
        Scanner teclado = new Scanner(System.in);
        trama = tr;
        
        switch(tr){
            case "1":
                System.out.println("¿Cuanto saldo quieres depositar? ");
                depositar = teclado.nextInt();
                trama = "E1" + depositar;
                break;
                
            case "2":
                System.out.println("Juguemos entonces! ");
                trama = "E2";
                break;
                
            case "3":
                System.out.println("Este es tu saldo: ");
                trama = "E3";
                break;
                
            case "4":
                System.out.println("Vamos a ver que has ganado: ");
                trama = "E4";
                break;
                
            case "5":
                System.out.println("¿Cuánto saldo quieres retirar? ");
                extraer = teclado.nextInt();
                trama = "E5" + extraer;                               
                break;
                
            case "6":
                trama = "E6Adiós";
                break;
                
            default:
                trama = "E9";
            }
            
        //Encriptar la trama
        String TramaEncriptada = Criptografia.Encriptar(trama);
        return TramaEncriptada;
        
    }
    public static void procesaRespuesta(String tr) {
        
        //Desencriptar la trama
        
        try{
            String TramaDesencriptada = Criptografia.Desencriptar(tr);
            switch(TramaDesencriptada.substring(0,2)){
            
            case "R1":
                System.out.println(TramaDesencriptada.substring(2));
                break;
                
            case "R2":
                System.out.println(TramaDesencriptada.substring(2));
                break;  
                
            case "R3":
                System.out.println(TramaDesencriptada.substring(2));
                break;
            
            case "R4":
                String cadena = TramaDesencriptada.substring(2);
                String[] separar = cadena.split(";");   
                for (int i = 0; i < separar.length; i++)    {     
                    System.out.println(separar[i]);   
                } 
                break;
                    
            case "R5":
                System.out.println(TramaDesencriptada.substring(2));
                break;                      
                
            case "R6":
                System.out.println(TramaDesencriptada.substring(2));
                
                break;
                
            default:
                System.out.println(TramaDesencriptada.substring(2));
            }
        }
        catch (Exception fallo){
            System.out.println("Fallo en la desencriptación de la trama R.");
            System.out.println(fallo);
        }
    }
        public static void main(String[] args) {
    	//variable que se encarga del control del programa
        boolean exit=false;
        
        //es el socket de comunicación
        Socket socket;
        
        //control de errores con un try catch
        try {            
            System.out.println("MENU");  
            ///AÃ±adir el menÃº
            
            //Se debe incluir lo necesario para mostrar el menu
            while( !exit ){//ciclo repetitivo   
                //abremos el socket socket
                socket = new Socket(SERVER, PORT);    
                
                //Para leer lo que envie el servidor      
                BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));  
                
                //para imprimir datos del servidor
                PrintStream output = new PrintStream(socket.getOutputStream());   
                
                //Para leer lo que escriba el usuario            
                BufferedReader brRequest = new BufferedReader(new InputStreamReader(System.in)); 
                
                System.out.println("-- Menu jackpot -- \n");
                System.out.println("1. Poner Saldo"); 
                System.out.println("2. Jugar"); 
                System.out.println("3. Ver saldo"); 
                System.out.println("4. Ver Premios"); 
                System.out.println("5. Retirar Saldo"); 
                System.out.println("6. Salir \n");
                
                //captura comando escrito por el usuario
                String request = brRequest.readLine();    
                
                String request_a_enviar=creaTrama(request);
                
                //manda peticion al servidor
                output.println(request_a_enviar);
                
                //captura respuesta e imprime
                String st = input.readLine();
                if( st != null ) {
                    procesaRespuesta(st);
                    //System.out.println("Trama del server encriptada = " + st );   
                }
                if(request.equals("6")){//terminar aplicacion poner el valor de salida
                    exit=true;                  
                    System.out.println("Fin de programa");    
                }
                socket.close();
            }//end while                                    
        } 
        catch (IOException ex) {        
            System.err.println(ex.getMessage());   
        }
    }
}
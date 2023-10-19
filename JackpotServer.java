package jackpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JackpotServer {
    /**
     * Puerto 
     */
    private final static int PORT = 8500;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        //Aqui deberás incluir la clase Jugador
        Jugador J = new Jugador();
        try {
            
            //Socket de servidor para esperar peticiones de la red
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");    
            System.out.println("En espera de cliente...");    
            //Socket de cliente
            Socket clientSocket;
            while(true){
                //en espera de conexion, si existe la acepta
                clientSocket = serverSocket.accept();
                
                //Para leer lo que envie el cliente
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                //para imprimir datos de salida                
                PrintStream output = new PrintStream(clientSocket.getOutputStream());
                
                //se lee peticion del cliente
                String request = input.readLine();
                
                //se procesa la peticion y se espera resultado
                String strOutput= procedimiento(request, J);  //Es posible que debas cambiar los parametros y pasar Jugador como parametro
                
                //se imprime en cliente
                output.flush();//vacia contenido
                output.println(strOutput);                
                //cierra conexion 
                clientSocket.close();
            }    
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    /**
     * procesa peticion del cliente y retorna resultado
     * @param request peticion del cliente
     * @return String
     */
    public static String procedimiento(String request, Jugador J){ //Es posible que tengas que incluir otro parametro que sea el Jugador para utilizarlo dentro
        
        //Desencriptar la trama
        String trama="";
        //Funcion que se encargará de procesar la peticion del cliente. 
        //Aqui llega la trama y se deberá¡ proceder a desmenuzarla y según lo que pida el cliente, actuar.
        //El resultado será otra trama con la contestación del resultado.
        //USO Obligatorio de Swith Case
        
        try{
            String TramaDesencriptada = Criptografia.Desencriptar(request);

                switch(TramaDesencriptada.substring(0,2)){
                
                case "E1":
                    int entero = Integer.parseInt(TramaDesencriptada.substring(2));
                    if (entero >0){
                        J.ingresaSaldo(Integer.parseInt(TramaDesencriptada.substring(2)));
                        trama = "R1Añadidos " + TramaDesencriptada.substring(2) + "€ correctamente.";
                        System.out.println(trama);
                    }
                    else{
                        trama = "R1Lo siento, no puedes ingresar números negativos o cero.";
                    }
                    break;

                case "E2":
                    trama = "R2"+J.Juego();
                    System.out.println(trama);
                    break;  

                case "E3":
                    trama = "R3Tu saldo actual es de " + J.verSaldo() + " €.";
                    System.out.println(trama);
                    break;

                case "E4":
                    trama = "R4Tus premios hasta el momento son: " + J.toString();;
                    System.out.println(trama);
                    break;

                case "E5":
                    int entero2 = Integer.parseInt(TramaDesencriptada.substring(2));
                    if (entero2 >0){
                        if (J.verSaldo() >= Integer.parseInt(TramaDesencriptada.substring(2))) {
                            J.retiraSaldo(Integer.parseInt(TramaDesencriptada.substring(2)));
                            trama = "R5Tu retirada de " + TramaDesencriptada.substring(2) + " € se ha procesado.";
                        } else {
                            trama = "R5Lo siento, tu saldo es insuficiente.";
                        }
                        System.out.println(trama);
                    }
                    else
                        trama = "R5Lo siento, no puedes ingresar números negativos o cero.";
                    break;                      

                case "E6":
                    trama = "R6Gracias por jugar con nosotros, que pases un buen dí­a!";
                    System.out.println(trama);
                    break;

                default:
                    trama= "R9Los números deben ser entre el 1 y el 6.";
                }
            }
            
        catch (Exception ex){
            System.out.println("Fallo en la desencriptación de la trama E.");
            System.out.println(ex);
        }
        
        //Encriptar el resultado
        String TramaEncriptada = Criptografia.Encriptar(trama);
        return TramaEncriptada;
    }
    
}
# Cómo jugar al Jackpot en JAVA por Caín

En este documento está explicado cómo se juega al JackPot subido a **Gitlab** programado con **Java** sin interfaz gráfica.

*Para que funcione este programa se deben añadir las librerias correspondientes para la funcion Utils Random y criptografía con su .java. **No incluidos en este repositorio.***

## Ejecutar el Jackpot

Abrimos el **JackpotServer.Java** y lo ejecutamos con run file, una vez salga el mensaje de ***En espera del cliente***, ejecutamos el cliente y saldrá el Menu del Jackpot.

![Servidor Listo](https://i.imgur.com/zDmrtgx.png)
![Menu Jackpot](https://i.imgur.com/RZdA6Yq.png)

## Opciones del menu

- [ ] La opción 1 es para añadir el saldo, la 5 para retirarlo, no permite ingresar números negativos o cero y para ver el saldo que tienes pulsa el 3.

![Error ingreso dato](https://i.imgur.com/6OgE0aE.png)
![Ingreso correcto](https://i.imgur.com/OVxQJqq.png)
![Saldo actual](https://i.imgur.com/b1WKVBJ.png)
![Retiro correcto](https://i.imgur.com/Tu6Wnpu.png)

- [ ] La opción 2 es para jugar, generará 3 letras aleatorias para ganar premios. Se debe tener 1 € de saldo como mínimo por jugada.

-  Lista de premios:

| PREMIO | LETRAS | OBTIENES   |
| -| -| -|
| Primero | PPP | 25.000 € |
| Segundo | AAA | 10.000 € |
| Tercero | MMM | 5.000 € |
| Cuarto | AA- | 500 € |
| Quinto | OO- | 250 € |
| Sexto | A E o U | 10 € |

![Jugar](https://i.imgur.com/niS3MZu.png)

- [ ] Para ver los premios ganados hasta el momento pulsa el 4.

![Premios](https://i.imgur.com/UNMAAuZ.png)

# ¿Cómo funciona el programa?

Explicación del funcionamiento del Jackpot de forma técnica.

## Seguimiento de las tramas

- [ ] Cuando pulsamos una opción del menu el cliente entra al *Switch Case* y crea una trama que envía al servidor empezando por "E" más la opción seleccionada, se envía encriptada utilizando la función **Encriptar**:

```java
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
         
        String TramaEncriptada = Criptografia.Encriptar(trama);
        return TramaEncriptada;
```
- [ ] El servidor recibe la trama encriptada y la desencripta mediante la función Desencriptar, en este caso es necesario utilizar un *Try Catch* porque la función contiene **throws Exception**. 
    - Según la opción seleccionada devolverá otra trama al cliente esta vez con la letra "R" y también la encripta. Dentro de este *Switch Case* se llaman a las funciones que hemos creado en clase **Jugador** que más tarde veremos.

```java
try {
    String TramaDesencriptada = Criptografia.Desencriptar(request);

        switch(TramaDesencriptada.substring(0,2)){
        
        case "E1":
            int entero = Integer.parseInt(TramaDesencriptada.substring(2));
            if (entero >0){
                J.ingresaSaldo(Integer.parseInt(TramaDesencriptada.substring(2)));
                trama = "R1Añadidos " + TramaDesencriptada.substring(2) + "€ correctamente.";
                System.out.println(trama);}
            else
                trama = "R1Lo siento, no puedes ingresar números negativos o cero.";
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
                System.out.println(trama);}
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

String TramaEncriptada = Criptografia.Encriptar(trama);
return TramaEncriptada;
```

- [ ] Por último el cliente recibirá la trama y mostrará por pantalla el resultado que le ha enviado el servidor.

```java
try {
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
```

## Clase Jugador

**Aquí hemos creado las funciones que se llaman desde el servidor.**

- Opción **Jugar**:
    - Esta es la más compleja porque genera las letras aleatorias y almacena los premios al saldo y en una array list al mismo tiempo.

```java
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
```

- El *To String* para mostrar los premios del arraylist.

```java
public String toString() {
        boolean valorArray = nPremio.isEmpty();
        if (valorArray){
            VerPremioEnviar=";Sin premios";
        }
        else 
            VerPremioEnviar = String.join("", nPremio);;
        return VerPremioEnviar;
    }
```

- Las funciones de ingresar, ver o retirar saldo son muy simples.

```java
public int verSaldo() {
    return saldo;
}
public void ingresaSaldo(int nSaldo) {
    saldo = saldo + nSaldo;
}
public void retiraSaldo(int nSaldo) {
    saldo = saldo - nSaldo; 
}
```
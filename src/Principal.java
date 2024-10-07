import util.Archivo;
import util.ConexionApi;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String clave = "e48c2696c3a0e24cad3e2fca";
        Scanner sc = new Scanner(System.in);
        Archivo historial = new Archivo("src/recursos/Historial.txt");

        //Menu para la busqueda del usuario
        boolean sw = true;
        do {
            System.out.println("*************************************************");
            System.out.println("\tBienvenido/a al Conversor de Moneda");
            System.out.println("*************************************************");
            System.out.println("1) Dólar estadounidense =>>> Peso Argentino");
            System.out.println("2) Peso Argentino =>>> Dólar estadounidense");
            System.out.println("3) Dólar estadounidense =>>> Boliviano boliviano");
            System.out.println("4) Boliviano boliviano =>>> Dólar estadounidense");
            System.out.println("5) Dólar estadounidense =>>> Real brasileño");
            System.out.println("6) Real brasileño =>>> Dólar estadounidense");
            System.out.println("7) Dólar estadounidense =>>> Peso colombiano");
            System.out.println("8) Peso colombiano =>>> Dólar estadounidense");
            System.out.println("9) Historial");
            System.out.println("0) Salir");
            System.out.println("*************************************************");
            System.out.println("\tElija una opcion valida entre (0 - 9)");
            System.out.println("*************************************************\n");
            int opcion = sc.nextInt();
            String moneda = "", monedaConvertir = "", direccion = "";
            switch (opcion) {
                case 1:
                    moneda = "USD";
                    monedaConvertir = "ARS";
                    direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
                    break;
                case 2:
                    moneda = "ARS";
                    monedaConvertir = "USD";
                    direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
                    break;
                case 3:
                    moneda = "USD";
                    monedaConvertir = "BOB";
                    direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
                    break;
                case 4:
                    moneda = "BOB";
                    monedaConvertir = "USD";
                    direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
                    break;
                case 5:
                    moneda = "USD";
                    monedaConvertir = "BRL";
                    direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
                    break;
                case 6:
                    moneda = "BRL";
                    monedaConvertir = "USD";
                    direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
                    break;
                case 7:
                    moneda = "USD";
                    monedaConvertir = "COP";
                    direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
                case 8:
                    moneda = "COP";
                    monedaConvertir = "USD";
                    direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
                    break;
                case 9:
                    System.out.println("El historial es :");
                    historial.leerArchivo();
                    break;
                case 0:
                    sw = false;
                    historial.eliminarArchivo();
                    break;
                default:
                    System.out.println("\tCODIGO NO VALIDO!!");
                    System.out.println("Ingrese un valor valido");
            }
            //Mostrar la direccion de la consulta de la API
            //System.out.println(direccion);
            if (!direccion.isEmpty()) {
                System.out.println("Ingrese el valor que deseas convertir:");
                int valor = sc.nextInt();
                ConexionApi conexion = new ConexionApi(valor, direccion, moneda, monedaConvertir, historial);
            }
        } while (sw);
    }
}
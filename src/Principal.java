import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String clave = "e48c2696c3a0e24cad3e2fca";
        Scanner sc = new Scanner(System.in);

        //Menu para la busqueda del usuario
        boolean sw = true;
        do {
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
            int opcion = sc.nextInt();
            String moneda, monedaConvertir, direccion = "";
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
                    System.out.println("historial");
                    break;
                case 0:
                    sw = false;
                    break;

                default:
                    System.out.println("CASO EXTREMO");
            }
            //Mostrar la direccion de la consulta de la API
            System.out.println(direccion);
            if (!direccion.isEmpty()) {
                try {
                    //Creando  el cliente HTTP
                    HttpClient client = HttpClient.newHttpClient();
                    //Creando la solicitud (request)
                    HttpRequest req = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
                    //Enviando la solicitud y obtener la respuesta (response)
                    HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
                    //Cuerpo de la respuesta (response)
                    //System.out.println(res.body());
                    // Procesar la respuesta  JSON
                    Gson gson = new Gson();
                    ConversionMoneda convert = gson.fromJson(res.body(), ConversionMoneda.class);
                    // Mostrar resultados
                    System.out.println("Moneda base: " + convert.getMoneda());
                    System.out.println("Tipos de cambio:");
                    for (Map.Entry<String, Double> entry : convert.getConversion().entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        } while (sw != false);

    }
}

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
        String moneda = sc.next();
        String direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;
        HttpClient cliente = HttpClient.newBuilder().build();
        //Mostrar la direccion de la consulta de la API
        System.out.println(direccion);
        try {
            //Creando  el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            //Creando la solicitud (request)
            HttpRequest req = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
            //Enviando la solicitud y obtener la respuesta (response)
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            //Cuerpo de la respuesta (response)
            System.out.println(res.body());
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
}

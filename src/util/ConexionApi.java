package util;

import com.google.gson.Gson;
import modelo.ConversionMoneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConexionApi {

    public ConexionApi(int valor, String direccion, String moneda, String monedaConvertir, Archivo historial){
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
//          System.out.println("Moneda base: " + convert.getMoneda());
//          System.out.println("Tipos de cambio:");
//          for (Map.Entry<String, Double> entry : convert.getConversion().entrySet()) {
//              System.out.println(entry.getKey() + ": " + entry.getValue());
//          }

            String salida = convert.ComvercionDeMoneda(valor, moneda, monedaConvertir);
            historial.guardarSalida(salida);
            System.out.println(salida);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

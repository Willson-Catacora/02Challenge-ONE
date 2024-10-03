//import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String clave = "e48c2696c3a0e24cad3e2fca";
        Scanner sc = new Scanner(System.in);
        String moneda =  sc.next();
        String direccion = "https://v6.exchangerate-api.com/v6/" + clave +"/latest/"+moneda;
        HttpClient cliente = HttpClient.newBuilder().build();

        //Gson gson = new Gson();
        System.out.println(direccion);
        try {
        //Creando la el cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString());
            System.out.println(res.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

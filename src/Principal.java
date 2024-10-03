//import com.google.gson.Gson;

import java.net.http.HttpClient;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String clave = "e48c2696c3a0e24cad3e2fca";
        Scanner sc = new Scanner(System.in);
        String moneda =  sc.next();
        String direccion = " https://v6.exchangerate-api.com/v6/" + clave +"/latest/"+moneda;
        HttpClient cliente = HttpClient.newBuilder().build();

        //Gson gson = new Gson();
        System.out.println(direccion);
    }
}

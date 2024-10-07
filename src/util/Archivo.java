package util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Archivo {
    private String rutaArchivo;

    public Archivo(String ruta){
        this.rutaArchivo = ruta;
    }

    public void guardarSalida(String salida){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            // Obtener la fecha y hora actuales
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHora = now.format(formatter);

            // Escribir la fecha y hora junto con el mensaje
            writer.write("\t[" + fechaHora + "]");
            writer.newLine(); // Agregar una nueva línea después de cada salida
            writer.write(salida);
            writer.newLine(); // Agregar una nueva línea después de cada salida
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
//            System.out.println("Contenido de " + rutaArchivo + ":");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

//    public void eliminarArchivo() {
//        File archivo = new File(rutaArchivo);
//        if (archivo.delete()) {
//            System.out.println("Nos vemos hasta que tengas la necesidad de convertir mas monedas.");
//        } else {
//            System.err.println("No se pudo eliminar el archivo " + rutaArchivo + ".");
//        }
//    }
}

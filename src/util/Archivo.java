package util;

import java.io.*;

public class Archivo {
    private String rutaArchivo;

    public Archivo(String ruta){
        this.rutaArchivo = ruta;
    }

    public void guardarSalida(String salida){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
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

    public void eliminarArchivo() {
        File archivo = new File(rutaArchivo);
        if (archivo.delete()) {
            System.out.println("Nos vemos hasta que tengas la necesidad de convertir mas monedas.");
        } else {
            System.err.println("No se pudo eliminar el archivo " + rutaArchivo + ".");
        }
    }
}

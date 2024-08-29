/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generecidadexercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BBDD bbdd = new BBDD();
        bbdd.conectar();
        Scanner scanner = new Scanner(System.in);
        
               // Solicitamos datos al usuario
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la EPS: ");
        String eps = scanner.nextLine();

        System.out.print("Ingrese la fecha de nacimiento formato: YYYY-MM-DD: ");
        String fechaNacimiento = scanner.nextLine();
        
        //Instanciamos la clase generica con los datos
        Pair<Integer, String> personData = new Pair<>(edad, nombre);
        Pair<String, String> epsData = new Pair<>(eps, fechaNacimiento);

        // Crear una instancia del controlador de la BBDD con los datos
        ControllerDDBB controller = new ControllerDDBB(personData, epsData);

        // Guardar los datos en la base de datos
        controller.guardar_usuario();

        // Imprimimos la informacion ingresada
        PrintInfo(personData, epsData);
        
    }

    public static void PrintInfo(Pair<Integer, String> personData, Pair<String, String> epsData) {
        // Ejemplo ilustrativo de cómo se podrían utilizar los datos
        System.out.println("Los datos guardados son");
        System.out.println("Edad: " + personData.getFirst());
        System.out.println("Nombre: " + personData.getSecond());
        System.out.println("EPS: " + epsData.getFirst());
        System.out.println("Fecha de nacimiento: " + epsData.getSecond());

    }
}

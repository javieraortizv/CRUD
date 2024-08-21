
package com.mycompany.claseintroduccionjava;

import java.util.Scanner;


public class ClaseIntroduccionJava {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibroCrud libro = new LibroCrud();
        
        while(true){
            System.out.println("Opciones:");
            System.out.println("1. Crear un libro");
            System.out.println("2. Leer todos los libros");
            System.out.println("3. Leer libro por ID");
            System.out.println("4. Actualizar estado Libro");
            System.out.println("5. Eliminar Libro");
            System.out.println("6. Salir del sistema");
            
            int opcion = scanner.nextInt();
            
            switch(opcion){
                case 1 ->{
                    System.out.println("ID del libro: ");
                    int idLibro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Autor:");
                    String autor = scanner.nextLine();
                    System.out.println("Editorial");
                    String editorial = scanner.nextLine();
                    System.out.println("Año de publicacion");
                    int anioPublicacion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("ISBN");
                    String isbn = scanner.nextLine();
                    System.out.println("Categoria");
                    String categoria = scanner.nextLine();
                    System.out.println("Estado");
                    String estado = scanner.nextLine();
                    libro.crearLibro(idLibro, titulo, autor, editorial, anioPublicacion, isbn, categoria, estado);
                }
                case 2 -> {
                    libro.leerLibro();
                }
                case 3 ->{
                    System.out.println("ID del libro: ");
                    int idLibro = scanner.nextInt();
                    scanner.nextLine();
                    libro.leerLibroPorID(idLibro);
                }
                case 4 ->{
                    System.out.println("ID del libro: ");
                    int idLibro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nuevo estado: ");
                    String nuevoEstado = scanner.nextLine();
                    libro.actualizarLibro(idLibro, nuevoEstado);
                }
                case 5 ->{
                    System.out.println("ID del libro: ");
                    int idLibro = scanner.nextInt();
                    scanner.nextLine();
                    libro.eliminarLibro(idLibro);
                }
                case 6 ->{
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Opcion invalida");
                }
            }
        }
    }
}

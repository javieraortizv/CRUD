
package com.mycompany.claseintroduccionjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class LibroCrud {
    
    int ID_Libro;
    String titulo;
    String autor;
    String editorial;
    int anioPublicacion;
    String ISBN;
    String categoria;
    String estado;
    
    /*
    Metodo encargado de registrar en la base de datos los libros
    */
    
    public void crearLibro(int ID_Libro, String titulo, String autor, String editorial, int anioPublicacion,String ISBN, String categoria, String estado){
        String query = "INSERT INTO Libro (ID_Libro, Título, Autor, Editorial, Año_Publicación, ISBN, Categoría, Estado)" + "VALUES(?,?,?,?,?,?,?,?)";
        
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, ID_Libro);
            pstmt.setString(2, titulo);
            pstmt.setString(3, autor);
            pstmt.setString(4, editorial);
            pstmt.setInt(5, anioPublicacion);
            pstmt.setString(6, ISBN);
            pstmt.setString(7, categoria);
            pstmt.setString(8, estado);
            pstmt.executeUpdate();
            conn.close();
            
            System.out.println("Libro creado exitosamente");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    /*
    Metodo para obtener libros registrados en el sistema    
    */
    
    public void leerLibro(){
        String query = "SELECT * FROM Libro";
        
        try(Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){
            while(rs.next()){
                System.out.println(rs.getInt(   "ID_Libro") + "\t" + 
                                   rs.getString("Título")   + "\t" +
                                   rs.getString("Autor")    + "\t" +
                                   rs.getString("Editorial")+ "\t" +
                                   rs.getInt(   "Año_Publicación") + "\t" +
                                   rs.getString("ISBN")     + "\t" +
                                   rs.getString("Categoría")+ "\t" +
                                   rs.getString("Estado")
                        );
            }
            conn.close();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
    Este metodo busca un libro por su identificador
    */
    public void leerLibroPorID(int ID_Libro){
        String query = "SELECT * FROM Libro WHERE ID_Libro = " + ID_Libro;
        
        try(Connection conn = ConexionBD.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){
            while(rs.next()){
                System.out.println("ID_Libro: "  + rs.getInt(   "ID_Libro") + "\n" + 
                                   "Titulo: "    +rs.getString("Título")   + "\n" +
                                   "Autor: "     +rs.getString("Autor")    + "\n" +
                                   "Editorial: " +rs.getString("Editorial")+ "\n" +
                                   "Anio_Publicacion: " +rs.getInt(   "Año_Publicación") + "\n" +
                                   "ISBN: "      +rs.getString("ISBN")     + "\n" +
                                   "Categoria: " +rs.getString("Categoría")+ "\n" +
                                   "Estado: "    +rs.getString("Estado")
                        );
            }
        conn.close();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
    Metodo para cambiar el estado del libro
    */
    
    public void actualizarLibro(int ID_Libro, String nuevoEstado){
        String query = "UPDATE Libro SET Estado = '" + nuevoEstado + "' WHERE ID_Libro = "+ ID_Libro;
       
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)){  
            pstmt.execute();
            conn.close();
            System.out.println("Estado del libro actualizado con exito");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
    Metodo para eliminar un libro por ID
    */
    
    public void eliminarLibro(int ID_Libro){
        String query = "DELETE FROM Libro WHERE ID_Libro = " + ID_Libro;
        
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)){  
            pstmt.execute();
            conn.close();
            System.out.println("Libro eliminado");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
            
}

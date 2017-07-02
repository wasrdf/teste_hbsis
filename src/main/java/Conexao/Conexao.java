package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static final String USUARIO = "root";
    private static final String SENHA = "26583205";
    private static final String URL = "jdbc:mysql://localhost:3306/hbsis";

    private static Connection conn;

    public static Connection conectar() {
        try {
            String DRIVER = "com.mysql.jdbc.Driver";
            Class.forName(DRIVER);
            Connection con = null;
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
            conn = con;
            System.out.println("Conectado...");
            return con;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

   

    public static void main(String[] args) {
        conectar();
    }
    
}

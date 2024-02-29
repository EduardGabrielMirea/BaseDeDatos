package ejemplos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
        private static  java.sql.Connection con;
        public static void main(String[] args) throws SQLException {
            //Connectar
            String host = "jdbc:sqlite:src/main/resources/network";
            con = java.sql.DriverManager.getConnection( host );
            //crearTabla();
            //inseratDatos();
            leerDatos();

        }

        private static void crearTabla()throws SQLException{
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE empleados (Num numeric(1,0), Nombre VARCHAR(100), Departamento numeric(2,0), Edad numeric(3,0), Sueldo numeric(6,2))");
            st.close();
        }

        private static void inseratDatos()throws SQLException{
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO empleados values (1,'Andreu',10,32,1000.00),(2,'Bernat',20,28,1200.00),(3,'Claudia',10,26,1100.00),(4,'Damià',10,40,1500.00)");
        }
        private static void leerDatos()throws SQLException{
            Statement st = con.createStatement();
            ResultSet rt = st.executeQuery("SELECT * FROM empleados");
                while (rt.next()){
                    System.out.printf("Num: %d, Nombre: %s, Departamento: %s, Edad: %d, Sueldo: %f \n",
                            rt.getInt(1),
                            rt.getString(2),
                            rt.getInt(3),
                            rt.getInt(4),
                            rt.getDouble(5)
                    );
                }
        }
    }


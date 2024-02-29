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
        leerUsuarios();
    }
    private static void crearTabla() throws SQLException{
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE t1 (C1 varchar(50))");
        st.close();
    }

    private static void leerUsuarios()throws SQLException{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.printf("ID: %d, Nombre: %s, Apellidos: %s \n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
    }
}


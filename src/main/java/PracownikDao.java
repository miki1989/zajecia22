import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PracownikDao {
    private static final String URL = "jdbc:mysql://localhost:3306/firma?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Nina2017";

    private Connection connection;

    public PracownikDao() {
        try {
            connection = DriverManager.getConnection(URL, USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Pracownik pracownik){
        String sql = "insert into pracownicy(imie, nazwisko, wyplata) values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pracownik.getImie());
            ps.setString(1, pracownik.getNazwisko());
            ps.setDouble(3,pracownik.getWyplata());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

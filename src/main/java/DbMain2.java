import java.sql.*;
import java.util.Scanner;

public class DbMain2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "Nina2017";

        Connection connnection = DriverManager.getConnection(url, username, password);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta");
        String cityname = scanner.nextLine();
        System.out.println("Podaj nową liczbę ludności");
        int value = scanner.nextInt();

        String sql = "update city set Population = ? where Name = ?";
        PreparedStatement preparedStatement = connnection.prepareStatement(sql);
        //preparedStatement.setString(1, cityname);
        preparedStatement.setInt(1,value);
        preparedStatement.setString(2, cityname);
        int rows = preparedStatement.executeUpdate();

        System.out.println("Zmienione wiersze " + rows);

        String sqlSelect = "select ID, Name, Population from city where Name=?";
        PreparedStatement preparedStatement1 = connnection.prepareStatement(sqlSelect);
        preparedStatement1.setString(1, cityname);
        ResultSet resultSet = preparedStatement1.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            String population = resultSet.getString("Population");
            System.out.println("Zaktualizowane rekordy: " + id + " " + name + " " + population);
        }


    }
}

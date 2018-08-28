import java.sql.*;
import java.util.Scanner;

public class DbMain {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "Nina2017";

            Connection connnection = DriverManager.getConnection(url,username, password);
            Statement statement = connnection.createStatement();
            String sql = "select * from city";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String countryCode = resultSet.getString("CountryCode");
                if (countryCode.equals("POL")){
                    String namePol = resultSet.getString("Name");
                    System.out.println(namePol + " " + countryCode);
                }

            }

            String sql2 = "select * from city WHERE countryCode='POL'";
            ResultSet resultSet1 = statement.executeQuery(sql2);
            while (resultSet1.next()){
                int id = resultSet1.getInt(1);
                String countryCode = resultSet1.getString("Name");
                System.out.println(id + " "+ countryCode);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj kod kraju");
            String countryCode = scanner.nextLine();
            String sql3 = "select * from city where countryCode='" + countryCode + "'";
            ResultSet resultSet2 = statement.executeQuery(sql3);
            while (resultSet2.next()){
                int id = resultSet2.getInt(1);
                String name = resultSet2.getString("Name");
                System.out.println(id + " " + name);
            }

            System.out.println("Podaj nazwę języka");
            String language = scanner.nextLine();
            String sql4 = "select * from countrylanguage where language = '" + language+ "'";
            ResultSet resultSet3 = statement.executeQuery(sql4);
            System.out.println("Język " + language + " obowiązuje w krajach: ");
            while (resultSet3.next()){
                String cc = resultSet3.getString("CountryCode");
                String isOfficial = resultSet3.getString("IsOfficial");
                System.out.println(cc + " " + isOfficial);
            }

            connnection.close();
        }
    }


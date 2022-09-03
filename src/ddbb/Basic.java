package ddbb;

import java.sql.*;

public class Basic {
    public static void main(String[] args) {

        try {

            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ensolvers", "root", "");

//            Statement myStatement = myConnection.createStatement();
//
//            ResultSet result = myStatement.executeQuery("SELECT * FROM notes");
//
//            while (result.next()) {
//                System.out.println(result.getString("archived"));
//            }

            PreparedStatement myStatement = myConnection.prepareStatement("SELECT * FROM notes WHERE archived=?");

            myStatement.setBoolean(1, true);

            ResultSet result = myStatement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("title"));
            }

            result.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

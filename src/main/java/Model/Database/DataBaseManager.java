package Model.Database;

import java.sql.*;

public class DataBaseManager {

    private static Connection dbConnection;
    private static String url = "jdbc:sqlite:C:myDatabase.db";

    /**
     * Accesses the database and drops the table, if it exists.
     *
     * @return String indicating if the operation was a success.
     */
    public String deleteTable() {
        try {
            dbConnection = DriverManager.getConnection(url);
            Statement deleteTableStatement = dbConnection.createStatement();
            deleteTableStatement.setQueryTimeout(30);
            deleteTableStatement.executeUpdate("DROP TABLE if exists Leagues");
            deleteTableStatement.executeUpdate("CREATE TABLE Leagues (id int, league string)");

            return "Table Leagues has successfully been created";
        } catch (SQLException e) {
            return "Error: ".concat(e.getMessage());
        } finally {
            try {
                if(dbConnection != null) {
                    dbConnection.close();
                }
            } catch(SQLException e) {
                return "Error".concat(e.getMessage());
            }
        }
    }

    /**
     * Accesses the database and creates the table, if it doesn't already exist.
     * @return String indicating if the operation was a success.
     */
    public String createTable() {
        try {
            dbConnection = DriverManager.getConnection(url);
            Statement createTableStatement = dbConnection.createStatement();
            createTableStatement.setQueryTimeout(30);
            createTableStatement.executeUpdate("CREATE TABLE if NOT EXISTS Leagues (id int, league string)");

            return "Table Leagues has successfully been created/loaded";
        } catch (SQLException e) {
            return "Error: ".concat(e.getMessage());
        } finally {
            try {
                if(dbConnection != null) {
                    dbConnection.close();
                }
            } catch(SQLException e) {
                return "Error".concat(e.getMessage());
            }
        }
    }

    /**
     * Inserts data into the first row of the database.
     *
     * @param data The data we want to insert into the database.
     * @return String indicating if the operation was a success.
     */
    public String insertData(String data) {
        String query = "INSERT INTO Leagues(id, league) VALUES(?,?)";
        try {
            dbConnection = DriverManager.getConnection(url);
            PreparedStatement prepStatement = dbConnection.prepareStatement(query);
            prepStatement.setInt(1, 1);
            prepStatement.setString(2, data);
            prepStatement.executeUpdate();

            return "Data successfully inserted";
        } catch(SQLException e) {
            return "Error: ".concat(e.getMessage());
        } finally {
            try {
                if(dbConnection != null) {
                    dbConnection.close();
                }
            } catch(SQLException e) {
                return "Error".concat(e.getMessage());
            }
        }
    }

    /**
     * Updates the first row in the database using the data provided.
     *
     * @param data The new data used to replace the old data.
     * @return String indicating if the operation was a success.
     */
    public String updateData(String data) {
        String query = "UPDATE Leagues SET league=? WHERE id=?";
        try {
            dbConnection = DriverManager.getConnection(url);
            PreparedStatement prepStatement = dbConnection.prepareStatement(query);
            prepStatement.setString(1, data);
            prepStatement.setInt(2, 1);
            prepStatement.executeUpdate();

            return "Data successfully updated";
        } catch(SQLException e) {
            return "Error: ".concat(e.getMessage());
        } finally {
            try {
                if(dbConnection != null) {
                    dbConnection.close();
                }
            } catch(SQLException e) {
                return "Error".concat(e.getMessage());
            }
        }
    }

    /**
     * Retrieves the first/only entry in the database.
     * @return data stored in the first entry.
     */
    public String retrieveData() {
        String query = "SELECT league FROM Leagues WHERE id=1";
        try {
            dbConnection = DriverManager.getConnection(url);
            Statement statement = dbConnection.createStatement();
            ResultSet results = statement.executeQuery(query);


            return results.getString("league");
        } catch(SQLException e) {
            return "Error: ".concat(e.getMessage());
        } finally {
            try {
                if(dbConnection != null) {
                    dbConnection.close();
                }
            } catch(SQLException e) {
                return "Error".concat(e.getMessage());
            }
        }
    }
}

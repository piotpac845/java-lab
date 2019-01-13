package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
/**
 * Used for communicating with database
 * @author Piotr Paczuła
 * @version 1.0
 */
public class DbRepository {
    private Connection connection;
    private Statement statement;
    
    public DbRepository(String path, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(path,user,password);//connectionString); 
        statement = connection.createStatement();
    }
    /**
     * Used for inserting new row into the database
     * @param GCD Greates Common Divisor
     * @param LCM Least Common Multiple
     * @throws SQLException 
     */
    public void insertRecord(int GCD, int LCM) throws SQLException{
        String query = "INSERT INTO CalculationArchives VALUES(" + GCD +", "+LCM+", '"+new Date().toString()+"')";
        statement.executeUpdate(query);
    }
    /**
     * Used for getting archived results from database
     * @return ArrayList of object containing archived calculations
     * @throws SQLException 
     */
    public ArrayList<CalculationArchive> getLastRecords() throws SQLException{
        ResultSet resultSet;
        ArrayList<CalculationArchive> archives = new ArrayList<>();
        String query = "SELECT * "+
                " FROM CalculationArchives " +
                "ORDER BY CalculationID DESC";
        resultSet = statement.executeQuery(query);
       int lcm, gcm;
       String date;
       while(resultSet.next()){
           gcm=resultSet.getInt("GCD");
           lcm=resultSet.getInt("LCM");
           date=resultSet.getString("CalculationDate");
           archives.add(new CalculationArchive(gcm,lcm,date));
       }
       return archives;
    }
    
}
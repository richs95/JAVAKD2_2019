/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author Richs
 */
public class ActionsWithDB {
    

    private static Connection con = null;
    private static Statement statement = null;

    
    //JDBC draivera ielade
    public static Connection connect() {
            con = null;

            String url = "jdbc:sqlite:database.db";
            try {
                    con = DriverManager.getConnection(url);
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            return con;
    }
    
    //datubazes izveide
    public static void createDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = connect();

            statement = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS Student " +
                    "(StudentID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FirstName VARCHAR(255) NOT NULL," +
                    "LastName VARCHAR(255) NOT NULL," +
                    "AGE INTEGER NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    
    public static void createAndInsertDB(ArrayList<Student> students) {
    createDB();

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = connect();

            conn.setAutoCommit(false);

            statement = conn.createStatement();

            for(Student student : students) {
                String sql = "INSERT INTO Student" +
                        "(FirstName, LastName, Age) " +
                        "VALUES ('"+student.getFirstname()+"','"+student.getLastname()+"',"+student.getAge()+")";
                statement.executeUpdate(sql);
                conn.commit();

                System.out.println("Added to database!");
            }
            conn.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Student> selectAllStudentsSQL() {
        ArrayList<Student> students = new ArrayList<>();
        try{
            Class.forName("org.sqlite.JDBC");
            Connection connection = connect();

            connection.setAutoCommit(false);

            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Student;");

            while(rs.next()) {
                students.add(new Student(rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("Age")));
            }
            rs.close();
            statement.close();
            connection.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return students;
    }
    
    public void closeDB(Connection connection) {
            try {
                    connection.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }
}

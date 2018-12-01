package eg.edu.alexu.csd.oop.db.cs04;

import eg.edu.alexu.csd.oop.db.Database;
import org.junit.Assert;

import java.io.File;
import java.sql.SQLException;

public class mainDBMS {

    public static void main(String[] args) {
        Database db = new MyDatabase();
        try {
           db.executeStructureQuery("Create Database test");
           db.executeStructureQuery("Create Table t1 (column1 int, column2 varchar,column3 int) ");
           db.executeUpdateQuery("INSERT INTO t1 VALUES (value1, 121, value3)");
           db.createDatabase("test",true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private File createDatabase(Database db, String name, boolean drop){
        String path = db.createDatabase("sample" + System.getProperty("file.separator") + name, drop); // create database
        //System.out.println(path);
        Assert.assertNotNull("Failed to create database", path);
        File dbDir = new File(path);
        Assert.assertTrue("Database directory is not found or not a directory", dbDir.exists() && dbDir.isDirectory());
        return dbDir;
    }

}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.grobo.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class SqliteDatabase implements Database{
    private File f;
    private Connection conn;
    public SqliteDatabase(File f){
        this.f=f;
    }
    @Override
    public void connect() throws Exception{
        System.out.println("Sqlite Database connecting...");
        String driver = "org.sqlite.JDBC";
        String url = "jdbc:sqlite:"+f.getAbsolutePath();
        Class.forName(driver);
        conn=DriverManager.getConnection(url);
        if(!conn.isClosed()){
            System.out.println("Sqlite Database connected!");
        }
    }

    @Override
    public ResultSet execSql(String sql) throws SQLException{
        Statement s=conn.createStatement();
        return s.executeQuery(sql);
    }

    @Override
    public void getWords(String[] args, int qid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

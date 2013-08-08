/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.grobo.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Administrator
 */
public class MysqlDatabase implements Database{
    private String db;
    private String pass;
    private String user;
    private Connection conn;
    @Override
    public void connect() throws Exception{
        System.out.println("Mysql Database connecting...");
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/"+db;
        Class.forName(driver);
        conn=DriverManager.getConnection(url, user, pass);
        if(!conn.isClosed()){
            System.out.println("Mysql Database connected!");
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
    public MysqlDatabase(String db,String user,String pass){
        this.db=db;
        this.user=user;
        this.pass=pass;
    }
}

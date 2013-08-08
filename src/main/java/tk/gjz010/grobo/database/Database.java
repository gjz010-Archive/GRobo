/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.grobo.database;

import java.sql.*;

/**
 *
 * @author Administrator
 */
public interface Database {
    public void connect() throws Exception;
    public ResultSet execSql(String sql) throws SQLException;
    public void getWords(String[] args,int qid);
    public void disconnect();
}

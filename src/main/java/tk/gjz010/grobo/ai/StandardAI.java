/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.grobo.ai;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import tk.gjz010.grobo.database.Database;

/**
 *
 * @author Administrator
 */
public class StandardAI implements AI{
    private Database db;
    public StandardAI(Database db){
        System.out.println("Standard AI initializing...");
        this.db=db;
        System.out.println("Standard AI initialized!");
    }
    @Override
    public String parseString(String str,int from) {
        StringBuilder sb=new StringBuilder("");
        try {
            db.execSql("select * from message where qid="+Integer.toString(from)+"or qid=0");
            
        } catch (SQLException ex) {
            Logger.getLogger(StandardAI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
}

package tk.gjz010.grobo;


import java.util.logging.Level;
import java.util.logging.Logger;
import tk.gjz010.grobo.database.*;
import com.webssky.jcseg.lucene.JcsegAnalyzer4X;
import java.io.File;
import java.sql.ResultSet;
import org.apache.lucene.analysis.Analyzer;
import tk.gjz010.grobo.ai.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello GRobo!" );
        Database mdb=new SqliteDatabase(new File("grobo.sqlite"));
        try {
            mdb.connect();
            ResultSet rs=mdb.execSql("select * from message");
            while(rs.next()){
                String name=rs.getString("message");
                System.out.println(name);
            }
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        AI ai=new StandardAI(mdb);
    }
}

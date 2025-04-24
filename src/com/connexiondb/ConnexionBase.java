package com.connexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ordi
 */
public class ConnexionBase {
    public Connection con;
    public Statement stat;
    
    public ConnexionBase() {
        //Class.forName("org.gjt.mm.mysql.Driver");//charger le pilote jdbc
        try
        {
            con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWD);
            stat = con.createStatement();//lanceur de requette
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    //select
    public ResultSet executeQuery (String query) throws Exception{
        ResultSet res = null;
        res = stat.executeQuery(query);
        return(res);
    }
    //insertion, update, delete
    public int executeUpdate (String query) throws Exception{
        int res=0;
	res=stat.executeUpdate(query, stat.RETURN_GENERATED_KEYS);
	return(res);
    }

    public void close() throws Exception{
	stat.close();
	con.close();
    }
}
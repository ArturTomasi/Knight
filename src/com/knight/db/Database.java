package com.knight.db;

import com.knight.application.ConfigurationManager;
import com.knight.data.Core;
import com.knight.db.fetcher.Fetcher;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author artur
 */
public class Database
{
    private static final String DB_URL      = ConfigurationManager.getInstance().getProperty( "db.url" );
    private static final String DB_USER     = ConfigurationManager.getInstance().getProperty( "db.user" );
    private static final String DB_PASSWORD = ConfigurationManager.getInstance().getProperty( "db.password" );
    private static final String DB_DRIVER   = ConfigurationManager.getInstance().getProperty( "db.driver" );

    private static Database database;
    private static Connection connection;
    private static Statement statment;
    
    /**
     * 
     * @throws Exception 
     */
    private Database() throws Exception
    {
        DriverManager.registerDriver( (Driver) Class.forName( DB_DRIVER ).newInstance() );
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    public static  Database getInstance()throws Exception
    {
        if( database == null )
        {
            database = new Database();
        }
        
        initConnection();
    
        return database;
    }
    
    /**
     * 
     * @throws Exception 
     */
    private static void initConnection() throws Exception
    {
        if( connection == null || connection.isClosed() )
        {
            connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD );
        }
    }
    
    /**
     * 
     * @throws Exception 
     */
    public void release() throws Exception
    {
        if( connection != null && statment != null )
        {   
            statment.close();
        }
    }
    
    /**
     * 
     * @param sql
     * @throws Exception 
     */
    public void executeCommand( String sql ) throws Exception
    {
        if( connection != null )
        {
            statment = connection.createStatement();
            
            statment.execute( sql );
            
            statment.close();
        }
    }
    
    /**
     * 
     * @param <T>
     * @param sql
     * @param fetcher
     * @return
     * @throws Exception
     */
    public <T> T fetchOne( String sql, Fetcher<T> fetcher ) throws Exception, Exception
    {
        statment = connection.createStatement();
        
        ResultSet resultSet = statment.executeQuery( sql );
        
        T t = null;
        
        if ( resultSet.next() )
        {
            t = fetcher.fetch( resultSet );
        }
        
        resultSet.close();

        statment.close();
        
        return t;
    }
    
    /**
     * 
     * @param <T>
     * @param sql
     * @param fetcher
     * @return
     * @throws Exception 
     */
    public <T>  List<T> fetchAll( String sql, Fetcher<T> fetcher ) throws Exception
    {
        statment = connection.createStatement();
        
        ResultSet resultSet = statment.executeQuery( sql );
        
        List<T> list = new ArrayList();
        
        while ( resultSet.next() )
        {
            list.add( fetcher.fetch( resultSet ) );
        }
        
        resultSet.close();
        
        statment.close();

        return list;
    }
    
    /**
     * 
     * @param sql
     * @return
     * @throws Exception 
     */
    public HashMap queryMap( String sql ) throws Exception
    {
        statment = connection.createStatement();
        
        ResultSet resultSet = statment.executeQuery( sql );
        
        HashMap hash = new HashMap();
        
        while ( resultSet.next() )
        {
            hash.put( resultSet.getInt( 1 ), resultSet.getObject( 2 ) );
        }
        
        resultSet.close();
        
        statment.close();

        return hash;
    }
    
    /**
     * 
     * @param sql
     * @return
     * @throws Exception 
     */
    public Integer queryInteger( String sql ) throws Exception
    {
        statment = connection.createStatement();
        
        ResultSet resultSet = statment.executeQuery( sql );
        
        Integer integer = null;
                
        if ( resultSet.next() )
        {
           integer = resultSet.getInt( 1 );
        }
        
        resultSet.close();
        
        statment.close();
        
        return integer;
    }
    
    /**
     * 
     * @param sql
     * @return
     * @throws Exception 
     */
    public String queryString( String sql ) throws Exception
    {
        statment = connection.createStatement();
        
        ResultSet resultSet = statment.executeQuery( sql );
        
        String string = null;
        
        if( resultSet.next() )
        {
            string = resultSet.getString( 1 );
        }
        
        resultSet.close();
        
        statment.close();
        
        return string;
    }
    
    /**
     * 
     * @param sql
     * @return
     * @throws Exception 
     */
    public ResultSet query( String sql ) throws Exception
    {
        statment = connection.createStatement();
        
        ResultSet resultSet = statment.executeQuery( sql );
        
        return resultSet;
    }
    
    /**
     * 
     * @param date
     * @return 
     */
    public String quote( Date date )
    {
        if( date == null )
        {
            return "null";
        }
    
        return "\'" + date.toString()  + "\'";
    }
    
    /**
     * 
     * @param object
     * @return 
     */
    public String quote( Object object )
    {
        if( object == null )
        {
            return "null";
        }
        
        return quote( object.toString() );
    }
    
    /**
     * 
     * @param sql
     * @return 
     */
    public String quote( String sql )
    {
        if( sql == null )
        {
           return "null";
        }
        
        if( sql.contains( "\'" ) )
        {
            sql = sql.replace( "\'", "\''" );
        }
        
        return "\'" + sql + "\'";
    }
   
    /**
     * 
     * @param value
     * @return 
     */
    public String upper( String value )
    {
        return " upper( " +  value + " ) ";
    }
    
    /**
     * 
     * @param value
     * @return 
     */
    public int flag( boolean value )
    {
        return value ? Core.FLAG_TRUE : Core.FLAG_FALSE;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public String foreingKey( int id )
    {
        String value = String.valueOf( id );
        
        if( id <= 0 )
        {
            value = "null";
        }
        
        return value;
    }
    
    /**
     * 
     * @return 
     */
    public Date currentDate()
    {
        return new Date( System.currentTimeMillis() );
    }
    
    /**
     * 
     * @return 
     */
    public Statement getStatment()
    {
        return Database.statment;
    }
    
    /**
     * 
     * @return 
     */
    public Connection getConnection()
    {
        return Database.connection;
    }
}

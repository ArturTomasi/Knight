package com.knight.application;

import com.knight.data.Security;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Time;
import java.util.Properties;
import org.zkoss.zk.ui.WebApps;

/**
 *
 * @author Matheus
 */
public class ConfigurationManager
{
    private static final String PROPERTIES_PATH = "/WEB-INF/application.properties";
    
    /**
     * 
     * @return 
     */
    public static ConfigurationManager getInstance()
    {
        return getInstance( WebApps.getCurrent().getResourceAsStream( PROPERTIES_PATH ) );
    }
    
    /**
     * 
     * @param in
     * @return 
     */
    public static ConfigurationManager getInstance( InputStream in )
    {
        return new ConfigurationManager( in );
    }

    private Properties properties = new Properties();
    
    /**
     * 
     * @param in 
     */
    public ConfigurationManager( InputStream in )
    {
        try
        {
            properties.load( in );
            
            in.close();
        }
        
        catch ( Exception e ) 
        {
            throw new RuntimeException( e );
        }
    }
    
    /**
     * 
     * @param key
     * @return 
     */
    public String[] getTokens( String key )
    {
        String value = getProperty( key );
        
        if ( value != null )
        {
            return value.split( "," );
        }
        
        return new String[]{};
    }
    
    /**
     * 
     * @param key
     * @param defaultTime
     * @return 
     */
    public Time getTime( String key, Time defaultTime )
    {
        String value = getProperty( key );
        
        if ( value != null )
        {
            return Time.valueOf( value );
        }
        
        return defaultTime;
    }
    
    /**
     * 
     * @param key
     * @return 
     */
    public int getInt( String key )
    {
        return Integer.parseInt( getProperty( key, "0" ) );
    }
    
    /**
     * 
     * @param key
     * @return 
     */
    public boolean getFlag( String key )
    {
        return Boolean.parseBoolean( getProperty( key, "false" ) );
    }
    
    /**
     * 
     * @param key
     * @return 
     */
    public String getDecryptedProperty( String key )
    {
        String value = getProperty( key );
        
        if ( value != null )
        {
            return Security.decrypt( value );
        }
        
        return null;
    }
    
    /**
     * 
     * @param key
     * @return 
     */
    public String getProperty( String key )
    {
        return getProperty( key, null );
    }
    
    /**
     * 
     * @param key
     * @param defaultValue
     * @return 
     */
    public String getProperty( String key, String defaultValue )
    {
        return properties.getProperty( key, defaultValue );
    }
    
    /**
     * 
     * @param key
     * @param o 
     */
    public void setProperty( String key, Object o )
    {
        properties.setProperty( key, o.toString() );
    }
    
    
    /**
     * 
     * @throws Exception 
     */
    public void store() throws Exception
    {
        store( new File( WebApps.getCurrent().getResource( PROPERTIES_PATH ).getFile() ) );
    }
    
    /**
     * 
     * @param out
     * @throws Exception 
     */
    public void store( File out ) throws Exception
    {
        FileOutputStream fos = null;
        
        try
        {
            fos = new FileOutputStream( out );
            
            properties.store( fos, null );
        }
        
        finally
        {
            if ( fos != null )
            {
                fos.flush();
                fos.close();
            }
        }
    }
}

package com.knight.data;

import com.knight.ApplicationUtilities;
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author arturW
 */
public class Security 
{
    private static MessageDigest messageDigest = null; 
    
    private static final String ALGORITHM = "AES";
    private static final String KEY = "Y1FEKJ8nQhT472vNToIpoQ==";
    
    public static String hash( String value )
    { 
        try
        {
            if ( value == null )
            {
                return null;
            }

            messageDigest = MessageDigest.getInstance( "SHA1" );
            
            return "<" + String.format( "%040x", new BigInteger( messageDigest.digest( value.getBytes() ) ).abs() ) + ">";
        }
        
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }
    
    /**
     * 
     * @param content
     * @return 
     */
    public static String encrypt( String content ) 
    {
        try
        {
            Key key = new SecretKeySpec( Base64.getDecoder().decode( KEY ), ALGORITHM );

            Cipher c = Cipher.getInstance( ALGORITHM );
            c.init( Cipher.ENCRYPT_MODE, key );

            byte[] bytes = c.doFinal( content.getBytes() );

            return new String( Base64.getEncoder().encode( bytes ) );
        }
        
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }
    
    /**
     * 
     * @param content
     * @return 
     */
    public static String decrypt( String content )
    {
        try
        {
            Key key = new SecretKeySpec( Base64.getDecoder().decode( KEY ), ALGORITHM );

            Cipher c = Cipher.getInstance( ALGORITHM );
            c.init( Cipher.DECRYPT_MODE, key );

            byte bytes[] = Base64.getDecoder().decode( content );

            return new String( c.doFinal( bytes ) );
        }
        
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }
   
}

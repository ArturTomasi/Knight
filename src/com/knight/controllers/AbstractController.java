package com.knight.controllers;

import com.knight.ApplicationUtilities;
import com.knight.data.User;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *
 * @author artur
 * @param <T>
 * @param <E>
 */
public abstract class AbstractController <T, E>
{
    private String  className ;
    
    public AbstractController() 
    {
        Type superClass = this.getClass().getGenericSuperclass();
        
        Type type = ( ( ParameterizedType ) superClass ).getActualTypeArguments()[0];
        
        className = type.toString().split(" ")[1];
    }
     
    
    public abstract String onEdit( E item ) throws Exception;
    public abstract String onDelete( E item ) throws Exception;
    public abstract String onAdd( E item ) throws Exception;

    public User getActiveUser()
    {
        return ApplicationUtilities.getInstance().getActiveUser();
    }
    
    protected void logException( Exception e )
    {
        ApplicationUtilities.getInstance().logException( e );
    }
}

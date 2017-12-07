package com.master.controllers;

import com.master.ApplicationUtilities;
import com.master.application.ModuleContext;
import com.master.data.Security;
import com.master.data.User;

/**
 * @author artur
 */
public class LoginController 
{
    private static LoginController instance;
    
    private LoginController(){}
    
    public static LoginController getInstance()
    {
        if( instance == null )
        {
            instance = new LoginController();
        }
        
        return instance;
    }
    
    public User login( String login, String password )
    {
        User user = null;
        
        try
        {
            user = ModuleContext.getInstance().getUserManager().getUserByLogin( login, Security.hash( password ) );
                      
            if( user != null )
            {
                ApplicationUtilities.getInstance().setActiveUser( user );
            }
        }
        
        catch( Exception e )
        {
            ApplicationUtilities.getInstance().logException( e );
        }
        
        return user;
    }
}

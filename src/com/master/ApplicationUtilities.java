package com.master;

import com.master.data.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

public class ApplicationUtilities
{

    private ApplicationUtilities()
    {
    }

    public static final String SESSION_NAME = "ApplicationUtilities";
    
    /**
     * 
     * @return 
     */
    public static ApplicationUtilities getInstance()
    {
        ApplicationUtilities ac = null;

        if ( Sessions.getCurrent() != null )
        {
            ac = (ApplicationUtilities) Sessions.getCurrent().getAttribute( SESSION_NAME );
        }

        if ( ac == null )
        {
            ac = new ApplicationUtilities();

            if ( Sessions.getCurrent() != null )
            {
                Sessions.getCurrent().setAttribute( SESSION_NAME, ac );
            }
        }

        return ac;
    }
    
    /**
     * 
     * @return 
     */
    public User getActiveUser()
    {
        return (User) ( (HttpSession) Sessions.getCurrent().getNativeSession() ).getAttribute( "ActiveUser" );
    }
    
    /**
     * 
     * @param user 
     */
    public void setActiveUser( User user )
    {
        ((HttpSession)Sessions.getCurrent().getNativeSession()).setAttribute( "ActiveUser", user );

        Executions.sendRedirect( "" );
    }
    
    /**
     * 
     * @return 
     */
    public Component getRoot()
    {
        return Executions.getCurrent().getDesktop().getFirstPage().getFirstRoot();
    }
    
    /**
     * 
     * @param e 
     */
    public void logException( Throwable e )
    {
        Logger.getGlobal().log( Level.SEVERE, null, e );
    }
    
    /**
     * 
     * @param info 
     */
    public void logInfo( String info )
    {
        Logger.getGlobal().log( Level.INFO, info );
    }
    
    /**
     * 
     */
    public void logout()
    {
        Executions.getCurrent().getSession().invalidate();
        Executions.sendRedirect( null );
    }

}

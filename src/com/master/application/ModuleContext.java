package com.master.application;

import com.master.db.services.*;

/**
 * @author artur
 */
public class ModuleContext 
{
    private static ModuleContext moduleContext;
    
    public static ModuleContext getInstance()
    {
        if( moduleContext == null )
        {
            moduleContext = new ModuleContext();
        }
        
        return  moduleContext;
    }
    
    private ModuleContext(){}
    
    public UserManagerService getUserManager()
    {
        return UserManagerService.getInstance();
    }
}

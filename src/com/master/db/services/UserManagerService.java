package com.master.db.services;

import com.master.data.User;
import com.master.db.Database;
import com.master.db.transactions.UserManagerTransactions;

public class UserManagerService 
    extends 
        Manager<User,UserManagerTransactions>
{
    private static UserManagerService service;
   
    public static UserManagerService getInstance()
    {
        if( service == null )
        {
            service = new UserManagerService();
        }
        
        return  service;
    }
    public UserManagerService()
    {
        transactions = new UserManagerTransactions();
    }

    public User getUserByLogin( String login, String password ) throws Exception 
    {
        Database db = Database.getInstance();
        
        try
        {
            return transactions.getUserByLogin( db, login, password );
        }
        
        finally
        {
            db.release();
        }
    }
}

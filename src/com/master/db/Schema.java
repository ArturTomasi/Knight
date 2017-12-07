package com.master.db;

import com.master.db.fetcher.*;

/**
 * @author artur
 */
public class Schema 
{    
    public static class Users
    {
        public static Users alias( String alias )
        {
            return new Users( alias );
        }
        
        public  class Columns
        {
            public String ID;
            public String NAME;
            public String MAIL;
            public String STATE;
            public String PASSWORD;
            public String LOGIN;
            public String ROLE;
            
            public Columns( String alias ) 
            {
                ID           = alias + "id";
                NAME         = alias + "name";
                MAIL         = alias + "mail";
                STATE        = alias + "state";
                PASSWORD     = alias + "password";
                LOGIN        = alias + "login";
                ROLE         = alias + "role";
            }
            
            @Override
            public String toString() 
            {
                return ID           + ", " +
                       NAME         + ", " +
                       MAIL         + ", " +
                       STATE        + ", " +
                       PASSWORD     + ", " +
                       LOGIN        + ", " +
                       ROLE;
            }
        }
        
        private final String TABLE_NAME =  "users";

        public String name = TABLE_NAME;

        public final String select;
        
        public final UserFetcher fetcher = new UserFetcher();
        
        public static final Users table = new Users( null );
        
        public final Columns columns;

        private Users( String alias ) 
        {
            this.name = alias != null ? TABLE_NAME + " " + alias : TABLE_NAME;
            
            columns = new Columns( alias != null ? alias + "." : "" );
            
            select = "select " + columns + " from " + this.name;
        }
    }
}

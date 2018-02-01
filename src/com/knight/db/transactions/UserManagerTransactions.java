package com.knight.db.transactions;

import com.knight.data.User;
import com.knight.data.filters.DefaultFilter;
import com.knight.db.Database;
import com.knight.db.Schema.*;
import java.sql.Date;
import java.util.List;

/**
 * @author artur
 */
public class UserManagerTransactions 
    extends 
        ManagerTransaction<User>
{
    @Override
    public void add( Database db, User user ) throws Exception
    {
        if( user == null )
        {
            throw new Exception( "User cannot be null" );
        }
        
        else if ( user.getId() != 0 )
        {
            throw new Exception( "Invalid user id" );
        }
        
        Users U = Users.table;
        
        String sql = "insert into " + U.name + 
                     "( " +
                        U.columns.NAME         + "," +
                        U.columns.MAIL         + "," +
                        U.columns.STATE        + "," +
                        U.columns.PASSWORD     + "," +
                        U.columns.ROLE         + "," +
                        U.columns.LOGIN        + 
                     ") values ( " +
                        db.quote( user.getName() )       + "," +
                        db.quote( user.getMail() )       + "," +
                        user.getState()                  + "," +
                        db.quote( user.getPassword() )   + "," +
                        user.getRole()                   + "," +
                        db.quote( user.getLogin() )      +
                     ") ";
        
        db.executeCommand( sql );
    }
    
    @Override
    public void delete( Database db, User user ) throws Exception
    {
        if( user == null )
        {
            throw new Exception( "User cannot be null" );
        }
        
        Users U = Users.table;
        
        String sql = " update " + U.name + " set " +
                        U.columns.STATE + " = " + User.STATE_INACTIVE +
                     " where "  +
                        U.columns.ID    + " = " + user.getId();
        
        db.executeCommand( sql );
    }
    
    @Override
    public void update( Database db, User user ) throws Exception
    {
        if( user == null )
        {
            throw new Exception( "User cannot be null" );
        }
        
        Users U = Users.table;
        
        String sql = " update " + U.name       + " set " +
                        U.columns.NAME         + " = " + db.quote( user.getName() )      + ", " +
                        U.columns.MAIL         + " = " + db.quote( user.getMail() )      + ", " +
                        U.columns.STATE        + " = " + user.getState()                 + ", " +
                        U.columns.PASSWORD     + " = " + db.quote( user.getPassword() )  + ", " +
                        U.columns.ROLE         + " = " + user.getRole()                  + ", " +
                        U.columns.LOGIN        + " = " + db.quote( user.getLogin() )     +
                     " where " + 
                        U.columns.ID           + " = " + user.getId();
        
        db.executeCommand( sql );
    }
    
    @Override
    public User get( Database db, int userId ) throws Exception
    {
        Users U = Users.table;
        
        String sql = U.select  + 
                     " where " + 
                     U.columns.ID    + " = " + userId +
                     " and "   +
                     U.columns.STATE + " = " + User.STATE_ACTIVE;
        
        return db.fetchOne( sql , U.fetcher );
    }
    
    @Override
    public List<User> get( Database db ) throws Exception
    {
        return get( db, false );
    }
    
    public List<User> get( Database db, boolean showInactives ) throws Exception
    {
        Users U = Users.table;
        
        String sql = U.select;
        
        if( ! showInactives )
        {
            sql += " where " + U.columns.STATE + " = " + User.STATE_ACTIVE;
        }
         
        sql += " order by " + U.columns.NAME;
        
        return db.fetchAll( sql , U.fetcher );
    }
    
    @Override
    public List<User> get( Database db, DefaultFilter filter ) throws Exception
    {
        Users U = Users.table;
        
        StringBuilder sb = new StringBuilder();
        
        sb.append( U.select )
          .append( " where true " );
        
        filter.getConditions().forEach( ( key, values ) ->
        {
            String condition = " and ( ";
            
            for( int i = 0; i < values.size(); i++ )
            {
                switch ( key )
                {
//                    case UserFilter.BIRTH_DATE:
//                    {
//                        if( values.get( i ) instanceof Date[] )
//                        {
//                            Date[] dates = (Date[]) values.get( i );
//                            
//                            condition += U.columns.BIRTH_DATE+ 
//                                         " between " + 
//                                         db.quote( dates[0] ) +
//                                         " and " +
//                                         db.quote( dates[1] );
//                        }
//                    }
//                    break;
                }
                
                condition += i == values.size() - 1 ? " ) " : " or ";
            }
            
            sb.append( condition );
            
        } );
        
        sb.append( " order by " ).append( U.columns.NAME );
        
        return  db.fetchAll( sb.toString(), U.fetcher );
    }
    
    
    public User getUserByLogin( Database db, String login, String password ) throws Exception
    {
        Users U = Users.table;
        
        String sql = U.select  + 
                     " where " +
                     U.columns.LOGIN    + " = " + db.quote( login ) +
                     " and "   +
                     U.columns.PASSWORD + " = " + db.quote( password ) +
                     " and "   +
                     U.columns.STATE    + " = " + User.STATE_ACTIVE;
        
        return db.fetchOne( sql, U.fetcher );
    }
}
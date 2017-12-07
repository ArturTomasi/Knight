package com.master.db.fetcher;

import com.master.data.User;
import java.sql.ResultSet;

/**
 * @author artur
 */
public class UserFetcher
    implements 
        Fetcher<User>
{
    /**
     * 
     * @param resultSet
     * @return
     * @throws Exception 
     */
    @Override
    public User fetch( ResultSet resultSet ) throws Exception 
    {
        int i = 1;
        
        User user = new User();
        
        user.setId( resultSet.getInt( i++ ) );
        user.setName( resultSet.getString( i++ ) );
        user.setMail( resultSet.getString( i++ ) );
        user.setState( resultSet.getInt( i++ ) );
        user.setPassword( resultSet.getString( i++ ) );
        user.setLogin( resultSet.getString( i++ ) );
        
        return  user;
    }
}

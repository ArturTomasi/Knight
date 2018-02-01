package com.knight.db.transactions;

import com.knight.data.Core;
import com.knight.db.Database;
import java.util.List;

/**
 * 
 * @author lucas
 * @param <T> Core
 */
public abstract class ManagerTransaction <T extends Core>
{
    public void delete( Database db, T obj ) throws Exception
    {
        obj.setState( Core.STATE_INACTIVE );
        
        update( db, obj );
    }
        
    public abstract void add( Database db, T obj ) throws Exception;
    
    public abstract void update( Database db, T obj ) throws Exception;
    
    public abstract T get( Database db, int id ) throws Exception;
    
    public abstract List get( Database db ) throws Exception;
    
    public abstract List get( Database db, com.knight.data.filters.DefaultFilter filter ) throws Exception;
}

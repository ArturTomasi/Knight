package com.master.db.services;

import com.master.data.Core;
import com.master.data.filters.DefaultFilter;
import com.master.db.Database;
import com.master.db.transactions.ManagerTransaction;
import java.util.List;

/**
 * @author lucas
 * @param <T> Transaction
 * @param <X> Core
 */
public class Manager<T extends Core, X extends ManagerTransaction<T> >
{
    protected X transactions;
    
    public void add( T obj ) throws Exception
    {
        Database db = Database.getInstance();
    
        try
        {
            transactions.add( db , obj );
        }

        finally
        {
            db.release();
        }
    }

    
    public void delete( T obj ) throws Exception
    {
        Database db = Database.getInstance();
    
        try
        {
            transactions.delete(db , obj );
        }

        finally
        {
            db.release();
        }   
    }
    
    public void update( T obj ) throws Exception
    {
        Database db = Database.getInstance();
    
        try
        {
            transactions.update(db , obj );
        }

        finally
        {
            db.release();
        }
    }
    
    public T get( int id ) throws Exception
    {
        Database db = Database.getInstance();
    
        try
        {
            return transactions.get( db , id );
        }

        finally
        {
            db.release();
        }
    }
    
    public List<T> get() throws Exception
    {
        Database db = Database.getInstance();
    
        try
        {
            return transactions.get( db );
        }

        finally
        {
            db.release();
        }
    }
    
    public List<T> get( DefaultFilter filter ) throws Exception
    {
        Database db = Database.getInstance();
    
        try
        {
            return transactions.get( db , filter );
        }

        finally
        {
            db.release();
        }
    }
}

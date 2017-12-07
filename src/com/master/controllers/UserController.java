package com.master.controllers;

import com.master.data.User;

/**
 * @author artur
 */
public class UserController 
    extends 
        AbstractController<UserController, User>
{
    private static UserController instance;
    
    private UserController(){}
    
    public static UserController getInstance()
    {
        if( instance == null )
        {
            instance = new UserController();
        }
        
        return instance;
    }
    
    @Override
    public String onDelete( User user ) throws Exception
    {
        if( user != null && user.getState() == User.STATE_INACTIVE )
        {
            return "Usuário já encontra-se excluida!";
        }

        else if( user == null )
        {
            return "Selecione um usuário para excluir!";
        }

        return null;
    }
    
    @Override
    public String onEdit( User user )
    {
        if( user == null)
        {
            return "Selecione um usuário para editar";
        }
        
        return null;
    }

    @Override
    public String onAdd( User item ) throws Exception 
    {
        return null;
    }
}

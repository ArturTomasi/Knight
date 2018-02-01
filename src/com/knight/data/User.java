package com.knight.data;

/**
 * @author artur
 */
public class User 
    extends 
        Core<User>
{
    public final static int ROLE_ADMIN    = 0;
    public final static int ROLE_OPERATOR = 1;
    
    private String name;
    private String mail;
    private int    role;
    private String login;
    private String password;

    public User(){}

    public User( String name, String login, String password ) 
    {
        this.name     = name;
        this.login    = login;
        this.password = password;
    }

    public void setLogin( String login )
    {
        this.login = login;
    }

    public String getLogin() 
    {
        return login;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getName() 
    {
        return name;
    }

    public void setName( String name ) 
    {
        this.name = name;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail( String mail )
    {
        this.mail = mail;
    }

    public int getRole() 
    {
        return role;
    }

    public void setRole( int role )
    {
        this.role = role;
    }

    @Override
    public String toString() 
    {
        return name;
    }
}

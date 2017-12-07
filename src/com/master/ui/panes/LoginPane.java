package com.master.ui.panes;

import com.master.application.ConfigurationManager;
import com.master.controllers.LoginController;
import com.master.data.User;
import com.master.ui.parts.AButton;
import com.master.ui.parts.ALabel;
import com.master.ui.parts.FormInput;
import com.master.ui.parts.FormInputType;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;

/**
 * @author artur
 */
public class LoginPane 
    extends 
        Div
{
    public LoginPane() 
    {
        initComponents();
    }
    
    private void login()
    {
        User user = LoginController.getInstance().login( loginField.getText(), passwordField.getText() );
        
        if ( user == null )
        {
            Clients.evalJavaScript( "onLoginError()" );
        }
    }
    
    
    private void initComponents()
    {
        setZclass( "container login-center" );

        ALabel labelApplication = new ALabel();
        labelApplication.setValue( ConfigurationManager.getInstance().getProperty( "application.name", "Application Name" ) );
        labelApplication.setStyle( "display: block;" );
        labelApplication.setZclass( "title-login" );
        
        FormPane loginPane = new FormPane();
        loginPane.setInputs( loginField, passwordField );
        
        
        btnLogin.setSclass( "btn-login" );
        
        btnLogin.addEventListener( Events.ON_CLICK, e -> login() );
        
        appendChild( labelApplication );
        appendChild( loginPane );
        appendChild( btnLogin );
    }
    
     private FormInput loginField    = new FormInput( FormInputType.TEXT, "Login" );
     private FormInput passwordField = new FormInput( FormInputType.PASSWORD, "Senha " );
     
    private  AButton btnLogin = new AButton( "Sign in" ) 
    {
        @Override
        public void onClick( Event e ) throws Exception 
        {
            login();
        }
    };
}

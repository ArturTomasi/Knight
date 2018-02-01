package com.knight.ui.panes;

import com.knight.application.ConfigurationManager;
import com.knight.controllers.LoginController;
import com.knight.data.User;
import com.knight.ui.parts.AButton;
import com.knight.ui.parts.ALabel;
import com.knight.ui.parts.FormInput;
import com.knight.ui.parts.FormInputType;
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
        
        ALabel errorLabel = new ALabel( "Atenção! login ou senha incorretos." );
        errorLabel.setZclass( "error-login" );
        
        FormPane loginPane = new FormPane();
        loginPane.setInputs( loginField, passwordField );
        
        btnLogin.setSclass( "btn-login" );
        
        loginField.addEventListener(    Events.ON_OK, e -> login() );
        passwordField.addEventListener( Events.ON_OK, e -> login() );
        
        Div conteiner = new Div();
        conteiner.setZclass( "login-center-container" );
        
        conteiner.appendChild( labelApplication );
        conteiner.appendChild( loginPane );
        conteiner.appendChild( btnLogin );
        conteiner.appendChild(  errorLabel );
        
        appendChild( conteiner );
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

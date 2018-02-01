package com.knight.ui.panes;

import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.North;

/**
 *
 * @author artur
 */
public class ApplicationCaption 
    extends 
        North
{
    public ApplicationCaption() 
    {
        initComponents();
    }
    
    private void initComponents()
    {
        Label lb = new Label( "Knight" );
        
        box.appendChild( lb );
        
        appendChild( box );
    }
    
    private Hbox box = new Hbox();
}

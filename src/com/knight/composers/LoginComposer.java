package com.knight.composers;

import com.knight.ui.panes.LoginPane;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericComposer;

public class LoginComposer 
    extends 
        GenericComposer
{
    @Override
    public void doAfterCompose( Component comp ) throws Exception 
    {
        super.doAfterCompose( comp );
        
        comp.appendChild( pane );
    }
    
    private LoginPane pane = new LoginPane();
}

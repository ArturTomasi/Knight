package com.knight.ui.application;

import com.knight.ui.panes.ApplicationCaption;
import com.knight.ui.panes.MenuPane;
import org.zkoss.zul.Borderlayout;

/**
 * @author artur
 */
public class HomeApplication 
    extends 
        Borderlayout
{

    public HomeApplication() 
    {
        initComponents();
    }
    
    private void initComponents()
    {
        appendChild( caption );
        appendChild( menu );
    }
    
    private ApplicationCaption caption = new ApplicationCaption();
    private MenuPane menu = new MenuPane();
    
}

package com.master.ui.parts;

import com.master.application.ResourceLocator;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Toolbarbutton;

/**
 *
 * @author artur
 */
public abstract class AButton 
    extends 
        Toolbarbutton
{
    private String _label, _icon;
    
    /**
     * 
     * @param label 
     */
    public AButton( String label )
    {
        this( label, "" );  
    }
    
    /**
     * 
     * @param label
     * @param icon 
     */
    public AButton( String label, String icon )
    {
        this._label = label;
        this._icon = icon;
        
        initComponents();
    }
    
    /**
     * 
     */
    private void initComponents()
    {
        setZclass( "btn" );
        
        setLabel( _label );
        
        if ( _icon != null && ! _icon.isEmpty() )
        {
            setImage( ResourceLocator.getImageResource( _icon ) );
        }
        
//        addEventListener( Events.ON_CLICK, e -> onClick( e ) );
    }
    
    /**
     * 
     * @param e
     * @throws Exception 
     */
    public abstract void onClick( Event e ) throws Exception;
}

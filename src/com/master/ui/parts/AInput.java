package com.master.ui.parts;

import org.zkoss.zul.Textbox;

/**
 *
 * @author artur
 */
public class AInput
    extends 
        Textbox
{
    private String _id = "";
    
    @Override
    public void setId( String id )
    {
        super.setId( id );
        
        super.setName( id );
    }
}

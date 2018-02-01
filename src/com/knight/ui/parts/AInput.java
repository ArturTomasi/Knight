package com.knight.ui.parts;

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

    public AInput() 
    {
        super();
        
        this.setZclass( " " );
    }
    
    
    @Override
    public void setId( String id )
    {
        this._id = id;
        
        super.setId( id );
        
        super.setName( id );
    }
    
    
}

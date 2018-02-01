package com.knight.ui.parts;

import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.sys.ContentRenderer;

/**
 *
 * @author artur
 */
public class ALabel
    extends 
        HtmlBasedComponent 
{
    private String _value = "";
    private String _for   = "";
    
    public ALabel(){}
    
    public ALabel( String label )
    {
        this._value = label;
    }
    
    public String getValue() 
    {
        return _value;
    }
 
    public void setValue( String _value )
    {
        if ( ! this._value.equals( _value ) ) 
        {
            this._value = _value;
        
            smartUpdate( "_value", this._value );
        }
    }
 
    public void setFor( String _for )
    {
        if ( ! this._for.equals( _for ) ) 
        {
            this._for = _for;
        
            smartUpdate( "_for", this._for );
        }
    }
    
    @Override
    protected void renderProperties( ContentRenderer renderer ) throws java.io.IOException 
    {
        super.renderProperties( renderer );
    
        render( renderer, "_value", _value );
        
        render( renderer, "_for", _for );
    }

    @Override
    public String getWidgetClass() 
    {
        return "com.knight.ui.parts.ALabel";
    }
}
package com.knight.ui.panes;

import com.knight.ui.parts.FormInput;
import org.zkoss.zul.Div;

/**
 *
 * @author artur
 */
public class FormPane 
    extends 
        Div
{
    private FormInput[] _inputs;

    public FormPane() 
    {
        initComponents();
    }
    
    public void setInputs( FormInput... inputs )
    {
        _inputs = inputs;
        
        getChildren().clear();
        
        for ( FormInput input : _inputs )
        {
            appendChild( input );
        }
    }
    
    private void initComponents()
    {
    }
}

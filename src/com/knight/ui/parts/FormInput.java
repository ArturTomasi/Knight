package com.knight.ui.parts;

import java.sql.Date;
import org.zkoss.zul.Div;


/**
 *
 * @author artur
 */
public class FormInput
    extends 
        Div
{
    private String label;
    private String key;
    private FormInputType type;

    public FormInput( FormInputType type, String label ) 
    {
        this.type = type;
        this.label = label;

        initComponents();
        
        refreshContent();
    }

    public String getLabel() 
    {
        return label;
    }

    public void setLabel( String label )
    {
        this.label = label;
    }

    public String getKey() 
    {
        return key;
    }

    public void setKey( String key )
    {
        this.key = key;
    }

    public FormInputType getType() 
    {
        return type;
    }

    public void setType( FormInputType type )
    {
        this.type = type;
    }
    
    public Double getNumber()
    {
        return Double.parseDouble( textField.getValue() );
    }

    public String getText()
    {
        return textField.getValue();
    }

    public Date getDate()
    {
        return Date.valueOf( textField.getValue() );
    }
    
    /**
     * 
     */
    public void refreshContent()
    {
        createAttributes();
        
        updateType();
        
        updateLabel();
        
        updateField();
    }
    
    /**
     * 
     */
    private void createAttributes()
    {
        this.key = String.valueOf( System.currentTimeMillis() ) + textField.getUuid();
    }
    
    /**
     * 
     */
    private void updateType()
    {
    	switch ( this.type )
    	{
            case DATE:
            {
                textField.setType( "date" );
            }
            break;
            
            case NUMERIC:
            {
                textField.setType( "numeric" );
            }
            break;
            
            case TEXT:
            {
                textField.setType( "text" );
            }
            break;
            
            case PASSWORD:	
            {
                textField.setType( "password" );
            }
            break;
    	}
    }
    
    /**
     * 
     */
    private void updateField()
    {
        textField.setId( key );
    }
    
    /**
     * 
     */
    private void updateLabel()
    {
        labelField.setValue( label );
        
        labelField.setFor( key );
    }

    /**
     * 
     */
    private void initComponents()
    {
    	setZclass( "input-field" );
        appendChild( textField );
        appendChild( labelField );
    }

    private ALabel labelField = new ALabel();
    private AInput textField  = new AInput();
}

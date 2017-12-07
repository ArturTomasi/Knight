/* global com, zk, zUtl */

com.master.ui.parts.ALabel = zk.$extends( zk.Widget, 
{
    _value : '',
    _for   : '', 
    
    redraw: function ( out )
    {
        out.push
        ( 
            '<label', this.domAttrs_(), 'for=', this.getFor(), '>', 
                this.getValue(), 
            '</label>'
        );
    },
    
    getValue : function() 
    {
        return this._value;
    },
    
    setValue : function( _value )
    {
        if ( this._value !== _value )
        {
            this._value = _value;
        }
    },
    
    getFor : function() 
    {
        return this._for;
    },
    
    setFor : function( _for )
    {
        if ( this._for !== _for )
        {
            this._for = _for;
        }
    }
} );
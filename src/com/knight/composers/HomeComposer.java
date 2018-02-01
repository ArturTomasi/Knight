package com.knight.composers;

import com.knight.ui.application.HomeApplication;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericComposer;

public class HomeComposer extends GenericComposer<Component>
{

    @Override
    public void doAfterCompose( Component comp ) throws Exception
    {
        super.doAfterCompose( comp );
        
        comp.appendChild( application );
    }
    
    private HomeApplication application = new HomeApplication();
}

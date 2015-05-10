// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OverlayLayout2.java

package com.borland.jbcl.layout;

import java.awt.*;
import java.io.Serializable;
import javax.swing.OverlayLayout;

public class OverlayLayout2
    implements LayoutManager2, Serializable
{

    public OverlayLayout2()
    {
    }

    public OverlayLayout2(Container parent)
    {
        layout = new OverlayLayout(parent);
    }

    void verifyInstance(Container parent)
    {
        if(layout == null)
            layout = new OverlayLayout(parent);
    }

    public void addLayoutComponent(Component component, Object constraint)
    {
        try
        {
            component.getParent().invalidate();
        }
        catch(Exception exception) { }
    }

    public Dimension maximumLayoutSize(Container parent)
    {
        verifyInstance(parent);
        return layout.maximumLayoutSize(parent);
    }

    public float getLayoutAlignmentX(Container parent)
    {
        verifyInstance(parent);
        return layout.getLayoutAlignmentX(parent);
    }

    public float getLayoutAlignmentY(Container parent)
    {
        verifyInstance(parent);
        return layout.getLayoutAlignmentY(parent);
    }

    public void invalidateLayout(Container parent)
    {
        verifyInstance(parent);
        layout.invalidateLayout(parent);
    }

    public void addLayoutComponent(String name, Component component)
    {
        try
        {
            component.getParent().invalidate();
        }
        catch(Exception exception) { }
    }

    public void removeLayoutComponent(Component component)
    {
        try
        {
            component.getParent().invalidate();
        }
        catch(Exception exception) { }
    }

    public Dimension preferredLayoutSize(Container parent)
    {
        verifyInstance(parent);
        return layout.preferredLayoutSize(parent);
    }

    public Dimension minimumLayoutSize(Container parent)
    {
        verifyInstance(parent);
        return layout.minimumLayoutSize(parent);
    }

    public void layoutContainer(Container parent)
    {
        verifyInstance(parent);
        layout.layoutContainer(parent);
    }

    OverlayLayout layout;
}

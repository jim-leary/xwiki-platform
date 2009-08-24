/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.xpn.xwiki.wysiwyg.client.plugin.macro.ui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.xpn.xwiki.wysiwyg.client.util.Config;
import com.xpn.xwiki.wysiwyg.client.widget.wizard.WizardStep;

/**
 * An abstract wizard step that is a widget composite.
 * 
 * @version $Id$
 */
public abstract class AbstractCompositeWizardStep extends Composite implements WizardStep
{
    /**
     * The object used to configure the wizard step.
     */
    private final Config config;

    /**
     * Creates a new composite wizard step.
     * 
     * @param config the object used to configure the newly created wizard step
     */
    public AbstractCompositeWizardStep(Config config)
    {
        this.config = config;

        initWidget(new FlowPanel());
    }

    /**
     * {@inheritDoc}
     * 
     * @see WizardStep#display()
     */
    public Widget display()
    {
        return this;
    }

    /**
     * @return the object used to configure the wizard step
     */
    public Config getConfig()
    {
        return config;
    }

    /**
     * @return the panel that holds all the widgets of this wizard step
     */
    protected FlowPanel getPanel()
    {
        return (FlowPanel) getWidget();
    }
}

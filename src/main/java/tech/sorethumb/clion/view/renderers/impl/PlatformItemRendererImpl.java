package tech.sorethumb.clion.view.renderers.impl;

import com.intellij.ui.ListCellRendererWrapper;
import tech.sorethumb.clion.models.packageIndex.Platform;
import tech.sorethumb.clion.view.renderers.ListCellRenderer;

public class PlatformItemRendererImpl implements ListCellRenderer {
    
    private final int index;
    private Platform value;
    
    public static PlatformItemRendererImpl create(int index, Platform value){
        return new PlatformItemRendererImpl(index, value);
    }
    
    private PlatformItemRendererImpl(int index, Platform value){
        this.index = index;
        this.value = value;
    }
    
    @Override
    public void renderValue (ListCellRendererWrapper cellRenderer, boolean isSelected) {
        cellRenderer.setText(getFormattedValue());
        String tip = String.format("%s", value.getName());
        cellRenderer.setToolTipText(tip);
    }
    
    @Override
    public void renderNode (ListCellRendererWrapper cellRenderer) {
        renderValue(cellRenderer, false);
    }
    
    @Override
    public String getKey () {
        return String.format("%s%s",index, value.getName());
    }
    
    @Override
    public String getFormattedValue () {
        return String.format("%s", value.getName());
    }
    
    @Override
    public Object getValue () {
        return this.value;
    }
    
    @Override
    public void setValue (Object value) {
        this.value = (Platform)value;
    }
    
    @Override
    public String pretty () {
        return null;
    }
    
    
}

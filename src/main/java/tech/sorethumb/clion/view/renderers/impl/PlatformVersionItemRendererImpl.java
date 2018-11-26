package tech.sorethumb.clion.view.renderers.impl;

import com.intellij.ui.ListCellRendererWrapper;
import tech.sorethumb.clion.models.packageIndex.PlatformVersion;
import tech.sorethumb.clion.view.renderers.ListCellRenderer;

public class PlatformVersionItemRendererImpl implements ListCellRenderer {
    
    private final int index;
    private PlatformVersion value;
    
    public static PlatformVersionItemRendererImpl create(int index, PlatformVersion value){
        return new PlatformVersionItemRendererImpl(index, value);
    }
    
    private PlatformVersionItemRendererImpl (int index, PlatformVersion value){
        this.index = index;
        this.value = value;
    }
    
    @Override
    public void renderValue (ListCellRendererWrapper cellRenderer, boolean isSelected) {
        cellRenderer.setText(getFormattedValue());
        String tip = String.format("%s (%s)", value.getArchitecture(), value.getVersion());
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
        return String.format("%s (%s)", value.getArchitecture(), value.getVersion());
    }
    
    @Override
    public Object getValue () {
        return this.value;
    }
    
    @Override
    public void setValue (Object value) {
        this.value = (PlatformVersion)value;
    }
    
    @Override
    public String pretty () {
        return null;
    }
    
    
}

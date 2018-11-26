package tech.sorethumb.clion.view.renderers.impl;

import com.intellij.ui.ListCellRendererWrapper;
import tech.sorethumb.clion.models.packageIndex.Package;
import tech.sorethumb.clion.view.renderers.ListCellRenderer;

public class PackageItemRendererImpl implements ListCellRenderer {
    
    private final int index;
    private Package value;
    
    public static PackageItemRendererImpl create(int index, Package value){
        return new PackageItemRendererImpl(index, value);
    }
    
    private PackageItemRendererImpl(int index, Package value){
        this.index = index;
        this.value = value;
    }
    
    @Override
    public void renderValue (ListCellRendererWrapper cellRenderer, boolean isSelected) {
        cellRenderer.setText(getFormattedValue());
        String tip = String.format("%s (%s)", value.getMaintainer(), value.getWebsiteURL());
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
        this.value = (Package)value;
    }
    
    @Override
    public String pretty () {
        return null;
    }
}

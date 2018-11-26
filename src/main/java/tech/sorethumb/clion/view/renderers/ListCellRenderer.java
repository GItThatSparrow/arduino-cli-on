package tech.sorethumb.clion.view.renderers;

import com.intellij.ui.ListCellRendererWrapper;

public interface ListCellRenderer {
    
    
    void renderValue(ListCellRendererWrapper cellRenderer, boolean isSelected);
    
    void renderNode(ListCellRendererWrapper cellRenderer);
    
    String getKey();
    
    String getFormattedValue();
    
    Object getValue();
    
    void setValue(Object value);
    
    String pretty();
}

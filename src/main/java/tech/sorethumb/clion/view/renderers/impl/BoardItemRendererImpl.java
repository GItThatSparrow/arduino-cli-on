package tech.sorethumb.clion.view.renderers.impl;

import com.intellij.ui.ListCellRendererWrapper;
import tech.sorethumb.clion.models.packageIndex.Board;
import tech.sorethumb.clion.view.renderers.ListCellRenderer;

public class BoardItemRendererImpl implements ListCellRenderer {
    
    private final int index;
    private Board value;
    
    public static BoardItemRendererImpl create(int index, Board value){
        return new BoardItemRendererImpl(index, value);
    }
    
    private BoardItemRendererImpl(int index, Board value){
        this.index = index;
        this.value = value;
    }
    
    @Override
    public void renderValue (ListCellRendererWrapper cellRenderer, boolean isSelected) {
        cellRenderer.setText(getFormattedValue());
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
        this.value = (Board)value;
    }
}

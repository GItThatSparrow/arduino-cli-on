package tech.sorethumb.clion.view.renderers;

import com.intellij.ui.ListCellRendererWrapper;
import tech.sorethumb.clion.models.packageIndex.Board;
import tech.sorethumb.clion.view.renderers.impl.BoardItemRendererImpl;

import javax.swing.*;

public class BoardCellRenderer extends ListCellRendererWrapper<Board> {
    
    /**
     * Implement this method to configure text and icon for given value.
     * Use {@link #setIcon(Icon)} and {@link #setText(String)} methods.
     *
     * @param list     The JList we're painting.
     * @param value    The value returned by list.getModel().getElementAt(index).
     * @param index    The cells index.
     * @param selected True if the specified cell was selected.
     * @param hasFocus True if the specified cell has the focus.
     */
    @Override
    public void customize (JList list, Board value, int index, boolean selected, boolean hasFocus) {
        BoardItemRendererImpl itemRenderer = BoardItemRendererImpl.create(index, value);
        itemRenderer.setValue(value);
        itemRenderer.renderNode(this);
    }
}

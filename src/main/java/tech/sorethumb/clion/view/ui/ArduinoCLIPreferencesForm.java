package tech.sorethumb.clion.view.ui;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VirtualFile;
import tech.sorethumb.clion.models.packageIndex.Root;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArduinoCLIPreferencesForm {
    
    private static final Logger log = Logger.getInstance(ArduinoCLIPreferencesForm.class);
    
    private JPanel rootPanel;
    private TextFieldWithBrowseButton apiPath;
    private JButton updateIndexButton;
    private JButton testPath;
    private JLabel testArduinoPathResult;
    private JTextPane useTheUpdateIndexTextPane;
    
    ArduinoCLIPreferencesForm () {
        apiPath.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e Event Source
             */
            @Override
            public void actionPerformed (ActionEvent e) {
                onApiPathClicked();
            }
        });
        updateIndexButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e Event Source
             */
            @Override
            public void actionPerformed (ActionEvent e) {
                if (e.getActionCommand().equals("click")) {
                    Root.updatePackageList();
                }
            }
        });
    }
    
    private void onApiPathClicked () {
        FileChooserDescriptor fileChooserDescriptor = new FileChooserDescriptor(false, true, false, false, false, false);
        VirtualFile vf = FileChooser.chooseFile(fileChooserDescriptor, null, null);
        if(vf != null) {
            if (!vf.isDirectory()) vf = vf.getParent();
            apiPath.setText(vf.getPath());
            log.debug("Selected Directory:\n\t" + vf.getPath());
        }
    }
    
    JPanel getRoot () {
        return rootPanel;
    }
}

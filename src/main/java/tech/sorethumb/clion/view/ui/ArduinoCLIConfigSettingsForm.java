package tech.sorethumb.clion.view.ui;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.NotNull;
import tech.sorethumb.clion.constants.Style;
import tech.sorethumb.clion.models.packageIndex.Board;
import tech.sorethumb.clion.models.packageIndex.Package;
import tech.sorethumb.clion.models.packageIndex.PlatformVersion;
import tech.sorethumb.clion.models.packageIndex.Root;
import tech.sorethumb.clion.projectBuildConfigs.ArduinoCLIonBuildConfiguration;
import tech.sorethumb.clion.services.ArduinoCLIonConfiguration;
import tech.sorethumb.clion.view.renderers.BoardCellRenderer;
import tech.sorethumb.clion.view.renderers.PackageCellRenderer;
import tech.sorethumb.clion.view.renderers.PlatformTree;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class ArduinoCLIConfigSettingsForm  extends SettingsEditor<ArduinoCLIonBuildConfiguration> {//extends JDialog {
    
    private static final Logger log = Logger.getInstance(ArduinoCLIConfigSettingsForm.class);
    
    private JPanel cPane;
    private JTextPane commandPreview;
    private JList listPackages;
    private JList listBoards;
    private JBScrollPane scrollPackages;
    private JBScrollPane scrollBoards;
    private Tree platformTree;
    private JBScrollPane platformScrollPane;
    private Package selectedPackage;
    private PlatformVersion selectedPlatformVersion;
    private Board selectedBoard;
    
    public ArduinoCLIConfigSettingsForm (ArduinoCLIonConfiguration arduinoCLIonConfiguration) {
        listPackages.setCellRenderer(new PackageCellRenderer());
        listPackages.addListSelectionListener(listPackagesSelectionListener);
        platformTree.addTreeSelectionListener(platformTreeSelectionListener);
        listBoards.addListSelectionListener(listBoardsSelectionListener);
    }
    
    @Override
    protected void resetEditorFrom (@NotNull ArduinoCLIonBuildConfiguration s) {
        
        if(s.getSelectedPackage() != null) setSelectedPackage(s.getSelectedPackage());
        if(s.getSelectedPlatformVersion() != null) setSelectedPlatformVersion(s.getSelectedPlatformVersion());
        if(s.getSelectedBoard() != null) setSelectedBoard(s.getSelectedBoard());
    }
    
    @Override
    protected void applyEditorTo (@NotNull ArduinoCLIonBuildConfiguration s) {
        com.intellij.openapi.util.Key<String> key = new com.intellij.openapi.util.Key<String>("TestKey");
        if(s.getUserData(key) == null) {
            s.putUserData(key, "Check out my values, brah.");
        }else{
            log.debug("Testing User Data Keys: " + s.getUserData(key));
        }
        s.setSelectedPlatformVersion(this.getSelectedPlatformVersion());
        s.setSelectedPackage(this.getSelectedPackage());
        s.setSelectedBoard(this.getSelectedBoard());
    }
    
    @NotNull
    @Override
    protected JComponent createEditor () {
        populateBoardDataList();
        return cPane;
    }
    
    private void populateBoardDataList (){
        Root root = Root.getPackageList();
        listPackages.setListData(root.getPackages().toArray());
        listPackages.setListData(root.getPackages().toArray());
    }
    
    private void setSelectedBoard (Board board){
        this.selectedBoard = board;
    }
    
    private Board getSelectedBoard (){
        return this.selectedBoard;
    }
    
    private Package getSelectedPackage () {
        return selectedPackage;
    }
    
    private void setSelectedPackage (Package selectedPackage) {
        this.selectedPackage = selectedPackage;
    }
    
    private PlatformVersion getSelectedPlatformVersion () {
        return selectedPlatformVersion;
    }
    
    private void setSelectedPlatformVersion (PlatformVersion selectedPlatformVersion) {
        this.selectedPlatformVersion = selectedPlatformVersion;
    }
    
    /**
     * Leaving this here since
     * it's part of <a href="https://github.com/GItThatSparrow/arduino-cli-on/issues/8">Form Validation #8</a>.
     */
    private void clearControlsAndShowError(){
        cPane.removeAll();
        cPane.add(new JLabel("The path to the arduino-cli is not configured correctly."));
    }
    
    private void populatePlatformTree (Object[] packagePlatforms){
        try {
            clearListBoards();
            PlatformTree pTree = new PlatformTree(packagePlatforms);
            platformTree.setModel(pTree.getTree().getModel());
        }catch (Exception x){
            JLabel jLabel = new JLabel("oops.");
            jLabel.setForeground(Style.NUMBER_COLOR);
            //listPlatforms.getParent().getParent().add(jLabel);
        }
    }
    
    private void populateBoardsList(PlatformVersion selectedPlatformVersion){
    
        log.debug("Selected Plaform: " + selectedPlatformVersion.getName());
        listBoards.setListData(selectedPlatformVersion.getBoards().toArray());
        listBoards.setCellRenderer(new BoardCellRenderer());
    }
    
    private void togglePlatformTreeNodeSelection(TreeSelectionEvent e){
        clearListBoards();
        if(e.getOldLeadSelectionPath() != null) {
            TreePath tp = (e.getOldLeadSelectionPath().getPathCount() == 2 ? e.getOldLeadSelectionPath() : e.getOldLeadSelectionPath().getParentPath());
            platformTree.collapsePath(tp);
        }
        platformTree.expandPath(e.getNewLeadSelectionPath());
    }
    
    private void clearListBoards(){
        listBoards.removeListSelectionListener(listBoardsSelectionListener);
        listBoards.setListData(new Object[]{});
        listBoards.addListSelectionListener(listBoardsSelectionListener);
    }
    
    private void handlePlatformVersionSelection(TreeSelectionEvent e){
        DefaultMutableTreeNode nd = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
        try {
            PlatformVersion pv = (PlatformVersion)nd.getUserObject();
            log.debug(String.format("Selected Platform id \"%s\" - (i.e \"%s %s\")", pv.getName(), pv.getArchitecture(), pv.getVersion()));
            populateBoardsList(pv);
        }catch (Exception x){
            log.error("Wrong selection in tree node: ", x);
        }
    }
    
    private final ListSelectionListener listPackagesSelectionListener = new ListSelectionListener() {
        /**
         * Called whenever the value of the selection changes.
         *
         * @param e the event that characterizes the change.
         */
        @Override
        public void valueChanged (ListSelectionEvent e) {
            selectedPackage = ((Package) ((JList) e.getSource()).getSelectedValue());
            log.debug("Selected Package: " + selectedPackage.getName());
            Object[] platforms = selectedPackage.getPlatforms().toArray();
            populatePlatformTree(platforms);
        }
    };
    
    private final TreeSelectionListener platformTreeSelectionListener = new TreeSelectionListener() {
        /**
         * Called whenever the value of the selection changes.
         *
         * @param e the event that characterizes the change.
         */
        @Override
        public void valueChanged (TreeSelectionEvent e) {
            
            switch (e.getPath().getPathCount()){
                case 2:
                    togglePlatformTreeNodeSelection(e);
                    break;
                case 3:
                    handlePlatformVersionSelection(e);
                    break;
            }
        }
    };
    
    private ListSelectionListener listBoardsSelectionListener = new ListSelectionListener(){
        /**
         * Called whenever the value of the selection changes.
         *
         * @param e the event that characterizes the change.
         */
        @Override
        public void valueChanged (ListSelectionEvent e) {
            selectedBoard = (Board)((JList)e.getSource()).getSelectedValue();
            log.debug("Selected Board: " + selectedBoard.getName());
        }
    };
}

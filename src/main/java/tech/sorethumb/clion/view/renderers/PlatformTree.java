package tech.sorethumb.clion.view.renderers;

import tech.sorethumb.clion.models.NamedPackageObjects;
import tech.sorethumb.clion.models.packageIndex.Platform;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Arrays;
import java.util.stream.Stream;

public class PlatformTree {
    private JTree tree;
    private Object[] packagePlatforms;
    private DefaultMutableTreeNode root;
    
    public PlatformTree (Object[] packagePlatforms) {
        this.packagePlatforms = packagePlatforms;
        root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        addChildren(root, packagePlatforms);
        
        /**
         * Stream<Object> s = Arrays.stream(packagePlatforms);
        s.forEach(o -> {
            NamedPackageObjects p = (Platform)o;
            DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(((Platform) o).getName());
        });
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);
         */
        
        //create the tree by passing in the root node
        tree = new JTree(root);
        /*add(tree);*/
    
        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");
        this.pack();
        this.setVisible(true);*/
    }
    
    private void addChildren(DefaultMutableTreeNode parent, Object[] children){
        Stream<Object> s = Arrays.stream(children);
        s
                .filter(o -> Arrays.asList(o.getClass().getInterfaces()).contains(NamedPackageObjects.class))
                .forEach(o -> {
                    DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(((NamedPackageObjects) o).getDisplayName());
                    defaultMutableTreeNode.setUserObject(o);
                    if(o.getClass().equals(Platform.class)) addChildren(defaultMutableTreeNode, ((Platform)o).getVersions().toArray());
                    parent.add(defaultMutableTreeNode);
                });
    }
    
    public JTree getTree () {
        return tree;
    }
    
    public DefaultMutableTreeNode getRoot(){
        return this.root;
    }
}

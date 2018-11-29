package tech.sorethumb.clion.constants.ACliC;


/**
 * Arduino commands about libraries
 */
public class Lib {
    
    /**
     * Arduino commands about libraries
     */
    public static final String LIB = "lib";
    
    @Override
    public String toString () {
        return LIB;
    }
    
    public static String asString () {
        return LIB;
    }
    
    /**
     * Downloads one or more libraries without installing them.
     */
    public static final String DOWNLOAD = "download";
    
    /**
     * Installs one of more specified libraries into the system.
     */
    public static final String INSTALL = "install";
    
    /**
     * Shows a list of all installed libraries.
     */
    public static final String LIST = "list";
    
    /**
     * Searchs for one or more libraries data.
     */
    public static final String SEARCH = "search";
    
    /**
     * Uninstalls one or more libraries.
     */
    public static final String UNINSTALL = "uninstall";
    
    /**
     * Updates the libraries index.
     */
    public static final String UPDATE_INDEX = "update-index";
    
    /**
     * Upgrades installed libraries.
     */
    public static final String UPGRADE = "upgrade";
    
    
}
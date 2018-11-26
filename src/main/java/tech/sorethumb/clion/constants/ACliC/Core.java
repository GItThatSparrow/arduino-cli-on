package tech.sorethumb.clion.constants.ACliC;

public class Core {
    
    private static final String CORE = "core";
    
    
    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString () {
        return CORE;
    }
    
    public static String asString () {
        return CORE;
    }
    
    /**
     * Downloads one or more cores and corresponding tool dependencies.
     */
    public static final String DOWNLOAD = "download";
    /**
     * Installs one or more cores and corresponding tool dependencies.
     */
    public static final String INSTALL = "install";
    /**
     * Shows the list of installed platforms.
     */
    public static final String LIST = "list";
    /**
     * Search for a core in the package index.
     */
    public static final String SEARCH = "search";
    /**
     * Uninstalls one or more cores and corresponding tool dependencies if no more used.
     */
    public static final String UNINSTALL = "uninstall";
    /**
     * Updates the index of cores.
     */
    public static final String UPDATE_INDEX ="update-index";
    /**
     * Upgrades one or all installed platforms to the latest version.
     */
    public static final String UPGRADE = "upgrade";
}

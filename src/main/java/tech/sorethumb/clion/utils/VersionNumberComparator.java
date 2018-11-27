package tech.sorethumb.clion.utils;

import tech.sorethumb.clion.models.packageIndex.PlatformVersion;

import java.util.Comparator;

public class VersionNumberComparator implements Comparator<PlatformVersion> {
    
    private boolean reverseOrder = false;
    
    /**
     * Check if this {@link Comparator} returns results in the reverse order.
     * @return
     */
    public boolean isReverseOrder () {
        return reverseOrder;
    }
    
    /**
     * Change the order of sorting.
     * @param reverseOrder If {@link true}, {@link PlatformVersion}s are sorted from newest to oldest.
     */
    public void setReverseOrder (boolean reverseOrder) {
        this.reverseOrder = reverseOrder;
    }
    
    /**
     * Retrieves a sorted list of {@link PlatformVersion} objects.  The order of sorting is from <b>newest</b>
     * to <b>oldest</b>.
     *
     * <h2>Example</h2>
     * <pre>
     *     String s1 = pv1.getVersion(); // returns "1.2.10"
     *     String s2 = pv2.getVersion(); // returns "1.2.1"
     *
     *     int result = comparePlatformVersions(pv1,pv2); // Returns 1, indicating the first parameter has a
     *                                                    // higher order than the second.
     * </pre>
     * @param version1
     * @param version2
     * @return
     */
    public static int comparePlatformVersions(PlatformVersion version1, PlatformVersion version2){
        VersionNumberComparator versionNumberComparator = new VersionNumberComparator();
        versionNumberComparator.setReverseOrder(true);
        return versionNumberComparator.compare(version1, version2);
    }
    
    @Override
    public int compare(PlatformVersion version1, PlatformVersion version2){
        if(version1.getVersion().equals(version2.getVersion())) return 0;
    
        String regex = "[^\\d]+";
        
        String[] v1 = version1.getVersion().split("[^\\d]");
        String[] v2 = version2.getVersion().split("[^\\d]");
        int i = 0;
        int vi1 = getVSlot(i, v1);
        int vi2 = getVSlot(i, v2);
        while(vi1 == vi2) {
            i++;
            vi1 = getVSlot(i, v1);
            vi2 = getVSlot(i, v2);
        }
        int i1 = (vi1 == vi2) ? 0 :
                ((vi1 < vi2 && reverseOrder) ? 1 : -1);
        return i1;
    }
    
    private int getVSlot(int index, String[] version){
        int retVal = version.length-1 < index ? 0 : Integer.parseInt(version[index]);
        return retVal;
    }
}

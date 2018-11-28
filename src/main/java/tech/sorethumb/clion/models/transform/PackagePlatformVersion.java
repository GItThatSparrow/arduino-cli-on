package tech.sorethumb.clion.models.transform;

import tech.sorethumb.clion.models.packageIndex.Platform;
import tech.sorethumb.clion.models.packageIndex.PlatformVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class PackagePlatformVersion {
    
    /**
     * Creates groups of objects from the full list.  These {@link PlatformVersion} objects
     * are grouped by {@link PlatformVersion#getArchitecture()}.
     *
     * @param platformVersions Represents all the {@link PlatformVersion}s related
     *                         to a single {@link tech.sorethumb.clion.models.packageIndex.Package}.
     * @return A collection of {@link Map}s, lists of {@link PlatformVersion} objects grouped by their
     * {@link PlatformVersion#getArchitecture()} list populated.
     */
    public static Map<String, List<PlatformVersion>> groupByPlatformArchitecture(List<PlatformVersion> platformVersions){
        Stream<PlatformVersion> pStream = platformVersions.stream();
        TreeMap<String, List<PlatformVersion>> grouped = new TreeMap<>(pStream.collect(groupingBy(PlatformVersion::getTitleCaseName)));
        return grouped;
    }
    
    /**
     * Creates groups of objects from the full list.  These {@link PlatformVersion} objects
     * are group by {@link PlatformVersion#getCategory()}.
     *
     * @param platformVersions Represents all the {@link PlatformVersion}s related
     *                         to a single {@link tech.sorethumb.clion.models.packageIndex.Package}.
     * @return A collection of {@link Map}s, lists of {@link PlatformVersion} objects grouped by their
     * {@link PlatformVersion#getCategory()} list populated.
     */
    public static Map<String, List<PlatformVersion>> groupByCategory(List<PlatformVersion> platformVersions){
        Stream<PlatformVersion> pStream = platformVersions.stream();
        TreeMap<String, List<PlatformVersion>> grouped = new TreeMap<>(pStream.collect(groupingBy(PlatformVersion::getCategory)));
        return grouped;
    }
    
    /**
     * Use the string representation of a {@link Platform} to filter only the related
     * {@link PlatformVersion} instances.
     * @param platformVersionMap Represents all the {@link Platform}s and {@link PlatformVersion}s
     *                           related to a single {@link tech.sorethumb.clion.models.packageIndex.Package}.
     * @return A list of {@link Platform} objects with their related {@link Platform#getVersions()} list populated.
     */
    public static ArrayList<Platform> mapToPlatformList(Map<String, List<PlatformVersion>> platformVersionMap){
        ArrayList<Platform> platforms = new ArrayList<>();
        platformVersionMap.forEach((i,o) -> {
            Platform.Builder builder = new Platform.Builder();
            builder.withName(i);
            builder.withversions(o);
            platforms.add(builder.build());
        });
        return platforms;
    }
}

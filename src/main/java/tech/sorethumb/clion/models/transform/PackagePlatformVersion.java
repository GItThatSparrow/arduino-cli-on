package tech.sorethumb.clion.models.transform;

import tech.sorethumb.clion.models.packageIndex.Platform;
import tech.sorethumb.clion.models.packageIndex.PlatformVersion;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class PackagePlatformVersion {
    
    public static Map<String, List<PlatformVersion>> groupByPlatformArchitecture(List<PlatformVersion> platformVersions){
        Stream<PlatformVersion> pStream = platformVersions.stream();
        TreeMap<String, List<PlatformVersion>> grouped = new TreeMap<>(pStream.collect(groupingBy(PlatformVersion::getArchitecture)));
        return grouped;
    }
    
    public static Map<String, List<PlatformVersion>> groupByCategory(List<PlatformVersion> platformVersions){
        Stream<PlatformVersion> pStream = platformVersions.stream();
        TreeMap<String, List<PlatformVersion>> grouped = new TreeMap<>(pStream.collect(groupingBy(PlatformVersion::getCategory)));
        return grouped;
    }
    
    public static ArrayList<Platform> mapToPlatformList(Map<String, List<PlatformVersion>> platformVersionMap){
        ArrayList<Platform> platforms = new ArrayList<>();
        platformVersionMap.forEach((i,o) -> {
            Platform.Builder builder = new Platform.Builder();
            builder.withName(i.toString());
            builder.withversions(o);
            platforms.add(builder.build());
        });
        
        /*platformVersions.forEach( (i, o) -> {
            Platform.Builder builder = new Platform.Builder();
            PlatformVersion[] platformVersions1 = null;
            //o.toArray(PlatformVersion);
            List<PlatformVersion> platformVersions2 = Arrays.asList(o.toArray(platformVersions1));
            builder.withversions(platformVersions2);
            builder.withName(i);
            Platform p = builder.build();
            platforms.add(p);
            //Platform.Builder withversions = builder.withversions(Arrays.asList(o.toArray()));
        });*/
        return platforms;
    }
}

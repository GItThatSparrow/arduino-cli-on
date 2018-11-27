package tech.sorethumb.clion.utils;

import org.junit.Test;
import tech.sorethumb.clion.models.packageIndex.Platform;
import tech.sorethumb.clion.models.packageIndex.PlatformVersion;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class VersionNumberComparatorTest {
    
    @Test
    public void compare () {
        PlatformVersion.Builder pvBuilder1 = new PlatformVersion.Builder();
        pvBuilder1.withVersion("1.6.2");
        
        PlatformVersion pv1 = pvBuilder1.build();
        PlatformVersion.Builder pvBuilder2 = new PlatformVersion.Builder();
        pvBuilder2.withVersion("1.6.23");
        PlatformVersion pv2 = pvBuilder2.build();
        
        Platform.Builder builder = new Platform.Builder();
        builder.withversions(new ArrayList<>(Arrays.asList(pv1,pv2)));
        Platform platform = builder.build();
        
        assertEquals("1.6.2", platform.getVersions().get(0).toString());
        assertEquals("1.6.23", platform.getVersions().get(1).toString());
        
        platform.reverseSortVersions();
        //Stream<PlatformVersion> platformVersionStream = platform.getVersions().stream();
    
        //List<PlatformVersion> sortedVersions =
                /*platformVersionStream.sorted((cpv1, cpv2) ->
                VersionNumberComparator.comparePlatformVersions(cpv1,cpv2)).collect(Collectors.toList());*/
        
        /*List<PlatformVersion> sortedVersions = platform.getVersions().sort((cpv1, cpv2) ->
                VersionNumberComparator.comparePlatformVersions(cpv1,cpv2));*/
        
        assertEquals("1.6.2", platform.getVersions().get(1).toString());
        assertEquals("1.6.23", platform.getVersions().get(0).toString());
    }
}
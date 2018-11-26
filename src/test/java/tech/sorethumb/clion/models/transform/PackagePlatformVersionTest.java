package tech.sorethumb.clion.models.transform;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import tech.sorethumb.clion.models.packageIndex.Package;
import tech.sorethumb.clion.models.packageIndex.Platform;
import tech.sorethumb.clion.models.packageIndex.PlatformVersion;
import tech.sorethumb.clion.models.packageIndex.Root;
import tech.sorethumb.clion.services.ArduinoCLIonConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PackagePlatformVersionTest {
    
    
    @Mock
    private ArduinoCLIonConfiguration arduinoCLIonConfiguration;
    private Root root;
    
    @Before
    public void setUp() {
        arduinoCLIonConfiguration = mock(ArduinoCLIonConfiguration.class);
        String a15Path = ("~/Library/Arduino15").replaceFirst("^~", java.lang.System.getProperty("user.home"));
        when(arduinoCLIonConfiguration.getApiPath()).thenReturn(a15Path);
        try {
            root = Root.getPackageList(arduinoCLIonConfiguration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown () throws Exception {
        root = null;
    }
    
    @Test
    public void groupByPlatformArchitecture () {
        Package p = root.getPackages().get(0);
        List<PlatformVersion> platformVersions = p.getPlatformVersions();
        Map<String, List<PlatformVersion>> setMap = PackagePlatformVersion.groupByPlatformArchitecture (platformVersions);
        assertTrue(setMap.size() > 0);
    }
    
    @Test
    public void groupByCategory () {
        Package p = root.getPackages().get(0);
        List<PlatformVersion> platformVersions = p.getPlatformVersions();
        Map<String, List<PlatformVersion>> setMap = PackagePlatformVersion.groupByCategory(platformVersions);
        assertTrue(setMap.size() > 0);
    }
    
    @Test
    public void mapToPlatformList () {
        Package p = root.getPackages().get(0);
        List<PlatformVersion> platformVersions = p.getPlatformVersions();
        Map<String, List<PlatformVersion>> setMap = PackagePlatformVersion.groupByPlatformArchitecture(platformVersions);
        assertTrue(setMap.size() > 0);
        
        List<Platform> platforms = PackagePlatformVersion.mapToPlatformList(setMap);
        assertTrue(!platforms.isEmpty());
        assertTrue(platforms.size() > 0);
    }
}
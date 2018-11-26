package tech.sorethumb.clion.models.packageIndex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import tech.sorethumb.clion.services.ArduinoCLIonConfiguration;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RootTest {
    
    @Mock
    private ArduinoCLIonConfiguration arduinoCLIonConfiguration;
    
    @Before
    public void setUp() {
        arduinoCLIonConfiguration = mock(ArduinoCLIonConfiguration.class);
    }
    @After
    public void tearDown() {
        arduinoCLIonConfiguration = null;
    }
    
    @Test
    public void updatePackageList(){
        Boolean b = Root.updatePackageList();
        assertTrue(b);
    }
    
    @Test
    public void getPackageList () {
        String a15Path = ("~/Library/Arduino15").replaceFirst("^~", java.lang.System.getProperty("user.home"));
        when(arduinoCLIonConfiguration.getApiPath()).thenReturn(a15Path);
        Root root = null;
        try {
            root = Root.getPackageList(arduinoCLIonConfiguration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(root);
        assertTrue(!root.getPackages().isEmpty());
    }
    
    
    @Test
    public void mapToPlatformList () {
        String a15Path = ("~/Library/Arduino15").replaceFirst("^~", java.lang.System.getProperty("user.home"));
        when(arduinoCLIonConfiguration.getApiPath()).thenReturn(a15Path);
        Root root = null;
        try {
            root = Root.getPackageList(arduinoCLIonConfiguration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Package p = root.getPackages().get(0);
        List<Platform> platforms = p.getPlatforms();
        
        assertTrue(platforms.size() > 0);
        assertTrue(platforms.get(0).getVersions().size() > 0);
    }
}
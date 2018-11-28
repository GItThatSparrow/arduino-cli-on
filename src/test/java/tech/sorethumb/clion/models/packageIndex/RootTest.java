package tech.sorethumb.clion.models.packageIndex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import tech.sorethumb.clion.services.ArduinoCLIonConfiguration;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

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
        Root root = Root.getPackageList();
        
        assertNotNull(root);
        assertTrue(!root.getPackages().isEmpty());
    }
    
    
    @Test
    public void mapToPlatformList () {
        Root root = Root.getPackageList();
        Package p = root.getPackages().get(0);
        List<Platform> platforms = p.getPlatforms();
        
        assertTrue(platforms.size() > 0);
        assertTrue(platforms.get(0).getVersions().size() > 0);
    }
}
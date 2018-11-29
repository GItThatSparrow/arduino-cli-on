package tech.sorethumb.clion.integrations.ACliC;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoreTest {
    
    static final String fqbn = "Intel:arc32";
    static final String version = "2.0.2";
    
    @Test
    public void coreUpdateIndex () {
        String actual = Core.coreUpdateIndex();
        assertTrue(!actual.isEmpty());
    }
    
    @Test
    public void getListJSON () {
        String json = Core.getListJSON();
        assertNotNull(json);
        assertTrue(json.startsWith("{\"Platforms\":[{\"ID\":\""));
    }
    
    @Test
    public void downloadCore () {
        String actual = Core.downloadCore(fqbn);
        assertTrue(!actual.isEmpty());
    }
    
    @Test
    public void installCore () {
        String actual = Core.installCore(fqbn);
        assertTrue(!actual.isEmpty());
    }
    
    @Test
    public void uninstallCore () {
        String actual = Core.uninstallCore(fqbn);
        assertTrue(!actual.isEmpty());
    }
    
    @Test
    public void downloadCore_V () {
        String actual = Core.downloadCore(fqbn, version);
        assertTrue(!actual.isEmpty());
    }
    
    @Test
    public void installCore_V () {
        String actual = Core.installCore(fqbn, version);
        assertTrue(!actual.isEmpty());
    }
    
    @Test
    public void uninstallCore_V () {
        String actual = Core.uninstallCore(fqbn, version);
        assertTrue(!actual.isEmpty());
    }
}
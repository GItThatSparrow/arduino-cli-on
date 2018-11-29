package tech.sorethumb.clion.integrations.ACliC;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoreTest {
    
    @Test
    public void getListJSON () {
        String json = Core.getListJSON();
        
        assertNotNull(json);
        assertTrue(json.startsWith("{\"Platforms\":[{\"ID\":\""));
    }
}
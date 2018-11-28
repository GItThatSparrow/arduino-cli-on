package tech.sorethumb.clion.integrations.ACliC;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigTest {
    
    @Test
    public void dump () {
        String response = ("proxy_type: auto\n" +
                "sketchbook_path: ~/Documents/Arduino\n" +
                "arduino_data: ~/Library/arduino15\n" +
                "board_manager: null")
                        .replace("~", System.getProperty("user.home"));
        
        String dump = Config.dump();
        assertNotNull(dump);
        assertEquals(response, dump);
    }
}
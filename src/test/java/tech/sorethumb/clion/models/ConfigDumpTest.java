package tech.sorethumb.clion.models;

import org.junit.Test;
import tech.sorethumb.clion.integrations.ACliC.Config;

import static org.junit.Assert.*;

public class ConfigDumpTest {
    
    @Test
    public void configDumpBuilder () {
        
        String confgiString = Config.dump();
        ConfigDump configDump = ConfigDump.ConfigDumpBuilder(confgiString);
        
        assertNotNull(configDump);
    
        String proxy_type = "auto";
        String sketchbook_path = ("~/Documents/Arduino").replace("~", System.getProperty("user.home"));
        String arduino_data = ("~/Library/arduino15").replace("~", System.getProperty("user.home"));
        String board_manager = "null";
        
        assertEquals(proxy_type, configDump.getProxyType());
        assertEquals(sketchbook_path, configDump.getSketchbookPath());
        assertEquals(arduino_data, configDump.getArduinoData());
        assertEquals(board_manager, configDump.getBoardManager());
    }
}
package tech.sorethumb.clion.models;

import tech.sorethumb.clion.constants.ACliC.Config;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Represents a small, baseline set of configuration values on
 * the user's system.  Use the {@link tech.sorethumb.clion.integrations.ACliC.Config#dump()} output as this
 * object's input.
 *
 * NOTE: This class isn't serializable since it's not possible to get a structured
 * response from the {@link tech.sorethumb.clion.integrations.ACliC.Config#dump()}} operation.
 */
public class ConfigDump {
    
    private String proxy_type;// auto
    private String sketchbook_path;// ~/Documents/Arduino
    private String arduino_data;// ~/Library/arduino15
    private String board_manager;// null
    
    public ConfigDump(String proxyType, String sbPath, String arduinoData, String boardManager){
        proxy_type = proxyType;
        sketchbook_path = sbPath;
        arduino_data = arduinoData;
        board_manager = boardManager;
    }
    
    public String getProxyType () {
        return proxy_type;
    }
    
    public String getSketchbookPath () {
        return sketchbook_path;
    }
    
    public String getArduinoData () {
        return arduino_data;
    }
    
    public String getBoardManager () {
        return board_manager;
    }
    
    public static ConfigDump ConfigDumpBuilder(String response){
        
        String proxy_type;
        String sketchbook_path;
        String arduino_data;
        String board_manager;
        
        String[] strings = response.split("\\n");
        
        Map<String, String> map = Arrays.asList(strings)
                .stream()
                .map(str -> str.split(": "))
                .collect(toMap(str -> str[0], str -> str[1]));
        
        proxy_type = map.get(Config.proxy_type);
        sketchbook_path = map.get(Config.sketchbook_path);
        arduino_data = map.get(Config.arduino_data);
        board_manager = map.get(Config.board_manager);
        
        return new ConfigDump(proxy_type, sketchbook_path, arduino_data, board_manager);
    }
}

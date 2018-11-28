package tech.sorethumb.clion.integrations;

import com.intellij.openapi.diagnostic.Logger;
import tech.sorethumb.clion.services.ArduinoCLIonConfiguration;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Using this class to test whether or not it's easier to work with data
 * already stored in JSON files from the `arduino-cli` utility.
 */
public class FileSystem {
    
    private static final Logger log = Logger.getInstance(FileSystem.class);
    
    public static String readPackageIndexJson(ArduinoCLIonConfiguration arduinoCLIonConfiguration) throws IOException {
        return readPackageIndexJson(arduinoCLIonConfiguration.getApiPath());
    }
    
    public static String readPackageIndexJson(String apiPath) {
        String filePath = apiPath + "/package_index.json";
        log.debug("Searching for packages at '" + filePath + "'");
        return readFile(filePath, Charset.defaultCharset());
    }
    
    private static String readFile (String path, Charset encoding) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            log.error("Cannot Read File", e);
        }
        return new String(encoded, encoding);
    }
}

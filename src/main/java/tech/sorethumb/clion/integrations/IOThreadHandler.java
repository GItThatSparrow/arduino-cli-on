package tech.sorethumb.clion.integrations;

import com.intellij.openapi.diagnostic.Logger;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IOThreadHandler extends Thread {
    
    private static final Logger log = Logger.getInstance(IOThreadHandler.class);
    
    private InputStream inputStream;
    private StringBuilder output = new StringBuilder();
    
    IOThreadHandler(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    public void run() {
        try (Scanner br = new Scanner(new InputStreamReader(inputStream))) {
            String line = null;
            while (br.hasNextLine()) {
                line = br.nextLine();
                output.append(line).append(System.getProperty("line.separator"));
            }
        }
    }
    
    StringBuilder getOutput () {
        return output;
    }
}
package tech.sorethumb.clion.integrations;

import org.junit.Test;
import tech.sorethumb.clion.integrations.ACliC.Board;

import static org.junit.Assert.*;

public class CommandLineTest {
    private static final String ASSERT_HELP = "Arduino Command Line Interface (arduino-cli).\n" +
            "\n" +
            "Usage:\n" +
            "  arduino-cli [command]\n" +
            "\n" +
            "Examples:\n" +
            "  arduino-cli <command> [flags...]\n" +
            "\n" +
            "Available Commands:\n" +
            "  board         Arduino board commands.\n" +
            "  compile       Compiles Arduino sketches.\n" +
            "  config        Arduino Configuration Commands.\n" +
            "  core          Arduino Core operations.\n" +
            "  help          Help about any command\n" +
            "  lib           Arduino commands about libraries.\n" +
            "  sketch        Arduino CLI Sketch Commands.\n" +
            "  upload        Upload Arduino sketches.\n" +
            "  version       Shows version number of arduino CLI.\n" +
            "\n" +
            "Flags:\n" +
            "      --config-file string   The custom config file (if not specified ./.cli-config.yml will be used).\n" +
            "      --debug                Enables debug output (super verbose, used to debug the CLI).\n" +
            "      --format string        The output format, can be [text|json]. (default \"text\")\n" +
            "  -h, --help                 help for arduino-cli\n" +
            "\n" +
            "Use \"arduino-cli [command] --help\" for more information about a command.\n";
    @Test
    public void boardListJSON() {
        Boolean b = true;
        String result = Board.BoardList();
        String jsonStart = "{\"serialBoards\":[";
        assertTrue(result.startsWith(jsonStart));
    }
    @Test
    public void boardList(){
        String result = Board.BoardList();
        String[] sa = result.split("\n");
        String last = sa[sa.length-1].trim();
        assertTrue(sa[sa.length-1].endsWith(last));
    }
    @Test
    public void boardListAllJSON(){
        Boolean b = true;
        String result = Board.BoardListAll();
        String jsonStart = "{\"boards\":[{\"name\":\"ATtiny24/44/84\",\"fqbn\":\"attiny:avr:ATtinyX4\"},{\"name\":\"ATtiny25/45/85\"";
        boolean bResult = result.startsWith(jsonStart);
        assertTrue(bResult);
    }
    @Test
    public void boardListAll(){
        Boolean b = true;
        String result = Board.BoardListAll();
        boolean bResult = result.startsWith("Board Name                             \tFQBN                                       \n");
        assertEquals(true, bResult);
    }
    @Test
    public void help () {
        String result = CommandLine.help();
        assertEquals(ASSERT_HELP, result);
    }
    @Test
    public void hasArduinoCliInstalled () {
        Boolean b = CommandLine.hasArduinoCliInstalled();
        assertEquals(b, true);
    }
}
package tech.sorethumb.clion.integrations.ACliC;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    
    String fqbn = "attiny:avr:ATtinyX4";
    
    /*@Test
    public void boardList () {
        String expectedExpr = "\\{\"serialBoards\":\\[\\{\"name\":\"unknown\",\"fqbn\":\"\",\"port\":\"/dev/cu.usbserial-({portId}:[^\"])\",\"usbID\":\".* - {portId}\"}],\"networkBoards\":[]}";
        String actual = Board.BoardList().trim();
        assertTrue(actual.matches(expectedExpr));
    }*/
    
    @Test
    public void boardList_DISCONNECTED () {
        String expected = "{\"serialBoards\":[],\"networkBoards\":[]}";
        String actual = Board.BoardList().trim();
        assertEquals(expected, actual);
    }
    
    @Test
    public void boardListAll () {
        String expected = "{\"boards\":[{\"name\":\"ATtiny24/44/84\",\"fqbn\":\"attiny:avr:ATtinyX4\"},{\"name\":\"ATtiny25/45/85\",\"fqbn\":\"attiny:avr:AT";
        String actual = Board.BoardListAll().toString();
        assertTrue(actual.startsWith(expected));
    }
    
    @Test
    public void boardDetails(){
        String expected = "{\n" +
                "  \"Name\": \"ATtiny24/44/84\",\n" +
                "  \"ConfigOptions\": [\n" +
                "    {\n" +
                "      \"Option\": \"cpu\",\n" +
                "      \"OptionLabel\": \"Processor\",";
    
        String actual = Board.BoardDetails(fqbn).trim();
        assertTrue( actual.startsWith(expected));
    }
}
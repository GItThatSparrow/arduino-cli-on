package tech.sorethumb.clion.models.boardIndex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardDetailsTest {
    
    String fqbn = "";
    
    @Before
    public void setUp () throws Exception {
    
        String fqbn = "attiny:avr:ATtinyX4";
    }
    
    @After
    public void tearDown () throws Exception {
        fqbn = "";
    }
    
    @Test
    public void load () {
        BoardDetails boardDetails = BoardDetails.load(fqbn);
        assertEquals("ATtiny24/44/84", boardDetails.getName());
    }
}
package tech.sorethumb.clion.integrations.ACliC;

import org.junit.Test;

import static org.junit.Assert.*;

public class VersionTest {
    
    @Test
    public void getVersion () {
        String actual = Version.getVersion();
        assertTrue(!actual.isEmpty());
    }
    
    @Test
    public void isVersionValid () {
        assertTrue(Version.isVersionValid());
    }
}
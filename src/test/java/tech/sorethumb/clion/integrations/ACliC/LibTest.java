package tech.sorethumb.clion.integrations.ACliC;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibTest {
    
    @Test
    public void getInstalledLibraries () {
        String strLib = Lib.getInstalledLibraries();
        assertTrue(strLib.isEmpty());
    }
    
    @Test
    public void getAllInstalledLibraries () {
        String strLib = Lib.getAllInstalledLibraries();
        assertTrue(strLib.startsWith("{\"libraries\":[{\"library\":{\"Name\":\""));
    }
    
    @Test
    public void getUpdatableLibraries () {
        String strLib = Lib.getUpdatableLibraries();
        assertTrue(strLib.isEmpty());
    }
}
package tech.sorethumb.clion.integrations.ACliC;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
    
    @Test
    public void updateIndex(){
        String actual = Lib.updateIndex();
        assertTrue(!actual.isEmpty());
        assertTrue(actual.equals("Updating index: library_index.json downloaded"));
    }
    
    @Test
    public void upgradeLibraries(){
        String actual = Lib.upgradeLibraries();
        assertTrue(actual.isEmpty());
    }
    
    @Test
    public void downloadLibrary () {
    }
    
    @Test
    public void downloadLibrary1 () {
    }
    
    @Test
    public void installLibrary () {
    }
    
    @Test
    public void installLibrary1 () {
    }
    
    @Test
    public void searchLibrary(){
    
    }
}
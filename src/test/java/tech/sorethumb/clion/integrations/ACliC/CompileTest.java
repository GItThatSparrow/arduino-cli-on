package tech.sorethumb.clion.integrations.ACliC;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class CompileTest {
    
    @Test
    public void run () {
        /*
        Class.ReflectionData<Compile> reflectionData = Compile.class.reflectionData();
        SerializedName[] aTypes = reflectionData.declaredPublicMethods[5].getAnnotationsByType(SerializedName.class);
        aTypes[0].value();
    */
    }
    
    @Test
    public void test1 () {
        Compile compile = new Compile();
        compile.setFqbn("Intel:38s");
        compile.setBuildPath(System.getProperty("user.home"));
        Set<String> params = compile.getKeyValueParams();
        assertTrue(params.size() == 2);
        assertTrue(params != null);
    }
    
    @Test
    public void testWarningLevel () {
        Compile compile = new Compile();
        
        compile.setFqbn("Intel:38s");
        compile.setShowProperties("true");
        compile.setPreprocess("false");
        compile.setBuildCachePath("/this/is/a/cache/path");
        compile.setExportFile("/ThisIsAnExport/Path/Here");
        compile.setBuildPath(System.getProperty("user.home"));
        compile.setBuildProperties("some=property,another=prop");
        compile.setWarnings(Compile.WarningLevel.ALL);
        compile.setVerbose("true");
        compile.setQuiet("true");
        compile.setVidPid("vidPid");
        
        Set<String> params = compile.getKeyValueParams();
        assertTrue(params != null);
        assertTrue(params.contains("--warnings \"all\""));
        assertTrue(params.size() == 11);
    }
}
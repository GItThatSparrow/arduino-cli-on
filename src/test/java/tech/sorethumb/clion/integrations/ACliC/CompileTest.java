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
}
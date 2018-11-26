package tech.sorethumb.clion.projectBuildConfigs;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import static tech.sorethumb.clion.constants.ArduinoCLIBuildConstants.ACB_PLUGIN_ID_CONFIG_FACTORY;
import static tech.sorethumb.clion.constants.ArduinoCLIBuildConstants.ACB_PLUGIN_ID_CONFIG_FACTORY_NAME;

public class ArduinoCLIConfigurationFactory extends ConfigurationFactory {
    
    public ArduinoCLIConfigurationFactory (ConfigurationType type) {
        super(type);
    }
    
    /**
     * Creates a new template run configuration within the context of the specified project.
     *
     * @param project the project in which the run configuration will be used
     * @return the run configuration instance.
     */
    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration (@NotNull Project project) {
        return new ArduinoCLIConfiguration(project, this, ACB_PLUGIN_ID_CONFIG_FACTORY_NAME);
    }
    
    @Override
    public String getName () {
        return ACB_PLUGIN_ID_CONFIG_FACTORY;
    }
}

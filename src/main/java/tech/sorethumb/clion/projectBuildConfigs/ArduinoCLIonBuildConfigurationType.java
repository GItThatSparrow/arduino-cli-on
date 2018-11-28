package tech.sorethumb.clion.projectBuildConfigs;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import tech.sorethumb.clion.constants.ArduinoCLIBuildConstants;

import javax.swing.*;

public class ArduinoCLIonBuildConfigurationType implements ConfigurationType {
    
    /**
     * Returns the display name of the configuration type. This is used, for example, to represent the configuration type in the run
     * configurations tree, and also as the name of the action used to create the configuration.
     *
     * @return the display name of the configuration type.
     */
    @Nls
    @Override
    public String getDisplayName () {
        return ArduinoCLIBuildConstants.ACB_LABEL;
    }
    
    /**
     * Returns the description of the configuration type. You may return the same text as the display name of the configuration type.
     *
     * @return the description of the configuration type.
     */
    @Nls
    @Override
    public String getConfigurationTypeDescription () {
        return ArduinoCLIBuildConstants.ACB_DESC;
    }
    
    /**
     * Returns the 16x16 icon used to represent the configuration type.
     *
     * @return the icon
     */
    @Override
    public Icon getIcon () {
        Icon retVal = AllIcons.General.Information;
        try {
            /**
             * NOTE: The resource path is required to start with {@code /icons} by the {@link IconLoader} class.
             */
            String iconFileName = "/icons/sore_thumb_icon.16.svg";
            retVal = IconLoader.getIcon(iconFileName);
        }catch (Exception x){
        
        }
        return retVal;
    }
    
    /**
     * Returns the ID of the configuration type. The ID is used to store run configuration settings in a project or workspace file and
     * must not change between plugin versions.
     *
     * @return the configuration type ID.
     */
    @NotNull
    @Override
    public String getId () {
        return ArduinoCLIBuildConstants.ACB_NAME;
    }
    
    /**
     * Returns the configuration factories used by this configuration type. Normally each configuration type provides just a single factory.
     * You can return multiple factories if your configurations can be created in multiple variants (for example, local and remote for an
     * application server).
     *
     * @return the run configuration factories.
     */
    @Override
    public ConfigurationFactory[] getConfigurationFactories () {
        return new ConfigurationFactory[]{new ArduinoCLIonBuildConfigurationFactory(this)};
    }
}

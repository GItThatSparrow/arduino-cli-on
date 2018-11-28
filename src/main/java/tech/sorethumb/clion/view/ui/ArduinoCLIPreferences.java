package tech.sorethumb.clion.view.ui;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.BaseConfigurable;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.options.ex.ConfigurableCardPanel;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sorethumb.clion.constants.ArduinoCLIBuildConstants;
import tech.sorethumb.clion.services.ArduinoCLIonConfiguration;

import javax.swing.*;

/**
 * Managing the preferences, with the {@link ArduinoCLIonConfiguration} as the service
 * providing access to/from the persistence layer.
 */
public class ArduinoCLIPreferences extends BaseConfigurable implements SearchableConfigurable {
    
    private static final Logger log = Logger.getInstance(ConfigurableCardPanel.class);
    
    private ArduinoCLIPreferencesForm arduinoCLIPreferencesForm;
    private static final String ARDUINO_CLION_ID = "preference.arduinoCLIon";
    
    private final Project project;
    private final ArduinoCLIonConfiguration arduinoCLIonConfiguration;
    
    public ArduinoCLIPreferences (@NotNull Project project) {
        this.project = project;
        arduinoCLIonConfiguration = ArduinoCLIonConfiguration.getInstance(project);
    }
    
    @Nls
    @Override
    public String getDisplayName() {
        return ArduinoCLIBuildConstants.ACB_LABEL;
    }
    
    @Nullable
    @Override
    public String getHelpTopic() {
        return ARDUINO_CLION_ID;
    }
    
    @NotNull
    @Override
    public String getId() {
        return ARDUINO_CLION_ID;
    }
    
    @Nullable
    @Override
    public Runnable enableSearch(String s) {
        return null;
    }
    
    @Nullable
    @Override
    public JComponent createComponent() {
        try{
            arduinoCLIPreferencesForm = new ArduinoCLIPreferencesForm();
            return arduinoCLIPreferencesForm.getRoot();
        }catch (Exception x) {
            log.error("Can't create a component...", x);
        }
        return new JPanel().getRootPane();
    }
    
    @Override
    public boolean isModified() {
        return false;
    }
    
    @Override
    public void apply() {
    }
    
    @Override
    public void reset() {
    }
    
    @Override
    public void disposeUIResources() {
        arduinoCLIPreferencesForm = null;
    }
}
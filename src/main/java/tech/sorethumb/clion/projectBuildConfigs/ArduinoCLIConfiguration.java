package tech.sorethumb.clion.projectBuildConfigs;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.impl.CheckableRunConfigurationEditor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.options.SettingsEditorGroup;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sorethumb.clion.services.ArduinoCLIonConfiguration;
import tech.sorethumb.clion.view.ui.ArduinoCLIConfigSettingsForm;

public class ArduinoCLIConfiguration extends RunConfigurationBase {
    
    Logger log = Logger.getInstance(ArduinoCLIConfiguration.class);
    
    ArduinoCLIonConfiguration arduinoCLIonConfiguration;
    
    @Override
    public boolean collectOutputFromProcessHandler () {
        return super.collectOutputFromProcessHandler();
    }
    
    public ArduinoCLIConfiguration (Project project, ConfigurationFactory factory, String name){
        super(project, factory, name);
        arduinoCLIonConfiguration = ArduinoCLIonConfiguration.getInstance(project);
    }
    
    /**
     * Returns the UI control for editing the run configuration settings. If additional control over validation is required, the object
     * returned from this method may also implement {@link CheckableRunConfigurationEditor}. The returned object
     * can also implement {@link SettingsEditorGroup} if the settings it provides need to be displayed in
     * multiple tabs.
     *
     * @return the settings editor component.
     */
    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor () {
        ArduinoCLIConfigSettingsForm arduinoCLIConfigSettingsForm = new ArduinoCLIConfigSettingsForm(arduinoCLIonConfiguration);
        return arduinoCLIConfigSettingsForm;
    }
    
    /**
     * This is an opportunity to update values submitted by the user.
     * @throws RuntimeConfigurationException
     */
    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        log.debug("Checking configuration - this is a ");
    }
    
    /**
     * Prepares for executing a specific instance of the run configuration.
     *
     * @param executor    the execution mode selected by the user (run, debug, profile etc.)
     * @param environment the environment object containing additional settings for executing the configuration.
     * @return the RunProfileState describing the process which is about to be started, or null if it's impossible to start the process.
     */
    @Nullable
    @Override
    public RunProfileState getState (@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
        log.debug("RUN PROFILE STATE: " + environment.getState());
        RunProfileState runProfileState = new RunProfileState() {
            @Nullable
            @Override
            public ExecutionResult execute (Executor executor, @NotNull ProgramRunner runner) throws ExecutionException {
                return null;
            }
        };
        return null;
    }
    
}

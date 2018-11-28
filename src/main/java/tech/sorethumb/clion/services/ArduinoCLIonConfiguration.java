package tech.sorethumb.clion.services;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sorethumb.clion.models.packageIndex.Board;
import tech.sorethumb.clion.models.packageIndex.Package;
import tech.sorethumb.clion.models.packageIndex.PlatformVersion;

/**
 * PersistentStateComponent keeps project config values.
 * Similar notion of 'preference' in Android
 */
@State(
        name="ArduinoCLIonConfiguration",
        storages = {
                @Storage(file = "$PROJECT_FILE$"),
                @Storage(file = "$PROJECT_CONFIG_DIR$/arduinoClion.xml", scheme = StorageScheme.DIRECTORY_BASED)
        }
)
public class ArduinoCLIonConfiguration implements PersistentStateComponent<ArduinoCLIonConfiguration> {
    
    private String apiPath;
    private Package selectedPackage;
    private PlatformVersion selectedPlatformVersion;
    private Board selectedBoard;
    
    ArduinoCLIonConfiguration () { }
    
    public void setSelectedBoard(Board board){
        this.selectedBoard = board;
    }
    
    public Board getSelectedBoard(){
        return this.selectedBoard;
    }
    
    public Package getSelectedPackage () {
        return selectedPackage;
    }
    
    public void setSelectedPackage (Package selectedPackage) {
        this.selectedPackage = selectedPackage;
    }
    
    public PlatformVersion getSelectedPlatformVersion () {
        return selectedPlatformVersion;
    }
    
    public void setSelectedPlatformVersion (PlatformVersion selectedPlatformVersion) {
        this.selectedPlatformVersion = selectedPlatformVersion;
    }
    
    @Nullable
    @Override
    public ArduinoCLIonConfiguration getState() {
        return this;
    }
    
    /**
     * This method is called when new component state is loaded. The method can and will be called several times, if
     * config files were externally changed while IDEA running.
     *
     * @param state loaded component state
     * @see XmlSerializerUtil#copyBean(Object, Object)
     */
    @Override
    public void loadState (@NotNull ArduinoCLIonConfiguration state) {
        XmlSerializerUtil.copyBean(state, this);
    }
    
    @Nullable
    public static ArduinoCLIonConfiguration getInstance(Project project) {
        return ServiceManager.getService(project, ArduinoCLIonConfiguration.class);
    }
}
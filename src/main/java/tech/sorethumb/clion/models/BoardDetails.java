package tech.sorethumb.clion.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BoardDetails implements Serializable
{
    
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ConfigOptions")
    @Expose
    private List<ConfigOption> configOptions = null;
    private final static long serialVersionUID = -4181169089045339152L;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
     * Gets a collection of available CPUs for this chip.
     * @return Collection of CPU options.
     */
    public List<ConfigOption> getConfigOptions() {
        return configOptions;
    }
    
    public void setConfigOptions(List<ConfigOption> configOptions) {
        this.configOptions = configOptions;
    }
    
}


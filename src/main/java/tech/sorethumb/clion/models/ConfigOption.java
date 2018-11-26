package tech.sorethumb.clion.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfigOption implements Serializable
{
    
    @SerializedName("Option")
    @Expose
    private String option;
    @SerializedName("OptionLabel")
    @Expose
    private String optionLabel;
    @SerializedName("Values")
    @Expose
    private List<ConfigOptionValue> values = null;
    private final static long serialVersionUID = 8296167612998506447L;
    
    public String getOption() {
        return option;
    }
    
    public void setOption(String option) {
        this.option = option;
    }
    
    public String getOptionLabel() {
        return optionLabel;
    }
    
    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel;
    }
    
    public List<ConfigOptionValue> getValues() {
        return values;
    }
    
    public void setValues(List<ConfigOptionValue> values) {
        this.values = values;
    }
    
}

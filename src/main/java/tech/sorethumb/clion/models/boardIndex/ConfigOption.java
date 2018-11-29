package tech.sorethumb.clion.models.boardIndex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConfigOption implements Serializable {
    
    @SerializedName("Option")
    @Expose
    private String option;
    @SerializedName("OptionLabel")
    @Expose
    private String optionLabel;
    @SerializedName("Values")
    @Expose
    private List<Value> values = new ArrayList<Value>();
    private final static long serialVersionUID = 5456403965756830581L;
    
    /**
     * No args constructor for use in serialization
     */
    public ConfigOption () {
    }
    
    /**
     * @param values
     * @param optionLabel
     * @param option
     */
    public ConfigOption (String option, String optionLabel, List<Value> values) {
        super();
        this.option = option;
        this.optionLabel = optionLabel;
        this.values = values;
    }
    
    public String getOption () {
        return option;
    }
    
    public void setOption (String option) {
        this.option = option;
    }
    
    public String getOptionLabel () {
        return optionLabel;
    }
    
    public void setOptionLabel (String optionLabel) {
        this.optionLabel = optionLabel;
    }
    
    public List<Value> getValues () {
        return values;
    }
    
    public void setValues (List<Value> values) {
        this.values = values;
    }
    
    public ConfigOption withOption (String option) {
        this.option = option;
        return this;
    }
    
    public ConfigOption withOptionLabel (String optionLabel) {
        this.optionLabel = optionLabel;
        return this;
    }
    
    public ConfigOption withValues (List<Value> values) {
        this.values = values;
        return this;
    }
    
    @Override
    public String toString () {
        return new ToStringBuilder(this).append("option", option).append("optionLabel", optionLabel).append("values", values).toString();
    }
    
}
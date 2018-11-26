package tech.sorethumb.clion.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfigOptionValue implements Serializable
{
    
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("ValueLabel")
    @Expose
    private String valueLabel;
    @SerializedName("Selected")
    @Expose
    private Boolean selected;
    private final static long serialVersionUID = -894660016823080518L;
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getValueLabel() {
        return valueLabel;
    }
    
    public void setValueLabel(String valueLabel) {
        this.valueLabel = valueLabel;
    }
    
    public Boolean getSelected() {
        return selected;
    }
    
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
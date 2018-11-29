package tech.sorethumb.clion.models.boardIndex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Value implements Serializable {
    
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("ValueLabel")
    @Expose
    private String valueLabel;
    @SerializedName("Selected")
    @Expose
    private Boolean selected;
    private final static long serialVersionUID = 3395599195276878526L;
    
    /**
     * No args constructor for use in serialization
     */
    public Value () {
    }
    
    /**
     * @param selected
     * @param valueLabel
     * @param value
     */
    public Value (String value, String valueLabel, Boolean selected) {
        super();
        this.value = value;
        this.valueLabel = valueLabel;
        this.selected = selected;
    }
    
    public String getValue () {
        return value;
    }
    
    public void setValue (String value) {
        this.value = value;
    }
    
    public String getValueLabel () {
        return valueLabel;
    }
    
    public void setValueLabel (String valueLabel) {
        this.valueLabel = valueLabel;
    }
    
    public Boolean getSelected () {
        return selected;
    }
    
    public void setSelected (Boolean selected) {
        this.selected = selected;
    }
    
    public Value withValue (String value) {
        this.value = value;
        return this;
    }
    
    public Value withValueLabel (String valueLabel) {
        this.valueLabel = valueLabel;
        return this;
    }
    
    public Value withSelected (Boolean selected) {
        this.selected = selected;
        return this;
    }
    
    @Override
    public String toString () {
        return new ToStringBuilder(this).append("value", value).append("valueLabel", valueLabel).append("selected", selected).toString();
    }
    
}
package tech.sorethumb.clion.models.coreIndex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Platform implements Serializable {
    
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Installed")
    @Expose
    private String installed;
    @SerializedName("Latest")
    @Expose
    private String latest;
    @SerializedName("Name")
    @Expose
    private String name;
    private final static long serialVersionUID = -550391757532403781L;
    
    public String getID () {
        return iD;
    }
    
    public void setID (String iD) {
        this.iD = iD;
    }
    
    public Platform withID (String iD) {
        this.iD = iD;
        return this;
    }
    
    public String getInstalled () {
        return installed;
    }
    
    public void setInstalled (String installed) {
        this.installed = installed;
    }
    
    public Platform withInstalled (String installed) {
        this.installed = installed;
        return this;
    }
    
    public String getLatest () {
        return latest;
    }
    
    public void setLatest (String latest) {
        this.latest = latest;
    }
    
    public Platform withLatest (String latest) {
        this.latest = latest;
        return this;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public Platform withName (String name) {
        this.name = name;
        return this;
    }
    
}
package tech.sorethumb.clion.models.lib;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Library implements Serializable
{
    
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Releases")
    @Expose
    private List<Release> releases = null;
    private final static long serialVersionUID = 8263488174161734268L;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public Library() {
    }
    
    /**
     *
     * @param releases
     * @param name
     */
    public Library(String name, List<Release> releases) {
        super();
        this.name = name;
        this.releases = releases;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Library withName(String name) {
        this.name = name;
        return this;
    }
    
    public List<Release> getReleases() {
        return releases;
    }
    
    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
    
    public Library withReleases(List<Release> releases) {
        this.releases = releases;
        return this;
    }
    
}

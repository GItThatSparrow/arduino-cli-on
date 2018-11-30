package tech.sorethumb.clion.models.lib;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Search implements Serializable
{
    
    @SerializedName("libraries")
    @Expose
    private List<Library> libraries = null;
    private final static long serialVersionUID = -1924156452991766923L;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public Search() {
    }
    
    /**
     *
     * @param libraries
     */
    public Search(List<Library> libraries) {
        super();
        this.libraries = libraries;
    }
    
    public List<Library> getLibraries() {
        return libraries;
    }
    
    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
    
    public Search withLibraries(List<Library> libraries) {
        this.libraries = libraries;
        return this;
    }
    
}
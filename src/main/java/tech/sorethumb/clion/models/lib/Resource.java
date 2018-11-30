package tech.sorethumb.clion.models.lib;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Resource implements Serializable
{
    
    @SerializedName("URL")
    @Expose
    private String uRL;
    @SerializedName("ArchiveFileName")
    @Expose
    private String archiveFileName;
    @SerializedName("Checksum")
    @Expose
    private String checksum;
    @SerializedName("Size")
    @Expose
    private Integer size;
    @SerializedName("CachePath")
    @Expose
    private String cachePath;
    private final static long serialVersionUID = -8025131246801643968L;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public Resource() {
    }
    
    /**
     *
     * @param cachePath
     * @param archiveFileName
     * @param uRL
     * @param checksum
     * @param size
     */
    public Resource(String uRL, String archiveFileName, String checksum, Integer size, String cachePath) {
        super();
        this.uRL = uRL;
        this.archiveFileName = archiveFileName;
        this.checksum = checksum;
        this.size = size;
        this.cachePath = cachePath;
    }
    
    public String getURL() {
        return uRL;
    }
    
    public void setURL(String uRL) {
        this.uRL = uRL;
    }
    
    public Resource withURL(String uRL) {
        this.uRL = uRL;
        return this;
    }
    
    public String getArchiveFileName() {
        return archiveFileName;
    }
    
    public void setArchiveFileName(String archiveFileName) {
        this.archiveFileName = archiveFileName;
    }
    
    public Resource withArchiveFileName(String archiveFileName) {
        this.archiveFileName = archiveFileName;
        return this;
    }
    
    public String getChecksum() {
        return checksum;
    }
    
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
    
    public Resource withChecksum(String checksum) {
        this.checksum = checksum;
        return this;
    }
    
    public Integer getSize() {
        return size;
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }
    
    public Resource withSize(Integer size) {
        this.size = size;
        return this;
    }
    
    public String getCachePath() {
        return cachePath;
    }
    
    public void setCachePath(String cachePath) {
        this.cachePath = cachePath;
    }
    
    public Resource withCachePath(String cachePath) {
        this.cachePath = cachePath;
        return this;
    }
    
}

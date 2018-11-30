package tech.sorethumb.clion.models.lib;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Release implements Serializable
{
    
    @SerializedName("Version")
    @Expose
    private String version;
    @SerializedName("Author")
    @Expose
    private String author;
    @SerializedName("Maintainer")
    @Expose
    private String maintainer;
    @SerializedName("Sentence")
    @Expose
    private String sentence;
    @SerializedName("Paragraph")
    @Expose
    private String paragraph;
    @SerializedName("Website")
    @Expose
    private String website;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("Architectures")
    @Expose
    private List<String> architectures = null;
    @SerializedName("Types")
    @Expose
    private List<String> types = null;
    @SerializedName("Resource")
    @Expose
    private Resource resource;
    private final static long serialVersionUID = -4083362785338841210L;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public Release() {
    }
    
    /**
     *
     * @param architectures
     * @param author
     * @param category
     * @param paragraph
     * @param website
     * @param resource
     * @param sentence
     * @param types
     * @param maintainer
     * @param version
     */
    public Release(String version, String author, String maintainer, String sentence, String paragraph, String website, String category, List<String> architectures, List<String> types, Resource resource) {
        super();
        this.version = version;
        this.author = author;
        this.maintainer = maintainer;
        this.sentence = sentence;
        this.paragraph = paragraph;
        this.website = website;
        this.category = category;
        this.architectures = architectures;
        this.types = types;
        this.resource = resource;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public Release withVersion(String version) {
        this.version = version;
        return this;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Release withAuthor(String author) {
        this.author = author;
        return this;
    }
    
    public String getMaintainer() {
        return maintainer;
    }
    
    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }
    
    public Release withMaintainer(String maintainer) {
        this.maintainer = maintainer;
        return this;
    }
    
    public String getSentence() {
        return sentence;
    }
    
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    
    public Release withSentence(String sentence) {
        this.sentence = sentence;
        return this;
    }
    
    public String getParagraph() {
        return paragraph;
    }
    
    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
    
    public Release withParagraph(String paragraph) {
        this.paragraph = paragraph;
        return this;
    }
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public Release withWebsite(String website) {
        this.website = website;
        return this;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public Release withCategory(String category) {
        this.category = category;
        return this;
    }
    
    public List<String> getArchitectures() {
        return architectures;
    }
    
    public void setArchitectures(List<String> architectures) {
        this.architectures = architectures;
    }
    
    public Release withArchitectures(List<String> architectures) {
        this.architectures = architectures;
        return this;
    }
    
    public List<String> getTypes() {
        return types;
    }
    
    public void setTypes(List<String> types) {
        this.types = types;
    }
    
    public Release withTypes(List<String> types) {
        this.types = types;
        return this;
    }
    
    public Resource getResource() {
        return resource;
    }
    
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    
    public Release withResource(Resource resource) {
        this.resource = resource;
        return this;
    }
    
}

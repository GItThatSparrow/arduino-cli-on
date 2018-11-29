package tech.sorethumb.clion.models.coreIndex;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import tech.sorethumb.clion.integrations.ACliC.Core;

import java.io.Serializable;
import java.util.List;

public class Root implements Serializable
{
    
    @SerializedName("Platforms")
    @Expose
    private List<Platform> platforms = null;
    private final static long serialVersionUID = -5221863073354496526L;
    
    public List<Platform> getPlatforms() {
        return platforms;
    }
    
    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }
    
    public Root withPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
        return this;
    }
    
    public static void getCoreList(){
    
    }
    
    /**
     * Retrieves a JSON-formatted file from the {@code Arduino15} directory. The JSON is
     * deserialized as a fully populated {@link tech.sorethumb.clion.models.coreIndex.Root} object.
     * @return A complete data structure of supported boards, cores and their architecture specs.
     */
    public static Root getPackageList() {
        String s = Core.getListJSON();
        Gson gson = new Gson();
        return (Root)gson.fromJson(s, Root.class);
    }
}
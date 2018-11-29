
package tech.sorethumb.clion.models.packageIndex;

import com.google.gson.annotations.SerializedName;
import tech.sorethumb.clion.models.NamedPackageObjects;
import tech.sorethumb.clion.models.transform.PackagePlatformVersion;

import javax.annotation.Generated;
import java.util.List;
import java.util.Map;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Package implements NamedPackageObjects {

    @SerializedName("email")
    private String mEmail;
    @SerializedName("help")
    private Help mHelp;
    @SerializedName("maintainer")
    private String mMaintainer;
    @SerializedName("name")
    private String mName;
    @SerializedName("platforms")
    private List<PlatformVersion> mPlatformVersions;
    @SerializedName("tools")
    private List<Tool> mTools;
    @SerializedName("websiteURL")
    private String mWebsiteURL;

    public String getEmail() {
        return mEmail;
    }

    public Help getHelp() {
        return mHelp;
    }

    public String getMaintainer() {
        return mMaintainer;
    }

    public String getName() {
        return mName;
    }

    public List<PlatformVersion> getPlatformVersions () {
        return mPlatformVersions;
    }
    
    public List<Platform> getPlatforms(){
        Map<String, List<PlatformVersion>> stringListMap = PackagePlatformVersion.groupByPlatformArchitecture(getPlatformVersions());
        return PackagePlatformVersion.mapToPlatformList(stringListMap);
    }

    public List<Tool> getTools() {
        return mTools;
    }

    public String getWebsiteURL() {
        return mWebsiteURL;
    }
    
    @Override
    public String getDisplayName () {
        return mName;
    }
    
    public static class Builder {

        private String mEmail;
        private Help mHelp;
        private String mMaintainer;
        private String mName;
        private List<PlatformVersion> mPlatformVersions;
        private List<Tool> mTools;
        private String mWebsiteURL;

        public Package.Builder withEmail(String email) {
            mEmail = email;
            return this;
        }

        public Package.Builder withHelp(Help help) {
            mHelp = help;
            return this;
        }

        public Package.Builder withMaintainer(String maintainer) {
            mMaintainer = maintainer;
            return this;
        }

        public Package.Builder withName(String name) {
            mName = name;
            return this;
        }

        public Package.Builder withPlatforms(List<PlatformVersion> platformVersions) {
            mPlatformVersions = platformVersions;
            return this;
        }

        public Package.Builder withTools(List<Tool> tools) {
            mTools = tools;
            return this;
        }

        public Package.Builder withWebsiteURL(String websiteURL) {
            mWebsiteURL = websiteURL;
            return this;
        }
    }

}

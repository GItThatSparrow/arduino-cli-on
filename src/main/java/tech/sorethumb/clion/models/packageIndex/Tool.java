
package tech.sorethumb.clion.models.packageIndex;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Tool {

    @SerializedName("name")
    private String mName;
    @SerializedName("systems")
    private List<System> mSystems;
    @SerializedName("version")
    private String mVersion;

    public String getName() {
        return mName;
    }

    public List<System> getSystems() {
        return mSystems;
    }

    public String getVersion() {
        return mVersion;
    }

    public static class Builder {

        private String mName;
        private List<System> mSystems;
        private String mVersion;

        public Tool.Builder withName(String name) {
            mName = name;
            return this;
        }

        public Tool.Builder withSystems(List<System> systems) {
            mSystems = systems;
            return this;
        }

        public Tool.Builder withVersion(String version) {
            mVersion = version;
            return this;
        }

        public Tool build() {
            Tool tool = new Tool();
            tool.mName = mName;
            tool.mSystems = mSystems;
            tool.mVersion = mVersion;
            return tool;
        }

    }

}

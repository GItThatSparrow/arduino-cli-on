
package tech.sorethumb.clion.models.packageIndex;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ToolsDependency {

    @SerializedName("name")
    private String mName;
    @SerializedName("packager")
    private String mPackager;
    @SerializedName("version")
    private String mVersion;

    public String getName() {
        return mName;
    }

    public String getPackager() {
        return mPackager;
    }

    public String getVersion() {
        return mVersion;
    }

    public static class Builder {

        private String mName;
        private String mPackager;
        private String mVersion;

        public ToolsDependency.Builder withName(String name) {
            mName = name;
            return this;
        }

        public ToolsDependency.Builder withPackager(String packager) {
            mPackager = packager;
            return this;
        }

        public ToolsDependency.Builder withVersion(String version) {
            mVersion = version;
            return this;
        }

        public ToolsDependency build() {
            ToolsDependency toolsDependency = new ToolsDependency();
            toolsDependency.mName = mName;
            toolsDependency.mPackager = mPackager;
            toolsDependency.mVersion = mVersion;
            return toolsDependency;
        }

    }

}

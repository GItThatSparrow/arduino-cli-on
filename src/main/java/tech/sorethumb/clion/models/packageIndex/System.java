
package tech.sorethumb.clion.models.packageIndex;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class System {

    @SerializedName("archiveFileName")
    private String mArchiveFileName;
    @SerializedName("checksum")
    private String mChecksum;
    @SerializedName("host")
    private String mHost;
    @SerializedName("size")
    private String mSize;
    @SerializedName("url")
    private String mUrl;

    public String getArchiveFileName() {
        return mArchiveFileName;
    }

    public String getChecksum() {
        return mChecksum;
    }

    public String getHost() {
        return mHost;
    }

    public String getSize() {
        return mSize;
    }

    public String getUrl() {
        return mUrl;
    }

    public static class Builder {

        private String mArchiveFileName;
        private String mChecksum;
        private String mHost;
        private String mSize;
        private String mUrl;

        public System.Builder withArchiveFileName(String archiveFileName) {
            mArchiveFileName = archiveFileName;
            return this;
        }

        public System.Builder withChecksum(String checksum) {
            mChecksum = checksum;
            return this;
        }

        public System.Builder withHost(String host) {
            mHost = host;
            return this;
        }

        public System.Builder withSize(String size) {
            mSize = size;
            return this;
        }

        public System.Builder withUrl(String url) {
            mUrl = url;
            return this;
        }

        public System build() {
            System system = new System();
            system.mArchiveFileName = mArchiveFileName;
            system.mChecksum = mChecksum;
            system.mHost = mHost;
            system.mSize = mSize;
            system.mUrl = mUrl;
            return system;
        }

    }

}

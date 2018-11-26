
package tech.sorethumb.clion.models.packageIndex;

import com.google.gson.annotations.SerializedName;
import tech.sorethumb.clion.models.NamedPackageObjects;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PlatformVersion implements NamedPackageObjects {

    @SerializedName("architecture")
    private String mArchitecture;
    @SerializedName("archiveFileName")
    private String mArchiveFileName;
    @SerializedName("boards")
    private List<Board> mBoards;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("checksum")
    private String mChecksum;
    @SerializedName("name")
    private String mName;
    @SerializedName("size")
    private String mSize;
    @SerializedName("toolsDependencies")
    private List<ToolsDependency> mToolsDependencies;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("version")
    private String mVersion;

    public String getArchitecture() {
        return mArchitecture;
    }

    public String getArchiveFileName() {
        return mArchiveFileName;
    }

    public List<Board> getBoards() {
        return mBoards;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getChecksum() {
        return mChecksum;
    }

    public String getName() {
        return mName;
    }

    public String getSize() {
        return mSize;
    }

    public List<ToolsDependency> getToolsDependencies() {
        return mToolsDependencies;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getVersion() {
        return mVersion;
    }
    
    public String getDisplayName(){
        return mVersion;
    }

    public static class Builder {

        private String mArchitecture;
        private String mArchiveFileName;
        private List<Board> mBoards;
        private String mCategory;
        private String mChecksum;
        private String mName;
        private String mSize;
        private List<ToolsDependency> mToolsDependencies;
        private String mUrl;
        private String mVersion;

        public PlatformVersion.Builder withArchitecture(String architecture) {
            mArchitecture = architecture;
            return this;
        }

        public PlatformVersion.Builder withArchiveFileName(String archiveFileName) {
            mArchiveFileName = archiveFileName;
            return this;
        }

        public PlatformVersion.Builder withBoards(List<Board> boards) {
            mBoards = boards;
            return this;
        }

        public PlatformVersion.Builder withCategory(String category) {
            mCategory = category;
            return this;
        }

        public PlatformVersion.Builder withChecksum(String checksum) {
            mChecksum = checksum;
            return this;
        }

        public PlatformVersion.Builder withName(String name) {
            mName = name;
            return this;
        }

        public PlatformVersion.Builder withSize(String size) {
            mSize = size;
            return this;
        }

        public PlatformVersion.Builder withToolsDependencies(List<ToolsDependency> toolsDependencies) {
            mToolsDependencies = toolsDependencies;
            return this;
        }

        public PlatformVersion.Builder withUrl(String url) {
            mUrl = url;
            return this;
        }

        public PlatformVersion.Builder withVersion(String version) {
            mVersion = version;
            return this;
        }

        public PlatformVersion build() {
            PlatformVersion platformVersion = new PlatformVersion();
            platformVersion.mArchitecture = mArchitecture;
            platformVersion.mArchiveFileName = mArchiveFileName;
            platformVersion.mBoards = mBoards;
            platformVersion.mCategory = mCategory;
            platformVersion.mChecksum = mChecksum;
            platformVersion.mName = mName;
            platformVersion.mSize = mSize;
            platformVersion.mToolsDependencies = mToolsDependencies;
            platformVersion.mUrl = mUrl;
            platformVersion.mVersion = mVersion;
            return platformVersion;
        }

    }
    
    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString () {
        return mVersion;
    }
}

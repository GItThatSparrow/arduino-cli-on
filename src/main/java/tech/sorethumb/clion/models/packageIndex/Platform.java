
package tech.sorethumb.clion.models.packageIndex;

import com.google.gson.annotations.SerializedName;
import tech.sorethumb.clion.models.NamedPackageObjects;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Platform implements NamedPackageObjects {

    @SerializedName("name")
    private String mName;
    @SerializedName("platforms")
    private List<PlatformVersion> mPlatformVersions;
    
    
    public String getName() {
        return mName;
    }
    public List<PlatformVersion> getVersions() {
        return mPlatformVersions;
    }
    
    @Override
    public String getDisplayName () {
        return mName;
    }
    
    public static class Builder {

        private List<PlatformVersion> mPlatformVersions;
        private String mName;
    
        public Platform.Builder withversions(List<PlatformVersion> platformVersions) {
            mPlatformVersions = platformVersions;
            return this;
        }
    
        public Platform.Builder withName(String name) {
            mName = name;
            return this;
        }

        public Platform build() {
            Platform platform = new Platform();
            platform.mPlatformVersions = mPlatformVersions;
            platform.mName = mName;
            return platform;
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
        return mName;
    }
}

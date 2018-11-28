
package tech.sorethumb.clion.models.packageIndex;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import tech.sorethumb.clion.integrations.ACliC.Core;
import tech.sorethumb.clion.integrations.FileSystem;
import tech.sorethumb.clion.services.ArduinoCLIonConfiguration;

import javax.annotation.Generated;
import java.io.IOException;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Root {

    @SerializedName("packages")
    private List<Package> mPackages;

    public List<Package> getPackages() {
        return mPackages;
    }

    public static class Builder {

        private List<Package> mPackages;

        public Root.Builder withPackages(List<Package> packages) {
            mPackages = packages;
            return this;
        }

        public Root build() {
            Root root = new Root();
            root.mPackages = mPackages;
            return root;
        }

    }
    
    /**
     * Updates the index of cores.
     * @return {@code true} if the operation resturns as "success[ful]" string.
     */
    public static Boolean updatePackageList(){
        String result = Core.coreUpdateIndex();
        Boolean b = result.endsWith("Updating index: package_index.json downloaded\n");
        return b;
    }
    
    /**
     * Retrieves a JSON-formatted file from the {@code Arduino15} directory. The JSON is
     * deserialized as a fully populated {@link Root} object.
     * @param arduinoCLIonConfiguration The local configuration to use in finding the appropriate JSON file.
     * @return A complete data structure of supported boards, cores and their architecture specs.
     * @throws IOException
     */
    public static Root getPackageList(ArduinoCLIonConfiguration arduinoCLIonConfiguration) throws IOException {
        String s = FileSystem.readPackageIndexJson(arduinoCLIonConfiguration);
        Gson gson = new Gson();
        return (Root)gson.fromJson(s, Root.class);
    }
    /**
     * Retrieves a JSON-formatted file from the {@code Arduino15} directory. The JSON is
     * deserialized as a fully populated {@link Root} object.
     * @param arduinoCLIonConfiguration The local configuration to use in finding the appropriate JSON file.
     * @return A complete data structure of supported boards, cores and their architecture specs.
     * @throws IOException
     */
    public static Root getPackageList(String apiPath) {
        String s = FileSystem.readPackageIndexJson(apiPath);
        Gson gson = new Gson();
        return (Root)gson.fromJson(s, Root.class);
    }
}

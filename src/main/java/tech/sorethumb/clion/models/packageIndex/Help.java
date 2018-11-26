
package tech.sorethumb.clion.models.packageIndex;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Help {

    @SerializedName("online")
    private String mOnline;

    public String getOnline() {
        return mOnline;
    }

    public static class Builder {

        private String mOnline;

        public Help.Builder withOnline(String online) {
            mOnline = online;
            return this;
        }

        public Help build() {
            Help help = new Help();
            help.mOnline = mOnline;
            return help;
        }

    }

}


package tech.sorethumb.clion.models.packageIndex;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Board {

    @SerializedName("name")
    private String mName;

    public String getName() {
        return mName;
    }

    public static class Builder {

        private String mName;

        public Board.Builder withName(String name) {
            mName = name;
            return this;
        }

        public Board build() {
            Board board = new Board();
            board.mName = mName;
            return board;
        }

    }

}

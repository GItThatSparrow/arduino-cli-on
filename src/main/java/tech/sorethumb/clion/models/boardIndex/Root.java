package tech.sorethumb.clion.models.boardIndex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Uses the response from command-line operations to build
 * a response with information about connected boards.
 */
public class Root implements Serializable {
    
    @SerializedName("serialBoards")
    @Expose
    private List<SerialBoard> serialBoards = new ArrayList<SerialBoard>();
    @SerializedName("networkBoards")
    @Expose
    private List<Object> networkBoards = new ArrayList<Object>();
    private final static long serialVersionUID = -731174448254553781L;
    
    /**
     * No args constructor for use in serialization
     */
    public Root () {
    }
    
    /**
     * @param networkBoards
     * @param serialBoards
     */
    public Root (List<SerialBoard> serialBoards, List<Object> networkBoards) {
        super();
        this.serialBoards = serialBoards;
        this.networkBoards = networkBoards;
    }
    
    public List<SerialBoard> getSerialBoards () {
        return serialBoards;
    }
    
    public void setSerialBoards (List<SerialBoard> serialBoards) {
        this.serialBoards = serialBoards;
    }
    
    public List<Object> getNetworkBoards () {
        return networkBoards;
    }
    
    public void setNetworkBoards (List<Object> networkBoards) {
        this.networkBoards = networkBoards;
    }
    
    public Root withSerialBoards (List<SerialBoard> serialBoards) {
        this.serialBoards = serialBoards;
        return this;
    }
    
    public Root withNetworkBoards (List<Object> networkBoards) {
        this.networkBoards = networkBoards;
        return this;
    }
    
    @Override
    public String toString () {
        return new ToStringBuilder(this).append("serialBoards", serialBoards).append("networkBoards", networkBoards).toString();
    }
    
}
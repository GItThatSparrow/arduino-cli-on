package tech.sorethumb.clion.models.boardIndex;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import tech.sorethumb.clion.integrations.ACliC.Board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Show information about a board, in particular if the board has options to be specified in the FQBN.
 */
public class BoardDetails implements Serializable {
    
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ConfigOptions")
    @Expose
    private List<ConfigOption> configOptions = new ArrayList<ConfigOption>();
    private final static long serialVersionUID = 5940301312840937484L;
    
    /**
     * No args constructor for use in serialization
     */
    public BoardDetails () {
    }
    
    /**
     * @param name
     * @param configOptions
     */
    public BoardDetails (String name, List<ConfigOption> configOptions) {
        super();
        this.name = name;
        this.configOptions = configOptions;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public List<ConfigOption> getConfigOptions () {
        return configOptions;
    }
    
    public void setConfigOptions (List<ConfigOption> configOptions) {
        this.configOptions = configOptions;
    }
    
    public BoardDetails withName (String name) {
        this.name = name;
        return this;
    }
    
    public BoardDetails withConfigOptions (List<ConfigOption> configOptions) {
        this.configOptions = configOptions;
        return this;
    }
    
    @Override
    public String toString () {
        return new ToStringBuilder(this).append("name", name).append("configOptions", configOptions).toString();
    }
    
    /**
     * Load the board detailsby providing a Fully Qualified Board Name
     * @param fqbn The Fully Qualified Board Name used to retrieve details.
     * @return All options available for the board. Also includes identifier
     * for selected value in each option group.
     */
    public static BoardDetails load(String fqbn){
        String json = Board.BoardDetails(fqbn);
        Gson gson = new Gson();
        return gson.fromJson(json, BoardDetails.class);
    }
}
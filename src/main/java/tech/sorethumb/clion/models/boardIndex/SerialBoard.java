package tech.sorethumb.clion.models.boardIndex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class SerialBoard implements Serializable {
    
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fqbn")
    @Expose
    private String fqbn;
    @SerializedName("port")
    @Expose
    private String port;
    @SerializedName("usbID")
    @Expose
    private String usbID;
    private final static long serialVersionUID = -1427275877979684760L;
    
    /**
     * No args constructor for use in serialization
     */
    public SerialBoard () {
    }
    
    /**
     * @param port
     * @param fqbn
     * @param usbID
     * @param name
     */
    public SerialBoard (String name, String fqbn, String port, String usbID) {
        super();
        this.name = name;
        this.fqbn = fqbn;
        this.port = port;
        this.usbID = usbID;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getFqbn () {
        return fqbn;
    }
    
    public void setFqbn (String fqbn) {
        this.fqbn = fqbn;
    }
    
    public String getPort () {
        return port;
    }
    
    public void setPort (String port) {
        this.port = port;
    }
    
    public String getUsbID () {
        return usbID;
    }
    
    public void setUsbID (String usbID) {
        this.usbID = usbID;
    }
    
    public SerialBoard withUsbID (String usbID) {
        this.usbID = usbID;
        return this;
    }
    
    public SerialBoard withName (String name) {
        this.name = name;
        return this;
    }
    
    public SerialBoard withFqbn (String fqbn) {
        this.fqbn = fqbn;
        return this;
    }
    
    public SerialBoard withPort (String port) {
        this.port = port;
        return this;
    }
    
    @Override
    public String toString () {
        return new ToStringBuilder(this).append("name", name).append("fqbn", fqbn).append("port", port).append("usbID", usbID).toString();
    }
    
    public BoardDetails getBoardDetails(){
        return BoardDetails.load(getFqbn());
    }
}
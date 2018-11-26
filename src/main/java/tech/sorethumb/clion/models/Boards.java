package tech.sorethumb.clion.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import tech.sorethumb.clion.models.packageIndex.Board;

import java.io.Serializable;
import java.util.List;

public class Boards implements Serializable
{
    
    @SerializedName("boards")
    @Expose
    private List<Board> boards = null;
    private final static long serialVersionUID = -1385809022627640735L;
    
    public List<Board> getBoards() {
        return boards;
    }
    
    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
    
}
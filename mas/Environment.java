package mas;


import java.util.ArrayList;
import java.util.List;

public class Environment{
    private int[][] world;
    private int width, height; 
    private List<Agent> agentList; 

    public Environment(int width, int height){
        this.width = width; 
        this.height = height; 
        this.agentList = new ArrayList<>();
        this.world = new int[width][height];
        for(int i = 0; i <world.length; i ++){
            for(int j = 0; j<world[i].length; j++){
                this.world[i][j] = 0 ;
            }
        }     
    }

    public void addAgent(Agent newbie){
        this.agentList.add(newbie);
    }

    public String toString(){
        String toS = "";
        for(int i = 0; i <world.length; i ++){
            for(int j = 0; j<world[i].length; j++){
                if(this.world[i][j] == 0 ){
                    toS += ".";
                }
                else if(this.world[i][j] == 1 ){
                    toS += "A";
                }
            }
            toS += "\n";
        }        
        return toS; 
    }

    public Agent agentAt(int x , int y){
        for(Agent tmp : agentList){
            if(tmp.getX() == x && tmp.getY() == y){
                return tmp;
            }
        }
        return null;
    }

    public int[] getDims(){
        int[] dims = new int[2]; 
        dims[0] = this.width ; 
        dims[1] = this.height;
        return dims;  
    }

    public int[][] getWorld(){
        return this.world;
    }

    public List<Agent> getAgentList() {
        return this.agentList;
    }

    public int getMax_y() {
        return this.height;
    }

    public int getMax_x() {
        return this.width;
    }

}
package mas;
import java.util.Random;


public abstract class Agent{
    protected int posX; 
    protected int posY; 
    protected int dirX; 
    protected int dirY; 
    protected String color; 

    protected Environment env; 


    public Agent(int posX, int posY, int dirX, int dirY, Environment env){
        this.posX = posX; 
        this.posY = posY; 
        this.env = env;
        this.dirX = dirX; 
        this.dirY = dirY; 
        this.color = (new Random().nextBoolean()) ? "G" : "R";
        this.env.addAgent(this);
    }
    
    public abstract void update();

    public abstract void decide();

    public abstract String getColor();
} 
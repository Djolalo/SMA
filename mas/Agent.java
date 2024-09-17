package mas;
import java.util.Random;

import utils.Clipping;


public class Agent{
    private int posX; 
    private int posY; 
    private int dirX; 
    private int dirY; 
    private String color; 

    private Environment env; 


    public Agent(int posX, int posY, int dirX, int dirY, Environment env){
        this.posX = posX; 
        this.posY = posY; 
        this.env = env;
        this.dirX = dirX; 
        this.dirY = dirY; 
        this.color = (new Random().nextBoolean()) ? "G" : "R";
        this.env.addAgent(this);
    }
    
    public void update(){
        //TODO: Implement this graphical method

    }

    public void decide(){
        int[] dims = this.env.getDims();
        int newX, newY; 
        newX = this.getX() + this.getDX();
        newY = this.getY() + this.getDY();
            
        int pos = Clipping.calcule_code(this.posX, this.posY, 0 , 0, dims[0],dims[1]);

        if((pos&1) == 1 || (pos&2)==2){
            this.dirX = -this.dirX;
            newX = this.getX() + this.getDX();
        }
        if((pos & 4)==4 || (pos&8)==8){
            this.dirY = -this.dirY;
            newY = this.getY() + this.getDY();
        }
        Agent bob= this.env.agentAt(newX, newY); 
        if(bob== null || bob == this){
            this.move(newX, newY);

        }
        else{
           this.resolveCollision(bob);
        }
    }

    private void resolveCollision(Agent bob){
        boolean juiDiag = this.dirX != 0 && this.dirY !=0 ; 
        boolean Bobdiag = bob.getDX() != 0 && bob.getDY()!=0;
        if(juiDiag && !Bobdiag){
            handleDiagvsDroit(this, bob);
        }
        else if (!juiDiag && Bobdiag){
            handleDiagvsDroit(bob, this);
        }
        else{
            boolean oppX = this.dirX != 0 && this.dirX == -bob.dirX;
            boolean oppY = this.dirY !=0 && this.dirY == -bob.dirY;
            if(oppX){
                handleHorizontalColl(bob);
            }
            if(oppY){
                handleVerticalColl(bob);
            }
            else{
                deriverMoiEt(bob);
            }
        }
    }

    private void deriverMoiEt(Agent bob){
        if(this.dirX !=  bob.dirX){
            int tmp = bob.dirX; 
            bob.dirX = this.dirX; 
            this.dirX = tmp;
        }
        if(this.dirY != bob.dirY){
            int tmp = bob.dirY;
            bob.dirY = this.dirY; 
            this.dirY = tmp;
        }
    }

    private void handleHorizontalColl(Agent bob){
        this.dirX = -this.dirX; 
        bob.dirX = -bob.dirX;
    }

    private void handleVerticalColl(Agent bob){
        this.dirY = -this.dirY; 
        bob.dirY = -bob.dirY; 
    }

    private void handleDiagvsDroit(Agent diag, Agent Droit){

    }

    private void move(int newX, int  newY ){
        this.setposX(newX);
        this.setposY(newY);
    }
    public int getX(){
        return this.posX;
    }
     
    public int getY(){
        return this.posY;
    }

    public int getDY(){
        return this.dirY;
    }

    public int getDX(){
        return this.dirX;
    }

    public String getColor(){
        return this.color; 
    }
    public void setposX(int posX){
        this.posX = posX;
    }

    public void setposY(int posY){
        this.posY = posY;
    }

    public void setdirX(int dirX){
        this.dirX = dirX;
    }

    public void setDirY(int dirY){
        this.dirY = dirY; 
    }
} 
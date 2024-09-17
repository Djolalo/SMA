package mas;

import mas.Agent; 
import mas.Environment;
import view.MASView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public class MAS{

    private PropertyChangeSupport supp; 
    private List<Agent> agentList;
    private Environment env;
    private int width; 
    private int height;

    public MAS(int height, int width, int nbAgents){
        Random rng = new Random();
        this.env = new Environment(width, height);
        this.agentList = new ArrayList<>();
        this.supp = new PropertyChangeSupport(this);
        for(int i = 0; i< nbAgents; i++){
            this.agentList.add(new Agent(rng.nextInt(width), rng.nextInt(width), rng.nextInt(2)-1, rng.nextInt(2)-1, this.env));
        }
    }

    public void run(){

        for(Agent pat : agentList){
            pat.decide();
        }
        this.supp.firePropertyChange("agents", null, agentList);

    }

    public Environment getEnv() {
        return this.env;
    }

    public void addChangeListener(PropertyChangeListener listener) {
        supp.addPropertyChangeListener(listener);
    }
}
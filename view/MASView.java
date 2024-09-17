package view;

import mas.MAS;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Properties;

public class MASView extends JPanel implements PropertyChangeListener {

    private MAS mas;
    // Size of a square
    private int SQUARE_SIZE;
    // Number of rows (range for y)
    private int NUM_ROWS;
    // number of columns (range for x)
    private int NUM_COLS ;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (this.mas == (MAS)evt.getSource()) {
            repaint();
        }
    }

    private void drawAgent(Graphics g, int col, int row, String color) {
        // Define the particle color
        if (color.equals("G")){
            g.setColor(Color.GRAY);
        }else {
            g.setColor(Color.RED);
        }
        //  circle centred in the square
        g.fillOval(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }

    public MASView(MAS mas, Properties p) {
        this.mas = mas;
        mas.addChangeListener(this);
        this.NUM_ROWS = mas.getEnv().getMax_y();
        this.NUM_COLS = mas.getEnv().getMax_x();
        try {
            this.SQUARE_SIZE = Integer.parseInt(p.getProperty("view.boxSize"));
        }catch(NumberFormatException nfe){
            this.SQUARE_SIZE = 10 ;
        }
        this.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int row=0; row<NUM_ROWS; row++){
            for(int col=0; col<NUM_COLS; col++){
                g.setColor(Color.WHITE);
                g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                if (mas.getEnv().agentAt(col,row)!=null){
                    this.drawAgent(g, col, row, mas.getEnv().agentAt(col,row).getColor());
                }
            }
        }
    }

    // JPanel size to suit the environment
    public Dimension getPreferredSize() {
        return new Dimension(NUM_COLS * SQUARE_SIZE, NUM_ROWS * SQUARE_SIZE);
    }
}

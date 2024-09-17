package view;

import mas.MAS;

import javax.swing.*;
//import java.awt.event.*;
import java.util.Properties;

public class MASFrame extends JFrame{

    public MASFrame(MAS mas, Properties p){
        super("MAS visualization") ;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add observer
        MASView myView = new MASView(mas,p);

        this.setContentPane(new JScrollPane(myView));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}

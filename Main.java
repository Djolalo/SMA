import mas.MAS;
import view.MASFrame;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Créer une configuration pour la vue
        Properties viewProps = new Properties();
        viewProps.setProperty("view.boxSize", "20"); // Chaque case = 20 pixels d'aire

        MAS mas = new MAS(50, 80, 1000);

        MASFrame frame = new MASFrame(mas, viewProps);

        while(true) {
            mas.run(); 
            frame.repaint();
            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

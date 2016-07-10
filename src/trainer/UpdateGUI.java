/*
 *  Project name: Biometrija_Klika_Trainer_DIPLOMSKI/UpdateGUI.java
 *  Author & email: Mirza Suljić <mirza.suljic.ba@gmail.com>
 *  Date & time: Mar 23, 2016, 2:34:49 AM
 */
package trainer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mirza Suljić <mirza.suljic.ba@gmail.com>
 */
public class UpdateGUI implements Runnable {
    
    volatile boolean flag = true;
    volatile int clicks;
    JLabel clicksCounter_L;

    public UpdateGUI(int clicks, JLabel clicksCounter_L) {
        this.clicks = clicks;
        this.clicksCounter_L = clicksCounter_L;
    }   
    
    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(UpdateGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateUI();
        } while (flag);
    }
    
    public void updateUI(){
        SwingUtilities.invokeLater(() -> {
            clicksCounter_L.setText(String.valueOf(clicks));
        });
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }    
    
}

/*
 *  Project name: Biometrija_Klika_DIPLOMSKI/Engine.java
 *  Author & email: Mirza Suljić <mirza.suljic.ba@gmail.com>
 *  Date & time: Mar 14, 2016
 */
package trainer;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mirza Suljić <mirza.suljic.ba@gmail.com>
 */
public class Engine {

    private final Brain brain = new Brain();
    private final Global global = new Global();

    public void noteEvent(MouseEvent evt, Profile p, JTextArea jta, long duration) {
        switch (evt.getButton()) {
            case 1:
                // Left click
                p.getEvents().add(0);
                p.getEventLog().add(evt.getWhen());
                p.getClickDurations().add(duration);
                realTimeEventMonitor(jta, 0);
                break;
            case 3:
                // Right click
                p.getEvents().add(1);
                p.getEventLog().add(evt.getWhen());
                p.getClickDurations().add(duration);
                realTimeEventMonitor(jta, 1);
                break;
            default:
                System.out.println("Unsupported click.");
                break;
        }
    }

    public String getWekaResults(Profile p) {
        String set = "";
        int[] bigrams = brain.countBigrams(p.getEvents());
        int[] trigrams = brain.countTrigrams(p.getEvents());
        int[] fourgrams = brain.countFourgrams(p.getEvents());
        for (int temp : bigrams) {
            set += temp + ", ";
        }
        for (int temp : trigrams) {
            set += temp + ", ";
        }
        for (int temp : fourgrams) {
            set += temp + ", ";
        }
        set += brain.avgClickDuration(p.getClickDurations());
        double[] avgBigramDuration = brain.avgBigramDuration(p.getEvents(), p.getClickDurations());
        double[] maxBigramDuration = brain.maxBigramDuration(p.getEvents(), p.getClickDurations());
        double[] minBigramDuration = brain.minBigramDuration(p.getEvents(), p.getClickDurations());
        for (double temp : avgBigramDuration) {
            set += temp + ", ";
        }
        for (double temp : maxBigramDuration) {
            set += temp + ", ";
        }
        for (double temp : minBigramDuration) {
            set += temp + ", ";
        }
        set += p.getName();
        return set;
    }

    public void getResults(Profile p, JTextArea binary, JTextArea consoleNgrams, JTextArea consoleTime, JTextArea consoleDurations) throws NoSuchElementException {
        System.out.println(
                "Events: " + p.getEvents().size()
                + "\nLogs: " + p.getEventLog().size()
                + "\nDurs: " + p.getClickDurations().size()
        );
        binary.setText(brain.printEvents(p.getEvents()));
        int[] count = brain.countOnesZeroes(p.getEvents());
        int[] bigrams = brain.countBigrams(p.getEvents());
        int[] trigrams = brain.countTrigrams(p.getEvents());
        int[] fourgrams = brain.countFourgrams(p.getEvents());
        consoleNgrams.setText(
                "Total 0: " + count[0] + ", total 1: " + count[1]
                + "\n\tBIGRAMS"
                + "\n00: " + bigrams[0]
                + "\n01: " + bigrams[1]
                + "\n10: " + bigrams[2]
                + "\n11: " + bigrams[3]
                + "\n\tTRIGRAMS"
                + "\n000: " + trigrams[0]
                + "\n001: " + trigrams[1]
                + "\n010: " + trigrams[2]
                + "\n100: " + trigrams[3]
                + "\n011: " + trigrams[4]
                + "\n110: " + trigrams[5]
                + "\n101: " + trigrams[6]
                + "\n111: " + trigrams[7]
                + "\n\tFOURGRAMS"
                + "\n0000: " + fourgrams[0]
                + "\n0001: " + fourgrams[1]
                + "\n0010: " + fourgrams[2]
                + "\n0100: " + fourgrams[3]
                + "\n1000: " + fourgrams[4]
                + "\n0011: " + fourgrams[5]
                + "\n0110: " + fourgrams[6]
                + "\n1100: " + fourgrams[7]
                + "\n0101: " + fourgrams[8]
                + "\n1010: " + fourgrams[9]
                + "\n1001: " + fourgrams[10]
                + "\n1101: " + fourgrams[11]
                + "\n1011: " + fourgrams[12]
                + "\n1110: " + fourgrams[13]
                + "\n0111: " + fourgrams[14]
                + "\n1111: " + fourgrams[15]
        );
        double[] avgBigramDuration = brain.avgBigramDuration(p.getEvents(), p.getClickDurations());
        double[] maxBigramDuration = brain.maxBigramDuration(p.getEvents(), p.getClickDurations());
        double[] minBigramDuration = brain.minBigramDuration(p.getEvents(), p.getClickDurations());
        double avgEvtDura = brain.avgClickDuration(p.getClickDurations());
        consoleTime.setText("\tEVENT DURATION (s)"
                + "\nAvg: " + avgEvtDura
                + "\nMax: " + (Collections.max(p.getClickDurations()) / 1000.00)
                + "\nMin: " + (Collections.min(p.getClickDurations()) / 1000.00)
                + "\n\tBIGRAMS' DURATIONS (avg s)"
                + "\n00: " + avgBigramDuration[0]
                + "\n01: " + avgBigramDuration[1]
                + "\n10: " + avgBigramDuration[2]
                + "\n11: " + avgBigramDuration[3]
                + "\n\tBIGRAMS' DURATIONS (max s)"
                + "\n00: " + maxBigramDuration[0]
                + "\n01: " + maxBigramDuration[1]
                + "\n10: " + maxBigramDuration[2]
                + "\n11: " + maxBigramDuration[3]
                + "\n\tBIGRAMS' DURATION (min s)"
                + "\n00: " + minBigramDuration[0]
                + "\n01: " + minBigramDuration[1]
                + "\n10: " + minBigramDuration[2]
                + "\n11: " + minBigramDuration[3]
        );
        brain.printEventAndDuration(p.getEvents(), p.getClickDurations(), consoleDurations);

    }

    public void serialize(Profile p, String path) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = null;
        String filename;
        try {
            if (p.getName().contains(".bioclick")) {
                filename = p.getName().replace(".bioclick", "");
            } else {
                filename = p.getName();
            }
            FileOutputStream fout = new FileOutputStream(path + filename + ".bioclick");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(p);
        } catch (Exception ex) {
            System.out.println("ERROR: Engine.serialize()" + ex);
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    public Profile deserialize(String name, String path) throws IOException {
        Profile temp = null;
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream(path);
            objectinputstream = new ObjectInputStream(streamIn);
            temp = (Profile) objectinputstream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("ERROR: Engine.deserialize()" + ex);
        } finally {
            if (objectinputstream != null) {
                objectinputstream.close();
            }
        }
        return temp;
    }

    private void realTimeEventMonitor(JTextArea jta, int event) {
        SwingUtilities.invokeLater(() -> {
            jta.append("*");
            jta.setCaretPosition(jta.getDocument().getLength());
        });
    }

    public boolean fileExists(String path, String name) {
        System.out.println(path);
        boolean exists = false;
        File[] listOfFiles = new File(path).listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && (listOfFiles[i].getName().equals(name) || listOfFiles[i].getName().replace(".bioclick", "").equals(name))) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public List readProfileDirectory(JLabel directory) throws IOException {
        List<Profile> allProfiles = new ArrayList();
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showOpenDialog(null);
        directory.setText(jfc.getSelectedFile().getPath());
        directory.setToolTipText(jfc.getSelectedFile().getPath());
        
        for (int i = 0; i < jfc.getSelectedFile().listFiles().length; i++) {
            if (jfc.getSelectedFile().listFiles()[i].getName().contains(global.getExtension())) {                
                allProfiles.add(
                        deserialize(
                                jfc.getSelectedFile().listFiles()[i].getName(), 
                                jfc.getSelectedFile().listFiles()[i].getPath()
                        )
                );
            }
        }
        return allProfiles;
    }
}

/*
 *  Project name: Biometrija_Klika_DIPLOMSKI/GUI.java
 *  Author & email: Mirza Suljić <mirza.suljic.ba@gmail.com>
 *  Date & time: Mar 14, 2016
 */
package trainer;

import export.WekaExporter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mirza Suljić <mirza.suljic.ba@gmail.com>
 */
public class GUI extends javax.swing.JFrame {

    private Timer timer;
    private Profile activeProfile;
    private final Thread t;
    private final UpdateGUI updater;
    private final Engine engine = new Engine();
    private final JFileChooser jfc = new JFileChooser();

    private final Global global = new Global();

    private int remainingTime = global.getTestDuration();
    private int clicks = 0;
    private long mousePress;
    private long mouseRelease;

    /**
     * Creates new form GUI
     *
     * @throws java.io.IOException
     */
    public GUI() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        timer_L.setText(String.valueOf(new Global().getTestDuration()));
        jfc.setFileFilter(
                new FileNameExtensionFilter(
                        "Biometric file",
                        global.getExtension().replace(".", "")
                )
        );
        updater = new UpdateGUI(clicks, totalClicks_L);
        t = new Thread(updater);
        t.start();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        totalClicks_L = new javax.swing.JLabel();
        clickPane_P = new javax.swing.JPanel();
        timer_L = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consoleNgrams_TA = new javax.swing.JTextArea();
        analyze_B = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        activeProfile_L = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consoleBinary_TA = new javax.swing.JTextArea();
        resetTimer_B = new javax.swing.JButton();
        replay_B = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        consoleTime_TA = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        consoleDuration_TA = new javax.swing.JTextArea();
        menubar_MB = new javax.swing.JMenuBar();
        file_M = new javax.swing.JMenu();
        newProfile_MI = new javax.swing.JMenuItem();
        loadProfile_MI = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        save_MI = new javax.swing.JMenuItem();
        saveAs_MI = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        exportWekaSet = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exit_MI = new javax.swing.JMenuItem();
        edit_M = new javax.swing.JMenu();
        renameProfile_MI = new javax.swing.JMenuItem();
        resetProfile_MI = new javax.swing.JMenuItem();
        about_M = new javax.swing.JMenu();
        about_MI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biometrija Niza Klikova - Mirza Suljić 210020/2012, FRI 2016, Univerzitet Sinergija");
        setMinimumSize(new java.awt.Dimension(690, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total clicks:");

        totalClicks_L.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalClicks_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalClicks_L.setText("0");
        totalClicks_L.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        clickPane_P.setBackground(new java.awt.Color(102, 102, 102));
        clickPane_P.setBorder(javax.swing.BorderFactory.createTitledBorder("CLICK HERE!"));
        clickPane_P.setToolTipText("Click here");
        clickPane_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clickPane_PMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clickPane_PMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout clickPane_PLayout = new javax.swing.GroupLayout(clickPane_P);
        clickPane_P.setLayout(clickPane_PLayout);
        clickPane_PLayout.setHorizontalGroup(
            clickPane_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        clickPane_PLayout.setVerticalGroup(
            clickPane_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        timer_L.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        timer_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer_L.setText("10");
        timer_L.setToolTipText("");
        timer_L.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Timer(s):");

        consoleNgrams_TA.setEditable(false);
        consoleNgrams_TA.setColumns(20);
        consoleNgrams_TA.setLineWrap(true);
        consoleNgrams_TA.setRows(5);
        consoleNgrams_TA.setText("INSTRUCTIONS: \n1. Click \"File\\New profile...\" or press CTRL+N\n\n2. Give your profile a name.\n\n3. Simply start clicking in the gray box. Use either RIGHT or LEFT clicks and try to click as much as possible for more accurate results.\n\n4. Don't forget to save the data (\"File\\Save\" or CTRL+S).");
        consoleNgrams_TA.setWrapStyleWord(true);
        consoleNgrams_TA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "nGrams", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane1.setViewportView(consoleNgrams_TA);

        analyze_B.setText("Analyze data");
        analyze_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyze_BActionPerformed(evt);
            }
        });

        jLabel4.setText("Active profile:");

        activeProfile_L.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        activeProfile_L.setText("none");

        consoleBinary_TA.setEditable(false);
        consoleBinary_TA.setColumns(20);
        consoleBinary_TA.setLineWrap(true);
        consoleBinary_TA.setRows(5);
        jScrollPane2.setViewportView(consoleBinary_TA);

        resetTimer_B.setText("Reset timer");
        resetTimer_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTimer_BActionPerformed(evt);
            }
        });

        replay_B.setText("Replay profile");
        replay_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replay_BActionPerformed(evt);
            }
        });

        consoleTime_TA.setEditable(false);
        consoleTime_TA.setColumns(20);
        consoleTime_TA.setLineWrap(true);
        consoleTime_TA.setRows(5);
        consoleTime_TA.setWrapStyleWord(true);
        consoleTime_TA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time Analysis", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane3.setViewportView(consoleTime_TA);

        consoleDuration_TA.setEditable(false);
        consoleDuration_TA.setColumns(20);
        consoleDuration_TA.setLineWrap(true);
        consoleDuration_TA.setRows(5);
        consoleDuration_TA.setWrapStyleWord(true);
        consoleDuration_TA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Durations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane4.setViewportView(consoleDuration_TA);

        file_M.setText("File");

        newProfile_MI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newProfile_MI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.png"))); // NOI18N
        newProfile_MI.setText("New profile...");
        newProfile_MI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProfile_MIActionPerformed(evt);
            }
        });
        file_M.add(newProfile_MI);

        loadProfile_MI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        loadProfile_MI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/load.gif"))); // NOI18N
        loadProfile_MI.setText("Load profile...");
        loadProfile_MI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadProfile_MIActionPerformed(evt);
            }
        });
        file_M.add(loadProfile_MI);
        file_M.add(jSeparator1);

        save_MI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save_MI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        save_MI.setText("Save");
        save_MI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_MIActionPerformed(evt);
            }
        });
        file_M.add(save_MI);

        saveAs_MI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAs_MI.setText("Save as...");
        saveAs_MI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAs_MIActionPerformed(evt);
            }
        });
        file_M.add(saveAs_MI);

        jMenu1.setText("Export");

        exportWekaSet.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        exportWekaSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/weka.png"))); // NOI18N
        exportWekaSet.setText("Weka Set");
        exportWekaSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportWekaSetActionPerformed(evt);
            }
        });
        jMenu1.add(exportWekaSet);

        file_M.add(jMenu1);
        file_M.add(jSeparator2);

        exit_MI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exit_MI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/quit.png"))); // NOI18N
        exit_MI.setText("Exit");
        exit_MI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_MIActionPerformed(evt);
            }
        });
        file_M.add(exit_MI);

        menubar_MB.add(file_M);

        edit_M.setText("Edit");

        renameProfile_MI.setText("Rename profile...");
        renameProfile_MI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameProfile_MIActionPerformed(evt);
            }
        });
        edit_M.add(renameProfile_MI);

        resetProfile_MI.setText("Reset profile");
        resetProfile_MI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetProfile_MIActionPerformed(evt);
            }
        });
        edit_M.add(resetProfile_MI);

        menubar_MB.add(edit_M);

        about_M.setText("About");

        about_MI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        about_MI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info.gif"))); // NOI18N
        about_MI.setText("About this project...");
        about_MI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_MIActionPerformed(evt);
            }
        });
        about_M.add(about_MI);

        menubar_MB.add(about_M);

        setJMenuBar(menubar_MB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activeProfile_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(analyze_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(replay_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(clickPane_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timer_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalClicks_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resetTimer_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(activeProfile_L))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clickPane_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resetTimer_B)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timer_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalClicks_L, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(analyze_B)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(replay_B)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analyze_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyze_BActionPerformed
        try {
            engine.getResults(activeProfile,
                    consoleBinary_TA,
                    consoleNgrams_TA,
                    consoleTime_TA,
                    consoleDuration_TA
            );
        } catch (ArithmeticException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null,
                    "No profile loaded or the profile is "
                    + "incompatible with this version.",
                    "No data",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("ERROR: " + ex);
        } catch (NoSuchElementException ex) {
            System.out.println("NSEE: " + ex);
        }
    }//GEN-LAST:event_analyze_BActionPerformed

    private void clickPane_PMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickPane_PMousePressed
        if (activeProfile != null) {
            if (timer == null) {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        timer_L.setText(String.valueOf(remainingTime--));
                        if (Integer.parseInt(timer_L.getText()) == 0) {
                            timer.cancel();
                            timer.purge();
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Training complete!",
                                    "Complete",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            save_MI.doClick();
                        }
                    }
                }, 0, 1000);
            }
            mousePress = evt.getWhen();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Unable to start, no active profile.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_clickPane_PMousePressed

    private void clickPane_PMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickPane_PMouseReleased
        mouseRelease = evt.getWhen();
        try {
            if (remainingTime > 0) {
                engine.noteEvent(evt, activeProfile, consoleBinary_TA, (mouseRelease - mousePress));
                clicks++;
                updater.setClicks(clicks);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Profile not loaded.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_clickPane_PMouseReleased

    private void resetTimer_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetTimer_BActionPerformed
        timer_L.setText(String.valueOf(global.getTestDuration()));
        remainingTime = global.getTestDuration();
        timer = null;
    }//GEN-LAST:event_resetTimer_BActionPerformed

    private void newProfile_MIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProfile_MIActionPerformed
        int result = jfc.showSaveDialog(null);
        if (result != JFileChooser.CANCEL_OPTION) {
            try {
                if (engine.fileExists(jfc.getSelectedFile().getPath().replace(jfc.getSelectedFile().getName(), ""), jfc.getSelectedFile().getName())) {
                    int dialogResult = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure you want to overwrite profile " + jfc.getSelectedFile().getName().replace(".bioclick", "") + "?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        activeProfile = new Profile(jfc.getSelectedFile().getName().replace(".bioclick", ""), jfc.getCurrentDirectory().getPath() + "\\");
                        engine.serialize(activeProfile, activeProfile.getPath());
                        activeProfile_L.setText(jfc.getSelectedFile().getName());
                        clicks = 0;
                        updater.setClicks(clicks);
                        consoleDuration_TA.setText("");
                        consoleNgrams_TA.setText("");
                        consoleTime_TA.setText("");
                        consoleBinary_TA.setText("");
                    }
                } else {
                    activeProfile = new Profile(jfc.getSelectedFile().getName(), jfc.getCurrentDirectory().getPath() + "\\");
                    engine.serialize(activeProfile, activeProfile.getPath());
                    activeProfile_L.setText(jfc.getSelectedFile().getName());
                    clicks = 0;
                    updater.setClicks(clicks);
                    consoleDuration_TA.setText("");
                    consoleNgrams_TA.setText("");
                    consoleTime_TA.setText("");
                    consoleBinary_TA.setText("");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Unable to save new profile.", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Unable to save new profile without name.", "No name", JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_newProfile_MIActionPerformed

    private void save_MIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_MIActionPerformed
        if (activeProfile != null) {
            try {
                engine.serialize(activeProfile, activeProfile.getPath());
                JOptionPane.showMessageDialog(null, "Your profile has been saved to\n" + activeProfile.getPath() + activeProfile.getName() + global.getExtension(), "Profile saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_save_MIActionPerformed

    private void loadProfile_MIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadProfile_MIActionPerformed
        int result = jfc.showOpenDialog(null);
        if (result != JFileChooser.CANCEL_OPTION) {
            if (jfc.getSelectedFile().getName().contains(".bioclick")) {
                try {
                    activeProfile = engine.deserialize(jfc.getSelectedFile().getName(), jfc.getSelectedFile().getAbsolutePath());
                    clicks = activeProfile.getEvents().size();
                    activeProfile_L.setText(activeProfile.getName());
                    updater.setClicks(activeProfile.getEvents().size());
                    analyze_B.doClick();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Profile '" + jfc.getSelectedFile().getName() + "' not found.", "No name", JOptionPane.WARNING_MESSAGE);
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "No name profile name provided, unable to load profile.", "No name", JOptionPane.WARNING_MESSAGE);
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Unsupported file format.", "Wrong format", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_loadProfile_MIActionPerformed

    private void saveAs_MIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAs_MIActionPerformed
        newProfile_MI.doClick();
    }//GEN-LAST:event_saveAs_MIActionPerformed

    private void exit_MIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_MIActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(
                null,
                "Have you saved your profile's data?",
                "Save data",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exit_MIActionPerformed

    private void about_MIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_MIActionPerformed
        JOptionPane.showMessageDialog(
                null,
                "Sinergija University, Faculty of Computing and Informatics\n"
                + "Subject: Information System Security\n\n"
                + "Student: Mirza Suljić 210020/2012\n"
                + "Mentor: Saša Adamović\n\n"
                + "Bijeljina, 2016\n",
                "About",
                JOptionPane.PLAIN_MESSAGE
        );
    }//GEN-LAST:event_about_MIActionPerformed

    private void replay_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replay_BActionPerformed
        JOptionPane.showMessageDialog(null, "In development!\nThis option will enable users to replay their test in realtime.", "Replay", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_replay_BActionPerformed

    private void renameProfile_MIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameProfile_MIActionPerformed
        JOptionPane.showMessageDialog(null, "In development!\nThis option will enable users to rename their profiles.", "Rename", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_renameProfile_MIActionPerformed

    private void resetProfile_MIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetProfile_MIActionPerformed
        JOptionPane.showMessageDialog(null, "In development!\nThis option will enable users to reset their profiles.", "Reset", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_resetProfile_MIActionPerformed

    private void exportWekaSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportWekaSetActionPerformed
        WekaExporter weka = new WekaExporter();
        weka.setVisible(true);
    }//GEN-LAST:event_exportWekaSetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GUI().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu about_M;
    private javax.swing.JMenuItem about_MI;
    private javax.swing.JLabel activeProfile_L;
    private javax.swing.JButton analyze_B;
    private javax.swing.JPanel clickPane_P;
    private javax.swing.JTextArea consoleBinary_TA;
    private javax.swing.JTextArea consoleDuration_TA;
    private javax.swing.JTextArea consoleNgrams_TA;
    private javax.swing.JTextArea consoleTime_TA;
    private javax.swing.JMenu edit_M;
    private javax.swing.JMenuItem exit_MI;
    private javax.swing.JMenuItem exportWekaSet;
    private javax.swing.JMenu file_M;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem loadProfile_MI;
    private javax.swing.JMenuBar menubar_MB;
    private javax.swing.JMenuItem newProfile_MI;
    private javax.swing.JMenuItem renameProfile_MI;
    private javax.swing.JButton replay_B;
    private javax.swing.JMenuItem resetProfile_MI;
    private javax.swing.JButton resetTimer_B;
    private javax.swing.JMenuItem saveAs_MI;
    private javax.swing.JMenuItem save_MI;
    private javax.swing.JLabel timer_L;
    private javax.swing.JLabel totalClicks_L;
    // End of variables declaration//GEN-END:variables
}

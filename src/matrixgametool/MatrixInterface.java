/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixgametool;

import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.UnboundedSolutionException;

/**
 *
 * @author mjw
 */
public class MatrixInterface extends javax.swing.JFrame {

    /**
     * Creates new form MatrixInterface
     */
    public MatrixInterface() {
        model = new PayoffMatrix(3);
        initComponents();
    }
    
    private PayoffMatrix model;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        gameTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        runButton = new javax.swing.JButton();
        p2StrategySet = new javax.swing.JPanel();
        p1StrategySet = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();
        loadGameMenuItem = new javax.swing.JMenuItem();
        saveGameMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        populateOptimalMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matrix Game Tool");

        gameTable.setModel(model);
        jScrollPane2.setViewportView(gameTable);

        jLabel1.setText("P1 Strategy");

        jLabel2.setText("P2 Strategy");

        runButton.setText("RUN");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        initFields2(3);

        javax.swing.GroupLayout p2StrategySetLayout = new javax.swing.GroupLayout(p2StrategySet);
        p2StrategySet.setLayout(p2StrategySetLayout);
        p2StrategySetLayout.setHorizontalGroup(
            p2StrategySetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        p2StrategySetLayout.setVerticalGroup(
            p2StrategySetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        p2StrategySet.setLayout(new BoxLayout(p2StrategySet, BoxLayout.X_AXIS));

        initFields1(3);

        javax.swing.GroupLayout p1StrategySetLayout = new javax.swing.GroupLayout(p1StrategySet);
        p1StrategySet.setLayout(p1StrategySetLayout);
        p1StrategySetLayout.setHorizontalGroup(
            p1StrategySetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );
        p1StrategySetLayout.setVerticalGroup(
            p1StrategySetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        p1StrategySet.setLayout(new BoxLayout(p1StrategySet, BoxLayout.X_AXIS));

        jMenu1.setText("File");

        newGameMenuItem.setText("New Game...");
        newGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(newGameMenuItem);

        loadGameMenuItem.setText("Load Game...");
        loadGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadGameMenuItem);

        saveGameMenuItem.setText("Save Game...");
        saveGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveGameMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Game");

        populateOptimalMenuItem.setText("Populate Optimal");
        populateOptimalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populateOptimalMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(populateOptimalMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2StrategySet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p1StrategySet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1StrategySet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2StrategySet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(runButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private JTextField[] fields1;
    private JTextField[] fields2;
    
    private void initFields1(int size) {
        fields1 = new JTextField[size];
        for(int i=0; i<size; i++)
            fields1[i] = new JTextField();
        addFields(p1StrategySet, fields1);
    }
    
    private void initFields2(int size) {
        fields2 = new JTextField[size];
        for(int i=0; i<size; i++)
            fields2[i] = new JTextField();
        addFields(p2StrategySet, fields2);
    }
    
    private void addFields(JComponent component, JTextField[] fields) {
        component.removeAll();
        for(JTextField field : fields)
            component.add(field);
    }
    
    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        //todo: input strategy sets
        double[] p1Strats = new double[3];
        double[] p2Strats = new double[3];
        for(int i=0; i<3; i++) {
            p1Strats[i] = Double.parseDouble(fields1[i].getText());
            p2Strats[i] = Double.parseDouble(fields2[i].getText());
        }
        double value = model.runGame(p1Strats, p2Strats, 100);
        JOptionPane.showMessageDialog(this, "The payoff is "+value, "Result", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_runButtonActionPerformed

    private void loadGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".game") || file.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Matrix Game files";
            }
        });
        int choice = chooser.showOpenDialog(this);
        if(choice == JFileChooser.APPROVE_OPTION) {
            model = PayoffMatrix.load(chooser.getSelectedFile());
            gameTable.setModel(model);
        }
    }//GEN-LAST:event_loadGameMenuItemActionPerformed

    private void saveGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".game") || file.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Matrix Game files";
            }
        });
        int choice = chooser.showOpenDialog(this);
        if(choice == JFileChooser.APPROVE_OPTION) {
            model.save(chooser.getSelectedFile());
        }
    }//GEN-LAST:event_saveGameMenuItemActionPerformed

    private void populateOptimalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populateOptimalMenuItemActionPerformed
        try {
            PointValuePair primal = model.calculatePrimal();
            PointValuePair dual = model.calculateDual();
            for(int i=0; i<fields1.length; i++){
                fields1[i].setText(""+primal.getPoint()[i+2]);
            }
            for(int i=0; i<fields2.length; i++){
                fields2[i].setText(""+dual.getPoint()[i+2]);
            }
        } catch (UnboundedSolutionException e) {
            JOptionPane.showMessageDialog(this, "This game is unbounded", "Unbounded Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_populateOptimalMenuItemActionPerformed

    private void newGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameMenuItemActionPerformed
        String response = JOptionPane.showInputDialog("Enter the size of the matrix");
        try {
            int size = Integer.parseInt(response);
            model = new PayoffMatrix(size);
            gameTable.setModel(model);
            initFields1(size);
            initFields2(size);
            pack();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Not a number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newGameMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gameTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadGameMenuItem;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JPanel p1StrategySet;
    private javax.swing.JPanel p2StrategySet;
    private javax.swing.JMenuItem populateOptimalMenuItem;
    private javax.swing.JButton runButton;
    private javax.swing.JMenuItem saveGameMenuItem;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixgametool;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mjw
 */
public class StrategySetPanel extends JPanel {
    
    public StrategySetPanel(int choices) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        for(int i=0; i<choices; i++) {
            this.add(new JTextField());
        }
        this.repaint();
        this.setVisible(true);
    }
}

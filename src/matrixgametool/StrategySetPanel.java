/*
 * Copyright (C) 2016 mjw
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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

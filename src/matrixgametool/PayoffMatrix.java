/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixgametool;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Models a payoff Matrix in a 2 player matrix game.
 * @author mjw
 */
public class PayoffMatrix implements TableModel {
    
    private final double[][] values;
    
    private final ArrayList<TableModelListener> listeners;
    
    public PayoffMatrix(int size) {
        this.values = new double[size][size];
        listeners = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return values.length;
    }

    @Override
    public int getColumnCount() {
        return values.length;
    }

    @Override
    public String getColumnName(int i) {
        return "x"+i;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return Double.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return values[i][i1];
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        values[i][i1] = (double) o;
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        listeners.add(tl);
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        listeners.remove(tl);
    }
    
    /**
     * Run this matrix game and accumulate the payoff
     * @param x the strategy set of player 1
     * @param y the strategy set of player 2
     * @param runs the number of times to play the game
     * @return the total payoff of the runs (positive indicates a gain for player 1)
     */
    public double runGame(double[] x, double[] y, int runs) {
        double payoff = 0.0;
        Random rng = new Random();
        for(int i=0; i<runs; i++) {
            double xgen = rng.nextDouble();
            double ygen = rng.nextDouble();
            int xstrat = 0;
            int ystrat = 0;
            for(int j=0; j<x.length; j++) {
                if(x[j]>xgen) {
                    xstrat = j;
                    break;
                } else {
                    xgen -= x[j];
                }
            }
            for(int j=0; j<y.length; j++) {
                if(y[j]>ygen) {
                    ystrat = j;
                    break;
                } else {
                    ygen -= y[j];
                }
            }
            payoff += values[xstrat][ystrat];
        }
        return payoff;
    }
    
}

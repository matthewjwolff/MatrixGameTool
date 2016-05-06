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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

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
    
    public PayoffMatrix(double[][] values) {
        this.values = values;
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
    
    //TODO: variable number of parameters
    public PointValuePair calculatePrimal() {
        SimplexSolver solver = new SimplexSolver();
        //All variables are nonnegative
        NonNegativeConstraint nonneg = new NonNegativeConstraint(true);
        //objective function is of the form MAX w+ - w- (+0x1,etc)
        LinearObjectiveFunction objective = new LinearObjectiveFunction(new double[] {1.0, -1.0, 0.0,0.0,0.0}, 0.0);
        ArrayList<LinearConstraint> constraints = new ArrayList<>();
        //probabilities must sum to 1.0
        double[] probabilityConstraint = new double[values.length + 2];
        probabilityConstraint[0] = probabilityConstraint[1] = 0.0;
        for(int i=2; i<probabilityConstraint.length; i++)
            probabilityConstraint[i]=1.0;
        constraints.add(new LinearConstraint(probabilityConstraint, Relationship.EQ, 1.0));
        //input game parameters
        //constraints supports two-sided equation
        double[] wConstraint = new double[values.length + 2];
        wConstraint[0] = 1.0;
        wConstraint[1] = -1.0;
        for(int i=0; i<values.length; i++) {
            double[] constr = new double[values.length+2];
            for(int j=2; j<constr.length; j++)
                constr[j]=values[i][j-2];
            constraints.add(new LinearConstraint(wConstraint, 0.0, Relationship.LEQ, constr, 0.0));
        }
        LinearConstraintSet constraintSet = new LinearConstraintSet(constraints);
        PointValuePair optimal = solver.optimize(objective, nonneg, constraintSet, GoalType.MAXIMIZE);
        return optimal;
    }
    
    public PointValuePair calculateDual() {
        SimplexSolver solver = new SimplexSolver();
        //All variables are nonnegative
        NonNegativeConstraint nonneg = new NonNegativeConstraint(true);
        //objective function is of the form MAX w+ - w- (+0x1,etc)
        LinearObjectiveFunction objective = new LinearObjectiveFunction(new double[] {1.0, -1.0, 0.0,0.0,0.0}, 0.0);
        ArrayList<LinearConstraint> constraints = new ArrayList<>();
        //probabilities must sum to 1.0
        double[] probabilityConstraint = new double[values.length + 2];
        probabilityConstraint[0] = probabilityConstraint[1] = 0.0;
        for(int i=2; i<probabilityConstraint.length; i++)
            probabilityConstraint[i]=1.0;
        constraints.add(new LinearConstraint(probabilityConstraint, Relationship.EQ, 1.0));
        //input game parameters
        //constraints supports two-sided equation
        double[] wConstraint = new double[values.length +2];
        wConstraint[0] = 1.0;
        wConstraint[1] = -1.0;
        for(int i=0; i<values.length; i++) {
            double[] constr = new double[values.length+2];
            for(int j=2; j<constr.length; j++)
                constr[j]=values[j-2][i];
            constraints.add(new LinearConstraint(wConstraint, 0.0, Relationship.GEQ, constr, 0.0));
        }
//        constraints.add(new LinearConstraint(new double[] {1.0,-1.0,0.0,0.0,0.0}, 0.0, Relationship.GEQ, new double[] {0.0,0.0,values[0][0],values[1][0],values[2][0]}, 0.0));
//        constraints.add(new LinearConstraint(new double[] {1.0,-1.0,0.0,0.0,0.0}, 0.0, Relationship.GEQ, new double[] {0.0,0.0,values[0][1],values[1][1],values[2][1]}, 0.0));
//        constraints.add(new LinearConstraint(new double[] {1.0,-1.0,0.0,0.0,0.0}, 0.0, Relationship.GEQ, new double[] {0.0,0.0,values[0][2],values[1][2],values[2][2]}, 0.0));
        LinearConstraintSet constraintSet = new LinearConstraintSet(constraints);
        PointValuePair optimal = solver.optimize(objective, nonneg, constraintSet, GoalType.MINIMIZE);
        return optimal;
    }
    
    public void save(File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            StringBuilder output = new StringBuilder();
            for(int i=0; i<values.length; i++) {
                for(int j=0; j<values[i].length; j++) {
                    writer.print(values[i][j]+",");
                }
                writer.print(";");
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PayoffMatrix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static PayoffMatrix load(File file) {
        try {
            Scanner scan = new Scanner(file);
            StringBuilder buffer = new StringBuilder();
            while(scan.hasNext())
                buffer.append(scan.nextLine());
            String[] columns = buffer.toString().split(";");
            double[][] values = new double[columns.length][columns.length];
            for(int i=0; i<columns.length; i++) {
                String[] rows = columns[i].split(",");
                values[i] = new double[rows.length];
                for(int j=0; j<rows.length; j++) {
                    values[i][j] = Double.parseDouble(rows[j]);
                }
            }
            return new PayoffMatrix(values);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PayoffMatrix.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

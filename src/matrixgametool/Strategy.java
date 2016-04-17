/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixgametool;

/**
 *
 * @author mjw
 */
public class Strategy {
    
    double[] probabilities;
    
    public Strategy(double[] probabilities) {
        //check values are positive and sum
        double sum = 0;
        for(double num : probabilities) {
            //get better error class...
            if(num<0)
                throw new Error();
            sum+=num;
        }
        if(sum!=1.0)
            throw new Error();
        this.probabilities = probabilities;
    }
}

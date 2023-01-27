package game.classes;

import java.util.Comparator;

public class CompareValeurs implements Comparator<PionStrategique> {

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(PionStrategique pion1, PionStrategique pion2) {
        if(pion1.getValeur() > pion2.getValeur()){
            return -1;
        }else if(pion1.getValeur() < pion1.getValeur()){
            return 1;
        }else{
            return 0;
        } 
    }
}

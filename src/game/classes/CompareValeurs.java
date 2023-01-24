package game.classes;

import java.util.Comparator;

public class CompareValeurs implements Comparator<PionStrategique> {

    @Override
    public int compare(PionStrategique piece1, PionStrategique piece2) {
        if(piece1.getValeur() > piece2.getValeur()) return -1;
        else if(piece1.getValeur() < piece1.getValeur()) return 1;
        else return 0;
    }
}

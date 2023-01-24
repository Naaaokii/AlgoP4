import java.util.ArrayList;
import java.util.Collections;

public class Plateau {
    public static void colone(String[] args) {
        String[] colone = {"0", "0", "0", "0", "0", "0"};
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, colone);

        for (String str: list)
        {
            System.out.println(str);
        }
    }

    public static void lignes(String[] args) {
        String[] ligne = {"0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 "};
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, ligne);
    
        for (String str: list)
        {
            System.out.print(str);
        }
    }
}
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Menu {
    private static Scanner _scan = new Scanner(System.in);
    
        public static void main(String[] args) throws Exception {
    
            while (true) {
                afficherMenu();
                String choix = _scan.nextLine();
                switch (choix) {
                    case "1":
                        Jouer();
                        break;
                    /*case "2":
                        Settings();
                        break;*/
                    case "q":
                        return;
                    default:
                        System.out.println("Mauvaise touche");
                        break;
                }
            }
        }
        
        private static void afficherMenu() {
            ArrayList<String> menus = new ArrayList<>();
            menus.add("     MENU");
            menus.add("1- Jouer");
            /*menus.add("2- Settings");*/
            menus.add("q- Quitter");
            for (String menu : menus) {
                System.out.println(menu);
            }
        }
        
            /*private static void Settings() {
                }*/
        
        private static void Jouer() {
            System.out.println("Choisissez le nombre de joueur");
            /*menus.add("1- 1 joueur");
            menus.add("2- 2 joueurs");*/
            }
    }
    
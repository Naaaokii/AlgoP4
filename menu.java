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
                        String choix2 = _scan.nextLine();
                        switch (choix2) {
                            case "1":
                                JcJ();
                                switch (choix2) {
                                    case "1":
                                        choixClouleur1();
                                        switch (choix2) {
                                            case "1":
                                                Blanc();
                                            break;
                                            case "2":
                                                Bleu();
                                            break;
                                            case "3":
                                                Violet();
                                            break;
                                            case "4":
                                                Vert();
                                            break;
                                            case "5":
                                                Jaune();
                                            break;
                                            case "q":
                                                switch (choix2){};
                                            default:
                                                System.out.println("Mauvaise touche");
                                                break;
                                        }
                                    break;
                                    case "q":
                                        switch (choix){};
                                    default:
                                        System.out.println("Mauvaise touche");
                                        break;
                                }
                            break;
                            case "2":
                                JcIA();
                            break;
                            case "q":
                                switch (choix){};
                            default:
                                System.out.println("Mauvaise touche");
                                break;
                        }
                        break;
                    case "2":
                        Classement();
                        break;
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
            menus.add("\033[37m     MENU");
            menus.add("1- Jouer");
            menus.add("2- Classement");
            menus.add("q- Quitter");
            for (String menu : menus) {
                System.out.println(menu);
            }
        }
        
        /*private static void Settings() {
        }*/
        
        private static void Jouer() {
            /*System.out.println("Choisissez le nombre de joueur");
            menus.add("1- 1 joueur");
            menus.add("2- 2 joueurs");*/
            String choix = _scan.nextLine();
            ArrayList<String> menus = new ArrayList<>();
            menus.add("\033[37m Choisissez le mode de jeu");
            menus.add("1- Joueur contre Joueur");
            menus.add("2- Joueur contre IA");
            menus.add("q- Retour");
            for (String menu : menus) {
                System.out.println(menu);
            }
        }

        private static void Classement() {
            
        }
        
        private static void JcJ() {
            
            System.out.println("\033[37m Saisir le nom du joueur 1 :");
            String joueur1 = _scan.nextLine();
            System.out.println("\033[37m Saisir le nom du joueur 2 :");
            String joueur2 = _scan.nextLine();
            choixClouleur1();
            
        }
        
        private static void JcIA() {
            System.out.println("\033[37m Saisir le nom du joueur :");
            String joueur = _scan.nextLine();
            System.out.println("1- Level 1 :");
            System.out.println("2_ Level 2 :");
            System.out.println("3- Level 3 :");
            System.out.println("4- Level 4 :");
            String choixIa = _scan.nextLine();
        }

        private static void choixClouleur1(){
            String choix = _scan.nextLine();
            ArrayList<String> menusC = new ArrayList<>();
            menusC.add(" Choisissez la couleur du joueur 1");
            menusC.add("\033[37m1- Blanc\033[37m");
            menusC.add("\033[36m2- Bleu\033[37m");
            menusC.add("\033[35m3- Violet\033[37m");
            menusC.add("\033[32m4- Vert\033[37m");
            menusC.add("\033[33m5- Jaune\033[37m");
            menusC.add("q- Retour");
            for (String menu : menusC) {
                System.out.println(menu);
            }
        }
        
        private static void Jaune() {
        }
    
        private static void Vert() {
        }
    
        private static void Violet() {
        }
    
        private static void Bleu() {
        }
    
        private static void Blanc() {
        }
    }
    
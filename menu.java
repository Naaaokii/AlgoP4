import java.util.Scanner;


public class Menu {
    private static Scanner _scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        MenuJeu();
    }

    
    public static void MenuJeu() {
        System.out.println("\033[37m-----Accueil-----");
        System.out.println("1. Joueur contre joueur");
        System.out.println("2. Joueur contre ordinateur");
        System.out.println("3. Ordinateur contre ordinateur");
        System.out.println("4. Classement");
        String choixModeJeu = _scan.nextLine();
        switch(choixModeJeu) {
            case "1":
                JcJ();
                break;
            case "2":
                JcO();
                break;
            case "3":
                OcO();
                break;
            default:
                System.out.println("Erreur");
                break;
        }
    }
    
    private static void JcJ() { 
        System.out.println("\033[37m Saisir le nom du joueur 1 :");
        String joueur1 = _scan.nextLine();
        System.out.println("\033[37m Saisir le nom du joueur 2 :");
        String joueur2 = _scan.nextLine();  
        ChoixSymboleJcJ();
    }
    
    private static void ChoixSymboleJcJ() {
        System.out.println("\033[37m Choisissez un symbole du joueur 1:");
        String SymboleJ1 = _scan.nextLine();
        System.out.println("\033[37m Choisissez un symbole du joueur 2:");
        String SymboleJ2 = _scan.nextLine();
        ChoixCouleurJcJ(); 
        /*recap();*/
    }

    /*private static void recap(String joueur1, String SymboleJ1) {
        System.out.println (joueur1 + " a choisi le symbole " + SymboleJ1);
    }*/

    private static void ChoixCouleurJcJ() {
        System.out.println("\033[37m Choisissez la couleur du joueur 1 :");
        System.out.println("\033[37m1- Blanc\033[37m");
        System.out.println("\033[36m2- Bleu\033[37m");
        System.out.println("\033[35m3- Violet\033[37m");
        System.out.println("\033[32m4- Vert\033[37m");
        System.out.println("\033[33m5- Jaune\033[37m");
        String CouleurJ1 = _scan.nextLine();
        System.out.println("\033[37m Choisissez la couleur du joueur 2 :");
        System.out.println("\033[37m1- Blanc\033[37m");
        System.out.println("\033[36m2- Bleu\033[37m");
        System.out.println("\033[35m3- Violet\033[37m");
        System.out.println("\033[32m4- Vert\033[37m");
        System.out.println("\033[33m5- Jaune\033[37m");
        String CouleurJ2 = _scan.nextLine(); 
    }

    private static void JcO() {
        System.out.println("\033[37m Saisir le nom du joueur :");
        String joueur = _scan.nextLine();
        ChoixSymboleJcO();
    }
    
    private static void ChoixSymboleJcO() {
        System.out.println("\033[37m Choisissez un symbole du joueur :");
        String SymboleJ = _scan.nextLine();
        System.out.println("\033[37m Choisissez un symbole de l'ordinateur :");
        String SymboleO = _scan.nextLine();
        ChoixCouleurJcO();
    }

    private static void ChoixCouleurJcO() {
        System.out.println("\033[37m Choisissez la couleur du joueur :");
        System.out.println("\033[37m1- Blanc\033[37m");
        System.out.println("\033[36m2- Bleu\033[37m");
        System.out.println("\033[35m3- Violet\033[37m");
        System.out.println("\033[32m4- Vert\033[37m");
        System.out.println("\033[33m5- Jaune\033[37m");
        String CouleurJ = _scan.nextLine();
        System.out.println("\033[37m Choisissez la couleur de l'ordinateur :");
        System.out.println("\033[37m1- Blanc\033[37m");
        System.out.println("\033[36m2- Bleu\033[37m");
        System.out.println("\033[35m3- Violet\033[37m");
        System.out.println("\033[32m4- Vert\033[37m");
        System.out.println("\033[33m5- Jaune\033[37m");
        String CouleurO = _scan.nextLine();  
    }

    private static void OcO() {
        ChoixSymboleOcO();
    }

    private static void ChoixSymboleOcO() {
        System.out.println("\033[37m Choisissez un symbole de l'ordinateur 1:");
        String SymboleO1 = _scan.nextLine();
        System.out.println("\033[37m Choisissez un symbole de l'ordinateur 2:");
        String SymboleO2 = _scan.nextLine();
        ChoixCouleurOcO();
    }

    private static void ChoixCouleurOcO() {
        System.out.println("\033[37m Choisissez la couleur de l'ordinateur 1:");
        System.out.println("\033[37m1- Blanc\033[37m");
        System.out.println("\033[36m2- Bleu\033[37m");
        System.out.println("\033[35m3- Violet\033[37m");
        System.out.println("\033[32m4- Vert\033[37m");
        System.out.println("\033[33m5- Jaune\033[37m");
        String CouleurO1 = _scan.nextLine();
        System.out.println("\033[37m Choisissez la couleur de l'ordinateur 2:");
        System.out.println("\033[37m1- Blanc\033[37m");
        System.out.println("\033[36m2- Bleu\033[37m");
        System.out.println("\033[35m3- Violet\033[37m");
        System.out.println("\033[32m4- Vert\033[37m");
        System.out.println("\033[33m5- Jaune\033[37m");
        String CouleurO2 = _scan.nextLine();
    }
}














/* import java.io.FileNotFoundException;
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
                                                ChoixCouleur2();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit la couleur 1");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit la couleur 2");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit la couleur 3");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit la couleur 4");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit la couleur 5");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                            break;
                                            case "2":
                                            ChoixCouleur2();
                                            switch (choix2) {
                                                case "1":
                                                System.out.println("vous avez choisit la couleur 1");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "2":
                                                System.out.println("vous avez choisit la couleur 2");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "3":
                                                System.out.println("vous avez choisit la couleur 3");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "4":
                                                System.out.println("vous avez choisit la couleur 4");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "5":
                                                System.out.println("vous avez choisit la couleur 5");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "q":
                                                    switch (choix2){};
                                                default:
                                                    System.out.println("Mauvaise touche");
                                                break;
                                            }
                                            break;
                                            case "3":
                                                ChoixCouleur2();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit la couleur 1");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit la couleur 2");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit la couleur 3");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit la couleur 4");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit la couleur 5");
                                                    ChoixSymbole1();
                                                    switch (choix2) {
                                                        case "1":
                                                        System.out.println("vous avez choisit le symbole 1");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "2":
                                                        System.out.println("vous avez choisit le symbole 2");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "3":
                                                        System.out.println("vous avez choisit le symbole 3");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "4":
                                                        System.out.println("vous avez choisit le symbole 4");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "5":
                                                        System.out.println("vous avez choisit le symbole 5");
                                                            ChoixSymbole2();
                                                        break;
                                                        case "q":
                                                            switch (choix2){};
                                                        default:
                                                            System.out.println("Mauvaise touche");
                                                        break;
                                                    }
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                            break;
                                            case "4":
                                            ChoixCouleur2();
                                            switch (choix2) {
                                                case "1":
                                                System.out.println("vous avez choisit la couleur 1");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "2":
                                                System.out.println("vous avez choisit la couleur 2");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "3":
                                                System.out.println("vous avez choisit la couleur 3");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "4":
                                                System.out.println("vous avez choisit la couleur 4");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "5":
                                                System.out.println("vous avez choisit la couleur 5");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "q":
                                                    switch (choix2){};
                                                default:
                                                    System.out.println("Mauvaise touche");
                                                break;
                                            }
                                            break;
                                            case "5":
                                            ChoixCouleur2();
                                            switch (choix2) {
                                                case "1":
                                                System.out.println("vous avez choisit la couleur 1");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "2":
                                                System.out.println("vous avez choisit la couleur 2");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "3":
                                                System.out.println("vous avez choisit la couleur 3");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "4":
                                                System.out.println("vous avez choisit la couleur 4");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "5":
                                                System.out.println("vous avez choisit la couleur 5");
                                                ChoixSymbole1();
                                                switch (choix2) {
                                                    case "1":
                                                    System.out.println("vous avez choisit le symbole 1");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "2":
                                                    System.out.println("vous avez choisit le symbole 2");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "3":
                                                    System.out.println("vous avez choisit le symbole 3");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "4":
                                                    System.out.println("vous avez choisit le symbole 4");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "5":
                                                    System.out.println("vous avez choisit le symbole 5");
                                                        ChoixSymbole2();
                                                    break;
                                                    case "q":
                                                        switch (choix2){};
                                                    default:
                                                        System.out.println("Mauvaise touche");
                                                    break;
                                                }
                                                break;
                                                case "q":
                                                    switch (choix2){};
                                                default:
                                                    System.out.println("Mauvaise touche");
                                                break;
                                            }
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
        
        private static void Jouer() {
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
            System.out.println("\033[37m Choisissez la couleur du joueur 1 :");
            System.out.println("\033[37m1- Blanc\033[37m");
            System.out.println("\033[36m2- Bleu\033[37m");
            System.out.println("\033[35m3- Violet\033[37m");
            System.out.println("\033[32m4- Vert\033[37m");
            System.out.println("\033[33m5- Jaune\033[37m");
            String choixCouleurJ1 = _scan.nextLine();
        }
        
        private static void ChoixCouleur2() {
            System.out.println("\033[37m Choisissez la couleur du joueur 2 :");
            System.out.println("\033[37m1- Blanc\033[37m");
            System.out.println("\033[36m2- Bleu\033[37m");
            System.out.println("\033[35m3- Violet\033[37m");
            System.out.println("\033[32m4- Vert\033[37m");
            System.out.println("\033[33m5- Jaune\033[37m");
            String choixCouleurJ2 = _scan.nextLine();
        }
        
        private static void ChoixSymbole1() {
            System.out.println("\033[37m Choix du symbole du Joueur 1 :");
            System.out.println("1- @");
            System.out.println("2- =");
            System.out.println("3- &");
            System.out.println("4- $");
            System.out.println("5- €");
            String choixSymb1 = _scan.nextLine();
        }
        
        private static void ChoixSymbole2() {
            System.out.println("\033[37m Choix du symbole du Joueur 2 :");
            System.out.println("1- @");
            System.out.println("2- =");
            System.out.println("3- &");
            System.out.println("4- $");
            System.out.println("5- €");
            String choixSymb2 = _scan.nextLine();
        }
    }  */  
import javax.swing.JOptionPane;

import app.net.resource.Menu;
import app.net.wordQualifier.WordQualifier;

public class App {
    static final WordQualifier qualifier = new WordQualifier();

    public static void main(String[] args) throws Exception {
        boolean exist = true;
        String option = "";

        Menu menu = new Menu();
        while (exist) {
            option = menu.getMenu();
            switch (option) {
                case "1":
                AddWord();
                    break;
            }
        }
    }

    public static void AddWord() {
        
            String wordToAdd = JOptionPane.showInputDialog(null, "introduzca la palabra");
            qualifier.addWord(wordToAdd);
            JOptionPane.showMessageDialog(null, "la palabra se ha agregado correctamente");
        } 

    }



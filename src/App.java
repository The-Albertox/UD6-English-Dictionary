import java.util.List;

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

    

    public static void EliminateWord() {
        
            String wordToDelete = JOptionPane.showInputDialog(null, "ingrese la palabara para eliminarla");
            boolean exists = false;
            for (List<String> words : qualifier.getWordByInitial().values()) {
                if (words.remove(wordToDelete)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                JOptionPane.showMessageDialog(null, "Palabra eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "La palabra no estaba almacenada");
            }
        }
    
}

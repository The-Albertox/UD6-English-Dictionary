import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import app.net.tools.Menu;
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
                
                    case "2":
                    EliminateWord();
                    break;
                
                    case "3":
                    ExistWord();
                    break;
                
                    case "4":
                    ShowByInitial();
                    break;  
                
                    case "5":
                    ShowWordByInitial();
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, "Hasta la proxima");
                    exist = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "error opcion incorrecta");
                    break;

            }
        }
    }

    public static void AddWord() {
        try {
            String wordToAdd = JOptionPane.showInputDialog(null, "introduzca la palabra");
            qualifier.addWord(wordToAdd);
            JOptionPane.showMessageDialog(null, "la palabra se ha agregado correctamente");
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "error por favor ingrese un valor anetes de continuar");
        }
    }

    public static void EliminateWord() {
        try {
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
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "error por favor ingrese un valor anetes de continuar");
        }
    }

    public static void ExistWord() {
        try {
            String wordToFind = JOptionPane.showInputDialog(null, "Ponga la palabra que desa buscar");
            boolean exists = false;
            for (List<String> words : qualifier.getWordByInitial().values()) {
                if (words.contains(wordToFind)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                JOptionPane.showMessageDialog(null, "la palabra se ha encontrado");
            } else {
                JOptionPane.showMessageDialog(null, "La palabra no se ha encontrado");
            }
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "error por favor ingrese un valor anetes de continuar");
        }
    }

    public static void ShowByInitial() {
        try {
            JOptionPane.showMessageDialog(null, "Iniciales disponibles :");
            Set<Character> initials = qualifier.getInitials();
            if (initials.isEmpty()) {
                JOptionPane.showMessageDialog(null, "no hay iniciales disponibles en este momento");
            } else {
                for (char initial : initials) {
                    List<String> wordByInitials = qualifier.getWordsByInitial(initial);
                    if (!wordByInitials.isEmpty()) {
                        JOptionPane.showMessageDialog(null, initial);
                    }
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "error por favor ingrese un valor anetes de continuar");
        }
    }

    public static void ShowWordByInitial() {
        try {
            char initialToShow = JOptionPane.showInputDialog(null, "ingrese una inicial").charAt(0);
            List<String> wordsByInitial = qualifier.getWordsByInitial(initialToShow);
            if (wordsByInitial.isEmpty()) {
                JOptionPane.showMessageDialog(null, "no se ha encontrado la palabra");
            } else {
                JOptionPane.showMessageDialog(null, ("Palabras que comienzan con " + initialToShow + ":"));
                for (String word : wordsByInitial) {
                    JOptionPane.showMessageDialog(null, word);
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "error por favor ingrese un valor anetes de continuar");
        }
    }
}

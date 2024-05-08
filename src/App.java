import app.net.resource.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        boolean exist = true;
        String option = "";

        Menu menu = new Menu();
        while (exist) {
            option = menu.getMenu();
            switch (option) {
                case "1":

                    break;
            }
        }
    }
}

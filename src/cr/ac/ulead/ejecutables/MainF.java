package cr.ac.ulead.ejecutables;
import cr.ac.ulead.logica.Logic;
import cr.ac.ulead.ui.UIUtils;

public class MainF {
   public static void main(String[] args) {
       ejecutar();
   }
    private static void ejecutar() {
        Logic logic = new Logic();
        int option = 5;
        do {
            logic.execute(option);
        } while (option != 6);
    }
}




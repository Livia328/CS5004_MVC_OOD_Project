import Controller.AddMonkeyController;
import Controller.WelcomePageController;
import Model.Sanctuary;
import View.AddMonkeyPage;
import View.WelcomePage;

/**

 The Main class serves as the entry point for the Monkey Sanctuary application.

 It creates an instance of the Sanctuary class, which represents the main data model for the application.

 It also creates an instance of the WelcomePageController class, which handles the welcome page view and user input.
 */
public class main {
    /**

     The main method creates an instance of the Sanctuary class and an instance of the WelcomePageController class.

     It passes the sanctuary instance to the welcome page controller to use as the data model.

     */
    public static void main(String[] args) {
        Sanctuary sanctuary = new Sanctuary();
        WelcomePageController welcomePageController = new WelcomePageController(sanctuary);

    }
}

package View;

import Controller.ControllerMenu;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import Sample.BDDManager;


public class ViewPrincipale {

    private final Rectangle2D primaryScreenBounds;
    private Menu model;
    private javafx.scene.control.Button btnPageAdmin;
    private javafx.scene.control.Button btnQuitter;
    private Group root;
    private ImageView imgBG;
    private ImageView Logo;
    private BDDManager bdd;
    private ImageView corps;

    ViewPrincipale(Menu model, Group root) {

        this.root = root;
        this.model = model;
        primaryScreenBounds = Screen.getPrimary().getBounds();
        initBackground();
        initLogo();
        initCorps();


       // RÃ©cupÃ©ration de la taille de l'Ã©cran
        double posX = (primaryScreenBounds.getWidth() * 85) / 100;
        double posY = (primaryScreenBounds.getHeight() * 80) / 100;

        btnPageAdmin = initButton(posX, posY - 50, "Admin");
        btnQuitter = initButton(posX, posY + 20, "Quitter");

        setVueCompleteMenu();
    }


    public Button initButton(double posX, double posY, String textBtn) {

        Button b = new Button();// Création d'un bouton

        b.setText(textBtn);
        b.setLayoutX(posX);
        b.setLayoutY(posY);

        return b;
    }


    private void initBackground() {
        imgBG = new javafx.scene.image.ImageView("Asset/Images/background.jpg");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBG.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBG.setFitWidth((int) primaryScreenBounds.getWidth());
    }

    private void initLogo() {
        Logo = new javafx.scene.image.ImageView("Asset/Images/Logo_Medic.png");
        Logo.setY(100);
        Logo.setX(100);
    }

    private void initCorps() {
        corps = new ImageView("Asset/Images/corps.png");

        double posXBody = (primaryScreenBounds.getWidth() * 45) / 100;
        double posYBody = (primaryScreenBounds.getHeight() * 5) / 100;
        double heightBody = (primaryScreenBounds.getHeight() * 90) / 100;


        corps.setX(posXBody);
        corps.setY(posYBody);
        corps.setFitHeight(heightBody);
        corps.setPreserveRatio(true);

    }

    void setVueCompleteMenu() {
        root.getChildren().clear();
        root.getChildren().add(imgBG);
        root.getChildren().add(Logo);
        root.getChildren().add(btnPageAdmin);
        root.getChildren().add(btnQuitter);
        root.getChildren().add(corps);
    }

    void setEvents(ControllerMenu mc) {
        btnPageAdmin.setOnMouseClicked(mc);
        btnQuitter.setOnMouseClicked(mc);
    }

    public Button getQuitter() {
        return btnQuitter;
    }

    public Button getPageAdmin() {
        return btnPageAdmin;
    }
}

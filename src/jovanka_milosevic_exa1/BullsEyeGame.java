package jovanka_milosevic_exa1;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class represents a Bull's Eye Game
 *
 * @author Jovanka Milosevic
 */
public class BullsEyeGame extends Application {

    Circle circle1;
    Circle circle2;
    Circle circle3;
    Button btnShoot;
    Text xShot;
    Pane pane;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * An overridden start method that creates a scene, puts it on the stage and loads the stage.
     *
     * @param stage - a window of Bull's Eye Challenge
     */
    @Override
    public void start(Stage stage) {
        Scene scene = createPane(stage);

        stage.setTitle("Bull's Eye Challenge");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * A method that creates a Pane and adds nodes to it, then creates a VBox and put the pane and the Button on it,
     * and, finally, places the VBox on the scene.
     *
     * @param stage - the window of Bull's Eye Challenge
     * @return - the created scene
     */
    private Scene createPane(Stage stage) {
        pane = new Pane();
        pane.setMaxWidth(160);
        pane.setMaxHeight(160);

        circle1 = new Circle(75);
        circle1.setCenterX(80);
        circle1.setCenterY(80);
        circle1.setStroke(Color.RED);
        circle1.setStrokeWidth(15);
        circle1.setFill(Color.WHITE);

        circle2 = new Circle(45);
        circle2.setCenterX(80);
        circle2.setCenterY(80);
        circle2.setStroke(Color.BLUE);
        circle2.setStrokeWidth(15);
        circle2.setFill(Color.WHITE);

        circle3 = new Circle(20);
        circle3.setCenterX(80);
        circle3.setCenterY(80);
        circle3.setFill(Color.RED);

        pane.getChildren().addAll(circle1, circle2, circle3);

        btnShoot = new Button("Shoot!");
        btnShoot.setOnAction(event -> shoot());

        VBox root = new VBox(30, pane, btnShoot);
        root.setAlignment(Pos.CENTER);

        return new Scene(root, 300, 300);

    }

    /**
     * A method that creates a Text shape (x object) and randomly places it on the pane.
     */
    public void shoot() {
        xShot = new Text("x");
        xShot.setStyle("-fx-font: 15px Verdana; -fx-fontWeight: bold; -fx-fill: gold; -fx-stroke: black; -fx-stroke-width: 0.5;");
        Random randomShoot = new Random();

        int randX = randomShoot.nextInt((int) pane.getWidth());
        int randY = randomShoot.nextInt((int) pane.getHeight());
        xShot.setX(randX);
        xShot.setY(randY);
        pane.getChildren().add(xShot);
        if (pane.getChildren().size() >= 30) {
            btnShoot.setDisable(true);
        }

    }
}

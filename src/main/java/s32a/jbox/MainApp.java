package s32a.jbox;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.jbox2d.dynamics.Body;
import org.jcp.xml.dsig.internal.dom.Utils;
import s32a.calc.Game;


public class MainApp extends Application {
   
    Game game;
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Group root = new Group();        
        
        game = new Game();
        root.getChildren().add(game.getPuck());
        
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
 
        Duration duration = Duration.seconds(1.0/60.0); // Set duration for frame.
         
        //Create an ActionEvent, on trigger it executes a world time step and moves the balls to new position 
        EventHandler<ActionEvent> ae = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                        //Create time step. Set Iteration count 8 for velocity and 3 for positions
                       game.puck.physEngine.world.step(1.0f/60.f, 8, 3); 
           }
        };
 
         
        /**
         * Set ActionEvent and duration to the KeyFrame. 
         * The ActionEvent is trigged when KeyFrame execution is over. 
         */
        KeyFrame frame = new KeyFrame(duration, ae, null,null);
 
        timeline.getKeyFrames().add(frame);
 
        //Create button to start simulation.
        final Button btn = new Button();
        btn.setLayoutX((500/2));
        btn.setLayoutY((500-30));
        btn.setText("Start");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                        timeline.playFromStart(); 
                        btn.setVisible(false);
            }
        });
 
        //Add button to the root group
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

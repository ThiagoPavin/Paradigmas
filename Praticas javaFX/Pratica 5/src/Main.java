
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main extends Application {

    private Stage window;
    private Button Circle, Line;
    Boolean troca = FALSE;
    private Circle c;
    private Line line;
    double x,y;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Pratica 5");


        // criando o botão 'Circle'
        Circle = new Button();
        Circle.setText("Circle");
        Circle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                troca = FALSE;
            }
        });

        // criando o botão 'Line'
        Line = new Button();
        Line.setText("Line");
        Line.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                troca = TRUE;
            }
        });

        BorderPane layout = new BorderPane();

        Scene scene = new Scene(layout, 800, 500);
        window.setScene(scene);
        window.show();

        layout.setLeft(Circle);
        Circle.setPadding(new Insets(10, 10, 10, 10));
        layout.setMargin(Circle, new Insets(10, 10, 10, 10));

        layout.setRight(Line);
        Line.setPadding(new Insets(10, 10, 10, 10));
        layout.setMargin(Line, new Insets(10, 10, 10, 10));

        //private double raio = 10;
        layout.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                if (troca == FALSE) {
                    c = new Circle(e.getX(), e.getY(), 10, Color.RED);
                    x = e.getX();
                    y = e.getY();
                    System.out.println(x);
                    System.out.println(y);
                    layout.getChildren().add(c);
                } else {
                    line = new Line(e.getX(), e.getY(), e.getX(), e.getY());
                    layout.getChildren().add(line);
                }
            }
        });

        layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                if (troca == TRUE) {
                    line.setEndX(e.getX());
                    line.setEndY(e.getY());
                } else {
                    double distancia;
                    distancia = Math.sqrt( ( ( (e.getX() - x)*(e.getX() - x) ) + ( (e.getY() - y)*(e.getY() - y) ) ) );
                    c.setRadius(distancia);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
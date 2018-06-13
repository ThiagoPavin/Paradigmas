
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    private Button StartGame,BackMenu,Quit;
    private Scene Menu,Game;
    private Label lblMenu,lblGame;
    private String difficulty1,difficulty2,difficulty3;
    private int Aux = 2;
    Circle c1,c2,c3,c4,c5,c6,c7;
    Line l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Circle Mc1,Mc2,Mc3,Mc4,Mc5,Mc6,Mc7,Mc8,Mc9,Mc10,Mc11,Mc12,Mc13;
    Line Ml1,Ml2,Ml3,Ml4,Ml5,Ml6,Ml7,Ml8,Ml9,Ml10;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Planarity");

        lblMenu = new Label("Planarity");
        lblGame = new Label("Difficulty: Medium");

        StartGame = new Button();
        StartGame.setText("Start Game");

        Quit = new Button();
        Quit.setText("Quit Game");
        Quit.setOnAction(e -> primaryStage.close());

        BackMenu = new Button();
        BackMenu.setText("Back to menu");

    // layout 1 ----------------------------------------

        BorderPane layout1 = new BorderPane();

        StartGame.setPadding(new Insets(20,20,20,20));

        layout1.setBottom(Quit);
        Quit.setPadding(new Insets(10,10,10,10));
        BorderPane.setMargin(Quit, new Insets(10,10,10,10));
        BorderPane.setAlignment(Quit,Pos.BOTTOM_LEFT);

        layout1.setTop(lblMenu);
        BorderPane.setAlignment(lblMenu,Pos.TOP_CENTER);
        lblMenu.setPadding(new Insets(10,10,10,10));
        lblMenu.setFont(Font.font(70));
        BorderPane.setMargin(lblMenu, new Insets(10,10,10,10));

        Mc1 = new Circle(700,600,30, Color.BLACK);
        Mc2 = new Circle(600,600,30, Color.BLACK);
        Mc3 = new Circle(500,600,30, Color.BLACK);
        Mc4 = new Circle(800,500,30, Color.BLACK);
        Mc5 = new Circle(800,400,30, Color.BLACK);
        Mc6 = new Circle(800,300,30, Color.BLACK);
        Mc7 = new Circle(400,600,30, Color.BLACK);
        Mc8 = new Circle(800,200,30, Color.BLACK);

        Mc9 = new Circle(300,600,30, Color.BLACK);
        Mc10 = new Circle(200,600,30, Color.BLACK);
        Mc11 = new Circle(0,400,30, Color.BLACK);
        Mc12 = new Circle(0,500,30, Color.BLACK);
        Mc13 = new Circle(0,300,30, Color.BLACK);

        Ml1 = new Line(Mc1.getCenterX(),Mc1.getCenterY(),Mc4.getCenterX(),Mc4.getCenterY());
        Ml2 = new Line(Mc2.getCenterX(),Mc2.getCenterY(),Mc5.getCenterX(),Mc5.getCenterY());
        Ml3 = new Line(Mc3.getCenterX(),Mc3.getCenterY(),Mc6.getCenterX(),Mc6.getCenterY());
        Ml4 = new Line(Mc7.getCenterX(),Mc7.getCenterY(),Mc8.getCenterX(),Mc8.getCenterY());
        Ml5 = new Line(Mc7.getCenterX(),Mc7.getCenterY(),Mc9.getCenterX(),Mc9.getCenterY());
        Ml6 = new Line(Mc13.getCenterX(),Mc13.getCenterY(),Mc7.getCenterX(),Mc7.getCenterY());
        Ml7 = new Line(Mc11.getCenterX(),Mc11.getCenterY(),Mc9.getCenterX(),Mc9.getCenterY());
        Ml8 = new Line(Mc10.getCenterX(),Mc10.getCenterY(),Mc12.getCenterX(),Mc12.getCenterY());
        Ml9 = new Line(Mc12.getCenterX(),Mc12.getCenterY(),Mc4.getCenterX(),Mc4.getCenterY());
        Ml10 = new Line(Mc11.getCenterX(),Mc11.getCenterY(),Mc5.getCenterX(),Mc5.getCenterY());

        layout1.getChildren().addAll(Mc1,Mc2,Mc3,Mc4,Mc5,Mc6,Mc7,Mc8,Mc9,Mc10,Mc11,Mc12,Mc13,Ml1,Ml2,Ml3,Ml4,Ml5,Ml6,Ml7,Ml8,Ml9,Ml10);

        difficulty1 = "Difficulty: Easy";
        difficulty2 = "Difficulty: Medium";
        difficulty3 = "Difficulty: Hard";


    // Radio Button -----------------------------------

        VBox VbRadio;

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton(difficulty1);
        RadioButton rb2 = new RadioButton(difficulty2);
        RadioButton rb3 = new RadioButton(difficulty3);

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        rb1.setUserData(difficulty1);
        rb2.setUserData(difficulty2);
        rb3.setUserData(difficulty3);

        // Precheck 2nd option
        rb2.setSelected(true);

        VbRadio = new VBox(20,rb1,rb2,rb3);
        VbRadio.setPadding(new Insets(10));

        VBox VbMenu = new VBox(20,StartGame,VbRadio);

        layout1.setCenter(VbMenu);
        VbMenu.setPadding(new Insets(20,20,20,20));
        BorderPane.setMargin(VbMenu, new Insets(10,10,10,310));

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (group.getSelectedToggle() != null){
                    if (rb1.isSelected()){
                        Aux = 1;
                        lblGame.setText("Difficulty: Easy");
                    }else if (rb2.isSelected()){
                        Aux = 2;
                        lblGame.setText("Difficulty: Medium");
                    }else if (rb3.isSelected()){
                        Aux = 3;
                        lblGame.setText("Difficulty: Hard");
                    }
                    System.out.println("Auxiliar = " + Aux);
                }
            }
        });

        setUserAgentStylesheet(STYLESHEET_CASPIAN);

        Menu = new Scene(layout1,800,600);

    // layout 2 ----------------------------------------

        BorderPane layout2 = new BorderPane();

        layout2.setTop(lblGame);
        lblGame.setPadding(new Insets(10,10,10,10));
        BorderPane.setMargin(lblGame, new Insets(10,10,10,10));

        layout2.setBottom(BackMenu);
        BackMenu.setPadding(new Insets(10,10,10,10));
        BorderPane.setMargin(BackMenu, new Insets(10,10,10,10));

    // evento de clique do mouse
        EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
                orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
                /*
                if ( ( Math.sqrt( ( ( (c1.getCenterX() - orgSceneX)*(c1.getCenterX() - orgSceneX) ) + ( (c1.getCenterY() - orgSceneY)*(c1.getCenterY() - orgSceneY) ) ) ) ) <= 10 ){
                    AuxCircle = 1;
                }else if (( Math.sqrt( ( ( (c2.getCenterX() - orgSceneX)*(c2.getCenterX() - orgSceneX) ) + ( (c2.getCenterY() - orgSceneY)*(c2.getCenterY() - orgSceneY) ) ) ) ) <= 10){
                    AuxCircle = 2;
                }else if (( Math.sqrt( ( ( (c3.getCenterX() - orgSceneX)*(c3.getCenterX() - orgSceneX) ) + ( (c3.getCenterY() - orgSceneY)*(c3.getCenterY() - orgSceneY) ) ) ) ) <= 10){
                    AuxCircle = 3;
                }else if (( Math.sqrt( ( ( (c4.getCenterX() - orgSceneX)*(c4.getCenterX() - orgSceneX) ) + ( (c4.getCenterY() - orgSceneY)*(c4.getCenterY() - orgSceneY) ) ) ) ) <= 10){
                    AuxCircle = 4;
                }else if (( Math.sqrt( ( ( (c5.getCenterX() - orgSceneX)*(c5.getCenterX() - orgSceneX) ) + ( (c5.getCenterY() - orgSceneY)*(c5.getCenterY() - orgSceneY) ) ) ) ) <= 10){
                    AuxCircle = 5;
                }else if (( Math.sqrt( ( ( (c6.getCenterX() - orgSceneX)*(c6.getCenterX() - orgSceneX) ) + ( (c6.getCenterY() - orgSceneY)*(c6.getCenterY() - orgSceneY) ) ) ) ) <= 10){
                    AuxCircle = 6;
                }
                System.out.println("Auxiliar Circle = " + AuxCircle);
                */
            }
        };

    // evento de arrastar o mouse
        EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((Circle)(t.getSource())).setTranslateX(newTranslateX);
                ((Circle)(t.getSource())).setTranslateY(newTranslateY);

                if(Aux == 1){
                    layout2.getChildren().removeAll(l1,l2,l3);

                    l1 = new Line(t.getSceneX(),t.getSceneY(),c2.getCenterX(),c2.getCenterY());
                    l1.setStroke(Color.BLACK);
                    l2 = new Line(t.getSceneX(),t.getSceneY(),c3.getCenterX(),c3.getCenterY());
                    l2.setStroke(Color.BLACK);
                    l3 = new Line(t.getSceneX(),t.getSceneY(),c4.getCenterX(),c4.getCenterY());
                    l3.setStroke(Color.BLACK);

                    layout2.getChildren().addAll(l1,l2,l3);
                }else if(Aux == 2){
                    layout2.getChildren().removeAll(l1,l3,l4);

                    l1 = new Line(t.getSceneX(),t.getSceneY(),c2.getCenterX(),c2.getCenterY());
                    l1.setStroke(Color.BLACK);
                    l3 = new Line(t.getSceneX(),t.getSceneY(),c4.getCenterX(),c4.getCenterY());
                    l3.setStroke(Color.BLACK);
                    l4 = new Line(t.getSceneX(),t.getSceneY(),c5.getCenterX(),c5.getCenterY());
                    l4.setStroke(Color.BLACK);

                    layout2.getChildren().addAll(l1,l3,l4);
                }else{
                    layout2.getChildren().removeAll(l1,l3,l4);

                    l1 = new Line(t.getSceneX(),t.getSceneY(),c2.getCenterX(),c2.getCenterY());
                    l1.setStroke(Color.BLACK);
                    l3 = new Line(t.getSceneX(),t.getSceneY(),c4.getCenterX(),c4.getCenterY());
                    l3.setStroke(Color.BLACK);
                    l4 = new Line(t.getSceneX(),t.getSceneY(),c5.getCenterX(),c5.getCenterY());
                    l4.setStroke(Color.BLACK);

                    layout2.getChildren().addAll(l1,l3,l4);
                }
            }
        };

    // evento do clique no botao de 'Start Game'
        StartGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Aux == 1){

                    c1 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 20, Color.BLACK);
                    c1.setCursor(Cursor.HAND);
                    c1.setOnMousePressed(circleOnMousePressedEventHandler);
                    c1.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c2 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c2.setCursor(Cursor.HAND);
                    c2.setOnMousePressed(circleOnMousePressedEventHandler);
                    c2.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c3 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c3.setCursor(Cursor.HAND);
                    c3.setOnMousePressed(circleOnMousePressedEventHandler);
                    c3.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c4 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c4.setCursor(Cursor.HAND);
                    c4.setOnMousePressed(circleOnMousePressedEventHandler);
                    c4.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    l1 = new Line(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY());
                    l1.setStroke(Color.BLACK);
                    l2 = new Line(c1.getCenterX(),c1.getCenterY(),c3.getCenterX(),c3.getCenterY());
                    l2.setStroke(Color.BLACK);
                    l3 = new Line(c1.getCenterX(),c1.getCenterY(),c4.getCenterX(),c4.getCenterY());
                    l3.setStroke(Color.BLACK);
                    l4 = new Line(c2.getCenterX(),c2.getCenterY(),c3.getCenterX(),c3.getCenterY());
                    l5 = new Line(c2.getCenterX(),c2.getCenterY(),c4.getCenterX(),c4.getCenterY());
                    l6 = new Line(c3.getCenterX(),c3.getCenterY(),c4.getCenterX(),c4.getCenterY());

                    layout2.getChildren().addAll(l1,l2,l3,l4,l5,l6,c1,c2,c3,c4);

                }else if(Aux == 2){

                    c1 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 20, Color.BLACK);
                    c1.setCursor(Cursor.HAND);
                    c1.setOnMousePressed(circleOnMousePressedEventHandler);
                    c1.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c2 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c2.setCursor(Cursor.HAND);
                    c2.setOnMousePressed(circleOnMousePressedEventHandler);
                    c2.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c3 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c3.setCursor(Cursor.HAND);
                    c3.setOnMousePressed(circleOnMousePressedEventHandler);
                    c3.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c4 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c4.setCursor(Cursor.HAND);
                    c4.setOnMousePressed(circleOnMousePressedEventHandler);
                    c4.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c5 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c5.setCursor(Cursor.HAND);
                    c5.setOnMousePressed(circleOnMousePressedEventHandler);
                    c5.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    l1 = new Line(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY());
                    l1.setStroke(Color.BLACK);
                    l2 = new Line(c4.getCenterX(),c4.getCenterY(),c5.getCenterX(),c5.getCenterY());
                    l3 = new Line(c1.getCenterX(),c1.getCenterY(),c4.getCenterX(),c4.getCenterY());
                    l3.setStroke(Color.BLACK);
                    l4 = new Line(c1.getCenterX(),c1.getCenterY(),c5.getCenterX(),c5.getCenterY());
                    l4.setStroke(Color.BLACK);
                    l5 = new Line(c2.getCenterX(),c2.getCenterY(),c3.getCenterX(),c3.getCenterY());
                    l6 = new Line(c2.getCenterX(),c2.getCenterY(),c4.getCenterX(),c4.getCenterY());
                    l7 = new Line(c3.getCenterX(),c3.getCenterY(),c4.getCenterX(),c4.getCenterY());
                    l8 = new Line(c3.getCenterX(),c3.getCenterY(),c5.getCenterX(),c5.getCenterY());


                    layout2.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8,c1,c2,c3,c4,c5);
                }else if(Aux == 3){

                    c1 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 20, Color.BLACK);
                    c1.setCursor(Cursor.HAND);
                    c1.setOnMousePressed(circleOnMousePressedEventHandler);
                    c1.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c2 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c2.setCursor(Cursor.HAND);
                    c2.setOnMousePressed(circleOnMousePressedEventHandler);
                    c2.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c3 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c3.setCursor(Cursor.HAND);
                    c3.setOnMousePressed(circleOnMousePressedEventHandler);
                    c3.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c4 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c4.setCursor(Cursor.HAND);
                    c4.setOnMousePressed(circleOnMousePressedEventHandler);
                    c4.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c5 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c5.setCursor(Cursor.HAND);
                    c5.setOnMousePressed(circleOnMousePressedEventHandler);
                    c5.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    c6 = new Circle(100 + (int) (Math.random() * 600),100 + (int) (Math.random() * 450), 10, Color.BLACK);
                    c6.setCursor(Cursor.HAND);
                    c6.setOnMousePressed(circleOnMousePressedEventHandler);
                    c6.setOnMouseDragged(circleOnMouseDraggedEventHandler);

                    l1 = new Line(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY());
                    l1.setStroke(Color.BLACK);
                    l2 = new Line(c4.getCenterX(),c4.getCenterY(),c5.getCenterX(),c5.getCenterY());
                    l3 = new Line(c1.getCenterX(),c1.getCenterY(),c4.getCenterX(),c4.getCenterY());
                    l3.setStroke(Color.BLACK);
                    l4 = new Line(c1.getCenterX(),c1.getCenterY(),c5.getCenterX(),c5.getCenterY());
                    l4.setStroke(Color.BLACK);
                    l5 = new Line(c2.getCenterX(),c2.getCenterY(),c3.getCenterX(),c3.getCenterY());
                    l6 = new Line(c2.getCenterX(),c2.getCenterY(),c4.getCenterX(),c4.getCenterY());
                    l7 = new Line(c3.getCenterX(),c3.getCenterY(),c4.getCenterX(),c4.getCenterY());
                    l8 = new Line(c3.getCenterX(),c3.getCenterY(),c5.getCenterX(),c5.getCenterY());
                    l9 = new Line(c5.getCenterX(),c5.getCenterY(),c6.getCenterX(),c6.getCenterY());
                    l10 = new Line(c3.getCenterX(),c3.getCenterY(),c6.getCenterX(),c6.getCenterY());

                    layout2.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,c1,c2,c3,c4,c5,c6);
                }
                primaryStage.setScene(Game);
            }
        });
    // evento do clique no botao de 'Back to Menu'
        BackMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Aux == 1){
                    layout2.getChildren().removeAll(c1,c2,c3,c4,l1,l2,l3,l4,l5,l6,l7);
                }else if(Aux == 2){
                    layout2.getChildren().removeAll(c1,c2,c3,c4,c5,l1,l2,l3,l4,l5,l6,l7,l8);
                }else if(Aux == 3){
                    layout2.getChildren().removeAll(c1,c2,c3,c4,c5,c6,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10);
                }else if(Aux == 4){
                    layout2.getChildren().removeAll(c1,c2,c3,c4,c5,c6,c7,l1,l2,l3,l4,l5,l6,l7);
                }
                primaryStage.setScene(Menu);
            }
        });

        Game = new Scene(layout2,800,600);

        primaryStage.setScene(Menu);
        primaryStage.show();

    }
}

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.control.Slider;

import java.awt.geom.Line2D;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;
    private Button Aresta, Vertice, NovoGrafo, SalvarGrafo, Sair;
    private ColorPicker colorPicker1, colorPicker2, colorPicker3;
    private ToolBar toolBar1, toolBar2;
    private Canvas canvas;
    private Text TArestas, TVertices, TSobrepostas;
    private BorderPane layout;
    private VBox vBox1,vBox2;
    private Label labelSpace,labelSpace2;
    private Boolean troca = FALSE;
    private int NumArestas,NumVertices,NumSobre,Aux = 1;

    private double orgSceneX, orgSceneY, orgTranslateX, orgTranslateY;

    private Grafo grafoMenu = new Grafo();

    private Slider slider;

    private Scene Menu;

    public Main() {
        layout = new BorderPane();

        Aresta = new Button();
        Aresta.setText("Aresta");
        Aresta.setPadding(new Insets(10,20,10,10));

        Vertice = new Button();
        Vertice.setText("Vertice");
        Vertice.setPadding(new Insets(10,20,10,10));

        NovoGrafo = new Button();
        NovoGrafo.setText("Criar novo grafo");

        SalvarGrafo = new Button();
        SalvarGrafo.setText("Salvar Grafo");

        canvas = new Canvas(600,400);

        Sair = new Button();
        Sair.setText("Sair");
        Sair.setPadding(new Insets(5,10,5,5));
        Sair.setOnAction(e -> primaryStage.close());

        TArestas = new Text("Numero de arestas: " + grafoMenu.getNumArestas());
        TVertices = new Text("Numero de vertices: " + grafoMenu.getNumVertices());
        TSobrepostas = new Text("Numero de arestas sobrapostas: " + grafoMenu.getNumSobre());

        slider = new Slider();
        slider.setMin(1);
        slider.setMax(9);
        slider.setValue(5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(4);
        slider.setMinorTickCount(1);
        slider.setBlockIncrement(1);

        colorPicker1 = new ColorPicker();
        colorPicker1.setValue(Color.BLACK);
        colorPicker2 = new ColorPicker();
        colorPicker2.setValue(Color.CORAL);
        colorPicker3 = new ColorPicker();
        colorPicker3.setValue(Color.GREEN);

        labelSpace = new Label("======================");
        labelSpace2 = new Label("======================");

        vBox1 = new VBox(Vertice, colorPicker1, colorPicker3, labelSpace, Aresta, colorPicker2, slider, labelSpace2, TArestas, TVertices, TSobrepostas);
        vBox1.setSpacing(20);

        vBox2 = new VBox(labelSpace2,Sair);
        vBox2.setSpacing(80);

        toolBar1 = new ToolBar(vBox1,vBox2);
        toolBar1.setOrientation(Orientation.VERTICAL);

        toolBar2 = new ToolBar(NovoGrafo, SalvarGrafo);
        toolBar2.setOrientation(Orientation.HORIZONTAL);
    }

    public void NovoGrafo(){
        for (Node elemento : grafoMenu.getArestas()){
            if (elemento instanceof Line) {
                Line Vertice = (Line) elemento;
                layout.getChildren().remove(Vertice);
            }
        }

        for (Node elemento : grafoMenu.getVertices()) {
            if (elemento instanceof Circle) {
                Circle Aresta = (Circle) elemento;
                layout.getChildren().remove(Aresta);
            }
        }

        grafoMenu.RemArestas(grafoMenu.getArestas());
        grafoMenu.RemVertices(grafoMenu.getVertices());

        TArestas.setText("Numero de arestas: " + grafoMenu.getNumArestas());
        TVertices.setText("Numero de vertices: " + grafoMenu.getNumVertices());
        TSobrepostas.setText("Numero de arestas sobrapostas: " + grafoMenu.getNumSobre());

    }

    public void desenhaMenu() {

        layout.setLeft(toolBar1);

        layout.setTop(toolBar2);

        //layout.setCenter(canvas);

        setUserAgentStylesheet(STYLESHEET_CASPIAN);

        Menu = new Scene(layout, 800, 600);
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("Editor de grafos");

        desenhaMenu();

        // clique do botão vertice
        Vertice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                troca = FALSE;
            }
        });

        // clique do botão Aresta
        Aresta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                troca = TRUE;
            }
        });

        colorPicker1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Node elemento : grafoMenu.getVertices()) {
                    if (elemento instanceof Circle) {
                        Circle Vertice = (Circle) elemento;
                        Vertice.setFill(colorPicker1.getValue());
                    }
                }
            }
        });

        colorPicker3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Node elemento : grafoMenu.getVertices()) {
                    if (elemento instanceof Circle) {
                        Circle Vertice = (Circle) elemento;
                        Vertice.setStroke(colorPicker3.getValue());
                    }
                }
            }
        });

        colorPicker2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Node elemento : grafoMenu.getArestas()){
                    if (elemento instanceof Line) {
                        Line Aresta = (Line) elemento;
                        Aresta.setStroke(colorPicker2.getValue());
                    }
                }
            }
        });

        slider.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (Node elemento : grafoMenu.getArestas()){
                    if (elemento instanceof Line) {
                        Line Aresta = (Line) elemento;
                        Aresta.setStrokeWidth(slider.getValue());
                    }
                }
            }
        });

        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (Node elemento : grafoMenu.getArestas()){
                    if (elemento instanceof Line) {
                        Line Aresta = (Line) elemento;
                        Aresta.setStrokeWidth(slider.getValue());
                    }
                }
            }
        });

        slider.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                for (Node elemento : grafoMenu.getArestas()){
                    if (elemento instanceof Line) {
                        Line Aresta = (Line) elemento;
                        Aresta.setStrokeWidth(slider.getValue());
                    }
                }
            }
        });

        NovoGrafo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NovoGrafo();
            }
        });

        layout.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (troca == FALSE){
                    grafoMenu.addVertice(new Circle(e.getX(), e.getY(), 20, colorPicker1.getValue()));
                    grafoMenu.getVerticeInd((grafoMenu.sizeVertice() - 1)).setStroke(colorPicker3.getValue());
                    grafoMenu.getVerticeInd((grafoMenu.sizeVertice() - 1)).setStrokeWidth(4);
                    grafoMenu.incrementaVertices();
                    TVertices.setText("Numero de vertices: " + grafoMenu.getNumVertices());
                    System.out.println("Numero de vertices: " + grafoMenu.getNumVertices());
                    layout.getChildren().add(grafoMenu.getVerticeInd((grafoMenu.sizeVertice() - 1)));
                } else if (troca == TRUE){
                    if (Aux == 1){
                        for (Node elemento : grafoMenu.getVertices()){
                            if (elemento instanceof Circle){
                                Circle Vertice = (Circle) elemento;
                                if (Math.sqrt( (Vertice.getCenterX() - e.getSceneX())*(Vertice.getCenterX() - e.getSceneX()) + (Vertice.getCenterY() - e.getSceneY())*(Vertice.getCenterY() - e.getSceneY()) )  <= Vertice.getRadius()){
                                    Line aresta = new Line(Vertice.getCenterX(),Vertice.getCenterY(),Vertice.getCenterX(),Vertice.getCenterY());
                                    aresta.setStrokeWidth(1);
                                    aresta.setStroke(colorPicker2.getValue());
                                    grafoMenu.addAresta(aresta);
                                    layout.getChildren().add(grafoMenu.getArestaInd(grafoMenu.sizeAresta()-1));
                                    grafoMenu.incrementaAresta();
                                    TArestas.setText("Numero de arestas: " + grafoMenu.getNumArestas());
                                    System.out.println("Numero de arestas: " + grafoMenu.getNumArestas());
                                    Aux = 2;
                                }
                            }
                        }
                    }else if (Aux == 2){
                        grafoMenu.getArestaInd(grafoMenu.sizeAresta()-1).setEndX(e.getX());
                        grafoMenu.getArestaInd(grafoMenu.sizeAresta()-1).setEndY(e.getY());
                        Aux = 1;
                        int i,j;
                        Line Aresta1;
                        Line Aresta2;
                        for (i = 0; i<grafoMenu.sizeAresta(); i++) {
                            for (j = i+1 ; j<grafoMenu.sizeAresta(); j++) {
                                Aresta1 = grafoMenu.getArestaInd(i);
                                Aresta2 = grafoMenu.getArestaInd(j);
                                if(Line2D.linesIntersect(Aresta1.getStartX(),Aresta1.getStartY(),Aresta1.getEndX(),Aresta1.getEndY(),Aresta2.getStartX(),Aresta2.getStartY(),Aresta2.getEndX(),Aresta2.getEndY())){
                                    grafoMenu.incrementaSobre();
                                    TSobrepostas.setText("Numero de arestas sobrapostas: " + grafoMenu.getNumSobre());
                                    System.out.println("Numero de arestas sobrapostas: " + grafoMenu.getNumSobre());
                                }
                            }
                        }
                    }
                }
            }
        });

        primaryStage.setScene(Menu);
        primaryStage.show();
    }


}
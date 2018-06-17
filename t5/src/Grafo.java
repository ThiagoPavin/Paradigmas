import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;


public class Grafo {
    private ArrayList<Circle> vertices;
    private ArrayList<Line> arestas;
    private int NumArestas,NumVertices,NumSobre;


    public Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
        NumArestas = 0;
        NumSobre = 0;
        NumVertices = 0;
    }

    public void incrementaAresta(){
        NumArestas++;
    }

    public void incrementaVertices(){
        NumVertices++;
    }

    public void incrementaSobre(){
        NumSobre++;
    }

    public int getNumArestas() {
        return NumArestas;
    }

    public int getNumVertices() {
        return NumVertices;
    }

    public int getNumSobre() {
        return NumSobre;
    }

    public ArrayList<Circle> getVertices() {
        return vertices;
    }

    public ArrayList<Line> getArestas() {
        return arestas;
    }

    public Line getArestaInd(int i){
        return arestas.get(i);
    }

    public Circle getVerticeInd(int i){
        return vertices.get(i);
    }

    public void addVertice(Circle c) {
        vertices.add(c);
    }

    public void addAresta(Line l) {
        arestas.add(l);
    }

    public int sizeAresta(){
        return arestas.size();
    }

    public int sizeVertice(){
        return vertices.size();
    }

    public void RemArestas(ArrayList<Line> l) {
        arestas.removeAll(l);
        NumArestas = 0;
        NumSobre = 0;
    }

    public void RemVertices(ArrayList<Circle> c) {
        vertices.removeAll(c);
        NumVertices = 0;
    }
}


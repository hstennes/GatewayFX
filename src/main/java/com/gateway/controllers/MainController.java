package com.gateway.controllers;

import com.gateway.main.DraggableNode;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainController {

    @FXML
    public Canvas canvas;

    @FXML
    public DraggableNode paneProperties;

    public SplitPane paneSplit;

    public ToolBar toolbar;

    @FXML
    private Pane paneCenter;

    @FXML
    private ToolbarController toolbarController;

    @FXML
    public void initialize(){
        canvas.widthProperty().bind(paneCenter.widthProperty());
        canvas.heightProperty().bind(paneCenter.heightProperty());
        paneCenter.widthProperty().addListener((observableValue, number, t1) -> {
            paneProperties.setLayoutX(t1.intValue() - (number.intValue() - paneProperties.getLayoutX()));
        });
        toolbarController.addMain(this);
    }

    public void drawThing(boolean active){
        GraphicsContext g = canvas.getGraphicsContext2D();
        if(active) g.setFill(Color.BLUE);
        else g.setFill(Color.RED);
        g.fillOval(0, 0, 50, 50);
    }

    public void finalGUISetup(){
        paneSplit.setDividerPosition(0, 0.20);
        paneProperties.setLayoutX(paneCenter.getWidth() - paneProperties.getWidth() - 10);
        paneProperties.setLayoutY(10);
    }
}
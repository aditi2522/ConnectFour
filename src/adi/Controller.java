package adi;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    private static final int COLUMNS=7;
    private static final int ROWS=6;
    private static final int CIRCLE_DIAMETER=80;
    private static final String discColor1="#24303E";
    private static final String discColor2="#4CAABB";
    private Boolean isPlayerOneturn=true;

    private static String PLAYER_ONE="Player One";
    private static String PLAYER_TWO="Player Two";

    @FXML
    public GridPane rootGridPane;
    @FXML
    public Pane pane1;
    @FXML
    public Pane insertedDiscPane;
    @FXML
    public Label playerNameLabel;

    public void createPlayground()
    {
        Shape rectanglewithholes=gameStructure();
        rootGridPane.add(rectanglewithholes,0,1);

    }
    private Shape gameStructure()
    {
        Shape rectanglewithholes=new Rectangle((COLUMNS+1)*CIRCLE_DIAMETER,(ROWS+1)*CIRCLE_DIAMETER);
        Circle circle=new Circle();
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLUMNS;j++)
            {
                circle.setRadius(CIRCLE_DIAMETER/2);
                circle.setCenterX(CIRCLE_DIAMETER/2);
                circle.setCenterY(CIRCLE_DIAMETER/2);
                circle.setTranslateX(j*(CIRCLE_DIAMETER+5)+CIRCLE_DIAMETER/4);
                circle.setTranslateY(i*(CIRCLE_DIAMETER+5)+CIRCLE_DIAMETER/4);


                rectanglewithholes=Shape.subtract(rectanglewithholes,circle);

            }
        }
        rectanglewithholes.setFill(Color.WHITE);
        return rectanglewithholes;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}

/**
 * This program defines two classes: A NumberConversionCalculator class
 * and a NumberConversion class. The NumberConversionCalculator class 
 * sets up the GUI for the methods defined in the NumberConversion class
 * that actually allow for the base conversions to occur.
 * 
 * @author Suchir Agarwal
 */

// All required imports
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class NumberConversionCalculator extends Application {
    private TextField inputTF;
    private TextField base1TF;
    private TextField base2TF;
    private TextField resultTF;
    private Label errMsg;

    public void start(Stage myStage) {
        // Set title
        myStage.setTitle("Number Base Conversion Calculator");

        // Create new GridPane and set padding, vertical, and horizontal spacing
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(5);
        pane.setHgap(5);

        // Create new scene
        Scene myScene = new Scene(pane);

        // Create Labels
        Label label1 = new Label("Input Number: ");
        Label label2 = new Label("Current input base \n(accepted values from 2-16): ");
        Label label3 = new Label("Desired output base \n(accepted values from 2-16): ");
        Label label4 = new Label("Result: ");
        errMsg = new Label("Please enter valid inputs");

        errMsg.setTextFill(Color.web("#FF0000"));
        errMsg.setVisible(false);

        // Create TextFields
        inputTF = new TextField();
        base1TF = new TextField();
        base2TF = new TextField();
        resultTF = new TextField();

        // Create Button
        Button convert = new Button("Convert");

        // Create event handler object
        ButtonHandler buttonHandler = new ButtonHandler();

        // Register event handler
        convert.setOnAction(buttonHandler);

        // Add all Labels, TextFields, and Button to GridPane
        pane.add(label1, 0, 0);
        pane.add(label2, 0, 1);
        pane.add(label3, 0, 2);
        pane.add(label4, 0, 3);
        pane.add(errMsg, 0, 5);
  

        pane.add(inputTF, 1, 0);
        pane.add(base1TF, 1, 1);
        pane.add(base2TF, 1, 2);
        pane.add(resultTF, 1, 3);

        pane.add(convert, 1, 5);

        // Display
        myStage.setScene(myScene);
        myStage.show();
    }

    class ButtonHandler implements EventHandler<ActionEvent> {
        private String input;
        private int base1;
        private int base2;

        public void handle(ActionEvent a) {
            try {
                input = inputTF.getText();
                base1 = Integer.parseInt(base1TF.getText());
                base2 = Integer.parseInt(base2TF.getText());
                resultTF.setText(NumberConversion.baseConvert(input, base1, base2));
                errMsg.setVisible(false);
            }
            catch (Exception e) {
                errMsg.setVisible(true);
            }
        }
    }

    public static void main( String[] args ) {
        launch();
    }

}

/*

Riya Gharat             n00901846
12/03/2015


Write a program that uses a BorderPane that:
1. starts with two buttons on the bottom and your name on the screen and the two buttons should be programmed for up and down
instead of left and right, similar to example 16.2. Only use the left half of the center for your name (1 row 2 columns). See number 5
below for the right half of the center. So you could use a GridPane for the center.
2. enhances 16.2 with checkboxes that permit your name to be bold and/or italicized but the font must be  something other
than Times New Roman, and these checkboxes must be on the left (not the right) , similar to example 16.3
3. enhances 16.3 with  3 radio buttons that paint the text colors that are colors of your choice, but not red, green or blue,
and these radio buttons must be on the right (not the left), similar to example 16.4. You can use RGB coloring if you like.
4. puts a bouncing red rectangle (not a ball)  at the top  with a slider for speed (see see 16.12).
5. puts an mp4 video of something you have produced in the right half of the center with the same controls as in 16.14.
(use http://www.unf.edu/~nxxxxyyyy/name.mp4)
This will be in a folder that you create named homepage on Osprey.

All of this should be in a single file, but the code must show a variety of classes that use extends just as the author does
in chapter 16. Program incrementally, doing one "feature" at a time.  */


import javafx.application.Application;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Program7 extends RectangleSlider /*MediaDemo*/{
   
   public static void main(String[] args) {
    launch(args);
  }

}

class Name extends Application{
   protected Text text = new Text(75, 120, "Riya Gharat");
   
   protected BorderPane getPane(){
      HBox paneForButtons = new HBox(20);
      Button btUp = new Button("Up");
      Button btDown = new Button("Down");
      paneForButtons.getChildren().addAll(btUp, btDown);
      paneForButtons.setAlignment(Pos.CENTER);
      paneForButtons.setStyle("-fx-border-color: green");
      
      BorderPane pane = new BorderPane();
      pane.setBottom(paneForButtons);
      
      GridPane twoPanes = new GridPane();
      twoPanes.setHgap(10);
      twoPanes.setVgap(10);
      twoPanes.setPadding(new Insets(0, 10 , 0, 10));
      pane.setCenter(twoPanes);
      
      Pane paneForText = new Pane();
      paneForText.getChildren().add(text);
      twoPanes.add(paneForText, 0, 0);
//      pane.setCenter(paneForText);
      
      btUp.setOnAction(e -> text.setY(text.getY() - 10));
      btDown.setOnAction(e -> text.setY(text.getY() + 10));
      
      final String MEDIA_URL = "http://www.unf.edu/~n00901846/20150630_205906.mp4";   
      Media media = new Media(MEDIA_URL);
      MediaPlayer mediaPlayer = new MediaPlayer(media);
      MediaView mediaView = new MediaView(mediaPlayer);
      mediaView.setFitWidth(320);
      mediaView.setFitHeight(470);
      mediaView.setPreserveRatio(false);

      Button playButton = new Button(">");
      playButton.setOnAction(e -> {
        if (playButton.getText().equals(">")) {
         mediaPlayer.play();
         playButton.setText("||");
        } else {
         mediaPlayer.pause();
         playButton.setText(">");
        }
      });

      Button rewindButton = new Button("<<");
      rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));
    
      Slider slVolume = new Slider();
      slVolume.setPrefWidth(150);
      slVolume.setMaxWidth(Region.USE_PREF_SIZE);
      slVolume.setMinWidth(30);
      slVolume.setValue(50);
      mediaPlayer.volumeProperty().bind(
        slVolume.valueProperty().divide(100));

      HBox hBox = new HBox(10);
      hBox.setAlignment(Pos.CENTER);
      hBox.getChildren().addAll(playButton, rewindButton,
        new Label("Volume"), slVolume);

      BorderPane vpane = new BorderPane();
      vpane.setCenter(mediaView);
      vpane.setBottom(hBox);  
      
      twoPanes.add(vpane, 1, 0);
      
      return pane;
      
   }
   
   @Override
   public void start(Stage primaryStage){    
      
      Scene scene = new Scene(getPane(), 800, 600);
      primaryStage.setTitle("Project 3");
      primaryStage.setScene(scene);
      primaryStage.show();
      
   } 

}

class CheckBoxes extends Name{
 
   @Override
   protected BorderPane getPane() {
      BorderPane pane = super.getPane();
      Font fontBoldItalic = Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 20);
      Font fontBold = Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20);
      Font fontItalic = Font.font("Helvetica", FontWeight.NORMAL, FontPosture.ITALIC, 20);
      Font fontNormal = Font.font("Helvetica", FontWeight.NORMAL, FontPosture.REGULAR, 20);
      
      text.setFont(fontNormal);
      
      VBox paneForCheckBoxes = new VBox(20);
      paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5));
      paneForCheckBoxes.setStyle("-fx-border-color: green");
      CheckBox chkBold = new CheckBox("Bold");
      CheckBox chkItalic = new CheckBox("Italic");
      paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
      pane.setLeft(paneForCheckBoxes);
      
      EventHandler<ActionEvent> handler = e -> {
         if(chkBold.isSelected() && chkItalic.isSelected()){
            text.setFont(fontBoldItalic);
         }else if (chkBold.isSelected()){
            text.setFont(fontBold);
         }else if (chkItalic.isSelected()){
            text.setFont(fontItalic);
         }else{
            text.setFont(fontNormal);
         }
      };
      
      chkBold.setOnAction(handler);
      chkItalic.setOnAction(handler);
      
      return pane;
   }  
}   

class RadioButtons extends CheckBoxes{
   @Override
   protected BorderPane getPane(){
      BorderPane pane = super.getPane();
      
      VBox paneForRadioButtons = new VBox(20);
      paneForRadioButtons.setPadding(new Insets(5,5,5,5));
      paneForRadioButtons.setStyle("-fx-border-color: green");
      paneForRadioButtons.setStyle("-fx-border-width: 2px; -ffx-border-color: green");
      RadioButton rbCyan = new RadioButton("Cyan");
      RadioButton rbMagenta = new RadioButton("Magenta");
      RadioButton rbOrange = new RadioButton("Orange");
      paneForRadioButtons.getChildren().addAll(rbCyan, rbMagenta, rbOrange);
      pane.setRight(paneForRadioButtons);
      
      ToggleGroup group = new ToggleGroup();
      rbCyan.setToggleGroup(group);
      rbMagenta.setToggleGroup(group);
      rbOrange.setToggleGroup(group);
      
      rbCyan.setOnAction(e -> {
         if(rbCyan.isSelected()){
            text.setFill(Color.CYAN);
         }
      });
      
      rbMagenta.setOnAction(e -> {
         if(rbMagenta.isSelected()){
            text.setFill(Color.MAGENTA);
         }
      });
      
      rbOrange.setOnAction(e -> {
         if(rbOrange.isSelected()){
            text.setFill(Color.ORANGE);
         }
      });
      
      return pane;
   }
}

class RectanglePane extends Pane {

   public final double width = 30;
   public final double height = 15;
   private double x = width, y = height;
   private double dx = 1, dy = 1;
   private Rectangle rectangle = new Rectangle(x, y);
   private Timeline animation;
   
   public RectanglePane(){ 
      rectangle.setFill(Color.RED);  
      getChildren().add(rectangle);
      animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveRectangle()));
      animation.setCycleCount(Timeline.INDEFINITE);
      animation.play();
   }   
   
   public void play(){
      animation.play();
   }
   
   public void pause(){
      animation.pause();
   }
   
   public void increaseSpeed(){
      animation.setRate(animation.getRate() + 0.1);
   }         
   
   public void decreaseSpeed(){
      animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
   }
   
   public DoubleProperty rateProperty(){
      return animation.rateProperty();
   }
   
   protected void moveRectangle(){
      if (x < width || x > getWidth() - width){
         dx *= -1;
      }
      
      if (y < height || y > getHeight() - height){
         dy *= -1;
      }
      
      x += dx;
      y += dy;
      rectangle.setX(x);
      rectangle.setY(y);
      
   }
}                  

class RectangleSlider extends RadioButtons {
   @Override
   protected BorderPane getPane(){
      BorderPane pane = super.getPane();
   
      RectanglePane rectanglePane = new RectanglePane();
      Slider slSpeed = new Slider();
      slSpeed.setMax(20);
      rectanglePane.rateProperty().bind(slSpeed.valueProperty());
      
      BorderPane rPane = new BorderPane();
      rPane.setTop(rectanglePane);
      rPane.setBottom(slSpeed);
      
      pane.setTop(rPane);
      
      return pane;
   }
}
/*
class MediaDemo extends RectangleSlider {
   @Override
   protected BorderPane getPane(){
      BorderPane pane = super.getPane();
      final String MEDIA_URL = "http://www.unf.edu/~n00901846/20150630_205906.mp4";   
      Media media = new Media(MEDIA_URL);
      MediaPlayer mediaPlayer = new MediaPlayer(media);
      MediaView mediaView = new MediaView(mediaPlayer);
      mediaView.setFitWidth(320);
      mediaView.setFitHeight(420);
      mediaView.setPreserveRatio(false);

      Button playButton = new Button(">");
      playButton.setOnAction(e -> {
        if (playButton.getText().equals(">")) {
         mediaPlayer.play();
         playButton.setText("||");
        } else {
         mediaPlayer.pause();
         playButton.setText(">");
        }
      });

      Button rewindButton = new Button("<<");
      rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));
    
      Slider slVolume = new Slider();
      slVolume.setPrefWidth(150);
      slVolume.setMaxWidth(Region.USE_PREF_SIZE);
      slVolume.setMinWidth(30);
      slVolume.setValue(50);
      mediaPlayer.volumeProperty().bind(
        slVolume.valueProperty().divide(100));

      HBox hBox = new HBox(10);
      hBox.setAlignment(Pos.CENTER);
      hBox.getChildren().addAll(playButton, rewindButton,
        new Label("Volume"), slVolume);

      BorderPane vpane = new BorderPane();
      vpane.setCenter(mediaView);
      vpane.setBottom(hBox);  
      
      twoPanes.setRight(vpane);
      
//      pane.setCenter(vpane);
      pane.setCenter(vpane);
      
      return pane;
   }  
}*/
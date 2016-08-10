/*

Riya Gharat             n00901846
11/17/2015


Write a single program that produces Figure 14.52 (part b)  and
Figure 14.48  (part a)  and Figure 14.45 (part b).  All three should be visible at
the same time in a single window. 

In addition, the clock (figure 14.52 part b)should have your name inside it, displayed horizontally 
between the 9 and the 3.  Note that the time displayed is based upon random numbers and should vary with each run. 
 A single program should only produce a single display of all three figures. Resizing of the window should be 
possible and should preserve the figures as much as possible.*/


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.text.Text;
import javafx.animation.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.Collections;

public class Program6 extends Application{

   private static final int RADIUS = 100;
   private static final int GAP = 10;
   
   @Override
   public void start(Stage primaryStage){ 

  // Figure 14.45 (b)
     
      GridPane gridPane = new GridPane();
      gridPane.setHgap(5);
      gridPane.setVgap(5);
      gridPane.setPadding(new Insets(10));      
      
      Pane pane = new Pane();
    int x = RADIUS + GAP;
      int y = RADIUS + GAP;

      for (int i = 0; i < 2; i++) {

         // drawing a 2 Circles in each row
         for (int j = 0; j < 2; j++) {
            // create circle
            Circle circle = new Circle(RADIUS);
            circle.setCenterX(x);
            circle.setCenterY(y);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.WHITE);
            pane.getChildren().add(circle);

            // create 4 arcs in each circle with 90 degree increment
            for (int k = 30; k < 360; k += 90) {
               Arc arc = new Arc(x, y, RADIUS - 15,RADIUS - 15,k,30);
               arc.setFill(Color.BLACK);
               arc.setType(ArcType.ROUND);
               pane.getChildren().add(arc);
            }
            x += RADIUS * 2 + GAP;
         }
         // reset center for the next row
         x = RADIUS + GAP;
         y += RADIUS * 2 + GAP;
      }
         
            
   // Figure 14.48 (a)
    
      
    Pane pane2 = new Pane();
  
    Circle circle2 = new Circle(20);
      circle2.setCenterX(150);
      circle2.setCenterY(60);
      circle2.setStroke(Color.BLACK);
      circle2.setFill(Color.WHITE);
      pane2.getChildren().add(circle2);
      
      Line line = new Line();
      line.setStartX(150.0f);
      line.setStartY(20.0f);
      line.setEndX(150.0f);
      line.setEndY(41.0f);
      pane2.getChildren().add(line);
      
      Line line2 = new Line();
      line2.setStartX(50.0f);
      line2.setStartY(20.0f);
      line2.setEndX(150.0f);
      line2.setEndY(20.0f);
      pane2.getChildren().add(line2);
      
      Line line3 = new Line();
      line3.setStartX(50.0f);
      line3.setStartY(20.0f);
      line3.setEndX(50.0f);
      line3.setEndY(175.0f);
      pane2.getChildren().add(line3);
      
      Line line4 = new Line();
      line4.setStartX(150.0f);
      line4.setStartY(80.0f);
      line4.setEndX(150.0f);
      line4.setEndY(125.0f);
      pane2.getChildren().add(line4);
      
      Line line5 = new Line();
      line5.setStartX(133.0f);
      line5.setStartY(73.0f);
      line5.setEndX(100.0f);
      line5.setEndY(100.0f);
      pane2.getChildren().add(line5);
      
      Line line6 = new Line();
      line6.setStartX(165.0f);
      line6.setStartY(73.0f);
      line6.setEndX(200.0f);
      line6.setEndY(100.0f);
      pane2.getChildren().add(line6);
      
      Line line7 = new Line();
      line7.setStartX(150.0f);
      line7.setStartY(125.0f);
      line7.setEndX(125.0f);
      line7.setEndY(160.0f);
      pane2.getChildren().add(line7);
      
      Line line8 = new Line();
      line8.setStartX(150.0f);
      line8.setStartY(125.0f);
      line8.setEndX(175.0f);
      line8.setEndY(160.0f);
      pane2.getChildren().add(line8);
      
      Arc arc = new Arc();
      arc.setCenterX(50.0f);
      arc.setCenterY(175.0f);
      arc.setRadiusX(25.0f);
      arc.setRadiusY(25.0f);
      arc.setStartAngle(0.0f);
      arc.setLength(180.0f);
      arc.setType(ArcType.OPEN);
      arc.setFill(Color.WHITE);
      arc.setStroke(Color.BLACK);
      pane2.getChildren().add(arc); 
      
            
      // Figure 14.52 (b)
      
      int hour = (int)(Math.random() * 12);
    int minute = (int)(Math.random() * 31);
    ClockPane clock = new ClockPane(hour, minute, 0);
      clock.setMinuteHandVisible(true);
    Pane pane3 = new Pane(clock);    
      
      
    gridPane.add(pane, 0, 0);
    gridPane.add(pane2, 1 ,0);
    gridPane.add(pane3, 2, 0);  
    Scene scene = new Scene(gridPane, 900, 450);
        
    primaryStage.setTitle("Three figures");
    primaryStage.setScene(scene);
      primaryStage.show();
   }
   
  public static void main(String[] args) {
    launch(args);
  }
}

class ClockPane extends Pane {

    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;
    private Timeline timeline;

    // Clock pane's width and height
    private double w = 250, h = 250;

    /** Construct a default clock with the current time*/
    public ClockPane() {
        setPrefHeight(h);
        setPrefWidth(w);
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> update()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        setCurrentTime();
    }

    /** Construct a clock with specified hour, minute, and second */
    public ClockPane(int hour, int minute, int second) {
        this();
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    public ClockPane(int hour, int minute, int second, double width, double height) {
        this(hour, minute, second);
        this.w = width;
        this.h = height;
        paintClock();
    }

    /** Return hour */
    public int getHour() {
        return hour;
    }

    /** Set a new hour */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /** Return minute */
    public int getMinute() {
        return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    /** Return second */
    public int getSecond() {
        return second;
    }

    /** Set a new second */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    /** Return clock pane's width */
    public double getW() {
        return w;
    }

    /** Set clock pane's width */
    public void setW(double w) {
        this.w = w;
        paintClock();
    }

    /** Return clock pane's height */
    public double getH() {
        return h;
    }

    /** Set clock pane's height */
    public void setH(double h) {
        this.h = h;
        paintClock();
    }

    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    public void setHourHandVisible(boolean hourHandVisible) {
        this.hourHandVisible = hourHandVisible;
        paintClock();
    }

    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    public void setMinuteHandVisible(boolean minuteHandVisible) {
        this.minuteHandVisible = minuteHandVisible;
        paintClock();
    }

    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    public void setSecondHandVisible(boolean secondHandVisible) {
        this.secondHandVisible = secondHandVisible;
        paintClock();
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
        // Construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock(); // Repaint the clock
    }

    /** Paint the clock */
    private void paintClock() {
        // Initialize clock parameters
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;
        Point2D center = new Point2D(centerX, centerY);
        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
         
        //Write My Name
        Text text = new Text(centerX-40, centerY, "RIYA GHARAT");
         
        // Draw time numbers
        Text[] texts = new Text[12];
        for (int i = 0; i < 12; i++) {
            int time = (i + 3 > 12) ? i + 3 - 12 : i + 3;
            Point2D b = new Point2D(
                    centerX + clockRadius * Math.cos(i * 2 * Math.PI / 12),
                    centerY + clockRadius * Math.sin(i * 2 * Math.PI / 12));
            b = getPointBCloserToA(center, b, 0.82);
            texts[i] = new Text(b.getX() - (clockRadius * 0.03125), b.getY() + (clockRadius * 0.025), "" + time);
        }

        // Draw dashes
        Line[] dashes = new Line[60];
        for (int i = 0; i < dashes.length; i++) {
            Point2D start = new Point2D(
                    centerX + clockRadius * Math.cos(i * 2 * Math.PI / 60),
                    centerY + clockRadius * Math.sin(i * 2 * Math.PI / 60));
            double coefficient = (i % 5 == 0) ? 0.91 : 0.955;
            Point2D end = getPointBCloserToA(center,start, coefficient);
            dashes[i] = new Line(start.getX(), start.getY(), end.getX(), end.getY());
        }

        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
                Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
                Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);
        sLine.setVisible(isSecondHandVisible());

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
                Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
                Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);
        mLine.setVisible(isMinuteHandVisible());

        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);
        hLine.setVisible(isHourHandVisible());
        // Draw time HH:MM:SS
        String s = "" + getHour() + ":" + getMinute() + ":" + getSecond();
        Text timeText = new Text(getW() * 0.4, getH() - 10, s);

        // Adding nodes to pane
        getChildren().clear();
        ObservableList<Node> list = getChildren();
        list.add(circle);
        Collections.addAll(list, dashes);
        Collections.addAll(list, texts);
        list.addAll(sLine, mLine, hLine, timeText);
        getChildren().add(text);
    }

    public void start(){
        timeline.play();
    }

    public void stop(){
        timeline.pause();
    }

    private void update(){
        setCurrentTime();
        paintClock();
    }

    private Point2D getPointBCloserToA(Point2D a, Point2D b, double coefficient) {

        double deltaX = b.getX() - a.getX();
        double deltaY = b.getY() - a.getY();

        return new Point2D(
                a.getX() + coefficient * deltaX,
                a.getY() + coefficient * deltaY);
    }
} 
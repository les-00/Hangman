
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Stickman extends Pane {

	private Pane root = new Pane();
	private double radius = 35;
	private double rope_length = 45;
	private double arm_length = 230;
	private Line pole_arm = new Line();
	private double waist_length = 100 + (80 + rope_length + 2 * radius);
	private Timeline anim;
	private boolean isPlay = false;
	
	
	
	public boolean isPlay() {
		return isPlay;
	}

	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}

	

	public Stickman() {
		// TODO Auto-generated constructor stub
		setHeight(620);
		setWidth(500);
		drawFullHangMan();
		animateHangMan();
	}
	
	public void playAnim() {anim.play(); isPlay = true;}
	public void stopAnim() {anim.stop(); isPlay = false;}
	private void animateHangMan()
	{
		EventHandler<ActionEvent> event = e ->
		{
			if(arm_length >= 400)
			{
				arm_length = 60;
				drawFullHangMan();
			}
			else
			{
				arm_length += 10;
				drawFullHangMan();
			}
		};
		
		
		anim = new Timeline(new KeyFrame(Duration.millis(40), event));
		anim.setCycleCount(Timeline.INDEFINITE);
		//anim.play();
	}
	
	public void drawPost()
	{
		//Draw stand(rectangle) near bottom of pane
		Rectangle rect = new Rectangle(140, 180);
		rect.setY(400);
		rect.setX(30);
		rect.setFill(Color.BLUE);
		
		//Draw the pole
		Line line = new Line();
		line.setStartX(75);
		line.setStartY(80);
		line.setEndX(75);
		line.setEndY(400);
		
		//Draw arm
		pole_arm.setStartX(75);
		pole_arm.setStartY(80);
		pole_arm.setEndX(arm_length);
		pole_arm.setEndY(80);
		
		getChildren().addAll(rect, line, pole_arm);
		
	}
	
	public void drawRope()
	{
		Line line = new Line();
		line.setStartX(arm_length);
		line.setStartY(80);
		line.setEndX(arm_length);
		line.setEndY(80 + rope_length );
		getChildren().add(line);
	}
	
	
	public void drawHead()
	{
		Circle head = new Circle(radius );
		head.setCenterX(arm_length);
		head.setCenterY(80 + (radius + rope_length));
		head.setFill(Color.RED);
		getChildren().add(head);
	}
	
	private void drawArm(double x, double y)
	{
		Line line = new Line();
		line.setStartX(arm_length);
		line.setStartY(80 + rope_length+ (2*radius));
		line.setEndX(x);
		line.setEndY(y);
		getChildren().add(line);
	}
	
	public void drawRightArm()
	{
		drawArm(arm_length + 50, 300);
	}
	
	public void drawLeftArm()
	{
		drawArm(arm_length - 50, 300);
	}
	
	public void drawWaist()
	{
		Line line = new Line();
		line.setStartX(arm_length);
		line.setStartY(80 + rope_length+ (2*radius));
		line.setEndX(arm_length);
		line.setEndY(waist_length);
		getChildren().add(line);
	}
	
	private void drawLegs(double x, double y)
	{
		Line line = new Line();
		line.setStartX(arm_length);
		line.setStartY(waist_length);
		line.setEndX(x);
		line.setEndY(y);
		getChildren().add(line);
	}
	
	public void drawRightLeg() {
		drawLegs(arm_length + 40, waist_length + 120);
	}
	public void drawLeftLeg() {
		drawLegs(arm_length - 40, waist_length + 120);
	}
	
	
	public void drawFullHangMan()
	{
		getChildren().clear();
		drawPost();
		drawRope();
		drawHead();
		drawWaist();
		drawRightLeg();
		drawLeftLeg();
		drawRightArm();
		drawLeftArm();
	}
}

import greenfoot.*;

public class Punkt extends Actor {
    public Punkt() {
        setImage("gold-ball.png");
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }
}

package environment;

import main.GamePanel;

import java.awt.*;

public class EnvironmentManager {
    GamePanel gp;
    public Lighting lighting;
    public Light light;

    public EnvironmentManager(GamePanel gp) {
        this.gp = gp;

    }
    public void update(){
        lighting.update();
        light.update();
    }
    public void setup(){

        lighting = new Lighting(gp);
         light = new Light(gp);

    }
    public void draw(Graphics2D g2){
        lighting.draw(g2);
        //light.draw(g2);

    }
}

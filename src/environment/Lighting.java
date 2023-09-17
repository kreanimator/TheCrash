package environment;
import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Lighting {

    GamePanel gp;
    BufferedImage darknessFilter;
    public int dayCounter = 0;
    public float filterAlfa = 0f;
    //Day state
    public final int day =0;
    public final int dusk = 1;
    public final int night = 2;
    public final int dawn = 3;
    public int dayState = day;
    public boolean nightOn = false;




    public Lighting(GamePanel gp) {
        this.gp = gp;
        setLight();


    }
    public void setLight(){
        // Create a buffered image
        darknessFilter = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D)darknessFilter.getGraphics();
        if(gp.player.currentLight ==null ) {
        g2.setColor(new Color(0,0,0,0.97f));
        } else {

            // Get the center x and y of the light circle
            int centerX = gp.player.screenX + (gp.tileSize) / 2;
            int centerY = gp.player.screenY + (gp.tileSize) / 2;

            // Create a gradation effect
            Color[] color = new Color[12];
            float[] fraction = new float[12];

            color[0] = new Color(0, 0, 0.1f, 0.1f);
            color[1] = new Color(0, 0, 0.1f, 0.42f);
            color[2] = new Color(0, 0, 0.1f, 0.52f);
            color[3] = new Color(0, 0, 0.1f, 0.61f);
            color[4] = new Color(0, 0, 0.1f, 0.69f);
            color[5] = new Color(0, 0, 0.1f, 0.76f);
            color[6] = new Color(0, 0, 0.1f, 0.82f);
            color[7] = new Color(0, 0, 0.1f, 0.87f);
            color[8] = new Color(0, 0, 0.1f, 0.91f);
            color[9] = new Color(0, 0, 0.1f, 0.94f);
            color[10] = new Color(0, 0, 0.1f, 0.96f);
            color[11] = new Color(0, 0, 0.1f, 0.98f);

            fraction[0] = 0f;
            fraction[1] = 0.4f;
            fraction[2] = 0.5f;
            fraction[3] = 0.6f;
            fraction[4] = 0.65f;
            fraction[5] = 0.7f;
            fraction[6] = 0.75f;
            fraction[7] = 0.8f;
            fraction[8] = 0.85f;
            fraction[9] = 0.9f;
            fraction[10] = 0.95f;
            fraction[11] = 1f;

            // Create a gradation paint settings
            RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, gp.player.currentLight.lightRadius, fraction, color);

            // Set the gradient data on g2
            g2.setPaint(gPaint);


        }

        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.dispose();
    }

     public void resetDay(){
        dayState = day;
        filterAlfa = 0f;
     }
    public void update(){
        if(gp.player.updateLight){
            setLight();
            gp.player.updateLight = false;
        }
        if(dayState == day){
            dayCounter++;

            if(dayCounter > 6000){
                dayState = dusk;
                dayCounter = 0;
            }
        }
        if (dayState == dusk){
            filterAlfa += 0.001f;
            if(filterAlfa > 1f){
                filterAlfa = 1f;
                dayState = night;
            }
        }
        if (dayState ==night){
            dayCounter++;
            nightOn = true;
            if(dayCounter > 6000){
                dayState = dawn;
                dayCounter = 0;
            }
        }
        if (dayState ==dawn){
            filterAlfa -= 0.001f;
            nightOn = false;
            if (filterAlfa<0){
                filterAlfa =0f;
                dayState =day;
            }
        }
    }
    public void draw(Graphics2D g2){

        if(gp.currentArea == gp.outside) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, filterAlfa));
        }
        if(gp.currentArea == gp.outside || gp.currentArea == gp.cave || gp.currentArea == gp.bunker) {
            g2.drawImage(darknessFilter, 0, 0, null);
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));


        //DEBUG
        int frame1X = gp.tileSize * 20;
        int frame1Y = gp.tileSize/2;
        int frame1Width = gp.tileSize;
        int frame1Height = gp.tileSize;
        g2.setColor(new Color(201, 236, 133));
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
        g2.fillRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        BufferedImage currentDayState = switch (dayState) {
            case day -> setup("ui/daystate/sun", gp.tileSize, gp.tileSize);
            case night -> setup("ui/daystate/moon", gp.tileSize, gp.tileSize);
            case dusk -> setup("ui/daystate/sunset", gp.tileSize, gp.tileSize);
            case dawn -> setup("ui/daystate/sunrise", gp.tileSize, gp.tileSize);

            default -> throw new IllegalStateException("Unexpected value: " + dayState);
        };

        g2.drawImage(currentDayState,gp.tileSize * 20,gp.tileSize / 2,null);
    }
    public BufferedImage setup(String imagePath, int width, int height) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {

            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/" + imagePath + ".png")));
            image = uTool.scaleImage(image, width, height);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }
}

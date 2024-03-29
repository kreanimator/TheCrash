package environment;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.TileObserver;

public class Light {
    GamePanel gp;
    BufferedImage [][] darknessFilter;



    public float filterAlfa = 0f;


    public Light(GamePanel gp) {
        this.gp = gp;
        setEnvLight();
    }

    public  void setEnvLight() {
        // Create a buffered image
        BufferedImage [][] darknessFilter = new BufferedImage[gp.maxMap][500];


        for(int i =0; i< darknessFilter[1].length; i ++) {
            if (darknessFilter[gp.currentMap][i] != null) {
                darknessFilter[gp.currentMap][i] = new BufferedImage(gp.worldWidth, gp.worldHeight, BufferedImage.TYPE_INT_ARGB);



                Graphics2D g2 = (Graphics2D) darknessFilter[gp.currentMap][i].getGraphics();



                for (int j = 0; j < gp.lightSources[1].length; j++) {
                    if (gp.lightSources[gp.currentMap][j] != null) {


                        // Get the center x and y of the light circle
                        int centerX = gp.lightSources[gp.currentMap][j].worldX + gp.tileSize / 2;
                        int centerY = gp.lightSources[gp.currentMap][j].worldY + gp.tileSize / 2;

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
                        RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, gp.lightSources[gp.currentMap][i].lightRadius, fraction, color);

                        // Set the gradient data on g2
                        g2.setPaint(gPaint);


                    }

                    g2.fillRect(0, 0, gp.worldWidth, gp.worldHeight);

                    g2.dispose();
                }
            }
        }


    }

    public void draw(Graphics2D g2) {
for (int i =0; i < darknessFilter[1].length; i++) {
    if (darknessFilter[gp.currentMap][i] != null) {
        if (gp.currentArea == gp.outside) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, filterAlfa));
        }
        if (gp.currentArea == gp.outside || gp.currentArea == gp.cave || gp.currentArea == gp.bunker) {
            g2.drawImage(darknessFilter[gp.currentMap][i], 0, 0, null);
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
    }


    public void update() {

        for (int i = 0; i < gp.lightSources[1].length; i++) {


                    setEnvLight();





        }
    }
}

package entity;

import main.GamePanel;

import java.awt.*;

public class Particles extends Entity{

    Entity generator;
    Color color;
    int size;
    int xd;
    int yd;

    public Particles(GamePanel gp , Entity generator, Color color, int size, int speed, int maxHP, int xd, int yd) {
        super(gp);

        this.generator = generator;
        this.color = color;
        this.size = size;
        this.speed = speed;
        this.maxHP = maxHP;
        this.xd = xd;
        this.yd = yd;

        life = maxHP;

        int offset = (gp.tileSize/2) - (size/2);
        worldX = generator.worldX + offset;
        worldY = generator.worldY + offset;
    }
    public void update(){
        life --;
        if(life > maxHP/3){
            yd++;
            size--;
        }
        worldX += xd * speed;
        worldY += yd * speed;
        if (life ==0){
            alive = false;
        }

    }
    public void draw(Graphics2D g2){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY= worldY - gp.player.worldY + gp.player.screenY;

        g2.setColor(color);
        g2.fillRect(screenX,screenY,size,size);

    }
}

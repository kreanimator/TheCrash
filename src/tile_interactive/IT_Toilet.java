package tile_interactive;

import entity.Entity;
import main.GamePanel;
import object.misc.OBJ_HPPack;
import object.misc.OBJ_Money;

import java.awt.*;
import java.util.Random;

public class IT_Toilet extends InteractiveTile{
    GamePanel gp;
    public static final String itName = "Toilet";
    public IT_Toilet(GamePanel gp , int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        name = itName;

        life = 1;

        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;
        solidArea.x = 14;
        solidArea.y = 14;
        solidArea.width = 20;
        solidArea.height = 20;

        down1=(setup("objects/interactiveobjects/toilet1",gp.tileSize/2,gp.tileSize/2));
        destructible=true;
    }
    public boolean isCorrectItem(Entity entity){
        boolean isCorrectItem = false;
        if(entity.currentWeapon.type == typeCrowbar || entity.currentWeapon.type == typeMelee){
            isCorrectItem = true;
        }
        return isCorrectItem;
    }
    public void playSE(){
        gp.playSE(18);

    }
    public InteractiveTile getDestroyedForm(){
        InteractiveTile tile = new IT_BrokenToilet(gp,worldX/gp.tileSize,worldY/gp.tileSize);
        checkDrop();
        return tile;

    }
    public Color getParticleColor(){
        Color color = new Color(65,50,35);
        return color;
    }
    public int getParticleSize(){
        int size = 10;
        return size;
    }
    public int getParticleSpeed(){
        int speed = 1;
        return speed;
    }
    public int getParticleLife(){
        int maxHP = 10;
        return maxHP;
    }
    public void checkDrop(){
        int i = new Random().nextInt(100)+1;

        //SET THE CRATE DROP

        if (i <50){
            dropItem(new OBJ_Money(gp));
        }
        if (i >=50 && i < 100){
            dropItem(new OBJ_HPPack(gp));
        }


    }
}


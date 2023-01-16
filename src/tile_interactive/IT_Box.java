package tile_interactive;

import entity.Entity;
import main.GamePanel;
import object.misc.OBJ_Money;
import object.misc.OBJ_HPPack;

import java.awt.*;
import java.util.Random;

public class IT_Box extends InteractiveTile{

    GamePanel gp;
    public static final String itName = "Box";
    public IT_Box(GamePanel gp , int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        name = itName;

        life = 3;

        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;

        down1=(setup("objects/interactiveobjects/destructiblebox",gp.tileSize,gp.tileSize));
        destructible=true;
    }
    public boolean isCorrectItem(Entity entity){
        boolean isCorrectItem = false;
        if(entity.currentWeapon.type == typeCrowbar){
            isCorrectItem = true;
        }
        return isCorrectItem;
    }
    public void playSE(){
        gp.playSE(15);

    }
    public InteractiveTile getDestroyedForm(){
        InteractiveTile tile = new IT_BrokenBox(gp,worldX/gp.tileSize,worldY/gp.tileSize);
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

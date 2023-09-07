package object.projectiles;

import entity.Entity;
import entity.Projectiles;
import main.GamePanel;

import java.awt.*;

public class OBJ_Acid extends Projectiles {
    public final static String objName = "Acid";
    GamePanel gp;
    public OBJ_Acid(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = objName;
        speed = 10;
        maxHP = 80;
        life = maxHP;
        knockBackPower = 0;
        attack = 4;
        useCost = 1;
        alive = false;

        solidArea.width = 15;
        solidArea.height = 15;
        solidArea.x = gp.tileSize/2;
        solidArea.y = gp.tileSize/2;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        getImage();



    }


    public void getImage(){
        up1 = setup("objects/acid/acidup",gp.tileSize,gp.tileSize);
        up2 = setup("objects/acid/acidup2",gp.tileSize,gp.tileSize);
        down1 = setup("objects/acid/aciddown",gp.tileSize,gp.tileSize);
        down2 = setup("objects/acid/aciddown2",gp.tileSize,gp.tileSize);
        left1 = setup("objects/acid/acidleft",gp.tileSize,gp.tileSize);
        left2 = setup("objects/acid/acidleft2",gp.tileSize,gp.tileSize);
        right1  = setup("objects/acid/acidright",gp.tileSize,gp.tileSize);
        right2 = setup("objects/acid/acidright2",gp.tileSize,gp.tileSize);
    }

    public boolean haveResource(Entity user){
        boolean haveResource =false;
        if(user.pistolAmmo >= useCost){
            haveResource = true;
        }
        return haveResource;
    }
    public void subtractResource(Entity user){

        user.pistolAmmo -= useCost;
    }

    public Color getParticleColor(){
        Color color = new Color(75, 245, 8);
        return color;
    }
    public int getParticleSize(){
        int size = 8;
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
}


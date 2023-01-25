package object.weapon;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class OBJ_Crowbar extends Entity {

    public final static String objName = "Crowbar";
    public OBJ_Crowbar(GamePanel gp) {
        super(gp);
        type = typeCrowbar;
        price = 1000;
        name = objName;
        down1 = setup("objects/crowbar",gp.tileSize/2,gp.tileSize/2);
        attackValue = 6;
        knockBackPower = 10;
        description = "[" + name + "]\nAttack value: " + attackValue + "\nOld rusty crowbar.\n Dangerous as a weapon.\n Can brake some objects.";
        attackArea.width = 12;
        attackArea.height = 24;
        motion1Duration = 10;
        motion2Duration = 20;
        motion3Duration = 30;
    }
    public Color getParticleColor(){
        Color color = new Color(220, 1, 44);
        return color;
    }
    public int getParticleSize(){
        int size = 6;
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

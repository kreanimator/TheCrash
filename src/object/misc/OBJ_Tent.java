package object.misc;

import entity.Entity;
import main.GamePanel;

public class OBJ_Tent extends Entity {
    GamePanel gp;
    public final static String objName = "Tent";
    public OBJ_Tent(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = typeConsumable;
        name = objName;
        down1 = setup("objects/tent",gp.tileSize/2,gp.tileSize/2);
        description = "[Tent]\nAn old tent\nCan help you to survive a\n long night...";
        price = 400;
        stackable = true;

    }
    public boolean use(Entity entity){

        gp.gameState = gp.sleepState;
        gp.playSE(23);
        gp.player.life = gp.player.maxHP;
        gp.player.getSleepImage(down1);
        return true;

    }
    }


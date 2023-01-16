package object.misc;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class OBJ_Money extends Entity {

    GamePanel gp;
    public final static String objName = "Money";


    public OBJ_Money(GamePanel gp) {
        super(gp);
        Random rand = new Random();
        this.gp = gp;
        type = typePickupOnly;
        value = rand.nextInt(5,100);
        name = objName;
        down1 = setup("objects/money",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\nSome old prewar money. May be valuable.";

    }
    public boolean use (Entity entity){
        gp.playSE(3);
        gp.ui.addMessage("Money " + value);
        gp.player.coin += value;
        return true;

    }
}

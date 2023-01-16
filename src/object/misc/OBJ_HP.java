package object.misc;

import entity.Entity;
import main.GamePanel;

public class OBJ_HP extends Entity {

public final static String objName = "HP";
    public OBJ_HP(GamePanel gp) {
        super(gp);
        name = objName;

        image = setup("hpbar/0",gp.tileSize-10,gp.tileSize-10);
        image2 = setup("hpbar/2",gp.tileSize-10,gp.tileSize-10);
        image3 = setup("hpbar/4",gp.tileSize-10,gp.tileSize-10);


    }
}


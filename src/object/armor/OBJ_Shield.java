package object.armor;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield extends Entity {

    public final static String objName = "Haywemen's shield";
    public OBJ_Shield(GamePanel gp) {
        super(gp);
        type = typeShield;
        price = 200;
        name = objName;
        down1 = setup("objects/shield",gp.tileSize/2,gp.tileSize/2);
        defenseValue = 1;
        description = "[" + name + "]\nDefense value: " + defenseValue + "\nSimple shield \n Made of garbage";
    }
}

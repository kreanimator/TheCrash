package object.armor;

import entity.Entity;
import main.GamePanel;

public class OBJ_BarrelShield extends Entity {

    public final static String objName = "Barrel shield";
    public OBJ_BarrelShield(GamePanel gp) {
        super(gp);
        type = typeShield;
        price = 2000;
        name = objName;
        down1 = setup("objects/barrelshield",gp.tileSize/2,gp.tileSize/2);
        defenseValue = 3;
        description = "[" + name + "]\nDefense value: " + defenseValue + "\nStrong shield \n Made of half a barrel";
    }
}

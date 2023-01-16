package object.armor;

import entity.Entity;
import main.GamePanel;

public class OBJ_Armor_Learther extends Entity {
    public final static String objName = "Leather armor";
    public OBJ_Armor_Learther(GamePanel gp) {
        super(gp);
        type = typeArmor;
        price = 200;
        name = objName;
        down1 = setup("objects/leatherArmor",gp.tileSize/2,gp.tileSize/2);
        defenseValue = 1;
        description = "[" + name + "]\nDefense value: " + defenseValue + "\nBasic leather armor.\nBefore a great war \nyou might be cool in it.";
    }
}

package object.armor;

import entity.Entity;
import main.GamePanel;

public class OBJ_Armor_Metal extends Entity {
    public final static String objName = "Metal armor";
    public OBJ_Armor_Metal(GamePanel gp) {
        super(gp);
        type = typeArmor;
        price = 2000;
        name = objName;
        down1 = setup("objects/metalArmor",gp.tileSize/2,gp.tileSize/2);
        defenseValue = 5;
        description = "[" + name + "]\nDefense value: " + defenseValue + "\n Armor with high defense.";
    }
}

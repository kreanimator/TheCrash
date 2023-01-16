package object.weapon;

import entity.Entity;
import main.GamePanel;

public class OBJ_Pistol extends Entity {
    public final static String objName = "Pistol";
    public OBJ_Pistol(GamePanel gp) {
        super(gp);
        type = typePistol;
        price = 1500;
        name = objName;
        down1 = setup("objects/pistol",gp.tileSize/2,gp.tileSize/2);
        attackValue = 5;
        knockBackPower = 0;
        description = "[" + name + "]\nAttack value: " + attackValue + "\nStandard 10mm pistol.";

        attackArea.width = 0;
        attackArea.height = 0;
        motion1Duration = 5;
        motion2Duration = 15;
        motion3Duration = 25;
    }
}

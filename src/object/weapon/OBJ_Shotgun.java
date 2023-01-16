package object.weapon;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shotgun extends Entity {
    public final static String objName = "Shotgun";

    public OBJ_Shotgun(GamePanel gp) {
        super(gp);
        type = typeShotgun;
        price = 3000;
        name = objName;
        down1 = setup("objects/shotgun",gp.tileSize/2,gp.tileSize/2);
        image = setup("objects/shotgun",gp.tileSize/2,gp.tileSize/2);
        attackValue = 10;
        knockBackPower = 10;
        description = "[" + name + "]\nAttack value: " + attackValue + "\nOld good shotgun...";

        attackArea.width = 0;
        attackArea.height =0;
        motion1Duration = 15;
        motion2Duration = 25;
        motion3Duration = 35;
    }
}

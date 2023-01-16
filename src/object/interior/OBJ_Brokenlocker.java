package object.interior;

import entity.Entity;
import main.GamePanel;

public class OBJ_Brokenlocker extends Entity {
    GamePanel gp;
    public final static String objName = "Broken locker";
    public OBJ_Brokenlocker(GamePanel gp) {
        super(gp);
        type = typeObstacle;
        name = objName;
        image = setup("objects/interior/brokenlocker", gp.tileSize, gp.tileSize);
        down1 = image;
        collision = true;
        this.gp = gp;
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}

package object.interior;

import entity.Entity;
import main.GamePanel;

public class OBJ_Table extends Entity {
    GamePanel gp;
    public final static String objName = "Table";

    public OBJ_Table(GamePanel gp) {
        super(gp);
        type = typeObstacle;
        name = objName;
        image = setup("objects/interior/table", gp.tileSize, gp.tileSize);
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

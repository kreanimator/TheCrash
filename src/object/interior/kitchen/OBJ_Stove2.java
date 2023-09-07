package object.interior.kitchen;

import main.GamePanel;
import object.Object;

public class OBJ_Stove2 extends Object {
    GamePanel gp;
    public final static String objName = "Stove2";

    public OBJ_Stove2(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 6;
        solidArea.y = 16;
        solidArea.width = 20;
        solidArea.height = 14;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize - 16;
        int height = gp.tileSize - 10;

        down1 = setup("tiles/interior/kitchen/stove2", width, height);
    }

    public void interact() {
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
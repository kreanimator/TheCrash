package object.interior.shelves;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_Shelf1 extends Object {
    GamePanel gp;
    public final static String objName = "Shelf1";



    public OBJ_Shelf1(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        type = typeObstacle;
        name = objName;
        int height = gp.tileSize*2;
        int width = gp.tileSize+20;
        image = setup("tiles/interior/shelves/shelf1", width, height);
        down1 = image;
        collision = true;
        solidArea.x = 14;
        solidArea.y = 60;
        solidArea.width = 38;
        solidArea.height = 24;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }


    public void interact() {
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;

    }
}

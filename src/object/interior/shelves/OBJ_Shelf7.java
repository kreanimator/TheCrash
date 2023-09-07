package object.interior.shelves;

import main.GamePanel;
import object.Object;

public class OBJ_Shelf7 extends Object {
    GamePanel gp;
    public final static String objName = "Shelf7";



    public OBJ_Shelf7(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        type = typeObstacle;
        name = objName;
        int height = (gp.tileSize*2)+12;
        int width = gp.tileSize+36;
        image = setup("tiles/interior/shelves/shelf7", width, height);
        down1 = image;
        collision = true;
        solidArea.x = 14;
        solidArea.y = 60;
        solidArea.width = gp.tileSize+10;
        solidArea.height = 24;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }


    public void interact() {
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;

    }
}

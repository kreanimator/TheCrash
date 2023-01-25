package object.interior.tables;

import main.GamePanel;
import object.Object;

public class OBJ_Table4 extends Object {
    GamePanel gp;
    public final static String objName = "Table4";

    public OBJ_Table4(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 10;
        solidArea.y = 14;
        solidArea.width = 40;
        solidArea.height = 30;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize+14;
        int height = gp.tileSize +14;

        down1 = setup("tiles/interior/tables/table4", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}

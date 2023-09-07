package object.interior.beds.matresses;

import main.GamePanel;
import object.Object;

public class OBJ_Matress3 extends Object {
    GamePanel gp;
    public final static String objName = "Matress3";

    public OBJ_Matress3(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 4;
        solidArea.y = 2;
        solidArea.width = 42;
        solidArea.height = gp.tileSize-2;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize + 10;

        down1 = setup("tiles/interior/beds/matress3", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }

}
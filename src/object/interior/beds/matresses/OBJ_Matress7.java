package object.interior.beds.matresses;

import main.GamePanel;
import object.Object;

public class OBJ_Matress7 extends Object {
    GamePanel gp;
    public final static String objName = "Matress7";

    public OBJ_Matress7(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 16;
        solidArea.y = gp.tileSize;
        solidArea.width = 30;
        solidArea.height = gp.tileSize-12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize+12;
        int height = gp.tileSize *2;

        down1 = setup("tiles/interior/beds/matress7", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }

}
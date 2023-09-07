package object.interior.chairs;

import main.GamePanel;
import object.Object;

public class OBJ_Softchair2 extends Object {
    GamePanel gp;
    public final static String objName = "Softchair2";

    public OBJ_Softchair2(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 22;
        solidArea.height = 18;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize-12;
        int height = gp.tileSize;

        down1 = setup("tiles/interior/chairs/softchair2", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}

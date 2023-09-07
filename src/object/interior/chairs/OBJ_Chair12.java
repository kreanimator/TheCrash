package object.interior.chairs;

import main.GamePanel;
import object.Object;

public class OBJ_Chair12 extends Object {
    GamePanel gp;
    public final static String objName = "Chair12";

    public OBJ_Chair12(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 4;
        solidArea.y = 10;
        solidArea.width = 14;
        solidArea.height = 10;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = 22;
        int height = 28;

        down1 = setup("tiles/interior/chairs/chair12", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
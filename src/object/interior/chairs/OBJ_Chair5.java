package object.interior.chairs;

import main.GamePanel;
import object.Object;

public class OBJ_Chair5 extends Object {
    GamePanel gp;
    public final static String objName = "Chair5";

    public OBJ_Chair5(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 2;
        solidArea.y = 16;
        solidArea.width = 26;
        solidArea.height = 10;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize-12;
        int height = 30;

        down1 = setup("tiles/interior/chairs/chair5", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}

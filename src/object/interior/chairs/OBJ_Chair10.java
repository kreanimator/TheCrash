package object.interior.chairs;

import main.GamePanel;
import object.Object;

public class OBJ_Chair10 extends Object {
    GamePanel gp;
    public final static String objName = "Chair10";

    public OBJ_Chair10(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 2;
        solidArea.y = 14;
        solidArea.width = 14;
        solidArea.height = 10;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = 18;
        int height = gp.tileSize-12;

        down1 = setup("tiles/interior/chairs/chair10", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
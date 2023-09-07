package object.exterior.doors;

import entity.Entity;
import main.GamePanel;
import object.Object;


public class OBJ_Door3 extends Object {

    GamePanel gp;
    public final static String objName = "Door3";
    boolean opened = false;

    public OBJ_Door3(GamePanel gp, int col, int row) {
        super(gp,col,row);
        int height = (gp.tileSize*2)-30 ;
        int width = gp.tileSize+15;

        type = typeObstacle;
        name = objName;
        image = setup("tiles/exterior/doors/door3", width, height);
        image2 = null;
        //image2 = setup("objects/interactiveobjects/dooropened", width, height);
        down1 = image;
        collision = true;
        this.gp = gp;
        solidArea.x = 20;
        solidArea.y = 8;
        solidArea.width = 48;
        solidArea.height = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;


    }

    public void interact() {

        if (!opened) {
            gp.playSE(2);
            down1 = image2;
            opened = true;
            collision = false;
        }else{
            gp.player.attackCanceled = false;
            gp.player.shotCanceled = false;
        }

    }

}
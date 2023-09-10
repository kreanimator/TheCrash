package object.exterior.doors;

import main.GamePanel;
import object.Object;

public class OBJ_HiddenDoor extends Object {

    GamePanel gp;
    public final static String objName = "HiddenDoor";
    boolean opened = false;

    public OBJ_HiddenDoor(GamePanel gp, int col, int row) {
        super(gp,col,row);
        int height = gp.tileSize;
        int width = gp.tileSize;

        type = typeObstacle;
        name = objName;
        image = setup("tiles/exterior/doors/hiddenDoor", width, height);
        image2 = null;
        //image2 = setup("objects/interactiveobjects/dooropened", width, height);
        down1 = image;
        collision = true;
        this.gp = gp;
        solidArea.x = 0;
        solidArea.y = 0;
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


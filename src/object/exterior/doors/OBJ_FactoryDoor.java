package object.exterior.doors;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_FactoryDoor extends Object {

    GamePanel gp;
    public final static String objName = "FactoryDoor";
    boolean opened = false;

    public OBJ_FactoryDoor(GamePanel gp, int col, int row) {
        super(gp, col, row);

        int height = (gp.tileSize*2)-24 ;
        int width = gp.tileSize;

        type = typeObstacle;
        name = objName;
        image = setup("objects/interactiveobjects/factorydoorclosed", width, height);
        image2 = setup("objects/interactiveobjects/factorydooropened", width ,height);
        down1 = image;
        collision = true;
        this.gp = gp;
        solidArea.x = 0;
        solidArea.y = 10;
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

package object.exterior.fences;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_Fenceside2 extends Object {
    GamePanel gp;
    public final static String objName = "Fenceside2";

    public OBJ_Fenceside2(GamePanel gp, int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();
        setAction();

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 12;
        solidArea.height = gp.tileSize*2;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = gp.tileSize*2;
        int width = 12;

        down1 = setup("tiles/exterior/fence_side2", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}

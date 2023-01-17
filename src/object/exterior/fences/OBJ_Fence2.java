package object.exterior.fences;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_Fence2 extends Object {
    GamePanel gp;
    public final static String objName = "Fence2";

    public OBJ_Fence2(GamePanel gp, int col , int row) {
        super(gp, col ,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 0;
        solidArea.y = gp.tileSize;
        solidArea.width = gp.tileSize*2;
        solidArea.height = 6;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize *2;
        int height = gp.tileSize + 24;

        down1 = setup("tiles/exterior/fence2", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}

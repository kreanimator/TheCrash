package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_BasementWall extends Object {
    GamePanel gp;
    public final static String objName = "BasementWall";

    public WL_BasementWall(GamePanel gp, int col, int row) {
        super(gp, col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();


        solidArea.x = 0;
        solidArea.y = gp.tileSize;
        solidArea.width = gp.tileSize * 5;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2) ;
        int width = (gp.tileSize * 6) + 12;

        down1 = setup("tiles/wall/basementWall", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}


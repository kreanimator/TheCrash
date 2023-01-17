package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_RuinedWallFD extends Object {
    GamePanel gp;
    public final static String objName = "RuinedwallFD";

    public WL_RuinedWallFD(GamePanel gp, int col, int row) {
        super(gp, col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();


        solidArea.x = 64;
        solidArea.y = 48;
        solidArea.width = gp.tileSize * 9;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2)-24 ;
        int width = (gp.tileSize * 10)+15;

        down1 = setup("tiles/wall/ruinedwallfd", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}

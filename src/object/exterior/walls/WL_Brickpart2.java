package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_Brickpart2 extends Object {
    GamePanel gp;
    public final static String objName = "Wall Brick Part2";

    public WL_Brickpart2(GamePanel gp, int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();


        solidArea.x = 36;
        solidArea.y = 48;
        solidArea.width = 12;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2)-24 ;
        int width = gp.tileSize;

        down1 = setup("tiles/wall/wallbrickpart2", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}

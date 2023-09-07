package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_FactoryWall5 extends Object {
    GamePanel gp;
    public final static String objName = "FactoryWall5";

    public WL_FactoryWall5(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();


        solidArea.x = 0;
        solidArea.y = 48;
        solidArea.width = gp.tileSize;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2)-24 ;
        int width = gp.tileSize;

        down1 = setup("tiles/wall/factorywall5", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}

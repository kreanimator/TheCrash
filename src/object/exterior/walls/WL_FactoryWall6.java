package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_FactoryWall6 extends Object {
    GamePanel gp;
    public final static String objName = "FactoryWall6";
    public WL_FactoryWall6(GamePanel gp, int col, int row) {
        super(gp,col,row);
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

        down1 = setup("tiles/wall/factorywall6", width, height);

    }

    public void setAction() {

    }

    public void update() {

    }
}

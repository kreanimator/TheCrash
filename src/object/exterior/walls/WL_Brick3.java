package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_Brick3 extends Object {
    GamePanel gp;
    public final static String objName = "Brick3";

    public WL_Brick3(GamePanel gp, int col, int row) {
        super(gp, col , row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();


        solidArea.x = 0;
        solidArea.y = 48;
        solidArea.width = gp.tileSize * 11;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2)-24 ;
        int width = (gp.tileSize * 11)+12;


        down1 = setup("tiles/wall/brickwall3", width, height);

    }

    public void setAction() {

    }

    public void update() {

    }
}

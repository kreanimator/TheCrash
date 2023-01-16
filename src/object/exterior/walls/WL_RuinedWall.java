package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_RuinedWall extends Object {
    GamePanel gp;
    public final static String objName = "RuinedWall";

    public WL_RuinedWall(GamePanel gp, int col, int row) {
        super(gp, col, row);
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
        solidArea.width = gp.tileSize * 10;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2)-24 ;
        int width = (gp.tileSize * 10)+15;

        down1 = setup("tiles/wall/ruinedwall", width, height);

    }

    public void setAction() {

    }

    public void update() {

    }
}

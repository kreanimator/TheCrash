package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_Oldwall2 extends Object {

    GamePanel gp;
    public final static String objName = "Oldwall2";

    public WL_Oldwall2(GamePanel gp, int col, int row) {
        super(gp, col , row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();


        solidArea.x = 0;
        solidArea.y = 48;
        solidArea.width = gp.tileSize * 7;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2)-24 ;
        int width = (gp.tileSize * 7)+12;

        down1 = setup("tiles/wall/oldwall2", width, height);

    }

    public void setAction() {

    }

    public void update() {

    }
}

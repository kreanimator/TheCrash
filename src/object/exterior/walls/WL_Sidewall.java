package object.exterior.walls;

import main.GamePanel;
import object.Object;

public class WL_Sidewall extends Object {
    GamePanel gp;
    public final static String objName = "Sidewall";

    public WL_Sidewall(GamePanel gp, int col,int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();


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

        down1 = setup("tiles/wall/sidewall", width, height);

    }

    public void setAction() {

    }

    public void update() {

    }
}

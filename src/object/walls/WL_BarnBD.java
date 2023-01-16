package object.walls;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class WL_BarnBD extends Object {

    GamePanel gp;
    public final static String objName = "BarnBD";

    public WL_BarnBD(GamePanel gp, int col, int row) {
        super(gp, col , row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 60;
        solidArea.y = 48;
        solidArea.width = (gp.tileSize * 10)-10;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = (gp.tileSize*2)-24 ;
        int width = (gp.tileSize * 11)+12;

        down1 = setup("tiles/wall/barnbd", width, height);

    }

    public void setAction() {

    }

    public void update() {

    }
}

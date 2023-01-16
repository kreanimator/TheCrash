package object.walls;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class WL_FactoryDoor extends Object {
    GamePanel gp;
    public final static String objName = "FactoryDoor";

    public WL_FactoryDoor(GamePanel gp, int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        //collision = true;
        getImage();
        setAction();

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

        down1 = setup("tiles/wall/factorywalldoor", width, height);

    }

    public void setAction() {

    }

    public void update() {

    }
}

package object.exterior.trash;

import main.GamePanel;
import object.Object;

public class OBJ_Garbage1 extends Object {
    GamePanel gp;
    public final static String objName = "Garbage1";

    public OBJ_Garbage1(GamePanel gp, int col,int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();
        setAction();

        solidArea.x = 18;
        solidArea.y = 30;
        solidArea.width = gp.tileSize *2;
        solidArea.height = gp.tileSize;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize *3;
        int height = gp.tileSize *2;

        down1 = setup("tiles/exterior/garbage1", width, height);

    }

    public void setAction() {

    }

    public void update() {

    }
}

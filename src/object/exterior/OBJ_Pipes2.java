package object.exterior;

import main.GamePanel;
import object.Object;

public class OBJ_Pipes2 extends Object {
    GamePanel gp;
    public final static String objName = "Pipes2";

    public OBJ_Pipes2(GamePanel gp,int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();
        setAction();

        solidArea.x = 14;
        solidArea.y = 14;
        solidArea.width = (gp.tileSize * 3)-34;
        solidArea.height = gp.tileSize +14;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize * 3;
        int height = gp.tileSize *2;

        down1 = setup("tiles/exterior/pipes1", width, height);


    }

    public void setAction() {

    }

    public void update() {

    }
}

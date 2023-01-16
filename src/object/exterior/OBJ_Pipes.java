package object.exterior;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_Pipes extends Object {
    GamePanel gp;
    public final static String objName = "Pipes";

    public OBJ_Pipes(GamePanel gp,int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 14;
        solidArea.y = 14;
        solidArea.width = (gp.tileSize * 4)-24;
        solidArea.height = (gp.tileSize *4)-30;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize * 4;
        int height = gp.tileSize *4;

        down1 = setup("tiles/exterior/pipes", width, height);


    }

    public void setAction() {

    }

    public void update() {

    }
}

package object.exterior.streetlights;

import main.GamePanel;
import object.Object;

public class OBJ_Streetlight5 extends Object {
    GamePanel gp;
    public final static String objName = "Streetlight5";

    public OBJ_Streetlight5(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 15;
        solidArea.y = 50;
        solidArea.width = 8;
        solidArea.height = 36;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = (gp.tileSize*2)+12;

        down1 = setup("tiles/exterior/streetlight5", width, height);
    }
}

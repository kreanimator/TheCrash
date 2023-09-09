package object.exterior;

import entity.Entity;
import entity.LightSource;
import entity.NPC;
import main.GamePanel;

public class OBJ_Trashbin extends LightSource {

    GamePanel gp;
    public final static String objName = "Trashbin";

    public OBJ_Trashbin(GamePanel gp,int col,int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        updateLight = true;
        getImage();
        setAction();

        solidArea.x = 13;
        solidArea.y = 36;
        solidArea.width = 14;
        solidArea.height = 20;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize-10;
        int height = gp.tileSize+8;

        down1 = setup("objects/trashbin/1", width, height);
        down2 = setup("objects/trashbin/2",width, height);
        down3 = setup("objects/trashbin/3", width, height);
        down1 = setup("objects/trashbin/4", width, height);
        down2 = setup("objects/trashbin/5", width, height);
        down3 = setup("objects/trashbin/6", width, height);
        down1 = setup("objects/trashbin/1", width, height);
        down2 = setup("objects/trashbin/2",width, height);
        down3 = setup("objects/trashbin/3", width, height);
        down1 = setup("objects/trashbin/4", width, height);
        down2 = setup("objects/trashbin/5", width, height);
        down3 = setup("objects/trashbin/6", width, height);

    }
}

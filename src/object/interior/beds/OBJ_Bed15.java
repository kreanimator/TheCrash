package object.interior.beds;

import main.GamePanel;
import object.Object;

public class OBJ_Bed15 extends Object {
    GamePanel gp;
    public final static String objName = "Bed15";

    public OBJ_Bed15(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();
        setDialogue();

        solidArea.x = 6;
        solidArea.y = 12;
        solidArea.width = gp.tileSize -6;
        solidArea.height = gp.tileSize -12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize+6;
        int height = gp.tileSize + 18;

        down1 = setup("tiles/interior/beds/bed15", width, height);
    }
    public void interact(){
        startDialogue(this,0);
    }
    public void setDialogue(){
        dialogues[0][0] = "This bed looks luxurious but it's still not time for sleep...";
    }
}
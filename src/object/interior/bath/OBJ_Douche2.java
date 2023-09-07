package object.interior.bath;

import main.GamePanel;
import object.Object;

public class OBJ_Douche2 extends Object {

    GamePanel gp;
    public final static String objName = "Douche2";

    public OBJ_Douche2(GamePanel gp,int col,int row) {
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
        solidArea.y = gp.tileSize+12;
        solidArea.width = gp.tileSize-12;
        solidArea.height = gp.tileSize-20;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize*2;

        down1 = setup("tiles/interior/bath/douche2", width, height);

    }

    public void interact(){
        startDialogue(this,0);
    }
    public void setDialogue(){
        dialogues[0][0] = "I'm all itchy... It would be amazing to take a shower right now...";


    }
}
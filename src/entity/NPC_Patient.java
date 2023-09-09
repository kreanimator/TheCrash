package entity;

import main.GamePanel;


import java.awt.*;


public class NPC_Patient extends NPC{

    public final static String npcName = "Null Patient";

    public NPC_Patient(GamePanel gp,int col, int row) {
        super(gp,col,row);
        name = npcName;
        direction = "down";
        defaultSpeed = 0;
        speed = defaultSpeed;
        solidArea = new Rectangle();
        solidArea.x = 32;
        solidArea.y = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 44;
        solidArea.height = 15;
        lightRadius = 300;

        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        int width = (gp.tileSize *2)+12;
        int height = (gp.tileSize *2)+12;

        down1 = setup("npc/patient/down1", width, height);
        down2 = setup("npc/patient/down2", width, height);
        down3 = setup("npc/patient/down3", width, height);

    }

    public void setAction() {

    }

    public void setDialogue() {
        dialogues[0][0] = "Please....Kill me... I'm begging you....";

    }


    public void speak() {
        //
        // npcReactionToAction();
        startDialogue(this, dialogueSet);
        dialogueSet++;
        if(dialogues[dialogueSet][0] ==null){
//            dialogueSet = 0;
            dialogueSet--;
        }
    }
}
package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_Pinky extends NPC{
    boolean questStarted = false;
    boolean finishedPath = true;
    boolean questCompleted = false;

    public static final String npcName = "Pinky";

    public NPC_Pinky(GamePanel gp, int col, int row) {
        super(gp,col,row);
        direction = "down";
        name = npcName;
        defaultSpeed = 2;
        speed = defaultSpeed;
        solidArea.x = 6;
        solidArea.y = 12;
        solidArea.width = 36;
        solidArea.height = 36;
        //onPath = true;


        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        dialogueSet = -1;
        getImage();
        setDialogue();

    }

    public void getImage() {
        up1 = setup("npc/pinky/up1", gp.tileSize - 12, gp.tileSize-12);
        up2 = setup("npc/pinky/up2", gp.tileSize-12, gp.tileSize-12);
        up3 = setup("npc/pinky/up3", gp.tileSize-12, gp.tileSize-12);
        down1 = setup("npc/pinky/down1", gp.tileSize - 12, gp.tileSize-12);
        down2 = setup("npc/pinky/down2", gp.tileSize - 12, gp.tileSize-12);
        down3 = setup("npc/pinky/down3", gp.tileSize - 12, gp.tileSize-12);
        left1 = setup("npc/pinky/left1", gp.tileSize - 12, gp.tileSize-12);
        left2 = setup("npc/pinky/left2", gp.tileSize - 12, gp.tileSize-12);
        left3 = setup("npc/pinky/left3", gp.tileSize - 12, gp.tileSize-12);
        right1 = setup("npc/pinky/right1", gp.tileSize - 12, gp.tileSize-12);
        right2 = setup("npc/pinky/right2", gp.tileSize - 12, gp.tileSize-12);
        right3 = setup("npc/pinky/right3", gp.tileSize - 12, gp.tileSize-12);
    }


    public void setAction() {
        if (onPath) {
//            int goalCol = 30;
//            int goalRow = 71;
            int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
            searchPath(goalCol, goalRow);
            finishedPath = true;
            speed = 2;

        } else {
            actionLockCounter++;
            if (actionLockCounter == 240) {
                Random random = new Random();
                int i = random.nextInt(100) + 1; // pick up a number from 1 to 100

                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75) {
                    direction = "right";
                }
                actionLockCounter = 0;
            }
        }
    }

    public void setDialogue() {
        dialogues[0][0] = "I think so, Brain,\nbut if we covered the world in salad dressing,\nwould not the asparagus feel left out?";
        dialogues[1][0] = "Uh, I think so, Brain,\nbut balancing a family and a career… oh, it is all too much for me.";
        dialogues[2][0] = "Well, I think so, Brain,\nbut I cannot memorize a whole opera in Yiddish.";
        dialogues[3][0] = "I think so, Brain,\nbut this time you put the trousers on the chimp.";
        dialogues[4][0] = "Go Brain! Go find your smile! \neat more of these wonderful mushrooms.";

    }



    public void speak() {
        npcReactionToAction();
        startDialogue(this, dialogueSet);

        dialogueSet++;







        if(dialogues[dialogueSet][0] == null){
            dialogueSet = 0;
//            questStarted = true;
//            dialogueSet--;
        }
    }
    public void setQuest(){
        if (questStarted) {
        }
    }
}

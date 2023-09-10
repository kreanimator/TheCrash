package entity;

import main.GamePanel;
import object.quests.Q_KillBugs;

import java.util.Random;

public class NPC_Brain extends NPC{
    boolean questStarted = false;
    boolean finishedPath = true;
    boolean questCompleted = false;

    public static final String npcName = "Brain";

    public NPC_Brain(GamePanel gp, int col, int row) {
        super(gp,col,row);
        direction = "down";
        name = npcName;
        defaultSpeed = 2;
        speed = defaultSpeed;
        solidArea.x = 6;
        solidArea.y = 12;
        solidArea.width = 36;
        solidArea.height = 36;
        onPath = true;


        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        dialogueSet = -1;
        getImage();
        setDialogue();

    }

    public void getImage() {
        up1 = setup("npc/brain/up1", gp.tileSize - 12, gp.tileSize-12);
        up2 = setup("npc/brain/up2", gp.tileSize-12, gp.tileSize-12);
        up3 = setup("npc/brain/up3", gp.tileSize-12, gp.tileSize-12);
        down1 = setup("npc/brain/down1", gp.tileSize - 12, gp.tileSize-12);
        down2 = setup("npc/brain/down2", gp.tileSize - 12, gp.tileSize-12);
        down3 = setup("npc/brain/down3", gp.tileSize - 12, gp.tileSize-12);
        left1 = setup("npc/brain/left1", gp.tileSize - 12, gp.tileSize-12);
        left2 = setup("npc/brain/left2", gp.tileSize - 12, gp.tileSize-12);
        left3 = setup("npc/brain/left3", gp.tileSize - 12, gp.tileSize-12);
        right1 = setup("npc/brain/right1", gp.tileSize - 12, gp.tileSize-12);
        right2 = setup("npc/brain/right2", gp.tileSize - 12, gp.tileSize-12);
        right3 = setup("npc/brain/right3", gp.tileSize - 12, gp.tileSize-12);
    }


    public void setAction() {
        if (onPath) {
            int goalCol = 60;
            int goalRow = 46;
//            int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
//            int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
            searchPath(goalCol, goalRow);
            finishedPath = true;
        } else if (finishedPath) {
            int goalCol = 47;
            int goalRow = 46;
            searchPath(goalCol, goalRow);



//            goalCol = 47;
//            goalRow = 46;
//            searchPath(goalCol, goalRow);
//            goalCol = 37;
//            goalRow = 37;
//            searchPath(goalCol, goalRow);
//            goalCol = 60;
//            goalRow = 46;
//            searchPath(goalCol, goalRow);


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
        dialogues[0][0] = "Are you pondering what I am pondering?";
        dialogues[1][0] = "If we attached a tube to the vacuum that is your head,\n we could clean the whole city.We will reach Mars before I yell Poit! Pinky.";
        dialogues[2][0] = "The irony of it all, Pinky. Years of trying to take over the world,\n and all I had to do was say moo.";
        dialogues[3][0] = "I wish you were as smart as a tree stump, Pinky.";
        dialogues[4][0] = " These mushrooms tastes funny...";
        dialogues[5][0] = " Come on, Pinky, be a man! Like Eleanor Roosevelt!";


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

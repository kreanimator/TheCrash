package entity;

import main.GamePanel;
import object.misc.OBJ_KeyCard;
import object.quests.Q_KillBugs;

import java.util.Random;

public class NPC_Nick extends NPC{
    boolean questStarted = false;
    boolean finishedPath = true;
    boolean questCompleted = false;

    public static final String npcName = "Nick";

    public NPC_Nick(GamePanel gp,int col, int row) {
        super(gp,col,row);
        direction = "down";
        name = npcName;
        defaultSpeed = 2;
        speed = defaultSpeed;
        solidArea.x = 14;
        solidArea.y = 16;
        solidArea.width = 24;
        solidArea.height = 32;
        onPath = true;


        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        dialogueSet = -1;
        getImage();
        setDialogue();

    }

    public void getImage() {
        up1 = setup("npc/nick/up1", gp.tileSize, gp.tileSize);
        up2 = setup("npc/nick/up2", gp.tileSize, gp.tileSize);
        up3 = setup("npc/nick/up3", gp.tileSize, gp.tileSize);
        down1 = setup("npc/nick/down1", gp.tileSize, gp.tileSize);
        down2 = setup("npc/nick/down2", gp.tileSize, gp.tileSize);
        down3 = setup("npc/nick/down3", gp.tileSize, gp.tileSize);
        left1 = setup("npc/nick/left1", gp.tileSize, gp.tileSize);
        left2 = setup("npc/nick/left2", gp.tileSize, gp.tileSize);
        left3 = setup("npc/nick/left3", gp.tileSize, gp.tileSize);
        right1 = setup("npc/nick/right1", gp.tileSize, gp.tileSize);
        right2 = setup("npc/nick/right2", gp.tileSize, gp.tileSize);
        right3 = setup("npc/nick/right3", gp.tileSize, gp.tileSize);
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
        dialogues[0][0] = "Hey, you woke up ! That's Amazing!";
        dialogues[0][1] = "I found outside almost dying";
        dialogues[0][2] = "Feel yourself like home, you may take everything if you'll need";
        dialogues[0][3] = "I tell you everything, but could you do me a favor?";

        dialogues[1][0] = " There are a lot of bugs on the field near my house, please make them disappear...";

    }



    public void speak() {
        npcReactionToAction();
        startDialogue(this, dialogueSet);

        dialogueSet++;







        if(dialogues[dialogueSet][0] == null){
//            dialogueSet = 0;
            questStarted = true;
            dialogueSet--;
        }
        if (questStarted){
            setQuest();
        }
//        onPath = true;
    }
    public void setQuest(){
        if (questStarted) {
            Player.quest.clear();
            Player.quest.add(new Q_KillBugs(gp));
//            Player.inventory.clear();
//            Player.inventory.add(new OBJ_KeyCard(gp));
        }
    }

}



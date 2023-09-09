package entity;

import main.GamePanel;
import object.exterior.doors.OBJ_IronDoor;
import tile_interactive.IT_MetalPlate;
import tile_interactive.InteractiveTile;

import java.awt.*;
import java.util.ArrayList;

public class NPC_BigRock extends NPC {
    public final static String npcName = "Big rock";
    public NPC_BigRock(GamePanel gp, int col, int row) {
        super(gp,col,row);
        name = npcName;
        direction = "down";
        defaultSpeed = 4;
        speed = defaultSpeed;
        solidArea = new Rectangle();
        solidArea.x = 2;
        solidArea.y = 6;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 44;
        solidArea.height = 40;
        lightRadius = 300;

        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        up1 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        up2 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        up3 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        down1 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        down2 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        down3 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        left1 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        left2 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        left3 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        right1 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        right2 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
        right3 = setup("objects/interactiveobjects/movablerock", gp.tileSize, gp.tileSize);
    }

    public void setAction() {

    }

    public void setDialogue() {
        dialogues[0][0] = "Hmm... I think I can move it....";

    }
    public void update(){

    }
    public void move(String d){
        this.direction = d;

        checkCollision();
        if (!collisionOn){
            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }
        }
        detectPlate();

    }
    public void detectPlate(){
        ArrayList<InteractiveTile> platesList = new ArrayList<>();
        ArrayList<Entity> rockList = new ArrayList<>();

        //Create a plate list
        for (int i = 0; i < gp.iTile[1].length;i++){

            if(gp.iTile[gp.currentMap][i] != null &&
                    gp.iTile[gp.currentMap][i].name.equals(IT_MetalPlate.itName)){
                platesList.add(gp.iTile[gp.currentMap][i]);
            }
        }
        //Create a rock list
        for (int i = 0; i < gp.npc[1].length;i++){

            if(gp.npc[gp.currentMap][i] != null &&
                    gp.npc[gp.currentMap][i].name.equals(NPC_BigRock.npcName)){
                rockList.add(gp.npc[gp.currentMap][i]);
            }
        }
        int count = 0;

        //Scan the plate list
        for (int i = 0; i < platesList.size(); i ++){
            int xDistance = Math.abs(worldX - platesList.get(i).worldX);
            int yDistance = Math.abs(worldY - platesList.get(i).worldY);
            int distance = Math.max(xDistance, yDistance);

            if(distance < 8){
                if(linkedEntity ==null) {
                    linkedEntity = platesList.get(i);
                    gp.playSE(29);
                }
            }
            else {
                if(linkedEntity == platesList.get(i)) {
                    linkedEntity = null;
                }
            }

        }
        //Scan the rock list
        for (int i = 0; i < rockList.size(); i ++){

            //Count the rock on the plate

            if(rockList.get(i).linkedEntity!=null){
                count++;
            }
        }
        if(count == rockList.size()){
            for(int i = 0; i < gp.obj[1].length; i++){
                if (gp.obj[gp.currentMap][i] != null && gp.obj[gp.currentMap][i].name.equals(OBJ_IronDoor.objName)) {
                    gp.obj[gp.currentMap][i]=null;
                    gp.playSE(28);
                }
            }
        }


    }


    public void speak() {
        npcReactionToAction();
        startDialogue(this, dialogueSet);
        dialogueSet++;
        if(dialogues[dialogueSet][0] ==null){
//            dialogueSet = 0;
            dialogueSet--;
        }
    }
}
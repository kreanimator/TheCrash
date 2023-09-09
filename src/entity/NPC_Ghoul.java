package entity;

import main.GamePanel;
import object.armor.OBJ_Armor_Metal;
import object.misc.OBJ_HPPack;
import object.weapon.OBJ_Ammo_Pistol;
import object.weapon.OBJ_Ammo_Shotgun;
import object.weapon.OBJ_Pistol;
import object.weapon.OBJ_Shotgun;



public class NPC_Ghoul extends NPC{
    public static final String npcName = "Daniel the Ghoul";
    public NPC_Ghoul(GamePanel gp,int col, int row) {
        super(gp,col,row);
        direction = "down";
        name = npcName;


        solidArea.x = 14;
        solidArea.y = 16;
        solidArea.width = 24;
        solidArea.height = 32;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        lightRadius = 300;

        getImage();
        setDialogue();
        setItems();
    }
    public void getImage() {
        up1 = setup("npc/oldghoul/down1",gp.tileSize ,gp.tileSize );
        up2= setup("npc/oldghoul/down2",gp.tileSize ,gp.tileSize );
        up3 = setup("npc/oldghoul/down3",gp.tileSize ,gp.tileSize );
        down1 = setup("npc/oldghoul/down1",gp.tileSize ,gp.tileSize );
        down2 = setup("npc/oldghoul/down2",gp.tileSize ,gp.tileSize );
        down3 = setup("npc/oldghoul/down3",gp.tileSize ,gp.tileSize );
        left1 = setup("npc/oldghoul/left1",gp.tileSize ,gp.tileSize );
        left2 = setup("npc/oldghoul/left2",gp.tileSize ,gp.tileSize );
        left3 = setup("npc/oldghoul/left3",gp.tileSize ,gp.tileSize );
        right1 = setup("npc/oldghoul/right1",gp.tileSize ,gp.tileSize );
        right2 = setup("npc/oldghoul/right2",gp.tileSize ,gp.tileSize );
        right3 = setup("npc/oldghoul/right3",gp.tileSize ,gp.tileSize );
    }

    public void setDialogue(){
        dialogues[0][0] = " Please don't hit me! I know I can look ugly, but I'm not dangerous, " +
                "I just live here...\nI am a ghoul... Old ghoul named Daniel....\nI have some items for sale if you wish." +
                "\nSometimes I steal some stuff from these punks... hehehe...";
        dialogues [1][0] = "Come again hehehe...";
        dialogues [2][0]= "You have no enough money!";
        dialogues [3][0] = "Inventory is full!";
        dialogues [4][0] = "You cannot sell an equipped item!";



    }
    public void speak(){
        npcReactionToAction();
        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
    }
    public void setItems(){
        inventory.add(new OBJ_HPPack(gp));
        inventory.add(new OBJ_HPPack(gp));
        inventory.add(new OBJ_Ammo_Pistol(gp));
        inventory.add(new OBJ_Ammo_Pistol(gp));
        inventory.add(new OBJ_Ammo_Shotgun(gp));
        inventory.add(new OBJ_Ammo_Shotgun(gp));
        inventory.add(new OBJ_Pistol(gp));
        inventory.add(new OBJ_Shotgun(gp));
        inventory.add(new OBJ_Armor_Metal(gp));
    }
}


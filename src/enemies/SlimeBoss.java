package enemies;

import data.Progress;
import main.GamePanel;
import object.exterior.doors.OBJ_IronDoor;
import object.misc.OBJ_HPPack;
import object.misc.OBJ_Money;
import object.projectiles.OBJ_Acid;
import object.weapon.OBJ_Ammo_Pistol;
import object.weapon.OBJ_Ammo_Shotgun;

import java.util.Objects;
import java.util.Random;

public class SlimeBoss extends Enemy {
    GamePanel gp;
    public static final  String enName = "Gwargh the SLime Lord";


    public SlimeBoss(GamePanel gp, int col, int row) {
        super(gp, col, row);

        this.gp = gp;

        type = typeEnemy;
        name = enName;
        direction = "left";

        defaultSpeed = 2;
        speed = defaultSpeed;
        maxHP = 50;
        boss = true;
        life = maxHP;
        attack = 10;
        defense = 4;
        exp = 300;
        projectiles = new OBJ_Acid(gp);
        sleep = true;

        int size =gp.tileSize*5;

        solidArea.x = 48;
        solidArea.y = 48;
        solidArea.width = size - 48*2;
        solidArea.height = size -48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = 170*4;
        attackArea.height = 170*gp.tileSize;
        knockBackPower = 20;
        motion1Duration = 20;
        motion2Duration = 25;
        motion3Duration = 50;
        getImage();
        getAtkImage();
        setDialogue();

    }

    public void getImage() {
        int bossSize = gp.tileSize *5;
        up1 = setup("bosses/slimeboss/up1", bossSize , bossSize );
        up2 = setup("bosses/slimeboss/up2", bossSize , bossSize );
        up3 = setup("bosses/slimeboss/up3", bossSize , bossSize);

        down1 = setup("bosses/slimeboss/down1", bossSize , bossSize );
        down2 = setup("bosses/slimeboss/down2", bossSize , bossSize );
        down3 = setup("bosses/slimeboss/down3", bossSize , bossSize );

        left1 = setup("bosses/slimeboss/left1", bossSize , bossSize);
        left2 = setup("bosses/slimeboss/left2", bossSize , bossSize);
        left3 = setup("bosses/slimeboss/left3", bossSize , bossSize);

        right1 = setup("bosses/slimeboss/right1", bossSize , bossSize);
        right2 = setup("bosses/slimeboss/right2", bossSize , bossSize );
        right3 = setup("bosses/slimeboss/right3", bossSize , bossSize );

    }
    public void getAtkImage() {
        int bossSize = gp.tileSize *5;
        atkup1 = setup("bosses/slimeboss/attack/up1", bossSize , bossSize*2);
        atkup2 = setup("bosses/slimeboss/attack/up2", bossSize , bossSize*2);
        atkup3 = setup("bosses/slimeboss/attack/up3", bossSize , bossSize*2);

        atkdown1 = setup("bosses/slimeboss/attack/down1", bossSize , bossSize*2);
        atkdown2 = setup("bosses/slimeboss/attack/down2", bossSize , bossSize*2);
        atkdown3 = setup("bosses/slimeboss/attack/down3", bossSize , bossSize*2);

        atkleft1 = setup("bosses/slimeboss/attack/left1", bossSize*2 , bossSize );
        atkleft2 = setup("bosses/slimeboss/attack/left2", bossSize*2 , bossSize  );
        atkleft3 = setup("bosses/slimeboss/attack/left3", bossSize*2 , bossSize  );

        atkright1 = setup("bosses/slimeboss/attack/right1", bossSize*2 , bossSize  );
        atkright2 = setup("bosses/slimeboss/attack/right2", bossSize*2 , bossSize  );
        atkright3 = setup("bosses/slimeboss/attack/right3", bossSize*2 , bossSize  );

    }
    public void setDialogue(){
        dialogues[0][0] = "Umbgkh.... Freeeeeeeeesh meeeat.....";
        dialogues[0][1] = "Your .... blmrkh....kiiiind..... created.....me....\n And it were your mistake....";
        dialogues[0][2] = "Prepare to be the part of great entity....\n your way finishes here....";

    }

    public void setAction() {

        if(!inRage && life < maxHP/2){
            inRage = true;
            defaultSpeed = 4;
            speed = 4;
            attack = attack*2;
        }
        //Check if stops chasing
        if (getTileDistance(gp.player) < 10) {
            moveTowardPlayer(60);
            checkShoot(1, 30, 24);
        }
        else {
            getRandomDirection(50);

        }
        //Check if it attacks
        if(!attacking){
            checkAttacking(60,gp.tileSize*10,gp.tileSize*5);
        }
    }


    public void damageReaction() {
        actionLockCounter = 0;
    }

    public void playSE() {
        gp.playSE(7);
    }

    public void checkDrop() {
        gp.bossBattleOn = false;
        Progress.slimeBossDefeated = true;
        gp.stopMusic();
        gp.playMusic(27);

        for (int i = 0; i < gp.obj[1].length;i++){
            if (gp.obj[gp.currentMap][i] != null && Objects.equals(gp.obj[gp.currentMap][i].name, OBJ_IronDoor.objName)){
                gp.playSE(28);
                gp.obj[gp.currentMap][i] = null;
            }
        }
        int i = new Random().nextInt(100) + 1;
        //SET THE MONSTER DROP
        if (i < 25) {
            dropItem(new OBJ_Money(gp));
        }
        if (i >= 25 && i < 50) {
            dropItem(new OBJ_HPPack(gp));
        }
        if (i >= 50 && i < 75) {
            dropItem(new OBJ_Ammo_Pistol(gp));
        }
        if (i >= 75 && i < 100) {
            dropItem(new OBJ_Ammo_Shotgun(gp));
        }

    }
}



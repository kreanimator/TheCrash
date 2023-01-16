package enemies;

import entity.Entity;
import main.GamePanel;
import object.armor.OBJ_Armor_Metal;
import object.weapon.OBJ_Shotgun;

import java.util.Random;

public class DeathClaw extends Enemy {

    GamePanel gp;


    public DeathClaw(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;
        type = typeEnemy;
        name = "DeathClaw";

        defaultSpeed = 2;
        speed = defaultSpeed;
        maxHP = 30;
        life = maxHP;
        attack = 6;
        defense = 4;
        exp = 150;
        int size = gp.tileSize *2;

        solidArea.x = 12;
        solidArea.y = 36;
        solidArea.width = gp.tileSize -10;
        solidArea.height = gp.tileSize -10;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        attackArea.width = 48 * 2;
        attackArea.height = 48 * 2;
        knockBackPower = 5;
        motion1Duration = 10;
        motion2Duration = 30;
        motion3Duration = 50;
        getImage();



    }

//    public void update() {
//        super.update();
//
//    }

    public void getImage() {
        int size = gp.tileSize + (gp.tileSize/2);
        up1 = setup("enemies/deathclaw/up1", size, size );
        up2 = setup("enemies/deathclaw/up2",size, size );
        up3 = setup("enemies/deathclaw/up3", size, size );

        down1 = setup("enemies/deathclaw/down1", size, size );
        down2 = setup("enemies/deathclaw/down2", size, size);
        down3 = setup("enemies/deathclaw/down3", size, size );

        left1 = setup("enemies/deathclaw/left1", size, size );
        left2 = setup("enemies/deathclaw/left2", size, size );
        left3 = setup("enemies/deathclaw/left3", size, size );

        right1 = setup("enemies/deathclaw/right1", size, size );
        right2 = setup("enemies/deathclaw/right2", size, size );
        right3 = setup("enemies/deathclaw/right3", size, size );

    }

    public void playSE() {
        gp.playSE(16);

    }

    public void setAction() {
        //Check if stops chasing
        if (onPath) {
            //Check if stops chasing
            checkStopChasing(gp.player, 15, 50);
            //Search the direction
            speed = 4;
            searchPath(getGoalCol(gp.player), getGoalCRow(gp.player));
            //Shoots
            //checkShoot(100, 30, 12);
        }
        else {
            //Check if it starts chasing
            checkStartChasing(gp.player, 5, 50);
            getRandomDirection(50);
        }
        //Check if it attacks


        if(!attacking){
            checkAttacking(30,gp.tileSize*4,gp.tileSize);
        }
    }

    public void damageReaction() {
        actionLockCounter = 0;
        direction = gp.player.direction;

    }

    public void checkDrop() {
        int i = new Random().nextInt(100) + 1;

        //SET THE MONSTER DROP

        if (i < 50) {
            dropItem(new OBJ_Shotgun(gp));
        }
        if (i >= 50 && i < 100) {
            dropItem(new OBJ_Armor_Metal(gp));
        }


    }
}

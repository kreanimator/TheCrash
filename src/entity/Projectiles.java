package entity;

import main.GamePanel;

public class Projectiles extends  Entity{

    Entity user;
    public Projectiles(GamePanel gp) {
        super(gp);
    }

    public void set(int worldX , int worldY, String direction, boolean alive, Entity user ) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxHP;

    }
        public void update(){

        if(user == gp.player){
            //gp.cDetector.checkTile(this);
            int enemyIndex = gp.cDetector.checkEntity(this,gp.enemy);
            if(enemyIndex != 999){
                gp.player.damageEnemy(enemyIndex,this,attack, knockBackPower);
                generateParticle(user.projectiles,gp.enemy[gp.currentMap][enemyIndex]);
                alive = false;
            }

        }
        if(user != gp.player ){

            boolean contactPlayer = gp.cDetector.checkPlayer(this);
            if(!gp.player.invincible && contactPlayer){
                damagePlayer(attack);
                generateParticle(user.projectiles,gp.player);
                alive = false;
            }
        }

        switch (direction){
            case "up" -> worldY -= speed;
            case "down" -> worldY += speed;
            case "left" -> worldX -= speed;
            case "right" -> worldX += speed;
        }
        life--;
        if (life <= 0){
            alive = false;
        }
        spriteCounter ++;

        if(spriteCounter > 12){
            if (spriteNumber == 1){
                spriteNumber =2;
            }else if(spriteNumber ==2){
                spriteNumber = 1;
            }
            spriteCounter = 0;

        }

        }
    public boolean haveResource(Entity user){
        return false;
    }
    public boolean action(Entity user){
        boolean action = false;
        return action;
    }
    public void subtractResource(Entity user){
        if(user.currentWeapon.type == typePistol) {
            user.pistolAmmo -= useCost;
        }
        if(user.currentWeapon.type == typeShotgun) {
            user.shotgunAmmo -= useCost;
        }
    }

}

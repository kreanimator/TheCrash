package main;

import entity.Entity;
import object.armor.OBJ_Armor_Learther;
import object.armor.OBJ_Armor_Metal;
import object.armor.OBJ_BarrelShield;
import object.armor.OBJ_Shield;
import object.exterior.OBJ_Locker;
import object.exterior.doors.OBJ_Door;
import object.interior.*;
import object.misc.*;
import object.projectiles.OBJ_Acid;
import object.projectiles.OBJ_Bullet;
import object.projectiles.OBJ_ShotgunBullet;
import object.weapon.*;

public class EntityGenerator {

    GamePanel gp;

    public EntityGenerator(GamePanel gp) {
        this.gp = gp;
    }

    public Entity getObject(String itemName) {
        Entity obj = switch (itemName) {
            case OBJ_Armor_Learther.objName -> new OBJ_Armor_Learther(gp);
            case OBJ_Armor_Metal.objName -> new OBJ_Armor_Metal(gp);
            case OBJ_BarrelShield.objName -> new OBJ_BarrelShield(gp);
            case OBJ_Shield.objName -> new OBJ_Shield(gp);
            //case OBJ_BunkerDoor.objName ->new OBJ_BunkerDoor(gp);
            //case OBJ_CampFire.objName -> new OBJ_CampFire(gp);
//            case OBJ_Door.objName-> new OBJ_Door();
            // case OBJ_GarbageTrunk.objName -> new OBJ_GarbageTrunk(gp);
            //case OBJ_IronDoor.objName -> new OBJ_IronDoor(gp);
//            case OBJ_Locker.objName -> new OBJ_Locker(gp);
            case OBJ_Bed.objName -> new OBJ_Bed(gp);
            case OBJ_Bookshelf.objName -> new OBJ_Bookshelf(gp);
            case OBJ_Bookshelf2.objName -> new OBJ_Bookshelf2(gp);
            case OBJ_Brokenlocker.objName -> new OBJ_Brokenlocker(gp);
            case OBJ_Chair.objName -> new OBJ_Chair(gp);
            case OBJ_Table.objName -> new OBJ_Table(gp);
            case OBJ_Flashlight.objName -> new OBJ_Flashlight(gp);
            case OBJ_HP.objName -> new OBJ_HP(gp);
            case OBJ_HPPack.objName -> new OBJ_HPPack(gp);
            case OBJ_Key.objName -> new OBJ_Key(gp);
            case OBJ_KeyCard.objName -> new OBJ_KeyCard(gp);
            case OBJ_Lockpick.objName -> new OBJ_Lockpick(gp);
            case OBJ_Money.objName -> new OBJ_Money(gp);
            case OBJ_SweetBubaleh.objName -> new OBJ_SweetBubaleh(gp);
            case OBJ_Tent.objName -> new OBJ_Tent(gp);
            case OBJ_Acid.objName -> new OBJ_Acid(gp);
            case OBJ_Bullet.objName -> new OBJ_Bullet(gp);
            case OBJ_ShotgunBullet.objName -> new OBJ_ShotgunBullet(gp);
            case OBJ_Ammo_Pistol.objName -> new OBJ_Ammo_Pistol(gp);
            case OBJ_Ammo_Shotgun.objName -> new OBJ_Ammo_Shotgun(gp);
            case OBJ_Melee_Bat_normal.objName -> new OBJ_Melee_Bat_normal(gp);
            case OBJ_Pistol.objName -> new OBJ_Pistol(gp);
            case OBJ_Shotgun.objName -> new OBJ_Shotgun(gp);
            case OBJ_Crowbar.objName -> new OBJ_Crowbar(gp);

            default -> null;
        };
        return obj;
    }
}

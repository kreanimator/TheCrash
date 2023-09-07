package main;

import entity.Entity;
import object.armor.OBJ_Armor_Learther;
import object.armor.OBJ_Armor_Metal;
import object.armor.OBJ_BarrelShield;
import object.armor.OBJ_Shield;
import object.exterior.doors.*;
import object.interior.lockers.OBJ_Locker1;
import object.misc.*;
import object.weapon.*;
import object.interior.lockers.*;
import object.exterior.*;

public class EntityGenerator {

    GamePanel gp;

    public EntityGenerator(GamePanel gp) {
        this.gp = gp;
    }

    public Entity getObject(String itemName) {
        return switch (itemName) {
            case OBJ_Armor_Learther.objName -> new OBJ_Armor_Learther(gp);
            case OBJ_Armor_Metal.objName -> new OBJ_Armor_Metal(gp);
            case OBJ_BarrelShield.objName -> new OBJ_BarrelShield(gp);
            case OBJ_Shield.objName -> new OBJ_Shield(gp);
//            case OBJ_BunkerDoor.objName -> new OBJ_BunkerDoor();
//            case OBJ_Door.objName-> new OBJ_Door();
//            case OBJ_GarbageTrunkfr.objName -> new OBJ_GarbageTrunkfr();
//            case OBJ_GarbageTrunkl.objName -> new OBJ_GarbageTrunkl();
//            case OBJ_GarbageTrunkr.objName -> new OBJ_GarbageTrunkr();
            //case OBJ_IronDoor.objName -> new OBJ_IronDoor(gp);
//            case OBJ_Locker1.objName -> new OBJ_Locker1();
//            case OBJ_Locker2.objName -> new OBJ_Locker2();
//            case OBJ_Locker3.objName -> new OBJ_Locker3();
//            case OBJ_Locker4.objName -> new OBJ_Locker4();
//            case OBJ_Locker5.objName -> new OBJ_Locker5();
//            case OBJ_Locker6.objName -> new OBJ_Locker6();
            case OBJ_Amphetamine.objName -> new OBJ_Amphetamine(gp);
            case OBJ_Booze.objName ->  new OBJ_Booze(gp);
            case OBJ_Flashlight.objName -> new OBJ_Flashlight(gp);
            case OBJ_HP.objName -> new OBJ_HP(gp);
            case OBJ_HPPack.objName -> new OBJ_HPPack(gp);
            case OBJ_Key.objName -> new OBJ_Key(gp);
            case OBJ_KeyCard.objName -> new OBJ_KeyCard(gp);
            case OBJ_Lockpick.objName -> new OBJ_Lockpick(gp);
            case OBJ_Money.objName -> new OBJ_Money(gp);
            case OBJ_SweetBubaleh.objName -> new OBJ_SweetBubaleh(gp);
            case OBJ_Tent.objName -> new OBJ_Tent(gp);
            case OBJ_Ammo_Pistol.objName -> new OBJ_Ammo_Pistol(gp);
            case OBJ_Ammo_Shotgun.objName -> new OBJ_Ammo_Shotgun(gp);
            case OBJ_Melee_Bat_normal.objName -> new OBJ_Melee_Bat_normal(gp);
            case OBJ_Pistol.objName -> new OBJ_Pistol(gp);
            case OBJ_Shotgun.objName -> new OBJ_Shotgun(gp);
            case OBJ_Crowbar.objName -> new OBJ_Crowbar(gp);

            default -> null;
        };
    }
}

package online.held_der_zeit.finalmix.entity.mob;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import online.kingdomkeys.kingdomkeys.capability.IGlobalCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.config.ModConfigs;
import online.kingdomkeys.kingdomkeys.entity.EntityHelper.MobType;
import online.kingdomkeys.kingdomkeys.entity.mob.BaseKHEntity;
import online.kingdomkeys.kingdomkeys.entity.mob.IKHMob;
import online.kingdomkeys.kingdomkeys.item.KeybladeItem;
import online.kingdomkeys.kingdomkeys.item.ModItems;
import online.kingdomkeys.kingdomkeys.item.organization.IOrgWeapon;

public class FMKHEntity extends BaseKHEntity {

	public FMKHEntity(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
	}


//	@Override
//	public int getExperienceReward() {
//		if (getKHMobType() != MobType.NPC) {
//			IGlobalCapabilities mobData = ModCapabilities.getGlobal(this);
//			if (mobData != null && mobData.getLevel() > 0) {
//				return (int) (super.getExperienceReward() * (mobData.getLevel() / 10F));
//			}
//		}
//		return super.getExperienceReward();
//	}

//	enum MobType {
//
//	}


}
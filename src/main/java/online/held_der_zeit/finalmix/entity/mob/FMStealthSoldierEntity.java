package online.held_der_zeit.finalmix.entity.mob;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;
import online.held_der_zeit.finalmix.entity.ModEntities;
import online.kingdomkeys.kingdomkeys.entity.EntityHelper;
//import online.kingdomkeys.kingdomkeys.entity.ModEntities;
import online.kingdomkeys.kingdomkeys.entity.mob.BaseKHEntity;
import online.kingdomkeys.kingdomkeys.entity.mob.SoldierEntity;
import online.kingdomkeys.kingdomkeys.entity.mob.goal.SoldierGoal;
import online.kingdomkeys.kingdomkeys.item.KKResistanceType;

public class FMStealthSoldierEntity extends BaseKHEntity { //extends SoldierEntity {

    public FMStealthSoldierEntity(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        xpReward = 9;
    }

    public FMStealthSoldierEntity(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(ModEntities.TYPE_STEALTH_SOLDIER.get(), world);
    }

    // Stealth Soldier can go invisible - rather implement it being translucent
    // it goes fully visible after enough damage (idk, like half is gone?)


    @Override
    public boolean hurt(DamageSource source, float amount) {
        float multiplier = 1;
        if(source.getMsgId().equals(KKResistanceType.fire.toString())) {
            multiplier = 0.5f;
        }
        if(source.getMsgId().equals(KKResistanceType.ice.toString())) {
            multiplier = 0.5f;
        }
        if(source.getMsgId().equals(KKResistanceType.lightning.toString())) {
            multiplier = 0.1f;
        }
        return super.hurt(source, amount*multiplier);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
       // this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AnimalEntity.class, true));
        this.targetSelector.addGoal(4, new SoldierGoal(this));
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createLivingAttributes()
            .add(Attributes.FOLLOW_RANGE, 15.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.28D)
            .add(Attributes.MAX_HEALTH, 50.0D)
            .add(Attributes.ATTACK_DAMAGE, 4.0D)
			.add(Attributes.ATTACK_KNOCKBACK, 1.0D)

            ;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 4;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EntityHelper.STATE, 0);
        this.entityData.define(EntityHelper.ANIMATION, 0);
    }

    @Override
    public EntityHelper.MobType getKHMobType() {
        return EntityHelper.MobType.HEARTLESS_EMBLEM;
    }

}

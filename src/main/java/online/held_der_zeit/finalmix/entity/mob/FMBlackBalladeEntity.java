package online.held_der_zeit.finalmix.entity.mob;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.PlayMessages;
import online.held_der_zeit.finalmix.KingdomKeysFinalMix;
import online.held_der_zeit.finalmix.entity.ModEntities;
import online.kingdomkeys.kingdomkeys.damagesource.KKDamageTypes;
import online.kingdomkeys.kingdomkeys.entity.EntityHelper;
import online.kingdomkeys.kingdomkeys.entity.mob.BaseElementalMusicalHeartlessEntity;
import online.kingdomkeys.kingdomkeys.item.KKResistanceType;
import org.joml.Vector3f;

import java.util.Iterator;

public class FMBlackBalladeEntity extends BaseElementalMusicalHeartlessEntity {

    public FMBlackBalladeEntity(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    public FMBlackBalladeEntity(PlayMessages.SpawnEntity spawnEntity, Level world) {
        super(ModEntities.TYPE_BLACK_BALLADE.get(), spawnEntity, world);
        xpReward = 10;
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return BaseElementalMusicalHeartlessEntity.registerAttributes()
        		.add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D);
        		
    }

    //black ballade creates 4 or 5 copies - true one will jump, hitting wrong one will cause lightning struck
    //every attack it gets deals 5 damage to it, aka 25% of max hp

    @Override
    protected Goal goalToUse() {
        return new BlackBalladeGoal(this);
    }

    @Override
    public Element getElementToUse() {
        return Element.THUNDER;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public ResourceLocation getTexture() {
        return new ResourceLocation(KingdomKeysFinalMix.MODID, "textures/entity/mob/black_ballade.png");
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        float multiplier = 1;
        if(!this.level().isClientSide) {
            //if(source.getDirectEntity().equals(Player))
            if(source.getMsgId().equals(KKResistanceType.fire.toString())) {
                ((ServerLevel)this.level()).sendParticles(ParticleTypes.CLOUD, this.getX(), this.getY()+1, this.getZ(), 10, random.nextDouble()-0.5F,random.nextDouble()-0.5F,random.nextDouble()-0.5F, 0.0);
                return false;
            }
            if(source.getMsgId().equals(KKResistanceType.ice.toString())) {
                ((ServerLevel)this.level()).sendParticles(ParticleTypes.CLOUD, this.getX(), this.getY()+1, this.getZ(), 10, random.nextDouble()-0.5F,random.nextDouble()-0.5F,random.nextDouble()-0.5F, 0.0);
                return false;
            }
            if(source.getMsgId().equals(KKResistanceType.light.toString())) {
                ((ServerLevel)this.level()).sendParticles(ParticleTypes.CLOUD, this.getX(), this.getY()+1, this.getZ(), 10, random.nextDouble()-0.5F,random.nextDouble()-0.5F,random.nextDouble()-0.5F, 0.0);
                return false;
            }
            if(source.getMsgId().equals(KKResistanceType.lightning.toString())) {
                ((ServerLevel)this.level()).sendParticles(ParticleTypes.CLOUD, this.getX(), this.getY()+1, this.getZ(), 10, random.nextDouble()-0.5F,random.nextDouble()-0.5F,random.nextDouble()-0.5F, 0.0);
                return false;
            }
            if(source.getMsgId().equals(KKResistanceType.darkness.toString())) {
                ((ServerLevel)this.level()).sendParticles(ParticleTypes.CLOUD, this.getX(), this.getY()+1, this.getZ(), 10, random.nextDouble()-0.5F,random.nextDouble()-0.5F,random.nextDouble()-0.5F, 0.0);
                return false;
            }


        }
//        return super.hurt(source, amount * multiplier);
        return super.hurt(source, getMaxHealth()/4 * multiplier);
    }

    //black ballade creates 4 or 5 copies - true one will jump, hitting wrong one will cause lightning struck
    //every attack it gets deals 5 damage to it, aka 25% of max hp - it takes 4 hits until it dies
    //it is immune to all magic, only reacting on direct hits


    class BlackBalladeGoal extends TargetGoal {
        private boolean canUseAttack = true;
        private int attackTimer = 5, whileAttackTimer, shotChargeTimer = 50;
        private float initialHealth;

        public BlackBalladeGoal(FMBlackBalladeEntity e) {
            super(e,true);
        }

        @Override
        public boolean canUse() {
            if (mob.getTarget() != null) {
                if (!canUseAttack) {
                    if (attackTimer > 0) {
                        attackTimer-=2;
                        return false;
                    } else
                        return true;
                } else
                    return true;
            } else
                return false;
        }

        @Override
        public boolean canContinueToUse() {
            return canUseAttack;
        }

        @Override
        public void start() {
            canUseAttack = true;
            attackTimer = 25 + level().random.nextInt(5);
            EntityHelper.setState(mob, 0);
            this.mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.20D);
            whileAttackTimer = 0;
            initialHealth = mob.getHealth();
        }

        @Override
        public void tick() {
            if (mob.getTarget() != null && canUseAttack) {
                whileAttackTimer+=2;
                LivingEntity target = this.mob.getTarget();

                if (EntityHelper.getState(mob) == 0) {
                    this.mob.getLookControl().setLookAt(target, 30F, 30F);
                    if (level().random.nextInt(100) <= 35 && this.mob.distanceTo(target) > 6) {
                        EntityHelper.setState(this.mob, 1);
                    } else {
                        if (level().random.nextInt(100) + level().random.nextDouble() <= 50) {
                            if (mob.distanceTo(mob.getTarget()) < 8) {
                                EntityHelper.setState(this.mob, 2);

                                this.mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);

                                for (LivingEntity enemy : EntityHelper.getEntitiesNear(this.mob, 4))
                                    mob.doHurtTarget(enemy);
                            } else
                                return;
                        } else {
                            EntityHelper.setState(this.mob, 3);

                            this.mob.getLookControl().setLookAt(target, 30F, 30F);
                            this.mob.getNavigation().moveTo(target.getX(), target.getY(), target.getZ(), 3.0D);

                            for (LivingEntity enemy : EntityHelper.getEntitiesNear(this.mob, 3))
                                this.mob.doHurtTarget(enemy);
                        }
                    }

                }

                if (EntityHelper.getState(mob) == 3) {
                    if (whileAttackTimer > 50)
                        canUseAttack = false;

                    if (mob.blockPosition().getX() == (int) target.getX() && mob.blockPosition().getY() == (int) target.getY() && mob.blockPosition().getZ() == (int) target.getZ())
                        canUseAttack = false;

                    if (mob.distanceToSqr(this.mob.getTarget()) < 3)
                        canUseAttack = false;

                    if (initialHealth > mob.getHealth())
                        canUseAttack = false;
                }

                if (EntityHelper.getState(mob) == 2 && whileAttackTimer > 20) {
                    canUseAttack = false;
                    EntityHelper.setState(mob, 0);
                    this.mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.20D);
                }
                else if (EntityHelper.getState(mob) == 1) {
                    if(shotChargeTimer > 0){
                        shotChargeTimer--;
                        this.mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
                        ((ServerLevel)this.mob.level()).sendParticles(new DustParticleOptions(new Vector3f(1,1,0),1F), this.mob.getX(), this.mob.getY()+2.5, this.mob.getZ(), 1, 0,0,0, 0.0);
                    } else {
                        this.mob.getLookControl().setLookAt(target, 0F, 0F);
                        this.mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.20D);
                        if(!level().isClientSide) {
                            LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(level());
                            lightningboltentity.moveTo(target.position());
                            level().addFreshEntity(lightningboltentity);
                            target.hurt(KKDamageTypes.getElementalDamage(KKDamageTypes.LIGHTNING, lightningboltentity, this.mob), (float)this.mob.getAttributeValue(Attributes.ATTACK_DAMAGE));
                        }
                        if(whileAttackTimer > 50) {
                            shotChargeTimer = 50;
                            canUseAttack = false;
                            EntityHelper.setState(mob, 0);
                            this.mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.20D);
                        }
                    }
                }
            }
        }
    }

}

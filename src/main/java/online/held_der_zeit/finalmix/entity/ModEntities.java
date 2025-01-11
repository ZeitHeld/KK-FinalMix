package online.held_der_zeit.finalmix.entity;

import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import online.held_der_zeit.finalmix.KingdomKeysFinalMix;
import online.kingdomkeys.kingdomkeys.KingdomKeys;
import online.kingdomkeys.kingdomkeys.block.ModBlocks;
import online.kingdomkeys.kingdomkeys.client.ClientSetup;
import online.kingdomkeys.kingdomkeys.client.model.BlizzardModel;
import online.kingdomkeys.kingdomkeys.client.model.FireModel;
import online.kingdomkeys.kingdomkeys.client.model.armor.*;
import online.kingdomkeys.kingdomkeys.client.model.entity.*;
import online.kingdomkeys.kingdomkeys.client.render.block.*;
import online.kingdomkeys.kingdomkeys.client.render.entity.*;
import online.kingdomkeys.kingdomkeys.client.render.entity.drops.*;
import online.kingdomkeys.kingdomkeys.client.render.magic.HeartEntityRenderer;
import online.kingdomkeys.kingdomkeys.client.render.magic.InvisibleEntityRenderer;
import online.kingdomkeys.kingdomkeys.client.render.magic.MagnetEntityRenderer;
import online.kingdomkeys.kingdomkeys.client.render.magic.ThunderBoltEntityRenderer;
import online.kingdomkeys.kingdomkeys.client.render.org.*;
import online.kingdomkeys.kingdomkeys.client.render.shotlock.UltimaCannonShotlockShotEntityRenderer;
import online.kingdomkeys.kingdomkeys.client.render.shotlock.VolleyShotlockShotEntityRenderer;
import online.kingdomkeys.kingdomkeys.config.ModConfigs;
import online.kingdomkeys.kingdomkeys.entity.*;
import online.kingdomkeys.kingdomkeys.entity.EntityHelper.MobType;
import online.kingdomkeys.kingdomkeys.entity.block.*;
import online.kingdomkeys.kingdomkeys.entity.magic.*;
import online.kingdomkeys.kingdomkeys.entity.mob.*;
import online.kingdomkeys.kingdomkeys.entity.organization.*;
import online.kingdomkeys.kingdomkeys.entity.shotlock.*;
import online.kingdomkeys.kingdomkeys.item.ModItems;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiFunction;

import static online.kingdomkeys.kingdomkeys.entity.EntityHelper.MobType.*;

@Mod.EventBusSubscriber(modid = KingdomKeysFinalMix.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KingdomKeysFinalMix.MODID);

    public static HashMap<EntityType<? extends Entity>,Integer> pureblood = new HashMap<>();
    public static HashMap<EntityType<? extends Entity>,Integer> emblem = new HashMap<>();
    public static HashMap<EntityType<? extends Entity>,Integer> nobody = new HashMap<>();
    public static Set<EntityType<? extends Entity>> npc = new HashSet<>();



    //Mobs
    public static final Item.Properties PROPERTIES = new Item.Properties();

    public static final RegistryObject<EntityType<ShadowEntity>> TYPE_SHADOW = createEntityType(ShadowEntity::new, ShadowEntity::new, MobCategory.MONSTER, "shadow", 0.5F, 0.7F);
    public static final RegistryObject<EntityType<MegaShadowEntity>> TYPE_MEGA_SHADOW = createEntityType(MegaShadowEntity::new, MegaShadowEntity::new, MobCategory.MONSTER, "mega_shadow", 1.5F, 1.7F);
    public static final RegistryObject<EntityType<GigaShadowEntity>> TYPE_GIGA_SHADOW = createEntityType(GigaShadowEntity::new, GigaShadowEntity::new, MobCategory.MONSTER, "giga_shadow", 2.5F, 2.7F);
    public static final RegistryObject<EntityType<DarkballEntity>> TYPE_DARKBALL = createEntityType(DarkballEntity::new, DarkballEntity::new, MobCategory.MONSTER, "darkball", 1.5F, 2F);
    public static final RegistryObject<EntityType<ShadowGlobEntity>> TYPE_SHADOW_GLOB = createEntityType(ShadowGlobEntity::new, ShadowGlobEntity::new, MobCategory.MONSTER, "shadow_glob", 1F, 1F);

    //Emblems
    public static final RegistryObject<EntityType<MinuteBombEntity>> TYPE_MINUTE_BOMB = createEntityType(MinuteBombEntity::new, MinuteBombEntity::new, MobCategory.MONSTER, "minute_bomb", 0.6F, 1.3F);
    public static final RegistryObject<EntityType<SkaterBombEntity>> TYPE_SKATER_BOMB = createEntityType(SkaterBombEntity::new, SkaterBombEntity::new, MobCategory.MONSTER, "skater_bomb", 0.6F, 1.3F);
    public static final RegistryObject<EntityType<StormBombEntity>> TYPE_STORM_BOMB = createEntityType(StormBombEntity::new, StormBombEntity::new, MobCategory.MONSTER, "storm_bomb", 0.6F, 1.3F);
    public static final RegistryObject<EntityType<DetonatorEntity>> TYPE_DETONATOR = createEntityType(DetonatorEntity::new, DetonatorEntity::new, MobCategory.MONSTER, "detonator", 0.6F, 1.3F);
    public static final RegistryObject<EntityType<RedNocturneEntity>> TYPE_RED_NOCTURNE = createEntityTypeImmuneToFire(RedNocturneEntity::new, RedNocturneEntity::new, MobCategory.MONSTER, "red_nocturne", 1.0F,  2.0F);
    public static final RegistryObject<EntityType<BlueRhapsodyEntity>> TYPE_BLUE_RHAPSODY = createEntityType(BlueRhapsodyEntity::new, BlueRhapsodyEntity::new, MobCategory.MONSTER, "blue_rhapsody", 1.0F, 2.0F);
    public static final RegistryObject<EntityType<YellowOperaEntity>> TYPE_YELLOW_OPERA = createEntityType(YellowOperaEntity::new, YellowOperaEntity::new, MobCategory.MONSTER, "yellow_opera", 1.0F, 2.0F);
    public static final RegistryObject<EntityType<GreenRequiemEntity>> TYPE_GREEN_REQUIEM = createEntityType(GreenRequiemEntity::new, GreenRequiemEntity::new, MobCategory.MONSTER, "green_requiem", 1.0F, 2.0F);
    public static final RegistryObject<EntityType<SpawningOrbEntity>> TYPE_SPAWNING_ORB = createEntityType(SpawningOrbEntity::new, SpawningOrbEntity::new, MobCategory.MONSTER, "spawning_orb", 1.5F,  1.5F);

    public static final RegistryObject<EntityType<SoldierEntity>> TYPE_SOLDIER = createEntityType(SoldierEntity::new, SoldierEntity::new, MobCategory.MONSTER, "soldier", 0.8F, 1.6F);
    public static final RegistryObject<EntityType<WhiteMushroomEntity>> TYPE_WHITE_MUSHROOM = createEntityType(WhiteMushroomEntity::new, WhiteMushroomEntity::new, MobCategory.MONSTER, "white_mushroom", 0.6F, 1.1F);
    public static final RegistryObject<EntityType<BlackFungusEntity>> TYPE_BLACK_FUNGUS = createEntityType(BlackFungusEntity::new, BlackFungusEntity::new, MobCategory.MONSTER, "black_fungus", 0.6F, 1.1F);


    public static final RegistryObject<EntityType<EmeraldBluesEntity>> TYPE_EMERALD_BLUES = createEntityType(EmeraldBluesEntity::new, EmeraldBluesEntity::new, MobCategory.MONSTER, "emerald_blues", 0.8F, 1.6F);

    public static final RegistryObject<EntityType<LargeBodyEntity>> TYPE_LARGE_BODY = createEntityType(LargeBodyEntity::new, LargeBodyEntity::new, MobCategory.MONSTER, "large_body", 1.3F, 1.6F);
    public static final RegistryObject<EntityType<DirePlantEntity>> TYPE_DIRE_PLANT = createEntityType(DirePlantEntity::new, DirePlantEntity::new, MobCategory.MONSTER, "dire_plant", 0.75F, 1.5F);



    /**
     * Helper method to create a new EntityType and set the registry name
     * @param factory The entity type factory
     * @param clientFactory The client factory
     * @param classification The classification of the entity
     * @param name The registry name of the entity
     * @param sizeX The X size of the entity
     * @param sizeY The Y size of the entity
     * @param <T> The entity type
     * @return The EntityType created
     */
    public static <T extends Entity, M extends EntityType<T>>RegistryObject<EntityType<T>> createEntityType(EntityType.EntityFactory<T> factory, BiFunction<PlayMessages.SpawnEntity, Level, T> clientFactory, MobCategory classification, String name, float sizeX, float sizeY) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, classification)
                .setCustomClientFactory(clientFactory)
                .setShouldReceiveVelocityUpdates(false)
                .setUpdateInterval(1)
                .setTrackingRange(8)
                .sized(sizeX, sizeY)
                .build(name));
    }

    public static <T extends Entity, M extends EntityType<T>>RegistryObject<EntityType<T>> createEntityTypeImmuneToFire(EntityType.EntityFactory<T> factory, BiFunction<PlayMessages.SpawnEntity, Level, T> clientFactory, MobCategory classification, String name, float sizeX, float sizeY) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, classification)
                .setCustomClientFactory(clientFactory)
                .setShouldReceiveVelocityUpdates(true)
                .setUpdateInterval(1)
                .setTrackingRange(128)
                .sized(sizeX, sizeY)
                .fireImmune()
                .build(name));
    }

//
//
    public static void addToGroup(MobType group, EntityType<?> type, int level) {
        switch (group) {
            case HEARTLESS_PUREBLOOD -> pureblood.put(type, level);
            case HEARTLESS_EMBLEM -> emblem.put(type, level);
            case NOBODY -> nobody.put(type, level);
            case NPC -> npc.add(type);
        }
    }

    /**
     * Register the render classes for the entities, called in {@link ClientSetup#registerRenderers(EntityRenderersEvent.RegisterRenderers)}
     */
    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
//        //Entities

//        event.registerEntityRenderer(TYPE_SHADOW.get(), ShadowRenderer::new);
//        event.registerEntityRenderer(TYPE_MEGA_SHADOW.get(), MegaShadowRenderer::new);
//        event.registerEntityRenderer(TYPE_GIGA_SHADOW.get(), GigaShadowRenderer::new);
//        event.registerEntityRenderer(TYPE_DARKBALL.get(), DarkballRenderer::new);
//        event.registerEntityRenderer(TYPE_SHADOW_GLOB.get(), ShadowGlobRenderer::new);
//        event.registerEntityRenderer(TYPE_LARGE_BODY.get(), LargeBodyRenderer::new);
//        event.registerEntityRenderer(TYPE_MINUTE_BOMB.get(), BombRenderer::new);
//        event.registerEntityRenderer(TYPE_SKATER_BOMB.get(), BombRenderer::new);
//        event.registerEntityRenderer(TYPE_STORM_BOMB.get(), BombRenderer::new);
//        event.registerEntityRenderer(TYPE_DETONATOR.get(), BombRenderer::new);

//        event.registerEntityRenderer(TYPE_RED_NOCTURNE.get(), ElementalMusicalHeartlessRenderer::new);
//        event.registerEntityRenderer(TYPE_BLUE_RHAPSODY.get(), ElementalMusicalHeartlessRenderer::new);
//        event.registerEntityRenderer(TYPE_YELLOW_OPERA.get(), ElementalMusicalHeartlessRenderer::new);
//        event.registerEntityRenderer(TYPE_GREEN_REQUIEM.get(), ElementalMusicalHeartlessRenderer::new);
//        event.registerEntityRenderer(TYPE_EMERALD_BLUES.get(), ElementalMusicalHeartlessRenderer::new);

//        event.registerEntityRenderer(TYPE_DIRE_PLANT.get(), DirePlantRenderer::new);
//        event.registerEntityRenderer(TYPE_SOLDIER.get(), SoldierRenderer::new);
//        event.registerEntityRenderer(TYPE_WHITE_MUSHROOM.get(), WhiteMushroomRenderer::new);
//        event.registerEntityRenderer(TYPE_BLACK_FUNGUS.get(), BlackFungusRenderer::new);
//
//
//        event.registerEntityRenderer(TYPE_ORG_PORTAL.get(), OrgPortalEntityRenderer::new);
//        event.registerEntityRenderer(TYPE_HEART.get(), HeartEntityRenderer::new);
//        event.registerEntityRenderer(TYPE_XP.get(), XPEntityRenderer::new);
//
//        //event.registerEntityRenderer(TYPE_CHAKRAM.get(), ChakramEntityRenderer::new);
//        EntityRenderers.register(TYPE_KK_THROWABLE.get(), KKThrowableEntityRenderer::new);
//
//        event.registerEntityRenderer(TYPE_LANCE.get(), KKThrowableEntityRenderer::new);
//
//        event.registerEntityRenderer(TYPE_SEED_BULLET.get(), SeedBulletRenderer::new);
//        event.registerEntityRenderer(TYPE_ARROWGUN_SHOT.get(), ArrowgunShotEntityRenderer::new);
//

        //Tile Entities

//        event.registerBlockEntityRenderer(TYPE_PEDESTAL.get(), PedestalRenderer::new);
//        event.registerBlockEntityRenderer(TYPE_MOOGLE_PROJECTOR.get(), MoogleProjectorRenderer::new);
//        event.registerBlockEntityRenderer(TYPE_SOA_PLATFORM.get(), SoAPlatformRenderer::new);
//        event.registerBlockEntityRenderer(TYPE_PEDESTAL.get(), PedestalRenderer::new);
//        event.registerBlockEntityRenderer(TYPE_AIRSTEP_TARGET_TE.get(), AirstepTargetRenderer::new);
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
//        event.registerLayerDefinition(AssassinModel.LAYER_LOCATION, AssassinModel::createBodyLayer);
//        event.registerLayerDefinition(BombModel.LAYER_LOCATION, BombModel::createBodyLayer);
//        event.registerLayerDefinition(CubeModel.LAYER_LOCATION, CubeModel::createBodyLayer);
//        event.registerLayerDefinition(DarkballModel.LAYER_LOCATION, DarkballModel::createBodyLayer);
//        event.registerLayerDefinition(DirePlantModel.LAYER_LOCATION, DirePlantModel::createBodyLayer);
//        event.registerLayerDefinition(SoldierModel.LAYER_LOCATION, SoldierModel::createBodyLayer);


//        event.registerLayerDefinition(ElementalMusicalHeartlessModel.LAYER_LOCATION, ElementalMusicalHeartlessModel::createBodyLayer);
//        event.registerLayerDefinition(LargeBodyModel.LAYER_LOCATION, LargeBodyModel::createBodyLayer);
//        event.registerLayerDefinition(MarluxiaModel.LAYER_LOCATION, MarluxiaModel::createBodyLayer);
//        event.registerLayerDefinition(MoogleModel.LAYER_LOCATION, MoogleModel::createBodyLayer);

//        event.registerLayerDefinition(StopModel.LAYER_LOCATION, StopModel::createBodyLayer);
//        event.registerLayerDefinition(MagnetModel.LAYER_LOCATION, MagnetModel::createBodyLayer);
//        event.registerLayerDefinition(TerraShoulderModel.LAYER_LOCATION, () -> TerraShoulderModel.createBodyLayer(new CubeDeformation(0)));
//        event.registerLayerDefinition(AquaShoulderModel.LAYER_LOCATION, () -> AquaShoulderModel.createBodyLayer(new CubeDeformation(0)));
//        event.registerLayerDefinition(VentusShoulderModel.LAYER_LOCATION, () -> VentusShoulderModel.createBodyLayer(new CubeDeformation(0)));
//        event.registerLayerDefinition(EraqusShoulderModel.LAYER_LOCATION, () -> EraqusShoulderModel.createBodyLayer(new CubeDeformation(0)));
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
//        event.put(TYPE_BLUE_RHAPSODY.get(), BlueRhapsodyEntity.registerAttributes().build());
//        event.put(TYPE_DARKBALL.get(), DarkballEntity.registerAttributes().build());
//        event.put(TYPE_DETONATOR.get(), DetonatorEntity.registerAttributes().build());
//        event.put(TYPE_DIRE_PLANT.get(), DirePlantEntity.registerAttributes().build());

//        event.put(TYPE_GIGA_SHADOW.get(), GigaShadowEntity.registerAttributes().build());
//        event.put(TYPE_GREEN_REQUIEM.get(), GreenRequiemEntity.registerAttributes().build());
//        event.put(TYPE_EMERALD_BLUES.get(), EmeraldBluesEntity.registerAttributes().build());
//        event.put(TYPE_LARGE_BODY.get(), LargeBodyEntity.registerAttributes().build());
//        event.put(TYPE_MEGA_SHADOW.get(), MegaShadowEntity.registerAttributes().build());
//        event.put(TYPE_MINUTE_BOMB.get(), MinuteBombEntity.registerAttributes().build());

//        event.put(TYPE_RED_NOCTURNE.get(), RedNocturneEntity.registerAttributes().build());
//        event.put(TYPE_SHADOW.get(), ShadowEntity.registerAttributes().build());
//        event.put(TYPE_SHADOW_GLOB.get(), ShadowGlobEntity.registerAttributes().build());
//        event.put(TYPE_SKATER_BOMB.get(), SkaterBombEntity.registerAttributes().build());
//        event.put(TYPE_STORM_BOMB.get(), StormBombEntity.registerAttributes().build());
//        event.put(TYPE_YELLOW_OPERA.get(), YellowOperaEntity.registerAttributes().build());
//        event.put(TYPE_SOLDIER.get(), SoldierEntity.registerAttributes().build());
//        event.put(TYPE_WHITE_MUSHROOM.get(), WhiteMushroomEntity.registerAttributes().build());
//        event.put(TYPE_BLACK_FUNGUS.get(), BlackFungusEntity.registerAttributes().build());

//        event.put(TYPE_SPAWNING_ORB.get(), SpawningOrbEntity.registerAttributes().build());
//
    }

    public static Monster getRandomEnemy(int level, Level world) {
//        addToGroup(MobType.NPC, TYPE_MOOGLE.get(), 0);
//
//        addToGroup(HEARTLESS_PUREBLOOD, TYPE_SHADOW.get(), 0);
//        addToGroup(HEARTLESS_PUREBLOOD, TYPE_MEGA_SHADOW.get(), 10);
//        addToGroup(HEARTLESS_PUREBLOOD, TYPE_GIGA_SHADOW.get(), 20);
//        addToGroup(HEARTLESS_PUREBLOOD, TYPE_DARKBALL.get(), 15);
//        addToGroup(HEARTLESS_PUREBLOOD, TYPE_SHADOW_GLOB.get(), 5);
//
//        addToGroup(HEARTLESS_EMBLEM, TYPE_MINUTE_BOMB.get(), 4);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_SKATER_BOMB.get(), 8);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_STORM_BOMB.get(), 12);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_DETONATOR.get(), 16);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_RED_NOCTURNE.get(), 6);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_BLUE_RHAPSODY.get(), 6);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_YELLOW_OPERA.get(), 6);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_GREEN_REQUIEM.get(), 6);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_EMERALD_BLUES.get(), 8);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_LARGE_BODY.get(), 8);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_DIRE_PLANT.get(), 0);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_SOLDIER.get(), 3);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_WHITE_MUSHROOM.get(), 20);
//        addToGroup(HEARTLESS_EMBLEM, TYPE_BLACK_FUNGUS.get(), 25);
//
//
//        addToGroup(NOBODY, TYPE_NOBODY_CREEPER.get(), 4);
//        addToGroup(NOBODY, TYPE_DUSK.get(), 0);
//        addToGroup(NOBODY, TYPE_ASSASSIN.get(), 15);
//        addToGroup(NOBODY, TYPE_DRAGOON.get(), 10);
//
//        int purebloodChance = Integer.parseInt(ModConfigs.mobSpawnRate.get(0).split(",")[1]);
//		int emblemChance = Integer.parseInt(ModConfigs.mobSpawnRate.get(1).split(",")[1]);
//		int nobodyChance = Integer.parseInt(ModConfigs.mobSpawnRate.get(2).split(",")[1]);
//		int num = world.random.nextInt(100);
//		List<Monster> mobs = new ArrayList<Monster>();
//
//		if(num <= purebloodChance) {
//			for(Entry<EntityType<? extends Entity>, Integer> entry : pureblood.entrySet()) {
//				if(entry.getValue() <= level) {
//					mobs.add((Monster) entry.getKey().create(world));
//				}
//			}
//		} else if(num > purebloodChance && num <= purebloodChance + emblemChance) {
//			for(Entry<EntityType<? extends Entity>, Integer> entry : emblem.entrySet()) {
//				if(entry.getValue() <= level) {
//					mobs.add((Monster) entry.getKey().create(world));
//				}
//			}
//		} else if(num > purebloodChance + emblemChance && num <= purebloodChance + emblemChance + nobodyChance){
//			for(Entry<EntityType<? extends Entity>, Integer> entry : nobody.entrySet()) {
//				if(entry.getValue() <= level) {
//					mobs.add((Monster) entry.getKey().create(world));
//				}
//			}
//		} else {
//			KingdomKeys.LOGGER.error("No spawning, config is not adding up to 100 percent");
//		}
//
//		return mobs.get(world.random.nextInt(mobs.size()));
//	}
//
//    @SubscribeEvent
//    public static void registerPlacements(SpawnPlacementRegisterEvent event) {
//    	event.register(TYPE_ASSASSIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_BLUE_RHAPSODY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_DARKBALL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_DETONATOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_DIRE_PLANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_DUSK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_GIGA_SHADOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_GREEN_REQUIEM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_EMERALD_BLUES.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_LARGE_BODY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_MEGA_SHADOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_MINUTE_BOMB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_MOOGLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PathfinderMob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_NOBODY_CREEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_RED_NOCTURNE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_SHADOW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_SHADOW_GLOB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_SKATER_BOMB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_STORM_BOMB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_YELLOW_OPERA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_SPAWNING_ORB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_SOLDIER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_WHITE_MUSHROOM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_BLACK_FUNGUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//        event.register(TYPE_DRAGOON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//
//        event.register(TYPE_MARLUXIA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
//    }
//
//    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, KingdomKeys.MODID);
//
//    public static final RegistryObject<BlockEntityType<MagnetBloxTileEntity>> TYPE_MAGNET_BLOX = TILE_ENTITIES.register("magnet_blox", () -> BlockEntityType.Builder.of(MagnetBloxTileEntity::new, ModBlocks.magnetBlox.get()).build(null));
//    public static final RegistryObject<BlockEntityType<SavepointTileEntity>> TYPE_SAVEPOINT = TILE_ENTITIES.register("savepoint", () -> BlockEntityType.Builder.of(SavepointTileEntity::new, ModBlocks.savepoint.get()).build(null));
//    public static final RegistryObject<BlockEntityType<PedestalTileEntity>> TYPE_PEDESTAL = TILE_ENTITIES.register("pedestal", () -> BlockEntityType.Builder.of(PedestalTileEntity::new, ModBlocks.pedestal.get()).build(null));
//    public static final RegistryObject<BlockEntityType<MagicalChestTileEntity>> TYPE_MAGICAL_CHEST = TILE_ENTITIES.register("magical_chest", () -> BlockEntityType.Builder.of(MagicalChestTileEntity::new, ModBlocks.magicalChest.get()).build(null));
//    public static final RegistryObject<BlockEntityType<OrgPortalTileEntity>> TYPE_ORG_PORTAL_TE = TILE_ENTITIES.register("org_portal", () -> BlockEntityType.Builder.of(OrgPortalTileEntity::new, ModBlocks.orgPortal.get()).build(null));
//    public static final RegistryObject<BlockEntityType<MoogleProjectorTileEntity>> TYPE_MOOGLE_PROJECTOR = TILE_ENTITIES.register("moogle_projector", () -> BlockEntityType.Builder.of(MoogleProjectorTileEntity::new, ModBlocks.moogleProjector.get()).build(null));
//    public static final RegistryObject<BlockEntityType<SoAPlatformTileEntity>> TYPE_SOA_PLATFORM = TILE_ENTITIES.register("soa_platform", () -> BlockEntityType.Builder.of(SoAPlatformTileEntity::new, ModBlocks.station_of_awakening_core.get()).build(null));
//    public static final RegistryObject<BlockEntityType<GummiEditorTileEntity>> TYPE_GUMMI_EDITOR = TILE_ENTITIES.register("gummi_editor", () -> BlockEntityType.Builder.of(GummiEditorTileEntity::new, ModBlocks.gummiEditor.get()).build(null));
//    public static final RegistryObject<BlockEntityType<SoRCoreTileEntity>> TYPE_SOR_CORE_TE = TILE_ENTITIES.register("sor_core", () -> BlockEntityType.Builder.of(SoRCoreTileEntity::new, ModBlocks.sorCore.get()).build(null));
//    public static final RegistryObject<BlockEntityType<CardDoorTileEntity>> TYPE_CARD_DOOR = TILE_ENTITIES.register("card_door", () -> BlockEntityType.Builder.of(CardDoorTileEntity::new, ModBlocks.cardDoor.get()).build(null));
//    public static final RegistryObject<BlockEntityType<AirStepTargetEntity>> TYPE_AIRSTEP_TARGET_TE = TILE_ENTITIES.register("airstep_target", () -> BlockEntityType.Builder.of(AirStepTargetEntity::new, ModBlocks.airstepTarget.get()).build(null));
}
package online.held_der_zeit.finalmix.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import online.held_der_zeit.finalmix.KingdomKeysFinalMix;
import online.kingdomkeys.kingdomkeys.item.*;
import online.kingdomkeys.kingdomkeys.lib.Strings;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KingdomKeysFinalMix.MODID);

    public static final RegistryObject<Item>

        //dummy = ITEMS.register("dummy", () -> new Item(new Item.Properties(), KingdomKeysFinalMix.MODID+":dummy"));
        dummy = ITEMS.register("dummy", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysFinalMix.MODID+":magic_haste"));

    // Spell Orbs
//        hasteSpell = ITEMS.register("haste_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_haste")),
//        slowSpell = ITEMS.register("slow_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_slow")),
//        holySpell = ITEMS.register("holy_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_holy")),
//        ruinSpell = ITEMS.register("ruin_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_ruin")),
//        balloonSpell = ITEMS.register("balloon_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_balloon")),
//        ultimaSpell = ITEMS.register("ultima_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_ultima")),
//        cometSpell = ITEMS.register("comet_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_comet")),
//        berserkSpell = ITEMS.register("berserk_spell",() -> new MagicSpellItem(new Item.Properties(),KingdomKeysReMind.MODID+":magic_berserk")),
//        autoLifeSpell = ITEMS.register("autolife_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_auto-life")),
//        drainSpell = ITEMS.register("drain_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_drain")),
//        osmoseSpell = ITEMS.register("osmose_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_osmose")),
//        silenceSpell = ITEMS.register("silence_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_silence")),
//        esunaSpell = ITEMS.register("esuna_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_esuna")),
//        dispelSpell = ITEMS.register("dispel_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_dispel")),
//        warpSpell = ITEMS.register("warp_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_warp")),
//        faithSpell = ITEMS.register("faith_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_faith")),

            // Shotlock Orbs
//        flameSalvo = ITEMS.register("flame_salvo_shotlock",() -> new ShotlockOrbItem(new Item.Properties(),KingdomKeysReMind.MODID+":flame_salvo")),
//        bubbleBlaster = ITEMS.register("bubble_blaster_shotlock",() -> new ShotlockOrbItem(new Item.Properties(),KingdomKeysReMind.MODID+":bubble_blaster")),
//        thunderStorm = ITEMS.register("thunderstorm_shotlock",() -> new ShotlockOrbItem(new Item.Properties(),KingdomKeysReMind.MODID+":thunderstorm")),
//        bioBarrage = ITEMS.register("bio_barrage_shotlock",() -> new ShotlockOrbItem(new Item.Properties(),KingdomKeysReMind.MODID+":bio_barrage")),
//        meteorShower = ITEMS.register("meteor_shower_shotlock",() -> new ShotlockOrbItem(new Item.Properties(),KingdomKeysReMind.MODID+":meteor_shower")),
//        darkDivide = ITEMS.register("dark_divide_shotlock",() -> new ShotlockOrbItem(new Item.Properties(),KingdomKeysReMind.MODID+":dark_divide")),

            // Keyblades
//        xephiroKeyblade = ITEMS.register("xephiro_keyblade", () -> new KeybladeItem(new Item.Properties())),
//        pureblood = ITEMS.register("pureblood", () -> new KeybladeItem(new Item.Properties())),
//        elemental_crescendo = ITEMS.register("elemental_crescendo", () -> new KeybladeItem(new Item.Properties())),
//        gazing_omen = ITEMS.register("gazing_omen", () -> new KeybladeItem(new Item.Properties())),
//        crystalsLight = ITEMS.register("crystals_light", () -> new KeybladeItem(new Item.Properties())),

            // Keychains
//        xephiroKeybladeChain = ITEMS.register("xephiro_keyblade_chain", () -> new KeychainItem()),
//        purebloodChain = ITEMS.register("pureblood_chain", () -> new KeychainItem()),
//        elementalCrescendoChain = ITEMS.register("elemental_crescendo_chain", () -> new KeychainItem()),
//        gazingOmenChain = ITEMS.register("gazing_omen_chain", () -> new KeychainItem()),
//        crystalsLightChain = ITEMS.register("crystals_light_chain", () -> new KeychainItem()),

            // Org Weapons



            // KK Armors
//        aquaChaplet = ITEMS.register("aqua_chaplet", () -> new KKArmorItem(new Item.Properties().stacksTo(1),1, ImmutableMap.of(KKResistanceType.ice,50))),
//        herosGlove = ITEMS.register("heros_glove", () -> new KKArmorItem(new Item.Properties().stacksTo(1),4, ImmutableMap.of(KKResistanceType.fire,20,KKResistanceType.ice,20,KKResistanceType.darkness,20))),
//        herosBelt = ITEMS.register("heros_belt", () -> new KKArmorItem(new Item.Properties().stacksTo(1),3, ImmutableMap.of(KKResistanceType.lightning,20,KKResistanceType.ice,20,KKResistanceType.darkness,20))),
//        masterBelt = ITEMS.register("master_belt", () -> new KKArmorItem(new Item.Properties().stacksTo(1),7, ImmutableMap.of(KKResistanceType.darkness,20))),
//        ultima_ribbon = ITEMS.register("ultima_ribbon", () -> new KKArmorItem(new Item.Properties().stacksTo(1),5, ImmutableMap.of(KKResistanceType.fire,55,KKResistanceType.ice,55,KKResistanceType.lightning,55,KKResistanceType.darkness,55))),

            // KK Accessories
//        luckOfTheDraw = ITEMS.register("luck_of_the_draw", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1), 0,0,0,new String[] {Strings.luckyLucky,Strings.treasureMagnet})),
//        lightHeart = ITEMS.register("light_heart", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1), 5,0,0,new String[] {StringsRM.wayToLight})),
//        darkHeart = ITEMS.register("dark_heart", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1), 5,0,0,new String[] {StringsRM.darkPower})),
//        ragingHeart = ITEMS.register("raging_heart", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1), 5,0,0,new String[] {StringsRM.rageAwakened})),
//        celestriad = ITEMS.register("celestriad", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1), 5,2,3,new String[] {Strings.fireBoost,Strings.blizzardBoost,Strings.thunderBoost})),
//        forestClasp = ITEMS.register("forest_clasp", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),8,2,3,new String[] {StringsRM.hpWalker})),
//        laughterPin = ITEMS.register("laughter_pin", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),6,3,2,new String[] {StringsRM.mpWalker})),
//        crystalRegalia = ITEMS.register("crystal_regalia", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),16,5,5,new String[] {Strings.mpHastega})),
//        crystalRegaliaPlus = ITEMS.register("crystal_regalia_plus", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),25,6,6,new String[] {Strings.mpHastega})),
//        flanniversaryBadge = ITEMS.register("flanniversary_badge", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),0,4,4,new String[] {Strings.mpHastera,Strings.mpThrift})),
//        mickeyClasp = ITEMS.register("mickey_clasp", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),0,3,5,new String[] {Strings.mpHastega,Strings.endlessMagic})),
//        breakthrough = ITEMS.register("breakthrough", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),15,7,0, null)),
//        hasteBracer = ITEMS.register("haste_bracer", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),5,3,0, new String[] {StringsRM.attackHaste})),
//        sacrificeBracer = ITEMS.register("sacrifice_bracer", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),5,5,5, new String[] {StringsRM.vehemence})),
//        darkRing = ITEMS.register("dark_ring", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),5,5,5, new String[] {StringsRM.darknessBoost})),
//        lightRing = ITEMS.register("light_ring", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),5,5,5, new String[] {StringsRM.lightBoost})),
//
//        expRing = ITEMS.register("exp_ring", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),5,1,1, new String[] {StringsRM.expWalker})),
//        focusSash = ITEMS.register("focus_sash", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),3,0,3, new String[] {StringsRM.focusWalker})),
//        heartLocket = ITEMS.register("heart_locket", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),5,1,1, new String[] {StringsRM.heartWalker})),
//        friendBinder = ITEMS.register("friendbinder", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),10,0,0, new String[] {StringsRM.friendsPower})),
//        nothingnessBinder = ITEMS.register("nothingness_binder", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1),10,0,0, new String[] {StringsRM.heartsPower}))
//        ;


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

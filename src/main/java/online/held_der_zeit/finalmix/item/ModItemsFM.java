package online.held_der_zeit.finalmix.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import online.held_der_zeit.finalmix.KingdomKeysFinalMix;
import online.kingdomkeys.kingdomkeys.item.*;


public class ModItemsFM {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KingdomKeysFinalMix.MODID);

    public static final RegistryObject<Item>

        //dummy = ITEMS.register("dummy", () -> new Item(new Item.Properties(), KingdomKeysFinalMix.MODID+":dummy"));

        dummySpell = ITEMS.register("spell_dummy", () -> new MagicSpellItem(new Item.Properties(),
                                                                            KingdomKeysFinalMix.MODID + ":spell_dummy")),

    // Spell Orbs
    // hasteSpell = ITEMS.register("haste_spell", () -> new MagicSpellItem(new Item.Properties(), KingdomKeysReMind.MODID+":magic_haste")),


            // Shotlock Orbs
    // flameSalvo = ITEMS.register("flame_salvo_shotlock",() -> new ShotlockOrbItem(new Item.Properties(),KingdomKeysReMind.MODID+":flame_salvo")),

            // Keyblades
    // xephiroKeyblade = ITEMS.register("xephiro_keyblade", () -> new KeybladeItem(new Item.Properties())),


            // Keychains
    // xephiroKeybladeChain = ITEMS.register("xephiro_keyblade_chain", () -> new KeychainItem()),


            // Org Weapons


            // KK Armors
            lightResArmor = ITEMS.register("shadow_shirt", () -> new KKArmorItem(new Item.Properties().stacksTo(1),4,
                                                                    ImmutableMap.of(KKResistanceType.light,20))),

            // KK Accessories
//        luckOfTheDraw = ITEMS.register("luck_of_the_draw", () -> new KKAccessoryItem(new Item.Properties().stacksTo(1), 0,0,0,new String[] {Strings.luckyLucky,Strings.treasureMagnet})),

            dummyKey = ITEMS.register("keyblade_dummy", () -> new KeybladeItem(new Item.Properties())),
            dummyKeyChain = ITEMS.register("keyblade_dummy_chain", KeychainItem::new)
        ;


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

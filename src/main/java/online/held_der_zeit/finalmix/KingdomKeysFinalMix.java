package online.held_der_zeit.finalmix;

import com.google.common.base.Suppliers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import online.held_der_zeit.finalmix.entity.ModEntities;
import online.held_der_zeit.finalmix.item.ModItems;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KingdomKeysFinalMix.MODID)
public class KingdomKeysFinalMix {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "kkfinalmix";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static boolean efmLoaded = false;

    
    public KingdomKeysFinalMix(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        //MinecraftForge.EVENT_BUS.register(new EntityEvents());
        //ModMagics.MAGIC.register(modEventBus);
        //MinecraftForge.EVENT_BUS.register(new ModCapabilities());
//        ModSounds.SOUNDS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEntities.ENTITIES.register(modEventBus);
//        ModAbilities.ABILITIES.register(modEventBus);
//        ModDriveForms.DRIVE_FORMS.register(modEventBus);
//        ModShotlocks.SHOTLOCKS.register(modEventBus);
//        ModEffects.MOB_EFFECTS.register(modEventBus);
//        ModReactionCommands.REACTION_COMMANDS.register(modEventBus);
        modEventBus.addListener(this::setup);

        TABS.register(modEventBus);

//        if (ModList.get().isLoaded("epicfight")) {
//            efmLoaded = true;
//            KKFMSkills.SKILLS.register(modEventBus);
//            MinecraftForge.EVENT_BUS.register(new EpicFightEvents());
//        }
    }

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

//    private static final Supplier<List<ItemStack>> fmItems = Suppliers.memoize(() -> ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).map(ItemStack::new).toList());


//    public static final RegistryObject<CreativeModeTab>
//
//            kkfm_tab = TABS.register("kkfinalmixtab", () -> CreativeModeTab.builder()
//            .title(Component.translatable("itemGroup.kkfinalmix"))
////            //.icon(() -> new ItemStack(ModItemsRM.hasteSpell.get()))
////            .icon(() -> new ItemStack(ModItems.dummy.get())
//            .displayItems(((params, output) -> {
//                fmItems.get().forEach(output::accept);
//            }))
//            .build());

    private void setup(final FMLCommonSetupEvent event){
        // Some common setup code
		//event.enqueueWork(PacketHandlerRM::register);
        //event.enqueueWork(ModEntitiesRM::registerPlacements);


        // Org Weapons
        //ListsRM.loadAddonOrgWeapons();
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("Kingdom Keys: Final Mix Enabled on SERVER!");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
    		//MinecraftForge.EVENT_BUS.register(new InputHandlerRM());

            LOGGER.info("Kingdom Keys: Final Mix Enabled on CLIENT!");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }


    }
}

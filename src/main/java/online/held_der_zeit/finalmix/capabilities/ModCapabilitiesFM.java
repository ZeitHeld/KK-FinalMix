package online.held_der_zeit.finalmix.capabilities;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import online.held_der_zeit.finalmix.KingdomKeysFinalMix;

@Mod.EventBusSubscriber(modid = KingdomKeysFinalMix.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCapabilitiesFM {
	public static final Capability<IGlobalCapabilitiesFM> GLOBAL_CAPABILITIES = CapabilityManager.get(new CapabilityToken<>() {});
	// public static final Capability<IPlayerCapabilitiesFM> PLAYER_CAPABILITIES = CapabilityManager.get(new CapabilityToken<>() {});
	//public static final Capability<IWorldCapabilitiesFM> WORLD_CAPABILITIES = CapabilityManager.get(new CapabilityToken<>() {});

	public static IGlobalCapabilitiesFM getGlobal(LivingEntity e) {
		LazyOptional<IGlobalCapabilitiesFM> globalData = e.getCapability(ModCapabilitiesFM.GLOBAL_CAPABILITIES, null);
		return globalData.orElse(null);
	}

	@SubscribeEvent
	public static void register(RegisterCapabilitiesEvent event) {

	}
}

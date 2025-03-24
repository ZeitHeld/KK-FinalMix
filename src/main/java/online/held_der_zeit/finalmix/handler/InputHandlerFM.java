package online.held_der_zeit.finalmix.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import online.held_der_zeit.finalmix.client.gui.GUIHelperFM;
import online.held_der_zeit.finalmix.network.PacketHandlerFM;
import online.held_der_zeit.finalmix.network.cts.CSFMSyncAllClientDataPacket;
import online.kingdomkeys.kingdomkeys.api.event.client.KKInputEvent;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.client.gui.menu.NoChoiceMenuPopup;
import online.kingdomkeys.kingdomkeys.handler.InputHandler;
import online.kingdomkeys.kingdomkeys.lib.SoAState;
import online.kingdomkeys.kingdomkeys.network.PacketHandler;
import online.kingdomkeys.kingdomkeys.network.cts.CSSyncAllClientDataPacket;
import online.kingdomkeys.kingdomkeys.util.Utils;
import online.kingdomkeys.kingdomkeys.world.dimension.ModDimensions;

public class InputHandlerFM {

	public InputHandlerFM() {
	}

	@SubscribeEvent
	public void kkInputEvent(KKInputEvent.Pre event) {
		if(event.getKeybind() == InputHandler.Keybinds.OPENMENU) {
			PacketHandler.sendToServer(new CSSyncAllClientDataPacket());
			PacketHandlerFM.sendToServer(new CSFMSyncAllClientDataPacket());
			LocalPlayer player = Minecraft.getInstance().player;

			if (ModCapabilities.getPlayer(player).getSoAState() != SoAState.COMPLETE) {
				if (player.level().dimension() != ModDimensions.DIVE_TO_THE_HEART) {
					Minecraft.getInstance().setScreen(new NoChoiceMenuPopup());
				}
			} else {
				GUIHelperFM.openMenuFM();
			}
			event.setCanceled(true);
		}
	}
}

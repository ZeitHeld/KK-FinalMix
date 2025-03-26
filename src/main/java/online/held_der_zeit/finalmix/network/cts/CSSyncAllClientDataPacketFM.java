package online.held_der_zeit.finalmix.network.cts;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import online.held_der_zeit.finalmix.capabilities.IGlobalCapabilitiesFM;
import online.held_der_zeit.finalmix.capabilities.ModCapabilitiesFM;
import online.held_der_zeit.finalmix.network.PacketHandlerFM;

import java.util.function.Supplier;

public class CSSyncAllClientDataPacketFM {
	public CSSyncAllClientDataPacketFM() {
	}

	public void encode(FriendlyByteBuf buffer) {
	}

	public static CSSyncAllClientDataPacketFM decode(FriendlyByteBuf buffer) {
		CSSyncAllClientDataPacketFM msg = new CSSyncAllClientDataPacketFM();

		return msg;
	}

	public static void handle(final CSSyncAllClientDataPacketFM message, Supplier<NetworkEvent.Context> ctx) {
		Player player = ctx.get().getSender();

		IGlobalCapabilitiesFM globalData = ModCapabilitiesFM.getGlobal(player);
		PacketHandlerFM.syncGlobalToAllAround(player, globalData);

		ctx.get().setPacketHandled(true);
	}
}

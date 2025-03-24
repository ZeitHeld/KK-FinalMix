package online.held_der_zeit.finalmix.network.cts;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import online.held_der_zeit.finalmix.capabilities.IGlobalCapabilitiesFM;
import online.held_der_zeit.finalmix.capabilities.ModCapabilitiesFM;
import online.held_der_zeit.finalmix.network.PacketHandlerFM;
import online.kingdomkeys.kingdomkeys.capability.IPlayerCapabilities;
import online.kingdomkeys.kingdomkeys.capability.ModCapabilities;
import online.kingdomkeys.kingdomkeys.network.PacketHandler;
import online.kingdomkeys.kingdomkeys.network.cts.CSSyncAllClientDataPacket;
import online.kingdomkeys.kingdomkeys.network.stc.SCSyncCapabilityPacket;

import java.util.function.Supplier;

public class CSFMSyncAllClientDataPacket {
	public CSFMSyncAllClientDataPacket() {
	}

	public void encode(FriendlyByteBuf buffer) {
	}

	public static CSFMSyncAllClientDataPacket decode(FriendlyByteBuf buffer) {
		CSFMSyncAllClientDataPacket msg = new CSFMSyncAllClientDataPacket();

		return msg;
	}

	public static void handle(final CSFMSyncAllClientDataPacket message, Supplier<NetworkEvent.Context> ctx) {
		Player player = ctx.get().getSender();

		IGlobalCapabilitiesFM globalData = ModCapabilitiesFM.getGlobal(player);
		PacketHandlerFM.syncGlobalToAllAround(player, globalData);

		ctx.get().setPacketHandled(true);
	}
}

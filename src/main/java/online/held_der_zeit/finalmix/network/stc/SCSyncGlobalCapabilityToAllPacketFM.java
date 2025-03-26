package online.held_der_zeit.finalmix.network.stc;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.network.NetworkEvent;
import online.held_der_zeit.finalmix.capabilities.IGlobalCapabilitiesFM;
import online.held_der_zeit.finalmix.capabilities.ModCapabilitiesFM;

import java.util.function.Supplier;

public class SCSyncGlobalCapabilityToAllPacketFM {
	public int id;

	public SCSyncGlobalCapabilityToAllPacketFM() {}

	public SCSyncGlobalCapabilityToAllPacketFM(int id_p, IGlobalCapabilitiesFM capability) {
		id = id_p;
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeInt(id);
	}

	public static SCSyncGlobalCapabilityToAllPacketFM decode(FriendlyByteBuf buffer) {
		SCSyncGlobalCapabilityToAllPacketFM msg = new SCSyncGlobalCapabilityToAllPacketFM();
		msg.id = buffer.readInt();

		return msg;
	}

	public static void handle(final SCSyncGlobalCapabilityToAllPacketFM message, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			LivingEntity entity = (LivingEntity) Minecraft.getInstance().level.getEntity(message.id);

			if (entity != null) {
				LazyOptional<IGlobalCapabilitiesFM> globalData = entity.getCapability(ModCapabilitiesFM.GLOBAL_CAPABILITIES);
				globalData.ifPresent(cap -> {

					//idk what will come here

				});
			}
		});
		ctx.get().setPacketHandled(true);
	}
}

package online.held_der_zeit.finalmix.network.stc;

import net.minecraft.network.FriendlyByteBuf;
import online.held_der_zeit.finalmix.capabilities.IGlobalCapabilitiesFM;

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
}

package online.held_der_zeit.finalmix.network.cts;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import online.held_der_zeit.finalmix.capabilities.IGlobalCapabilitiesFM;
import online.held_der_zeit.finalmix.capabilities.ModCapabilitiesFM;

import java.util.function.Supplier;

public class CSDeckMeldingFM {

    public CSDeckMeldingFM() {

    }

    public void encode(FriendlyByteBuf buffer) {

    }

    public static CSDeckMeldingFM decode(FriendlyByteBuf buffer) {
        CSDeckMeldingFM msg = new CSDeckMeldingFM();

        return msg;
    }

    public static void handle(final CSDeckMeldingFM message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Player player = ctx.get().getSender();
            IGlobalCapabilitiesFM globalData = ModCapabilitiesFM.getGlobal(player);
            //globalData.setStepTicks(message.ticks,message.type);

            //PacketHandlerFM.syncGlobalToAllAround(player, globalData);
        });
        ctx.get().setPacketHandled(true);
    }
}

package online.held_der_zeit.finalmix.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import online.held_der_zeit.finalmix.KingdomKeysFinalMix;
import online.held_der_zeit.finalmix.capabilities.IGlobalCapabilitiesFM;
import online.held_der_zeit.finalmix.network.stc.SCSyncGlobalCapabilityToAllPacketFM;

public class PacketHandlerFM {
    private static final String PROTOCOL_VERSION = Integer.toString(1);

    private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(KingdomKeysFinalMix.MODID, "main_channel")).clientAcceptedVersions(PROTOCOL_VERSION::equals).serverAcceptedVersions(PROTOCOL_VERSION::equals).networkProtocolVersion(() -> PROTOCOL_VERSION).simpleChannel();

    public static <MSG> void sendToServer(MSG msg) {
        HANDLER.sendToServer(msg);
    }

    public static <MSG> void sendTo(MSG msg, ServerPlayer player) {
        if (!(player instanceof FakePlayer)) {
            HANDLER.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
        }
    }

    public static void syncGlobalToAllAround(LivingEntity entity, IGlobalCapabilitiesFM globalData) {
        if (!entity.level().isClientSide) {
            for (Player playerFromList : entity.level().players()) {
                sendTo(new SCSyncGlobalCapabilityToAllPacketFM(entity.getId(), (IGlobalCapabilitiesFM) globalData), (ServerPlayer) playerFromList);
            }
        }
    }


}

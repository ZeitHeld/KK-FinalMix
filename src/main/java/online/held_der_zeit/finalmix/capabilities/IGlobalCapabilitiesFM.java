package online.held_der_zeit.finalmix.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

@AutoRegisterCapability
public interface IGlobalCapabilitiesFM extends INBTSerializable<CompoundTag> {

	int getDummy();
}

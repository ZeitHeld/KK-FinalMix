package online.held_der_zeit.finalmix.sound;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import online.held_der_zeit.finalmix.KingdomKeysFinalMix;

import static online.kingdomkeys.kingdomkeys.client.sound.ModSounds.registerSound;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, KingdomKeysFinalMix.MODID);

    //Maybe somehow sort this
    public static final RegistryObject<SoundEvent>
        //english
        EN_SORA_KH1_HURT = registerSound("heroes/english/sora-kh1/hurt"),
        EN_SORA_KH1_ATTACK = registerSound("heroes/english/sora-kh1/attack"),
        EN_SORA_KH1_DEATH = registerSound("heroes/english/sora-kh1/death"),
        EN_SORA_KH1_ITEM = registerSound("heroes/english/sora-kh1/item"),
        EN_SORA_KH1_MAGIC_GENERIC = registerSound("heroes/english/sora-kh1/magic/generic"),
        EN_SORA_KH1_MAGIC_FIRE = registerSound("heroes/english/sora-kh1/magic/fire"),
        EN_SORA_KH1_MAGIC_BLIZZARD = registerSound("heroes/english/sora-kh1/magic/blizzard"),
        EN_SORA_KH1_MAGIC_THUNDER = registerSound("heroes/english/sora-kh1/magic/thunder"),
        EN_SORA_KH1_MAGIC_CURE = registerSound("heroes/english/sora-kh1/magic/cure"),

        //german
        DE_SORA_KH1_HURT = registerSound("heroes/german/sora-kh1/hurt"),
        DE_SORA_KH1_ATTACK = registerSound("heroes/german/sora-kh1/attack"),
        DE_SORA_KH1_DEATH = registerSound("heroes/german/sora-kh1/death"),
        DE_SORA_KH1_ITEM = registerSound("heroes/german/sora-kh1/item"),
        DE_SORA_KH1_MAGIC_GENERIC = registerSound("heroes/german/sora-kh1/magic/generic"),
        DE_SORA_KH1_MAGIC_FIRE = registerSound("heroes/german/sora-kh1/magic/fire"),
        DE_SORA_KH1_MAGIC_BLIZZARD = registerSound("heroes/german/sora-kh1/magic/blizzard"),
        DE_SORA_KH1_MAGIC_THUNDER = registerSound("heroes/german/sora-kh1/magic/thunder"),
        DE_SORA_KH1_MAGIC_CURE = registerSound("heroes/german/sora-kh1/magic/cure"),

        DE_SORA_KH2_HURT = registerSound("heroes/german/sora-kh1/hurt"),
        DE_SORA_KH2_ATTACK = registerSound("heroes/german/sora-kh2/attack"),
        DE_SORA_KH2_DEATH = registerSound("heroes/german/sora-kh2/death"),
        DE_SORA_KH2_ITEM = registerSound("heroes/german/sora-kh2/item"),
        DE_SORA_KH2_MAGIC_GENERIC = registerSound("heroes/german/sora-kh2/magic/generic"),
        DE_SORA_KH2_MAGIC_FIRE = registerSound("heroes/german/sora-kh2/magic/fire"),
        DE_SORA_KH2_MAGIC_BLIZZARD = registerSound("heroes/german/sora-kh2/magic/blizzard"),
        DE_SORA_KH2_MAGIC_THUNDER = registerSound("heroes/german/sora-kh2/magic/thunder"),
        DE_SORA_KH2_MAGIC_CURE = registerSound("heroes/german/sora-kh2/magic/cure")

    ;

}

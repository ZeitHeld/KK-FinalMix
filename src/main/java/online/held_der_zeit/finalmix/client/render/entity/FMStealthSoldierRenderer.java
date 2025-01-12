package online.held_der_zeit.finalmix.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import online.held_der_zeit.finalmix.entity.mob.FMStealthSoldierEntity;
import online.kingdomkeys.kingdomkeys.client.model.entity.SoldierModel;
import online.kingdomkeys.kingdomkeys.entity.mob.SoldierEntity;

public class FMStealthSoldierRenderer<Type extends FMStealthSoldierEntity> extends MobRenderer<Type, SoldierModel<Type>> {
    public FMStealthSoldierRenderer(EntityRendererProvider.Context context) {
        super(context, new SoldierModel(context.bakeLayer(SoldierModel.LAYER_LOCATION)), 0.5F);
    }

    public void render(Type entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.popPose();
    }

    protected void scale(Type entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.6F, 0.6F, 0.6F);
        super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }

    public ResourceLocation getTextureLocation(Type pEntity) {
        return new ResourceLocation("kkfinalmix", "textures/entity/mob/stealth_soldier.png");
    }
}

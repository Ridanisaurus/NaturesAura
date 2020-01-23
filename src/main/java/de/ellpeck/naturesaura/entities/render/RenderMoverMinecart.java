package de.ellpeck.naturesaura.entities.render;

import com.mojang.blaze3d.platform.GlStateManager;
import de.ellpeck.naturesaura.NaturesAura;
import de.ellpeck.naturesaura.entities.EntityMoverMinecart;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.util.ResourceLocation;

public class RenderMoverMinecart extends MinecartRenderer<EntityMoverMinecart> {

    private static final ResourceLocation RES = new ResourceLocation(NaturesAura.MOD_ID, "textures/models/mover_cart.png");
    private final ModelMoverMinecart model = new ModelMoverMinecart();

    public RenderMoverMinecart(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected void renderCartContents(EntityMoverMinecart cart, float partialTicks, BlockState state) {
        GlStateManager.pushMatrix();
        GlStateManager.translatef(0, 22 / 16F, 0);
        GlStateManager.rotatef(180, 1, 0, 0);
        this.bindTexture(RES);
        this.model.render();
        GlStateManager.popMatrix();
    }

    private static class ModelMoverMinecart extends Model {

        private final RendererModel box;

        public ModelMoverMinecart() {
            this.box = new RendererModel(this, 0, 0);
            this.box.setTextureSize(64, 64);
            this.box.addBox(0, 0, 0, 16, 24, 16);
        }

        public void render() {
            this.box.render(1 / 16F);
        }
    }
}

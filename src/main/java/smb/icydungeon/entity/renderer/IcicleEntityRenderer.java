package smb.icydungeon.entity.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;
import smb.icydungeon.Icy_Dungeons;
import smb.icydungeon.entity.projectile.IcicleShardEntity;

public class IcicleEntityRenderer extends ArrowRenderer<IcicleShardEntity, ArrowRenderState> {
    private static final Identifier TEXTURE =
            Icy_Dungeons.id("textures/entity/projectile/icicle_shard.png");

    public IcicleEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Identifier getTextureLocation(ArrowRenderState state) {
        return TEXTURE;
    }

    @Override
    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}

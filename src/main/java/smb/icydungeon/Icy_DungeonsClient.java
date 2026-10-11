package smb.icydungeon;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import smb.icydungeon.entity.renderer.IcicleEntityRenderer;
import smb.icydungeon.item.ModEntities;

public class Icy_DungeonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.ICICLE_SHARD, IcicleEntityRenderer::new);
    }
}

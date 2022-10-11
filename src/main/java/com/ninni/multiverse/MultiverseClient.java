package com.ninni.multiverse;

import com.ninni.multiverse.block.MultiverseBlocks;
import com.ninni.multiverse.client.models.CobblestoneGolemModel;
import com.ninni.multiverse.client.models.ExhaustedCobblestoneGolemModel;
import com.ninni.multiverse.client.renderer.CobblestoneGolemRenderer;
import com.ninni.multiverse.client.renderer.ExhaustedCobblestoneGolemRenderer;
import com.ninni.multiverse.entities.MultiverseEntityTypes;
import com.ninni.multiverse.client.models.MultiverseModelLayers;
import com.ninni.multiverse.network.MultiverseNetwork;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;

public class MultiverseClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(MultiverseEntityTypes.COBBLESTONE_GOLEM, CobblestoneGolemRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MultiverseModelLayers.COBBLESTONE_GOLEM, CobblestoneGolemModel::getLayerDefinition);
		EntityRendererRegistry.register(MultiverseEntityTypes.EXHAUSTED_COBBLESTONE_GOLEM, ExhaustedCobblestoneGolemRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MultiverseModelLayers.EXHAUSTED_COBBLESTONE_GOLEM, ExhaustedCobblestoneGolemModel::getLayerDefinition);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), MultiverseBlocks.LORE_TABLET);

		MultiverseNetwork.init();

	}

}

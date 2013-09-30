package vdvman1.pal.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import vdvman1.pal.block.PalBlocks;
import vdvman1.pal.client.model.ModelPal;
import vdvman1.pal.client.renderer.ItemPalRenderer;
import vdvman1.pal.client.renderer.TilePalRenderer;
import vdvman1.pal.inventory.TilePal;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		ModelPal.modelID = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TilePal.class, new TilePalRenderer());
		MinecraftForgeClient.registerItemRenderer(PalBlocks.palBlockID, new ItemPalRenderer());
	}

}

package vdvman1.pal.proxy;

import vdvman1.pal.inventory.TilePal;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TilePal.class, "tileProgLogArry");
	}
	
	public void initRendering() {}

}

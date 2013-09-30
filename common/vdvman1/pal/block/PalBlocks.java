package vdvman1.pal.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;

public class PalBlocks {
	
	//ID's
	public static int palBlockID = 200;
	
	public static Block palBlock;
	
	public static void init(Configuration config) {
		palBlock = new BlockPal(config.getBlock("palBlockID", palBlockID).getInt(palBlockID));
		
		GameRegistry.registerBlock(palBlock, "progLogArry");
	}

}

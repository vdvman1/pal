package vdvman1.pal.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;

public class PalBlocks {
	
	//ID's
	public static int palBlockID = 200;
	
	public static Block palBlock;
	
	public static void init(Configuration config) {
		palBlockID = config.getBlock("palBlockID", palBlockID).getInt(palBlockID);
		palBlock = new BlockPal(palBlockID);
		
		GameRegistry.registerBlock(palBlock, "progLogArry");
	}

}

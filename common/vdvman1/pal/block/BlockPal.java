package vdvman1.pal.block;

import vdvman1.pal.inventory.TilePal;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPal extends BlockContainer {

	public BlockPal(int id) {
		super(id, Material.circuits);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TilePal();
	}

}

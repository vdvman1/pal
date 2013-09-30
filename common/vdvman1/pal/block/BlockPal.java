package vdvman1.pal.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vdvman1.pal.client.model.ModelPal;
import vdvman1.pal.inventory.TilePal;

public class BlockPal extends BlockContainer {

	public BlockPal(int id) {
		super(id, Material.circuits);
		this.setUnlocalizedName("progLogArry");
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TilePal();
	}
	
	@Override
    public boolean renderAsNormalBlock() {

        return false;
    }

    @Override
    public boolean isOpaqueCube() {

        return false;
    }
    
    @Override
    public int getRenderType() {

        return ModelPal.modelID;
    }

}

package vdvman1.pal.client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import vdvman1.pal.client.model.ModelPal;
import vdvman1.pal.inventory.TilePal;

public class TilePalRenderer extends TileEntitySpecialRenderer {

	ModelPal model = new ModelPal();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		if(tileentity instanceof TilePal) {
				model.render((TilePal)tileentity, d0, d1, d2);
		}
	}

}

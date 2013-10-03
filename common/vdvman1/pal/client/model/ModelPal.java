package vdvman1.pal.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import vdvman1.pal.inventory.TilePal;
import cpw.mods.fml.client.FMLClientHandler;

public class ModelPal extends ModelBase {
	
	private IModelCustom modelPal;
	public static int modelID;
	
	                                      //{DOWN,    UP,      NORTH,   SOUTH,    WEST,    EAST};
	static final String[] sideToModelPart = {"neg_y", "pos_y", "neg_z", "pos_z", "neg_x", "pos_x"};
	
	public ModelPal() {
		modelPal = AdvancedModelLoader.loadModel("/assets/pal/models/pal.obj");
	}
	
	public void renderAll()
	{
		modelPal.renderPart("Center");
		for(String part: sideToModelPart) {
			modelPal.renderPart(part + "_off");
		}
	}
	
	public void render(TilePal pal, double x, double y, double z)
	{
	    GL11.glPushMatrix();
	    	GL11.glTranslatef((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
	    	GL11.glScalef(0.5f, 0.5f, 0.5f);
	    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("pal:models/pal.png"));
	    	modelPal.renderPart("Center");
	    	for(int i = 0; i < 6; i++) {
	    		if(pal.isSideActive(i)) {
	    			modelPal.renderPart(sideToModelPart[i] + (pal.isSideOn(i) ? "_on" : "_off"));
	    		}
	    	}
		GL11.glPopMatrix();
	}

}

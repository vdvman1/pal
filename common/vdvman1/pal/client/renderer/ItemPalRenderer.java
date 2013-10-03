package vdvman1.pal.client.renderer;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import vdvman1.pal.client.model.ModelPal;
import cpw.mods.fml.client.FMLClientHandler;

public class ItemPalRenderer implements IItemRenderer {

	private ModelPal model;
	
	public ItemPalRenderer() {
		model = new ModelPal();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type)
	    {
	        case ENTITY:{
	            render(0f, 0f, 0f, 0.5f);
	            return;
	        }
	         
	        case EQUIPPED:{
	            render(0f, 1f, 1f, 0.5f);
	            return;
	        }
	             
	        case INVENTORY:{
	            render(0f, 0f, 0f, 0.5f);
	            return;
	        }
	         
	        default:return;
	    }
	}
	
	private void render(float x, float y, float z, float scale)
	{
	    GL11.glPushMatrix();
	    GL11.glDisable(GL11.GL_LIGHTING);
	    	GL11.glTranslatef(x,  y,  z);
	    	GL11.glScalef(scale, scale, scale);
	    	GL11.glRotatef(180f, 0f, 1f, 0f);
	     
	    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("pal", "models/pal.png"));
	     
	    	model.renderAll();
	    GL11.glEnable(GL11.GL_LIGHTING);
	    GL11.glPopMatrix();
	}

}

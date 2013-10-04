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
		switch (type) {
        case ENTITY: {
            render(0F, 0.5F, 0F, 1F, 0f, 0f, 0f, 0f);
            return;
        }
        case EQUIPPED: {
            render(1F, 1F, 1F, 0.7F, 180f, 0f, 1f, 0f);
            return;
        }
        case EQUIPPED_FIRST_PERSON: {
            render(1F, 1F, 1F, 1F, 120f, 0f, 1f, 0f);
            return;
        }
        case INVENTORY: {
            render(1F, 0.8F, 1F, 0.8F, 180f, 0f, 1f, 0f);
            return;
        }
        default:
            return;
    }
	}
	
	private void render(float x, float y, float z, float scale, float degrees, float rotx, float roty, float rotz)
	{
	    GL11.glPushMatrix();
	    GL11.glDisable(GL11.GL_LIGHTING);
	    	GL11.glScalef(scale, scale, scale);
	    	GL11.glTranslatef(x,  y,  z);
	    	GL11.glRotatef(degrees, rotx, roty, rotz);
	     
	    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("pal", "models/pal.png"));
	     
	    	model.renderAll();
	    GL11.glEnable(GL11.GL_LIGHTING);
	    GL11.glPopMatrix();
	}

}

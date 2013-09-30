package vdvman1.pal.client.model;

import java.net.URL;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.ModelFormatException;
import net.minecraftforge.client.model.obj.WavefrontObject;
import cpw.mods.fml.common.FMLLog;

public class ModelHelper {
	
	public static WavefrontObject loadObjModel(String resourceName) throws IllegalArgumentException, ModelFormatException
    {
        int i = resourceName.lastIndexOf('.');
        if (i == -1 || !resourceName.substring(i + 1).equals("obj"))
        {
            FMLLog.severe("The resource name %s is not valid", resourceName);
            throw new IllegalArgumentException("The resource name is not valid");
        }
        URL resource = AdvancedModelLoader.class.getResource(resourceName);
        if (resource == null)
        {
            FMLLog.severe("The resource name %s could not be found", resourceName);
            throw new IllegalArgumentException("The resource name could not be found");
        }
        return new WavefrontObject(resourceName, resource);
    }

}

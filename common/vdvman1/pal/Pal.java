package vdvman1.pal;

import net.minecraftforge.common.Configuration;
import vdvman1.pal.gui.GuiHandler;
import vdvman1.pal.packet.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Pal.modid, name = Pal.modName, version = Pal.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {Pal.channel}, packetHandler = PacketHandler.class)
public class Pal {
	
	//Global variables
    public static final String modid = "Pal";
    public static final String channel = modid;
    public static final String modName = "The Redstone Gate/Pal";
    public static final String version = "1.5b1";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        
        config.save();
    }

    //Called during initialization, used for registering everything etc.
    @EventHandler
    public void init(FMLInitializationEvent event) {
        
        //register gui
        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
    }

}

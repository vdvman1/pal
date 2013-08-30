package vdvman1.pal.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import vdvman1.pal.Pal;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player _player) {
		if(packet.channel.equals(Pal.channel) && _player instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)_player;
			
		}
	} 

}

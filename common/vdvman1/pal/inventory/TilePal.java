package vdvman1.pal.inventory;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.google.common.primitives.Ints;

public class TilePal extends TileEntity {

	//output side 0-6    inputs
	//      000          000000
	public boolean[] truthTable = new boolean[0b110_111111 + 1]; //plus 1 to include 110_111111

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < truthTable.length; i += 3) {
			int combined = 0;
			for(int j = 0; j < 3; j++) {
				if(i + j < truthTable.length) {
					combined |= i + j << (10 * j + 1);
					combined |= 1 << (10 * j);
				}
			}
			array.add(combined);
		}
		tagCompound.setIntArray("truthTable", Ints.toArray(array));
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
	}

}

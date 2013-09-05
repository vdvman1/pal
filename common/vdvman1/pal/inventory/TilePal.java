package vdvman1.pal.inventory;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.google.common.primitives.Ints;

public class TilePal extends TileEntity {

	//output side 0-6    inputs
	//      000          000000
	public boolean[] truthTable = new boolean[0b110_111111 + 1]; //plus 1 to include 110_111111
	public boolean[] inputs = {false, false, false, false, false, false};
	public boolean[] outputs = {false, false, false, false, false, false};

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		//Save truth table compactly
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < truthTable.length; i += 3) {
			int combined = 0;
			for(int j = 0; j < 3; j++) {
				if(i + j < truthTable.length) {
					combined |= i + j << (10 * j + 1);
					if(truthTable[i+j]) {
						combined |= 1 << (10 * j);
					} //else leave off
				}
			}
			array.add(combined);
		}
		tagCompound.setIntArray("truthTable", Ints.toArray(array));
		//save inputs and outputs in a single int
		int inputsOutputs = 0;
		for(int i = 0; i < inputs.length; i++) {
			if(inputs[i]) { //Only set if true, default 0
				inputsOutputs |= 1 << i;
			}
		}
		for(int i = 0; i < outputs.length; i++) {
			if(inputs[i]) { //Only set if true, default 0
				inputsOutputs |= 1 << (i + 6);
			}
		}
		tagCompound.setInteger("inputsOutputs", inputsOutputs);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		//Load truth table from compacted array
		int[] array = tagCompound.getIntArray("truthTable");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < 3; j++) {
				int temp = array[i] >> (10 * j);
				int elem = (temp >> 1) & 0b111_111111;
				truthTable[elem] = (temp & 1) != 0;
			}
		}
		//Load inputs and outputs from single int
		int inputsOutputs = tagCompound.getInteger("inputsOutputs");
		for(int i = 0; i < 6; i++) {
			inputs[i] = ((inputsOutputs >> i) & 1) != 0;
		}
		for(int i = 0; i < 6; i++) {
			outputs[i] = ((inputsOutputs >> i + 6) & 1) != 0;
		}
	}

}

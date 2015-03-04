package com.whammich.sstow.handler;

import com.whammich.sstow.gameObjs.ForgeContainer;
import com.whammich.sstow.gameObjs.tile.ForgeTile;
import com.whammich.sstow.gui.ForgeGUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID == 0) {
			ForgeTile tileEntityFurnace = (ForgeTile) world
					.getTileEntity(x, y, z);
			return new ForgeContainer(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID == 0) {
			ForgeTile tileEntityTestContainer = (ForgeTile) world
					.getTileEntity(x, y, z);
			return new ForgeGUI(player.inventory, tileEntityTestContainer);
		}
		return null;
	}

}
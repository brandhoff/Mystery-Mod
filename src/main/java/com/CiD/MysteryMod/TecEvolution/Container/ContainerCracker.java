package com.CiD.MysteryMod.TecEvolution.Container;

import java.util.Random;

import com.CiD.MysteryMod.TecEvolution.TileEntity.TileEntityCracker;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class ContainerCracker extends Container {

        protected TileEntityCracker tileEntity;

        public ContainerCracker (InventoryPlayer inventoryPlayer, TileEntityCracker te){
                tileEntity = te;
                Random ran = new Random();
            
                for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < 2; j++) {
                                addSlotToContainer(new Slot(tileEntity, j + i * 3, 30+j * 18, 17 + i * 18));
                        }
                }
//                addSlotToContainer(new Slot(tileEntity, 1 + 1 * 3, 30 + 1 * 18, 17 + 1 * 18));
//                addSlotToContainer(new Slot(tileEntity, 2 + 1 * 3, 30+ 2 * 18, 17 + 1 * 18));

                bindPlayerInventory(inventoryPlayer);
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return tileEntity.isUseableByPlayer(player);
        }


        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                                8 + j * 18, 84 + i * 18));
                        }
                }

                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
                }
        }

        /**
         * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
         */
        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
                ItemStack stack = null;
                Slot slotObject = (Slot) inventorySlots.get(slot);

                return stack;
        }
}
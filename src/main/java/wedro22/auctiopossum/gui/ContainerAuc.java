package wedro22.auctiopossum.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wedro22.auctiopossum.Auctiopossum;
import wedro22.auctiopossum.blocks.Auctionator;

public class ContainerAuc extends Container {

    /** The crafting matrix inventory. */
    public InventoryAuc inventoryAuc = new InventoryAuc(this, 8);

    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerAuc(InventoryPlayer inventoryPlayer, World world, int x, int y, int z){
        Auctiopossum.logger.info("ContainerAuc player="+inventoryPlayer.player.getDisplayName()
        +" worldRemote="+world.isRemote+" x_y_z="+x+"_"+y+"_"+z);
        worldObj = world;
        posX = x;
        posY = y;
        posZ = z;

        this.addSlotToContainer(new Slot(inventoryPlayer, 0, 87, 8));
        this.addSlotToContainer(new Slot(inventoryPlayer, 1, 87, 26));
        this.addSlotToContainer(new Slot(inventoryPlayer, 2, 87, 44));
        this.addSlotToContainer(new Slot(inventoryPlayer, 3, 87, 62));
        this.addSlotToContainer(new Slot(inventoryPlayer, 4, 109, 8));
        this.addSlotToContainer(new Slot(inventoryPlayer, 5, 109, 26));
        this.addSlotToContainer(new Slot(inventoryPlayer, 6, 109, 44));
        this.addSlotToContainer(new Slot(inventoryPlayer, 7, 109, 62));

        // TODO: 13.03.2019 добавить слоты инвентаря игрока

    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer entityPlayer) {
        String str = "Container onContainerClosed";
        super.onContainerClosed(entityPlayer);
        if (!this.worldObj.isRemote) {
            str += " !isRemote";
            for (int i = 0; i < this.inventoryAuc.getSizeInventory(); ++i) {
                ItemStack itemstack = this.inventoryAuc.getStackInSlotOnClosing(i);
                if (itemstack != null) {
                    entityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        } else
            str += " isRemote";
        Auctiopossum.logger.info(str);
    }

    /** Может ли взаимодействовать с игроком */
    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        Auctiopossum.logger.info("Container canInteractWith");
        return true;
        // TODO: 14.03.2019 проверки на мир разнятся сервер/клиент не_удален/удален, позиции = 0 0 0
        /*String str = "Container canInteractWith:";
        net.minecraft.block.Block block = this.worldObj.getBlock(this.posX, this.posY, this.posZ);
        if (block == Auctionator.get()){
            str += " true_block";
            if (entityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D){
                str += " true_distance = true";
                Auctiopossum.logger.info(str);
                return true;
            }
        }
        str += " = false";
        Auctiopossum.logger.info(str);
        return false;*/
    }

}

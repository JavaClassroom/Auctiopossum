package wedro22.auctiopossum.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryAuc implements IInventory {

    private ItemStack[] stackLeft;
        /** список предметов слева */
        public ItemStack[] getStackLeft() {
            return stackLeft;
        }

    private Container eventHandler;

    /** Инвентарь аукционатора
     * @param container ...
     * @param slots_number количество слотов покупки/продажи
     */
    public InventoryAuc(Container container, int slots_number){
        stackLeft = new ItemStack[slots_number];
        eventHandler = container;
    }

    /** размер инвентаря */
    @Override
    public int getSizeInventory() {
        return stackLeft.length;
    }

    /** возвращает ItemStack, что лежит по указанному индексу */
    @Override
    public ItemStack getStackInSlot(int index) {
        return index >= getSizeInventory() ? null : this.stackLeft[index];
    }

    /** Удаляет определенное количество элементов из слота инвентаря и возвращает их в виде нового списка. */
     @Override
    public ItemStack decrStackSize(int index, int count) {
        if (stackLeft[index] == null)
            return null;

        ItemStack itemstack;

         if (stackLeft[index].stackSize <= count)
         {
             itemstack = stackLeft[index];
             stackLeft[index] = null;
             eventHandler.onCraftMatrixChanged(this);
             return itemstack;
         }
         else
         {
             itemstack = stackLeft[index].splitStack(count);

             if (stackLeft[index].stackSize == 0)
             {
                 stackLeft[index] = null;
             }

             eventHandler.onCraftMatrixChanged(this);
             return itemstack;
         }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        if (stackLeft[index] == null)
            return null;

        ItemStack itemstack = stackLeft[index];
        stackLeft[index] = null;
        return itemstack;
    }

    /** Добавляет стак в указанный слот */
    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        stackLeft[index] = stack;
        eventHandler.onCraftMatrixChanged(this);
    }

    /** имя контейнера */
    @Override
    public String getInventoryName() {
        return "container.auctionator";
    }

    /** инвентарь имеет собственное имя */
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    /** максимальный размер стака в слоте */
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    /** для tile entitie, не надо */
    @Override
    public void markDirty() {

    }

    /** Может ли игрок ипользовать этот инвентарь */
    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    /** Автоматизация в данный слот, разрешается вставлять данного стека (игнорируя размер стека). */
    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

}

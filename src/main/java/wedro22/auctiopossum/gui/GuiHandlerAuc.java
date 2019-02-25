package wedro22.auctiopossum.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandlerAuc implements IGuiHandler {
    public static final int AUC_GUI_ID = 0;

    /**
     * Вызов контейнера при его открытии.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == AUC_GUI_ID){
            return new ContainerAuc(player.inventory, world, x, y, z);
        }
        return null;
    }

    /**
     * Вызов GUI для контейнера.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == AUC_GUI_ID){
            return new GuiContainerAuc(player.inventory, world, x, y, z);
        }
        return null;
    }
}

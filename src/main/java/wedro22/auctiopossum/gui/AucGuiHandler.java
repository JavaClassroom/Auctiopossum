package wedro22.auctiopossum.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class AucGuiHandler implements IGuiHandler {
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
        return null;
        // TODO: 24.02.2019 вернуть GuiContainer 
    }
}

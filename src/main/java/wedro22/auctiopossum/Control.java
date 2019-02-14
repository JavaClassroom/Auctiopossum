package wedro22.auctiopossum;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import wedro22.auctiopossum.blocks.Auctionator;

/**
 * команды в чате
 */
@SideOnly(Side.CLIENT)
public class Control {
    public static CommandBase[] commands =
            {
                    new Get()
            };

    /**
     * команда выдачи в инвентарь блока Аукционатор
     */
    private static class Get extends CommandBase {
        @Override
        public String getCommandName() {
            return "auction";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "/auction";
        }

        @Override
        public void processCommand(ICommandSender sender, String[] args) {
            System.out.println("AUCTION");
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            ItemStack is = new ItemStack(Auctionator.get());
            entityplayer.inventory.addItemStackToInventory(is);
        }
    }

}

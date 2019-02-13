package wedro22.auctiopossum;

import net.minecraft.block.BlockSand;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import wedro22.auctiopossum.blocks.Auctionator;

/**
 * команды в чате
 */
public class Control {
    public static CommandBase[] commands =
            {
                    new Get()
            };

    private static class Get extends CommandBase {
        @Override
        public String getCommandName() {
            return "auction";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "/auction";
        }

        /**
         * ВЫДАЕТ НЕПРАВИЛЬНЫЙ ИТЕМ (БЕЗ ТЕКСТУРЫ)
         * или не выдает
         */
        @Override
        public void processCommand(ICommandSender sender, String[] args) {
            System.out.println("AUCTION");
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            ItemBlock ib = new ItemBlock(new Auctionator());
            //ItemStack is = new ItemStack(ib.getContainerItem());
            //entityplayer.inventory.setItemStack(is);
            //entityplayer.inventory.setItemStack(item);
//            entityplayer.dropItem(new ItemBlock(new Auctionator()).setTextureName("auctionator"), 1);
            //entityplayer.dropItem(Item.getItemFromBlock(new Auctionator()), 1);
//            entityplayer.dropItem(new ItemBlock(new BlockSand()), 1);
            entityplayer.setItemInUse(new ItemStack(new Auctionator()), 1);
        }
    }

}

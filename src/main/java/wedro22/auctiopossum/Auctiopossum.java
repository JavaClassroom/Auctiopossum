package wedro22.auctiopossum;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.command.CommandBase;
import wedro22.auctiopossum.blocks.Auctionator;

@Mod(modid = Auctiopossum.MODID, version = Auctiopossum.VERSION)
public class Auctiopossum
{
    public static final String MODID = "auctiopossum";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //регистрация блоков мода
        GameRegistry.registerBlock(new Auctionator(), "auctionator");
    }

    @EventHandler
    public void servStarting(FMLServerStartingEvent event){
        //регистрация команд в чате
        for (CommandBase command : Control.commands) {
            event.registerServerCommand(command);
        }
    }
}

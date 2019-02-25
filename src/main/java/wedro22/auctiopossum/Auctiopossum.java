package wedro22.auctiopossum;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.command.CommandBase;
import wedro22.auctiopossum.blocks.Auctionator;
import wedro22.auctiopossum.gui.GuiHandlerAuc;

@Mod(modid = Auctiopossum.MODID, version = Auctiopossum.VERSION)
public class Auctiopossum
{
    public static final String MODID = "auctiopossum";
    public static final String VERSION = "1.0";

    @Mod.Instance("auctiopossum")
    public static Auctiopossum instance;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //регистрация блоков мода
        GameRegistry.registerBlock(Auctionator.get(), "auctionator");
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        Auctionator.get().registerRenders();
        // register CommonProxy as our GuiHandler
        //NetworkRegistry.instance().registerGuiHandler(this, new CommonProxy());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandlerAuc());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    @EventHandler
    public void servStarting(FMLServerStartingEvent event){
        //регистрация команд в чате
        for (CommandBase command : Control.commands) {
            event.registerServerCommand(command);
        }
    }
}

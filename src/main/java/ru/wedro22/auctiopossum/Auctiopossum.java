package ru.wedro22.auctiopossum;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import ru.wedro22.auctiopossum.blocks.Auctionator;

@Mod(modid = Auctiopossum.MODID, version = Auctiopossum.VERSION)
public class Auctiopossum
{
    public static final String MODID = "auctiopossum";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("Auctiopossum load");

        Auctionator.setRegistry();
    }
}

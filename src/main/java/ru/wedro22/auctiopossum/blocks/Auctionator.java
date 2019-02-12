package ru.wedro22.auctiopossum.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Auctionator extends Block {
    protected Auctionator() {
        super(Material.sand);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(15F);
        setResistance(10F);
        setLightLevel(8F);
        setHarvestLevel("pickaxe", 1);
        setBlockName("auctionator");
        setBlockTextureName("auctiopossum:auctionator");
//        setBlockTextureName("diamond_block");
//        setBlockTextureName("auctionator");
    }

    private static boolean registry = false;
        public static void setRegistry() {
            if (registry) return;
            GameRegistry.registerBlock(new Auctionator(), "auctionator");
            registry = true;
        }


}

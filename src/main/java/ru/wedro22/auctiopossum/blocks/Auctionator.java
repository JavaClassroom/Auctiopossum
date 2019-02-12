package ru.wedro22.auctiopossum.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Auctionator extends Block {
    public Auctionator() {
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


}

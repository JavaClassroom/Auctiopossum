package wedro22.auctiopossum.blocks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wedro22.auctiopossum.Auctiopossum;
import wedro22.auctiopossum.gui.GuiHandlerAuc;

/**
 * блок Аукционатор для ведения торговли по пкм
 */
public class Auctionator extends Block {
    private static Auctionator auctionator;
    public static Auctionator get() {
        if (auctionator == null)
            auctionator = new Auctionator();
        return auctionator;
    }

    //не уверен: цвета отображения на карте, частицы и др
    private static Material material = new Material(MapColor.goldColor);

    public Auctionator() {
        super(material);
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(5F);
        setResistance(10F);
        setLightLevel(8F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeMetal);
        setBlockName("auctionator");
    }

    @SideOnly(Side.CLIENT)
    public void registerRenders(){
        setBlockTextureName("auctiopossum:auctionator_face");
    }


    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer,
                                    int side, float clickX, float clickY, float clickZ) {
        if (world.isRemote)
            return false;
        Block block = world.getBlock(x, y, z);
        if (block == null || entityPlayer == null)
            return false;
        if (!entityPlayer.isSneaking()) { //если игрок не сидит
            Auctiopossum.logger.info("Auctionator onBlockActivated");
            entityPlayer.openGui(Auctiopossum.instance, GuiHandlerAuc.AUC_GUI_ID, world, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    protected void dropBlockAsItem(World world, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
        super.dropBlockAsItem(world, p_149642_2_, p_149642_3_, p_149642_4_, p_149642_5_);
    }
}

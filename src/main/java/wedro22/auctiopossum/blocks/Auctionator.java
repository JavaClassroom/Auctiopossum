package wedro22.auctiopossum.blocks;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * блок Аукционатор для ведения торговли по пкм
 */
public class Auctionator extends Block {
    //не уверен: цвета отображения на карте, частицы и др
    private static Material material = new Material(MapColor.goldColor);

    public Auctionator() {
        super(material);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(15F);
        setResistance(10F);
        setLightLevel(8F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeMetal);
        setBlockName("auctionator");
        setBlockTextureName("auctiopossum:auctionator_face");
    }


    //@SideOnly(Side.CLIENT)
    /**
     * установление текстуры только для клиента
     */
    @Override
    public Block setBlockTextureName(String p_149658_1_) {
        if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT){//только клиент
            return super.setBlockTextureName(p_149658_1_);
        } else
            return this;
    }
}

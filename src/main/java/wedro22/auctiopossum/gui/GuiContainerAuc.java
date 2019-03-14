package wedro22.auctiopossum.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import wedro22.auctiopossum.Auctiopossum;

public class GuiContainerAuc extends GuiContainer {

    /** Текстура GUI */
    //private static final ResourceLocation textures = new ResourceLocation(MODID, "textures/gui/container/<name>.png");
    private static final ResourceLocation craftingTableGuiTextures =
            new ResourceLocation("textures/gui/container/crafting_table.png");

    public GuiContainerAuc(InventoryPlayer inventoryPlayer, World world, int x, int y, int z)
    {
        super(new ContainerAuc(inventoryPlayer, world, x, y, z));
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     * Метод для отрисовки текстов и etc.
     */
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]),
                28, 6, 4210752);
        // Отрисовать название инвентаря игрока, где оно обычно находится.
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]),
                8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Метод отрисовки задника GUI (фон, etc).
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float size, int x, int y)
    {
        // Окрасить все в белый цвет и в полную непрозрачность
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        // Привязать текстуру
        this.mc.getTextureManager().bindTexture(craftingTableGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}

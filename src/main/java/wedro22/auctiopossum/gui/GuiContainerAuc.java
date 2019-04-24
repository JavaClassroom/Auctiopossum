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
    private static final ResourceLocation texture =
            new ResourceLocation(Auctiopossum.MODID, "textures/gui/container/auctionator.png");
    /** Размеры интерфейса */
    private static final int WIDTH = 256, HEIGHT = 256;
    /** Смещение начала координат в интерфейсе из-за нестандартного размера */
    private static final int X = (176 - WIDTH)/2, Y = (166 - HEIGHT)/2;

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
        this.fontRendererObj.drawString(I18n.format("container.auction", new Object[0]),
                X+5, Y+156, 4210752);
        // Отрисовать название инвентаря игрока, где оно обычно находится.
        /*this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]),
                8, this.ySize - 96 + 2, 4210752);*/
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
        this.mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(guiLeft+X, guiTop+Y,
                0, 0, 256, 256);

    }
}

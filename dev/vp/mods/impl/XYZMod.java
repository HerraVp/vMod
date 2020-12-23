package dev.vp.mods.impl;

import dev.vp.gui.hud.ScreenPosition;
import dev.vp.mods.ModDraggable;

public class XYZMod extends ModDraggable {

    private ScreenPosition pos;

    @Override
    public int getWidth() {
        return font.getStringWidth(getXYZString());
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        font.drawString(getXYZString(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
    }

    private String getXYZString() {
        return String.format("XYZ: [%.3f] / [%.3f] / [%.3f]",
                mc.getRenderViewEntity().posX,
                mc.getRenderViewEntity().getEntityBoundingBox().minY,
                mc.getRenderViewEntity().posZ
        );
    }

    @Override
    public void save(ScreenPosition pos) {
        this.pos = pos;
    }

    @Override
    public ScreenPosition load() {
        return pos;
    }

}
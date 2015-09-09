package com.collapse.optifinerus;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.IModGuiFactory;
import java.util.Set;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class RusGuiFactory implements IModGuiFactory {

	public static class RusGuiScreen extends GuiConfig {
		public RusGuiScreen(GuiScreen parent) {
			super(parent, new ConfigElement(RusContainer.configFile.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), "optifinerus", Configuration.CATEGORY_GENERAL, false, true, GuiConfig.getAbridgedConfigPath(RusContainer.configFile.toString()));
		}
	}

	@Override
	public void initialize(Minecraft minecraftInstance) {}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass()
	{
		return RusGuiScreen.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
		return null;
	}
}

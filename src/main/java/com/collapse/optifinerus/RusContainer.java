package com.collapse.optifinerus;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.client.FMLFileResourcePack;
import cpw.mods.fml.client.FMLFolderResourcePack;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class RusContainer extends DummyModContainer {

	@Instance("RusContainer")
	public static RusContainer instance;

	public static Configuration configFile;

	public static boolean hdFontIndent = false;
	public static boolean rearrangeOptifine = true;

	public RusContainer()
	{
		super(new ModMetadata());

		ModMetadata localModMetadata = super.getMetadata();
		localModMetadata.authorList = Arrays.asList(new String[] { "collapse" });
		localModMetadata.description = "\u041f\u0435\u0440\u0435\u0432\u043e\u0434 \u004f\u0070\u0074\u0069\u0066\u0069\u006e\u0065 \u043d\u0430 \u0440\u0443\u0441\u0441\u043a\u0438\u0439 \u044f\u0437\u044b\u043a";
		localModMetadata.modId = "optifinerus";
		localModMetadata.version = "1.7.10";
		localModMetadata.name = "optifineRus";
		localModMetadata.url = "http://minecraft.collapsed.space";

		configFile = new Configuration(new File("config/optifineRus.cfg"));
		syncConfig();
	}

	public static void syncConfig() {
		List<String> propOrder = new ArrayList<String>();
        	Property prop;

        	prop = configFile.get(CATEGORY_GENERAL, "hdFontIndent", false);
        	prop.setLanguageKey("adv.config.hdFontIndent");
        	hdFontIndent = prop.getBoolean(hdFontIndent);
        	propOrder.add(prop.getName());

        	prop = configFile.get(CATEGORY_GENERAL, "rearrangeOptifine", true);
        	prop.setLanguageKey("adv.config.rearrangeOptifine").setRequiresMcRestart(true);
        	rearrangeOptifine = prop.getBoolean(rearrangeOptifine);
        	propOrder.add(prop.getName());

		configFile.setCategoryPropertyOrder(CATEGORY_GENERAL, propOrder);
		if (configFile.hasChanged()) configFile.save();
	}

	@Subscribe
	public void PreInit(FMLInitializationEvent evt) {
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onConfigChanged(OnConfigChangedEvent event)
	{
		if (getMetadata().modId.equals(event.modID)) syncConfig();
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}

	@Override
	public File getSource() {
		return RusLoader.source;
	}

	@Override
	public Class<?> getCustomResourcePackClass() {
		return getSource().isDirectory() ? FMLFolderResourcePack.class : FMLFileResourcePack.class;
	}

	@Override
	public String getGuiClassName()
	{
		return "com.collapse.optifinerus.RusGuiFactory";
	}

}

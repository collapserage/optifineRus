package com.collapse.optifinerus;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.io.File;
import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({"optifinerus"})
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class RusLoader implements IFMLLoadingPlugin {

	public RusLoader() {}
	public static File source;
	
	public String[] getASMTransformerClass() {
		return new String[] { "com.collapse.optifinerus.RusTransformer" };
	}
	
	public String getModContainerClass() {
		return "com.collapse.optifinerus.RusContainer";
	}
	
	public String getSetupClass() {
		return null;
	}
	
	public String getAccessTransformerClass() {
		return null;
	}

	public void injectData(Map<String, Object> paramMap) {
		source = (File) paramMap.get("coremodLocation");
	}

}

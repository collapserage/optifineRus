package com.collapse.optifinerus;

import java.io.InputStream;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.commons.io.IOUtils;

public class RusTransformer implements IClassTransformer {

	public RusTransformer() {}

	public byte[] transform(String obfName, String normalName, byte[] paramArrayOfByte) {
		if (obfName.equals("bbj") || 
			obfName.equals("bbn") || 
			obfName.equals("bbm") || 
			obfName.equals("bbu") || 
			obfName.equals("bef") || 
			normalName.equals("GuiDetailSettingsOF") || 
			normalName.equals("GuiAnimationSettingsOF") || 
			normalName.equals("GuiQualitySettingsOF") || 
			normalName.equals("GuiPerformanceSettingsOF") || 
			normalName.equals("GuiOtherSettingsOF")
			) paramArrayOfByte = patchClass(obfName, normalName, paramArrayOfByte);

		return paramArrayOfByte;
	}

	public byte[] patchClass(String obfName, String normalName, byte[] paramArrayOfByte) {
		try {
			InputStream localInputStream = getClass().getResourceAsStream("/patches/" + obfName);
			return IOUtils.toByteArray(localInputStream);
		} catch (Exception localException) {
			System.out.println("[optifineRus] Exception rewriting class: " + localException);
		}

		return paramArrayOfByte;
	}

}
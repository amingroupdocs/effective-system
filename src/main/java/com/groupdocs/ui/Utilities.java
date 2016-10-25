package com.groupdocs.ui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import com.groupdocs.conversion.License;
import com.groupdocs.conversion.config.ConversionConfig;

public class Utilities {
	//ExStart:CommonProperties
    public static final Path licensePath = getProjectBaseDir().resolve("GroupDocs.Total.Java.lic");
    //ExEnd:CommonProperties
	/**
	 * This method applies product license from file
	 * 
	 */
	public static void applyLicenseFromFile() {
		//ExStart:applyLicenseFromFile
		try {
			// Setup license
			License lic = new License();
			lic.setLicense(licensePath.toString());
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		//ExEnd:applyLicenseFromFile
	}
	
	/*
	 * get project base directories
	 */
	public static Path getProjectBaseDir() {
		Properties props = new Properties();
		try {
			InputStream i = Utilities.class.getResourceAsStream("/project.properties");
			props.load(i);
		} catch (IOException x) {
			throw new RuntimeException(x);
		}
		return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
	}
	
	public static ConversionConfig getConfiguration(Path source){
		try{
			// Setup Conversion configuration
	        ConversionConfig conversionConfig = new ConversionConfig();
	        conversionConfig.setStoragePath(source.getParent().toString());
			return conversionConfig;
		}
		catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
			return null;
		}
	}

}
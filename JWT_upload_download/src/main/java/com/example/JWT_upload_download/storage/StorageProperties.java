package com.example.JWT_upload_download.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

// konfiguracioni fajl koji nam sluzi za podesavanje vrednosti vezanih za skladistenje podataka
@ConfigurationProperties("storage")
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}

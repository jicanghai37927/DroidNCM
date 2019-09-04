package com.yeamy.ncmdump;

import java.io.File;

/**
 * file info for dump
 * 
 * @author Yeamy0754
 */
public class NcmFile {
	public final File fncm;
	private final File outPath;
	private final String fileNameWithoutExt;
	private String format;
	public ID3Data id3;
	public byte[] albumImage;

	public NcmFile(File fncm, File outPath) {
		this.fncm = fncm;
		this.outPath = outPath;
		String fname = fncm.getName();
		int i = fname.lastIndexOf('.');
		fileNameWithoutExt = fname.substring(0, i);
	}

	public void setID3(ID3Data id3) {
		this.id3 = id3;
	}

	public void setAlbumImage(byte[] albumImage) {
		this.albumImage = albumImage;
	}

	public String albumImageMimeType() {
		final byte[] mPNG = { (byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A };// PNG file header
		int l = mPNG.length;
		if (albumImage.length > l) {
			for (int i = 0; i < l; i++) {
				if (albumImage[i] != mPNG[i]) {
					return "image/jpg";
				}
			}
		}
		return "image/png";
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public File tmpFile() {
		return new File(outPath, fileNameWithoutExt + ".tmp");
	}

	public File outFile() {
		if (id3 != null && id3.format != null) {
			return new File(outPath, fileNameWithoutExt + "." + id3.format);
		}
		return new File(outPath, fileNameWithoutExt + "." + format);
	}

}

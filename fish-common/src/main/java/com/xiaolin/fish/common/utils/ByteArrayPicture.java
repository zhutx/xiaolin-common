/**
 * 
 */
package com.xiaolin.fish.common.utils;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author erxiao 2016年11月22日
 */
public class ByteArrayPicture implements Picture, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7998740537989546457L;

	public static final String IMAGE_TYPE_JPG = "JPG";

	public static final String IMAGE_TYPE_JPEG = "JPEG";

	public static final String IMAGE_TYPE_PNG = "PNG";

	public static final String IMAGE_TYPE_GIF = "GIF";

	private static final String[] FILE_EXTS = { IMAGE_TYPE_JPG, IMAGE_TYPE_JPEG, IMAGE_TYPE_PNG, IMAGE_TYPE_GIF };

	private static final byte[][] FILE_MAGS = new byte[][] { new byte[] { (byte) 0xFF, (byte) 0xD8, (byte) 0xFF, (byte) 0xE0 }, // JPG
			new byte[] { (byte) 0xFF, (byte) 0xD8, (byte) 0xFF, (byte) 0xE1 }, // JPEG
			new byte[] { (byte) 0x89, (byte) 0x50, (byte) 0x4E, (byte) 0x47 }, // PNG
			new byte[] { (byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38 } // GIF
	};

	private String imageType;

	private byte[] imageData;

	public ByteArrayPicture() {
	}

	public ByteArrayPicture(byte[] imageData) {
		this.imageData = imageData;
		this.imageType = getFileFormat(imageData);
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
		this.imageType = getFileFormat(imageData);
	}

	/**
	 * 判断真的是图片。支持的图片格式有：
	 * 
	 * @return
	 */
	public boolean isImage() {
		return imageType != null;
	}

	/**
	 * 获取图片格式
	 * 
	 * @return
	 */
	public String getFileFormat() {
		return this.imageType;
	}

	/**
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public byte[] getImageData() {
		return imageData;
	}

	private String getFileFormat(byte[] contents) {
		if (contents == null) {
			return null;
		}
		for (int i = 0; i < FILE_MAGS.length; i++) {
			byte[] mag = FILE_MAGS[i];
			if (contents.length >= mag.length) {
				if (Arrays.equals(Arrays.copyOf(contents, mag.length), mag)) {
					return FILE_EXTS[i];
				}
			}
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 */
	@SuppressWarnings("restriction")
	@Override
	public String getBase64ImageData() {
		if (getImageData() == null) {
			return null;
		}
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		String base64Image = encoder.encode(getImageData());
		//RFC 822/RFC2045规定，每76个字符，还需要加上一个回车换行.会导致json等各式错误
		// 替换换行符可以正常解码 base64Image.replaceAll("\r|\n", "")
		return base64Image;
	}

}

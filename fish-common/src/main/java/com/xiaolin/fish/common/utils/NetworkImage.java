package com.xiaolin.fish.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author erxiao 2016年5月4日
 */
public class NetworkImage extends ByteArrayPicture {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5875484670111642014L;

	private boolean isLoaded = false;

	private String imageUrl;

	public NetworkImage() {
	}

	/**
	 * 创建一个网络图片，
	 * 
	 * @param imageUrl
	 */
	public NetworkImage(String imageUrl) {
		super();
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * (non-Javadoc)
	 * 
	 */
	public boolean isImage() {
		if (!isLoaded) {
			loadImage();
		}
		return super.isImage();
	}

	/**
	 * (non-Javadoc)
	 * 
	 */
	public String getFileFormat() {
		if (!isLoaded) {
			loadImage();
		}
		return super.getFileFormat();
	}

	/**
	 * <pre>
	 * 加载图片，如果网络资源加载失败或网络资源不是图片，则图片数据为空:{@link #getImageData()} == null. <br>
	 * 可通过 {@link #getFileFormat()} 获取图片的格式,支持的图片格式有：<br>
	 * {@value #IMAGE_TYPE_JPG}
	 * {@value #IMAGE_TYPE_JPEG}
	 * {@value #IMAGE_TYPE_PNG}
	 * {@value #IMAGE_TYPE_GIF}
	 * </pre>
	 * 
	 * @return
	 */
	public NetworkImage loadImage() {
		if (isLoaded) {
			return this;
		}
		InputStream inStream = null;
		URLConnection connection = null;
		try {
			URL url = new URL(this.imageUrl);
			connection = (URLConnection) url.openConnection();
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			inStream = connection.getInputStream();
			byte[] imageData = readInputStream(inStream);
			setImageData(imageData);
			if (super.getFileFormat() == null) {
				setImageData(null);
			}
			isLoaded = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
				}
			}
			if (connection != null && connection instanceof HttpURLConnection) {
				((HttpURLConnection) connection).disconnect();
			}
		}
		return this;
	}

	private byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		return outStream.toByteArray();
	}

	/**
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public byte[] getImageData() {
		if (!isLoaded) {
			loadImage();
		}
		return super.getImageData();
	}

}
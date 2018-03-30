/**
 * 
 */
package com.xiaolin.fish.common.utils;

/**
 * @author erxiao 2016年12月5日
 */
public class NetworkFacePicture extends NetworkImage implements FacePicture {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3183589916219195L;

	private Rect rect;

	public NetworkFacePicture(){
		super();
	}
	
	public NetworkFacePicture(String imageUrl) {
		this(imageUrl, null);
	}

	/**
	 * @param imageUrl
	 */
	public NetworkFacePicture(String imageUrl, Rect rect) {
		super(imageUrl);
		this.rect = rect;
	}

	/**
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public Rect getRect() {
		return this.rect;
	}

}

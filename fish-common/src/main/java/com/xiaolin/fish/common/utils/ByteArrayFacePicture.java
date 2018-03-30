/**
 * 
 */
package com.xiaolin.fish.common.utils;

/**
 * @author erxiao 2016年12月5日
 */
public class ByteArrayFacePicture extends ByteArrayPicture implements FacePicture {

	private Rect rect;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6956960610278720057L;

	public ByteArrayFacePicture(){
		
	}
	
	/**
	 * @param imageData
	 */
	public ByteArrayFacePicture(byte[] imageData) {
		this(imageData, null);
	}

	/**
	 * @param imageData
	 */
	public ByteArrayFacePicture(byte[] imageData, Rect rect) {
		super(imageData);
		this.rect = rect;
	}

	public ByteArrayFacePicture(Rect rect) {
		super();
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

	public boolean isHaveRect() {
		return this.rect != null && !this.rect.equals(Rect.EMPTY);
	}

}

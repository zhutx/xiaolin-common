package com.xiaolin.fish.common.sign.impl;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMacSha1Signer extends AbstractHMacSigner {

	private final String AGLORITHM_NAME = "HmacSHA1";

	@Override
	protected Mac getMac() {
		try {
			Mac mac = Mac.getInstance(AGLORITHM_NAME);
			mac.init(new SecretKeySpec(this.getUniformKey().getBytes("UTF-8"), AGLORITHM_NAME));
			return mac;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected Mac getMac(String key) {
		try {
			Mac mac = Mac.getInstance(AGLORITHM_NAME);
			mac.init(new SecretKeySpec(key.getBytes("UTF-8"), AGLORITHM_NAME));
			return mac;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {

		HMacSha1Signer macSha1Signer = new HMacSha1Signer();
		macSha1Signer.setUniformKey("werwerfeweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeewerw");
		Long sss = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			// macSha1Signer.signString("ferferferferferrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
			// "werwerfeweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeewerw");
			// macSha1Signer.signString("GET&%2F&AccessKeyId%3Dtestid%26Action%3DDescribeRegions%26Format%3DXML%26SignatureMethod%3DHMAC-SHA1%26SignatureNonce%3D3ee8c1b8-83d3-44af-a94f-4e0ad82fd6cf%26SignatureVersion%3D1.0%26TimeStamp%3D2016-02-23T12%253A46%253A24Z%26Version%3D2014-05-26",
			// "testsecret");
		}
		Long qqq = System.currentTimeMillis();

		System.out.println(qqq - sss);
		System.out
				.println(macSha1Signer
						.signString(
								"GET&%2F&AccessKeyId%3Dtestid%26Action%3DDescribeRegions%26Format%3DXML%26SignatureMethod%3DHMAC-SHA1%26SignatureNonce%3D3ee8c1b8-83d3-44af-a94f-4e0ad82fd6cf%26SignatureVersion%3D1.0%26TimeStamp%3D2016-02-23T12%253A46%253A24Z%26Version%3D2014-05-26",
								"testsecret&"));
	}

}
package com.itcrazy.alanmall.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrepaidCardData implements Serializable {
	private static final long serialVersionUID = 7854926803775778229L;

	private String uniqueNo;
	private String symmetricKeyEncrpt;
	private String jsonDataEncrypt;
	private String apiName;
	private String url;
	private String accessKey; // ak
	private String accessKeySecret; // sk

}

package com.itcrazy.alanmall.common.client.constains;

import java.util.HashMap;
import java.util.Map;

public class PrepaidCardConstants {
	public final static Map<String, String> RESULT = new HashMap<String, String>() { 
		{
			put("ORSS0001", "请确认上送的随机密钥是否正确");
			put("ORSS0002", "请确认上送的企业联网发行密钥是否正确");
			put("ORSS0003", "对称密钥密文不能为空");
			put("ORSS0004", "联网发行唯一标识不能为空");
			put("ORSS0005", "上送报文不能为空");
			put("ORSS0006", "报送卡面额不能为空");
			put("ORSS0007", "卡号不能为空");
			put("ORSS0008", "卡号ID不能为空");
			put("ORSS0009", "唯一报送流水号不能为空");
			put("ORSS0010", "报送卡号有误");
			put("ORSS0012", "联网发行唯一标识不存在");
			put("ORSS0014", "JSON报文不正确");
			put("ORSS0015", "卡面额格式不对");
			put("ORSS0016", "是否记名卡标识格式不对");
			put("ORFK0001", "领卡时间不能为空");
			put("ORFK0002", "卡本金不能为空");
			put("ORFK0003", "卡有效期起不能为空");
			put("ORFK0004", "卡有效期止不能为空");
			put("ORFK0005", "是否记名不能为空");
			put("ORFK0007", "报送重复");
			put("ORFK0008", "卡本金格式不对");
			put("ORCZ0001", "充值时间不能为空");
			put("ORCZ0002", "是否联机开户不能为空");
			put("ORCZ0003", "充值方式不能为空");
			put("ORCZ0004", "请检查报送卡是否存在");
			put("ORCZ0005", "是否联机开户标识格式不对");
			put("ORCZ0006", "充值后累计本金格式不对");
			put("ORCZ0007", "充值本金格式不对");
			put("ORCZ0008", "充值面额格式不对");
			put("ORCZ0009", "充值方式格式不对");
			put("ORXF0001", "交易时间不能为空");
			put("ORXF0002", "交易类型标识不能为空");
			put("ORXF0003", "交易后剩余本金格式不对");
			put("ORXF0004", "交易本金格式不对");
			put("ORXF0005", "交易面额格式不对");
			put("ORXF0006", "交易类型格式标识不对");
			put("ORXF0007", "是否退卡标识格式不对");
			put("ORSC0001", "上传文件大小不符合要求");
			put("ORSC0002", "文件已经上传成功，不能再次上传");
			put("ORSC0003", "写入的文件大小和发送的报文中的文件大小不一致");
			put("ORSC0004", "后续上传未带流水号");
			put("ORSC0005", "上送的流水号 和联网发行唯一标识有误，没找到对应的文件");
			put("ORSC0006", "上传文件偏转量不能为空");
			put("ORSC0007", "上传文件大小超出");
			put("ORYZ0001", "上传文件不存在");
			put("ORSY0001", "单用途预付卡系统异常");
			put("0RVA0001", "私钥不存在");
	    }
	};

}

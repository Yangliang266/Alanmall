package com.itcrazy.alanmall.common.client.constains;

/**
 * 数据来源
 */
public class Source {

	/*
	 * ======================================================================
	 * TODO: 如果添加了新会员来源（创建新member，比如：支付即会员），会影响“营销活动”， 请修改prom-manager >>
	 * MemberMarketRuleCo >> reBuildMemberSource()
	 * ======================================================================
	 */

	public static final int SOURCE_MOBILEWEB = 1; // 移动web客户端
	public static final int SOURCE_USER_IOS = 6; // 用户手机IOS客户端
	public static final int SOURCE_MERCHANT = 10; // 商家shop后台
	public static final int SOURCE_OFFICE = 11; // 运营后台
	public static final int SOURCE_TASK = 12; // 定时任务工程
	public static final int SOURCE_INTERFACE = 13; // 前台接口工程
	public static final int SOURCE_CRM = 14;// CRM工程
	public static final int SOURCE_PS = 15;// 配送工程
	public static final int SOURCE_SC_CRM = 16;// 四川CRM工程
	public static final int SOURCE_SC_SHOP = 17; // 四川shop后台
	public static final int SOURCE_MEMBER_IMPORT = 21;// 商家后台导入
	public static final int SOURCE_BRAND_ADMIN = 31;// 品牌管理员
	public static final int SOURCE_MOBILD_BINDING = 32;// 手机绑定产生会员
	public static final int SOURCE_WECHAT = 51; // 微信平台
	public static final int SOURCE_IMPORT_WECHAT = 52; // 微信数据导入
	public static final int SOURCE_MSHOP = 53; // 微你小店
	public static final int SOURCE_WECHAT_CRM = 54; // 微信crm
	public static final int SOURCE_ERP_UNIFY = 101; // 问鼎ERP数据
	public static final int SOURCE_ERP_WANGXIANGYUAN = 102; // 望湘园ERP数据
	public static final int SOURCE_ERP_TIANZIXING = 103; // 天子星ERP数据
	public static final int SOURCE_JUHUIWAN = 104; // 聚会玩系统对接
	public static final int SOURCE_KELIN = 105; // 科林系统对接
	public static final int SOURCE_WECHAT_SHOP = 106; // 微信门店(比如微信门店ID：poi_id=282410212)
	public static final int SOURCE_SIYUANPOS = 107; // ???
	public static final int SOURCE_SEMOOR = 109; // 亚博松对接
	public static final int SOURCE_WECHAT_PAY = 110; // 微信支付
	public static final int SOURCE_PAIPAI = 111; // 派派对接
	public static final int SOURCE_ONEPOS = 112; // onePos
	public static final int SOURCE_ERP_ZHONGXIN = 113; // 中新ERP数据
	public static final int SOURCE_MALL = 114; // 在线商城
	public static final int SOURCE_AIDINGYUN = 115; // 爱订云ERP，对接小确幸
	public static final int SOURCE_SAND = 116; // 杉德POS
	public static final int SOURCE_ERP_CHENSEN = 117; // 辰森POS
	public static final int SOURCE_ERP_MYMYTI = 118; // 卖买提对接(摩提)
	public static final int SOURCE_ERP_FUBIDA = 119; // 富必达
	public static final int SOURCE_ERP_CANDAO = 120; // 餐道对接
	public static final int SOURCE_ERP_ZHIJIE = 123; // 智街对接,150->123
	public static final int SOURCE_ERP_WANYITONG = 151; // 万益通

	public static final int SOURCE_ALIPAY_TRADE = 121; // 支付宝当面付
	public static final int SOURCE_WECHAT_CITY = 122; // 微城市
	public static final int SOURCE_UNION_PAY = 160; // 银联

	public static final int SOURCE_TAKE_OUT = 130; // 外卖
	public static final int SOURCE_THIRD_TAKE_OUT = 131; // 第三方外卖
	public static final int SOURCE_CALL_CENTER = 132; // 呼叫中心

	public static final int SOURCE_DFIRE = 124; // 二维火对接

	public static final int SOURCE_ERP_ZPGD=125; // 正品贵德
	public static final int SOURCE_MMYEAH = 170; // 懵懵科技对接（人脸识别）

	public static final int SOURCE_POP = 180;

	public static final int SOURCE_ALIPAY_KOUBEI = 190; // 口碑对接
	/** 淘宝对接 */
	public static final int SOURCE_TAOBAO = 200;

    public static final int SOURCE_TAOBAO_EMPLOYEE = 210; //导购码入会
    public static final int SOURCE_TAOBAO_MEMBERCODE = 211; //会员码入会
    public static final int SOURCE_TAOBAO_BRANDSITE = 212; //品牌号入会
    public static final int SOURCE_TAOBAO_SHOP = 213; // 天猫旗舰店入会
    public static final int SOURCE_TAOBAO_STOREID = 214; // 扫门店码入会
    public static final int SOURCE_TAOBAO_PAY = 215; // 支付成功页入会

    public static final int SOURCE_MEMBER_BUY = 201; // 会员权益购买

	public static String getSourceName(Integer source) {
		String str = "";
		if (source == null) {
			return "未知";
		}

		if (source == Source.SOURCE_MOBILEWEB
				|| source == Source.SOURCE_WECHAT
				|| source == Source.SOURCE_IMPORT_WECHAT
				|| source == SOURCE_WECHAT_PAY) {
			str = "微信";
		} else if (source == Source.SOURCE_MERCHANT
				|| source == Source.SOURCE_MEMBER_IMPORT
				|| source == Source.SOURCE_BRAND_ADMIN) {
			str = "门店来源";
		} else if (source == Source.SOURCE_CRM
				|| source == Source.SOURCE_OFFICE) {
			str = "CRM来源";
		} else if (source == Source.SOURCE_INTERFACE 
				|| source == Source.SOURCE_USER_IOS) {
			str = "APP";
		} else if (source == Source.SOURCE_MOBILD_BINDING) {
			str = "手机绑定新增会员";
		} else if (source == Source.SOURCE_ERP_UNIFY) {
			str = "问鼎对接新增会员";
		} else if (source == Source.SOURCE_MSHOP) {
			str = "微你小店新增会员";
		} else if (source == Source.SOURCE_PS) {
			str = "配送";
		} else if (source == Source.SOURCE_SEMOOR) {
			str = "亚博松对接";
		} else if (source == Source.SOURCE_PAIPAI) {
			str = "派派对接";
		} else if (source == Source.SOURCE_ONEPOS) {
			str = "旺POS对接";
		} else if (source == Source.SOURCE_ERP_ZHONGXIN) {
			str = "中新对接";
		} else if (source == Source.SOURCE_AIDINGYUN) {
			str = "爱订云对接";
		} else if (source == Source.SOURCE_SAND) {
			str = "杉德对接";
		} else if (source == Source.SOURCE_ERP_CHENSEN) {
			str = "辰森对接";
		} else if (source == Source.SOURCE_ERP_MYMYTI) {
			str = "卖买提对接";
		} else if (source == Source.SOURCE_ERP_FUBIDA) {
			str = "富必达对接";
		} else if (source == Source.SOURCE_ERP_CANDAO) {
			str = "餐道对接";
		} else if (source == SOURCE_UNION_PAY) {
			str = "POS APP";
		} else if (source == Source.SOURCE_TAKE_OUT) {
			str = "外卖";
		} else if (source == Source.SOURCE_THIRD_TAKE_OUT) {
			str = "第三方外卖";
		} else if (source == Source.SOURCE_CALL_CENTER) {
			str = "呼叫中心";
		} else if (source == Source.SOURCE_ALIPAY_TRADE) {
			str = "支付宝";
		} else if (source == Source.SOURCE_DFIRE) {
			str = "二维火对接";
		} else if (source == Source.SOURCE_ERP_ZHIJIE) {
			str = "智街对接";
		} else if (source == SOURCE_ERP_WANYITONG) {
			str = "万益通对接";
		} else if (source == SOURCE_MMYEAH) {
			str = "懵懵科技对接";
		} else if (source == SOURCE_POP) {
			str = "推广";
		} else if (source == SOURCE_ALIPAY_KOUBEI) {
			str = "口碑对接";
		} else if (source == SOURCE_TAOBAO) {
			str = "淘宝对接";
		} else if (source == SOURCE_MEMBER_BUY){
            str = "会员权益购买";
        } else if (source == SOURCE_TAOBAO_EMPLOYEE){
		    str = "导购码入会";
        } else if (source == SOURCE_TAOBAO_MEMBERCODE){
            str = "会员码入会";
        } else if (source == SOURCE_TAOBAO_BRANDSITE){
            str = "品牌号入会";
        } else if (source == SOURCE_TAOBAO_SHOP){
            str = "天猫旗舰店入会";
        } else if (source == SOURCE_TAOBAO_STOREID){
            str = "扫门店码入会";
        } else if (source == SOURCE_TAOBAO_PAY){
            str = "支付成功页入会";
        } else if (source == SOURCE_ERP_ZPGD){
            str = "正品贵德";
        } else {
        	str = "未知";
        }
        return str;
	}

	public static String getActualSourceName(int source) {
		String str = "";

		if (source == Source.SOURCE_WECHAT) {
			str = "微信";
		} else if (source == Source.SOURCE_IMPORT_WECHAT) {
			str = "微信数据导入";
		} else if (source == SOURCE_WECHAT_PAY) {
			str = "微信支付";
		} else if (source == Source.SOURCE_MERCHANT) {
			str = "门店来源";
		} else if (source == Source.SOURCE_MEMBER_IMPORT) {
			str = "商家后台导入";
		} else if (source == Source.SOURCE_BRAND_ADMIN) {
			str = "品牌管理员";
		} else if (source == Source.SOURCE_CRM) {
			str = "CRM来源";
		} else if (source == Source.SOURCE_INTERFACE) {
			str = "APP";
		} else if (source == Source.SOURCE_MOBILD_BINDING) {
			str = "手机绑定新增会员";
		} else if (source == Source.SOURCE_ERP_UNIFY) {
			str = "问鼎对接新增会员";
		} else if (source == Source.SOURCE_MSHOP) {
			str = "微你小店新增会员";
		} else if (source == Source.SOURCE_PS) {
			str = "配送";
		} else if (source == Source.SOURCE_SEMOOR) {
			str = "亚博松对接";
		} else if (source == Source.SOURCE_PAIPAI) {
			str = "派派对接";
		} else if (source == Source.SOURCE_ONEPOS) {
			str = "旺POS对接";
		} else if (source == Source.SOURCE_ERP_ZHONGXIN) {
			str = "中新对接";
		} else if (source == Source.SOURCE_ERP_CHENSEN) {
			str = "辰森对接";
		} else if (source == Source.SOURCE_ERP_MYMYTI) {
			str = "卖买提对接";
		} else if (source == Source.SOURCE_ERP_FUBIDA) {
			str = "富必达对接";
		} else if (source == Source.SOURCE_ERP_CANDAO) {
			str = "餐道对接";
		} else if (source == SOURCE_UNION_PAY) {
			str = "POS APP";
		} else if (source == Source.SOURCE_TAKE_OUT) {
			str = "外卖";
		} else if (source == Source.SOURCE_THIRD_TAKE_OUT) {
			str = "第三方外卖";
		} else if (source == Source.SOURCE_CALL_CENTER) {
			str = "呼叫中心";
		} else if (source == Source.SOURCE_ALIPAY_TRADE) {
			str = "支付宝";
		} else if (source == Source.SOURCE_DFIRE) {
			str = "二维火对接";
		} else if (source == Source.SOURCE_ERP_ZHIJIE) {
			str = "智街对接";
		} else if (source == Source.SOURCE_ERP_WANYITONG) {
			str = "万益通对接";
		} else if (source == SOURCE_MMYEAH) {
			str = "懵懵科技对接";
		} else if (source == SOURCE_POP) {
			str = "推广";
		} else if (source == SOURCE_ALIPAY_KOUBEI) {
			str = "口碑对接";
		} else if (source == SOURCE_TAOBAO) {
			str = "淘宝对接";
		}else if (source == SOURCE_MEMBER_BUY){
            str = "会员权益购买";
        } else if (source == SOURCE_TAOBAO_EMPLOYEE){
            str = "导购码入会";
        } else if (source == SOURCE_TAOBAO_MEMBERCODE){
            str = "会员码入会";
        } else if (source == SOURCE_TAOBAO_BRANDSITE){
            str = "品牌号入会";
        } else if (source == SOURCE_TAOBAO_SHOP){
            str = "天猫旗舰店入会";
        } else if (source == SOURCE_TAOBAO_STOREID){
            str = "扫门店码入会";
        } else if (source == SOURCE_TAOBAO_PAY){
            str = "支付成功页入会";
        } else if (source == SOURCE_ERP_ZPGD){
			str = "正品贵德";
		} else {
			str = "未知";
		}

		return str;
	}
}

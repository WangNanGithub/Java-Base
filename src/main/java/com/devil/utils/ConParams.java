package com.devil.utils;

public class ConParams {
	/**
	 * 逗号
	 */
	public static String COMMON = ",";
	/**
	 * 竖线
	 */
	public static String VB = "|";
	public static String AND = "&";
	public static String POINT_STR = "Point";
	public static int LIMIT_COUNT=5000;
	
	public static String DEFAULT_GOODSTYPE="normal";
	public static String DRFAULT_ORDERTYPE="transfer_express";

	public static String salt = "SPEEDA";
	/**
	 * 实点句号
	 */
	public static String DOT = ".";

	/**
	 * 最大订单数
	 */
	public static int MAX_ORDERS = 100;
	/**
	 * 推送xml 最大出错 循环 次数
	 */
	public static int ERROR_NUM = 2;
	/**
	 * do while 最大循环数
	 */
	public static int MAX_NUM = 10;
	

	public static String codeAct(ACTCODE code,String c) {
		switch (code) {
		case CREATE:
			if(c.equalsIgnoreCase("C"))
			return "创建";
			else return "create";
		case PUBLISH:
			if(c.equalsIgnoreCase("C"))
			return "发布";
			else return "publish";
		case CANCEL:
			if(c.equalsIgnoreCase("C"))
			return "取消";
			else return "cancel";
		case UNPUBLISH:
			if(c.equalsIgnoreCase("C"))
			return "取消发布";
			else return "unpublish";
		case GRAB:
			if(c.equalsIgnoreCase("C"))
			return "分单";
			else return "grab";
		case PICKUP:
			if(c.equalsIgnoreCase("C"))
			return "自取件";
			else return "Pickup";
		case DISPATCH:
			if(c.equalsIgnoreCase("C"))
			return "派件";
			else return "Dispatch";
		case RECEIVE:
			if(c.equalsIgnoreCase("C"))
			return "网点收件";
			else return "Receive";
		case TRANSFER:
			if(c.equalsIgnoreCase("C"))
			return "中转";
			else return "Transfer";
		case ACCEPT:
			if(c.equalsIgnoreCase("C"))
			return "已签收";
			else return "Aceept";
		case FINISH:
			if(c.equalsIgnoreCase("C"))
			return "运单完结";
			else return "finish";
		case FREEZE:
			if(c.equalsIgnoreCase("C"))
			return "冻结";
			else return "freeze";
		default:
			return "unknown";
		}

	}

	public static String codeState(STATECODE code,String c) {
		switch (code) {
		case NOTPUBLISHEDSTATE:
			if(c.equalsIgnoreCase("C"))
			return "未发布";
			else return "NotPublishedState";
		case PUBLISHEDSTATE:
			if(c.equalsIgnoreCase("C"))
			return "已发布";
			else return "PublishedState";
		case GRABBEDSTATE:
			if(c.equalsIgnoreCase("C"))
			return "已抢单";
			else return "GrabbedState";
		case PICKUPSTATE:
			if(c.equalsIgnoreCase("C"))
			return "已取件";
			else return "PickupState";
		case NODERECEIVESTATE:
			if(c.equalsIgnoreCase("C"))
			return "网点收录";
			else return "NodeReceiveState";
		case TRANSFERSTATE:
			if(c.equalsIgnoreCase("C"))
			return "转运中";
			else return "TransferState";
		case DISPATCHSTATE:
			if(c.equalsIgnoreCase("C"))
			return "派件中";
			else return "DipatchState";
		case ACCEPTSTATE:
			if(c.equalsIgnoreCase("C"))
			return "已签收";
			else return "AcceptState";
		case FINISHSTATE:
			if(c.equalsIgnoreCase("C"))
			return "运单结束";
			else return "FinisheState";
		case FREEZESTATE:
			if(c.equalsIgnoreCase("C"))
			return "运单冻结";
			else return "FreezeState";
		case CANCELEDSTATE:
			if(c.equalsIgnoreCase("C"))
			return "运单取消";
			else return "CanceledState";
		default:
			return "unknown";
		}

	}

	/**
	 * 订单状态对照表
	 * 
	 * @author Administrator
	 * 
	 */
	public static enum STATECODE {
		NOTPUBLISHEDSTATE, PUBLISHEDSTATE, GRABBEDSTATE, PICKUPSTATE, NODERECEIVESTATE, TRANSFERSTATE, DISPATCHSTATE, ACCEPTSTATE, FINISHSTATE, FREEZESTATE, CANCELEDSTATE;

		public String CTS(String c) {
			return codeState(this,c);
		}

	}

	public static enum ACTCODE {
		CREATE, PUBLISH, CANCEL, UNPUBLISH, GRAB, PICKUP, DISPATCH, RECEIVE, TRANSFER, ACCEPT, FINISH, FREEZE;
		public String CTS(String c) {
			return codeAct(this,c);
		}

	}

	public static String codeKEYVALUE(KEYVALUE code) {
		switch (code) {
		case PREFIX:
			return "SPAKEY_";
		case AS:
			return "appkeyAndSecret";
		case ADDRESS:
			return "address";
		case CALLBACK:
			return "callback";
		case PLATFORM:
			return "platform_";
		case APPKEYS:
			return "APPKEYS";
		default:
			return "";
		}
	}

	public static enum KEYVALUE {
		PREFIX, AS, ADDRESS,CALLBACK,PLATFORM,APPKEYS;
		public String CTS() {
			return codeKEYVALUE(this);
		}
		

	}
	public interface HttpParams {
		public static String DEFAULT_CHARACTER = "UTF-8";
		public	static String DEFUALT_CONTENT_TYPE = "application/x-www-form-urlencoded";
		public static Integer TIME_OUT = 111 * 1000;
		public static Integer SO_OUT = 111 * 1000;
		public  static Integer CONN_MANAGER_TIMEOUT = 111 * 1000;
	}
	public interface TimeType {

		/** 常用日期格式常量  */
		public static final String FORMAT_YEAR 	= "yyyy";
		public static final String FORMAT_MONTH = "yyyy-MM";
		public static final String FORMAT_DATE 	= "yyyy-MM-dd";
		public static final String FORMAT_DATE_HOUR = "yyyy-MM-dd HH:00";
		public static final String FORMAT_DATE_MINUTE = "yyyy-MM-dd HH:mm";
		public static final String FORMAT_HOUR 	= "HH:00";
		public static final String FORMAT_MINUTE = "HH:mm";
		public static final String FORMAT_TIME 	= "HH:mm:ss";
		public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
		public static final String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";

		/** 常用时间单位格式常量  */
		public static final String UFMT_YEAR = "y";
		public static final String UFMT_MONTH = "M";
		public static final String UFMT_DAY = "d";
		public static final String UFMT_HOUR = "H";
		public static final String UFMT_MINUTE = "m";
		public static final String UFMT_SECOND = "s";
		public static final String UFMT_MILLISECOND = "S";

	}
}

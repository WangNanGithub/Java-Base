package com.devil.effective.constant;

/**
 * 
 * 常量类
 * 
 */
public class ConstantClass {

	/**
	 * 仓库编码:东莞仓<br/>
	 */
	static String WH_CODE_DONGGUAN = "DG";

	/**
	 * 发货单导出 东冠仓使用导出模板
	 */
	static String WH_CODE_TABLE_HEAD = "warehouse-dg";

	/**
	 * 除表头外，单个sheet限定支持50000行数据
	 */
	static int SHEET_MAX_ROW = 50000;

	/**
	 * Excel 2003版本最多支持256列 2007之后支持:16384列
	 */
	static int SHEET_MAX_COLUMN = 256;

	/**
	 * Sheet 的默认名称
	 */
	static String SHEET_DEFAULT_NAME = "sheet";

	/**
	 * 
	 * 手机接口常量类
	 */
	public class Phone {

		/**
		 * JSON的key值
		 */
		String J_KEY_STATUS = "status";

		String J_KEY_CONTENT = "content";

		/**
		 * 
		 * JSON响应的状态值
		 */
		class JsonStatus {
			/**
			 * json返回的默认值。 不代办业务成功与失败。
			 */
			String DEFAULT = "0";

			/**
			 * 服务器异常
			 */
			String SERVER_ERR = "-1";

			/**
			 * 响应成功
			 */
			String SUCCESS = "1";

			/**
			 * 订单复核失败:未查到信息
			 */
			String ORD_RECHECK_FAILED = "2";

			/**
			 * 订单复合：查询到多个结果
			 */
			String ORD_RECHECK_ORDERS = "3";

			/**
			 * 请求参数错误
			 */
			String ORD_RECHECK_PARAM_ERR = "4";

			/**
			 * 订单编号为空
			 */
			String ORD_RECHECK_ORDER_NO_NULL = "5";

			/**
			 * 运单编号为空
			 */
			String ORD_RECHECK_EXPRESS_NO_NULL = "6";

			/**
			 * LPN为空
			 */
			String ORD_PALLET_LPN_NULL = "7";

			/**
			 * 订单已经被绑定
			 */
			String PALLET_ORDER_IS_BIND = "2";

			/**
			 * 订单非发货状态
			 */
			String PALLET_ORDER_NOT_SEND = "3";

			/**
			 * 托盘为非空闲状态
			 */
			String PALLET_NOT_FEE = "2";

			/**
			 * 托盘不存在
			 */
			String PALLET_NOT_FOUND = "3";

			/**
			 * 托盘与订单未绑定
			 */
			String PALLET_ORDER_NOT_TOGETHER = "4";
		}

		/**
		 * JSON响应的描述值
		 */
		class JsonContent {

			public String DEFAULT = "正常响应";

			String SERVER_ERR = "服务器异常";

			String SUCCESS = "操作成功";

			String ORD_RECHECK_SUCCESS = "复核订单成功。";

		}
	}

	/**
	 * 
	 */
	class WorkerOrder {

		/**
		 * 1.创建批次
		 */
		String STATUS_CREATE_BATCH = "1";

		/**
		 * 2.创建任务
		 */
		String STATUS_CREATE_TASK = "2";

		/**
		 * 3.已拣货
		 */
		String STATUS_PICKED = "3";

		/**
		 * 4.已灯光拣选
		 */
		String STATUS_LIGHT_PICKED = "4";

		/**
		 * 5.已包装
		 */
		String STATUS_PACKAGED = "5";

		/**
		 * 6.已发货
		 */
		String STATUS_SHIPPED = "6";

		/**
		 * 7.已签收
		 */
		String STATUS_RECEIPTED = "7";

		/**
		 * 8.异常
		 */
		String STATUS_EXCEPTION = "8";

		/**
		 * 9.待包装
		 */
		String STATUS_STAY_PACKAGED = "9";
		
	}
}

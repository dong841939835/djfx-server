package com.qcloud.project.djfx.model.key;

public class TypeEnum {
	public enum EnableType {
		ENABLE(1, "启用"), DISABLE(0, "禁用");
		private final int key;
		private final String name;

		private EnableType(int key, String name) {
			this.key = key;
			this.name = name;
		}

		public int getKey() {
			return key;
		}

		public String getName() {
			return name;
		}
	}

	// 库存状态
	public enum StockType {
		DELETE(-9, "删除"), NOSTOCK(-1, "没库存"), HAVESTOCK(0, "有库存");
		private final int key;
		private final String name;

		private StockType(int key, String name) {
			this.key = key;
			this.name = name;
		}

		public int getKey() {
			return key;
		}

		public String getName() {
			return name;
		}
	}

	// 订单总部处理状态
	public enum OrderProcessingState {
		WEICHULI(1, "未处理"), FAHUOZHONG(2, "发货中"), YISONGDA(3, "已送达"), ZANBUCHULI(4, "暂不处理");
		private final int key;
		private final String name;

		private OrderProcessingState(int key, String name) {
			this.key = key;
			this.name = name;
		}

		public int getKey() {
			return key;
		}

		public String getName() {
			return name;
		}
	}

	// 订单状态
	public enum OrderState {
		DELETE(-1, "删除"), CAOGAO(0, "草稿"), YIXIADAN(1, "已下单"), CHEXIAZHONG(2, "撤下中"), YIWANCHENG(9, "已完成");
		private final int key;
		private final String name;

		private OrderState(int key, String name) {
			this.key = key;
			this.name = name;
		}

		public int getKey() {
			return key;
		}

		public String getName() {
			return name;
		}
	}
	
	// 部门级别类型
	public enum Department {
		JINGXIAOSHANG(2010008000010401L, "经销商");
		private final long key;
		private final String name;

		private Department(long key, String name) {
			this.key = key;
			this.name = name;
		}

		public long getKey() {
			return key;
		}

		public String getName() {
			return name;
		}
	}
	
	// 部门级别类型
	public enum ZhongBu {
		ZHONGBUID(2010008000010401L, "总部clerkId");
		private final long key;
		private final String name;

		private ZhongBu(long key, String name) {
			this.key = key;
			this.name = name;
		}

		public long getKey() {
			return key;
		}

		public String getName() {
			return name;
		}
	}

}

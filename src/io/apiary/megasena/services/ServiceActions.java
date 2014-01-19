package io.apiary.megasena.services;

public enum ServiceActions {

	SUCCESS {
		@Override
		public String getAction() {
			return SUCCESS_ACTION;
		}
	},
	CONNECTION_FAIL {
		@Override
		public String getAction() {
			return CONNECTION_FAIL_ACTION;
		}
	},
	SERVICE_FAIL
	{
		@Override
		public String getAction() {
			return SERVICE_FAIL_ACTION;
		}
	};
	
	private static final String SUCCESS_ACTION = "io.apiary.megasena.action.SUCCESS";
	
	private static final String CONNECTION_FAIL_ACTION = "io.apiary.megasena.action.CONNECTION_FAIL";
	
	private static final String SERVICE_FAIL_ACTION = "io.apiary.megasena.action.SERVICE_FAIL_ACTION";
	
	public abstract String getAction();

}

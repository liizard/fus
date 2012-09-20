package core.context;

public enum ContextTypeEnum {
	INITDEFAULT("initDefault"), 
	INITUSER("initUser");
	
	private String key;
	
	ContextTypeEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
}

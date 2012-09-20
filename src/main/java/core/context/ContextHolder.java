package core.context;


public class ContextHolder {

	private Context context;


	private static ContextHolder instance;

	private ContextHolder(final Context context) {
		this.context = context;
	}

	public static ContextHolder createInstance(final Context context) {
		if (instance == null) {
			synchronized (ContextHolder.class) {
				if (instance == null) {
					instance = new ContextHolder(context);
				}
			}
		}
		return instance;
	}

	public static ContextHolder getInstance() {
		Object initDefault = instance.context.get(ContextTypeEnum.INITDEFAULT);
		Object initUser = instance.context.get(ContextTypeEnum.INITUSER);

		if (initUser == null || ((Boolean) initUser) == false) {
			synchronized (ContextHolder.class) {
				if (initUser == null || ((Boolean) initUser) == false) {
					Object user = null;
					if (user != null) {
						initUser();
						instance.context.add(ContextTypeEnum.INITDEFAULT, true);
						instance.context.add(ContextTypeEnum.INITUSER, true);
					}
				}
			}
		}

		if (initDefault == null || ((Boolean) initDefault) == false) {
			synchronized (ContextHolder.class) {
				if (initDefault == null || ((Boolean) initDefault) == false) {
					initDefault();
					instance.context.add(ContextTypeEnum.INITDEFAULT, true);
				}
			}
		}

		return instance;
	}

	private static void initDefault() {
	}

	private static void initUser() {
	}
	
	public void clear() {
		context.clear();
	}
	
}

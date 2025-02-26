package pobj.motx.test;

import org.junit.BeforeClass;

public abstract class TestWithDataDir {
	
	//a changer eventuellement
	public static final String DEFAULT_DATA_DIR=System.getProperty("user.dir")+"/data";
	
	
	public static final String ENV_VAR_DATA_DIR="DATA_DIR";
	public static final String PROP_DATA_DIR="data.dir";
	public static String path_data_dir=null;
	
	@BeforeClass
	public static void setupDataDir() {
		path_data_dir=System.getenv(ENV_VAR_DATA_DIR);
		if(path_data_dir!=null) return;
		path_data_dir=System.getProperty(PROP_DATA_DIR);
		if(path_data_dir!=null) return;
		path_data_dir=DEFAULT_DATA_DIR;
		if(path_data_dir!=null) return;
		IllegalStateException e = new IllegalStateException("Data directory required but not specified");
		e.printStackTrace();
		throw e;
	}
}

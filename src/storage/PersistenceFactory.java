package storage;

public class PersistenceFactory {
	static PersistentHandler service;
	@SuppressWarnings("deprecation")
	static synchronized public PersistentHandler createPersistenceHandler()
	{
	if(service==null)
	{
		try {
	  service=(PersistentHandler)Class.forName("storage.DatabaseHandler").newInstance();
	//	service=(PersistentHandler)Class.forName("storage.Filehandler").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	return service;
	}

}
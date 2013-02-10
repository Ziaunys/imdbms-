package db.GettingStarted;

import com.sleepycat.db.Database;
import com.sleepycat.db.DatabaseConfig;
import com.sleepyat.db.DatabaseException;
import com.sleepycat.db.DatabaseType;

import java.io.FileNotFoundException;


public class baseDatabase { 

private Database imdb = null;
private String imdb_name = "im.db";

	public baseDatabase() {}
		
		public void setup(String dbNames) 
			throws DatabaseException { 
			
			DatabaseConfig dbConfig = new DatabaseConfig();
			
			dbConfig.setErrorStream(System.err);
			dbConfig.setErrorPrefix("Databases");
			dbConfig.setType(DatabaseType.BTREE);
			dbConfig.setAllowCreate(true);
	
			try { 
				imdb_name = dbNames + "/" + imdb_name;
				imdb = new Database(imdb_name, null, dbConfig);
			} catch(FileNotFoundException notFound) { 
				System.err.println("Databases: " + notFound.toString());
				System.exit(-1);
			} 
		}
				
		public Database getDB() { 
			return imdb;
		}

		public void close() { 
			try { 
				if (imdb != null) {
					imdb.close();
				}

			} catch(DatabaseException dbe) { 
				System.err.println("Error closing Databases: " + dbe.toString());
				System.exit(-1);
			}
		}
}

} 

package hackaton;
import java.security.MessageDigest;
import java.sql.Timestamp;


public class HashSecurity {
	private static String Hopital;
	private static String Nom;
	private static String Prenom;
	public HashSecurity(String hopital, String nom, String prenom) {
		super();
		Hopital = hopital;
		Nom = nom;
		Prenom = prenom;
	}
	
	public static String generateHash() 
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Long timest = new Long(timestamp.getTime());
		String value = timest.toString() + Nom + Prenom + Hopital;

		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
		    md.update(value.getBytes());
		    return bytesToHex(md.digest());
		}catch(Exception ex){
		    throw new RuntimeException(ex);
		}
	}
	
	private static String bytesToHex(byte[] bytes) 
	{
		StringBuffer result = new StringBuffer();
		for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		return result.toString();
	}

}

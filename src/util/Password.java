package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
	// TODO: La class Password doit stocker le hachee du mot de pass.
	private String password;

	public Password(String password){
		this.password = password;
	}
	
	public String getPassword() {
		
		return encode(password);
	}
	private static String encode(String password)
	// calculate the hash md5 of the password.
    {
        byte[] uniqueKey = password.getBytes();
        byte[] hash      = null;

        try
        {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new Error("No MD5 support in this VM.");
        }

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++)
        {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1)
            {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            }
            else
                hashString.append(hex.substring(hex.length() - 2));
        }
        return hashString.toString();
    }
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return getPassword();
	}
	
	
}

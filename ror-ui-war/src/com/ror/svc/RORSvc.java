package com.ror.svc;

import java.util.List;

import com.ror.model.RORUser;
import com.ror.model.RORUserToken;
import com.ror.vo.RORResponseVO;

public interface RORSvc {
	
	public boolean storeUser(RORUser user);
	
	public RORUser fetchUser(String userId);

	public boolean updateUser(RORUser user);
	
	public RORResponseVO deleteUser(String userId);

	public List<RORUser> fetchAlluser();

	public RORUser authenticateUser(RORUser user);

	public boolean storeUserToken(RORUser user, RORUserToken rorUserToken);

	public RORUserToken fetchUserToken(String rorUserId);

	public void deleteUserToken(String userId);

}

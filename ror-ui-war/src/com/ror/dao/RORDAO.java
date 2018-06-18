package com.ror.dao;

import java.util.List;

import com.ror.model.RORUser;
import com.ror.model.RORUserToken;
import com.ror.model.StoreRORUser;
import com.ror.vo.RORResponseVO;

public interface RORDAO {

	public StoreRORUser storeUser(RORUser user);

	public RORUser fetchUser(String userId);

	public boolean updateUser(RORUser user);

	public RORResponseVO deleteUser(String userId);

	public List<RORUser> fetchAllUser();

	public RORUser authenticateUser(RORUser user);

	public boolean storeUserToken(RORUser user, RORUserToken token);

	public RORUserToken fetchUserToken(String rorUserId);

	public void deleteUserToken(String userId);
}

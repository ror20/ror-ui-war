package com.ror.dao;

import java.util.List;

import com.ror.model.RORUser;
import com.ror.vo.RORResponseVO;

public interface RORDAO {

	public boolean storeUser(RORUser user);

	public RORUser fetchUser(String userId);

	public RORResponseVO updateUser(RORUser user);

	public RORResponseVO deleteUser(String userId);

	public List<RORUser> fetchAllUser();

	public RORUser authenticateUser(RORUser user);
}

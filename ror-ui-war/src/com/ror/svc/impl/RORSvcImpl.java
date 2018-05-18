package com.ror.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ror.dao.RORDAO;
import com.ror.model.RORUser;
import com.ror.model.RORUserToken;
import com.ror.svc.RORSvc;
import com.ror.vo.RORResponseVO;

public class RORSvcImpl implements RORSvc {

	@Autowired
	private RORDAO rorDAO;

	@Override
	public boolean storeUser(RORUser user) {
		if (validateUser(user))
			return rorDAO.storeUser(user);
		else {
			return false;
		}
	}

	@Override
	public RORUser fetchUser(String userId) {
		RORUser user = rorDAO.fetchUser(userId);
		if (user == null) {
			return new RORUser(null, null, null, null);
		}
		return user;
	}

	@Override
	public boolean updateUser(RORUser user) {
		return rorDAO.updateUser(user);
	}

	@Override
	public RORResponseVO deleteUser(String userId) {
		return rorDAO.deleteUser(userId);
	}

	@Override
	public List<RORUser> fetchAlluser() {
		return rorDAO.fetchAllUser();
	}

	@Override
	public RORUser authenticateUser(RORUser user) {
		return rorDAO.authenticateUser(user);
	}

	private boolean validateUser(RORUser user) {
		if (user.getUserId().length() != 6) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean storeUserToken(RORUser user, RORUserToken token) {
		return rorDAO.storeUserToken(user,token);
	}

	@Override
	public RORUserToken fetchUserToken(String rorUserId) {
		return rorDAO.fetchUserToken(rorUserId);
	}

	@Override
	public void deleteUserToken(String userId) {
		rorDAO.deleteUserToken(userId);
	}
}

package idv.jmrs.service;

import idv.jmrs.enums.Role;

public interface UserService extends BaseService {

	Role checkUserAndPassword(String name,String password);
}

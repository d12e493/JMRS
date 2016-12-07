package idv.jmrs.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idv.jmrs.entity.User;
import idv.jmrs.enums.Role;
import idv.jmrs.repository.UserRepository;
import idv.jmrs.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Role checkUserAndPassword(String name, String password) {

		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)) {
			User user = userRepository.findByName(name);
			if (user != null && user.getStatus()) {
				String dbPassword = user.getPassword();
				String inputShaPassword = DigestUtils.sha256Hex(password);
				if (dbPassword.equals(inputShaPassword)) {
					return user.getRole();
				}
			}
		}

		return null;
	}

}

package idv.jmrs.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idv.jmrs.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

}

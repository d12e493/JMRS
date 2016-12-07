package idv.jmrs.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import idv.jmrs.controller.BaseController;
import idv.jmrs.enums.Role;
import idv.jmrs.service.UserService;
import idv.jmrs.session.UserInfo;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider extends BaseController implements AuthenticationProvider {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private UserService userService;

	@Autowired
	private UserInfo userInfo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = (String) authentication.getCredentials();

		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			addMessage("ERR_LOGIN");
			throw new UsernameNotFoundException("email / password is empty !!! ");
		}

		Role role = userService.checkUserAndPassword(name, password);
		if (role == null) {
			addMessage("ERR_LOGIN");
			throw new UsernameNotFoundException("email / password is empty !!! ");
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));

		userInfo.setName(name);
		userInfo.setRole(role);

		return new UsernamePasswordAuthenticationToken(name, UUID.randomUUID(), grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

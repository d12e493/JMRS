package idv.jmrs.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private ApplicationContext context;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = (String) authentication.getCredentials();

		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			throw new UsernameNotFoundException("email / password is empty !!! ");
		}

		return new UsernamePasswordAuthenticationToken(null, null);
	}

	/**
	 * 自訂的登入後流程
	 * 
	 * @author Davis Chen
	 */
	private void authority() {

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

package qcm.rest.service.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import net.ko.framework.Ko;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		boolean hasSecurity = Ko.getConfigValue("security", false);
		if (hasSecurity) {
			// Get the HTTP Authorization header from the request
			String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

			// Check if the HTTP Authorization header is present and formatted correctly
			if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
				throw new NotAuthorizedException("Authorization header must be provided");
			}

			// Extract the token from the HTTP Authorization header
			String token = authorizationHeader.substring("Bearer".length()).trim();

			try {
				validateToken(token, requestContext);
			} catch (Exception e) {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
		}
	}

	private void validateToken(String token, ContainerRequestContext context) throws Exception {
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		String sessionToken = String.valueOf(request.getSession().getAttribute("token"));
		if (sessionToken == null || !token.equals(sessionToken))
			throw new Exception("Invalid token");
	}
}
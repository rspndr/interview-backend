package io.rspndr.interview.config;

import io.rspndr.interview.model.InternalRole;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, JwtAuthenticationToken> {

    @Override
    @SuppressWarnings("unchecked")
    public JwtAuthenticationToken convert(Jwt jwt) {
        Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
        Object roles = realmAccess != null ? realmAccess.get("roles") : null;

        Collection<GrantedAuthority> authorities;
        if (roles instanceof List<?> roleList && roleList.stream().allMatch(String.class::isInstance)) {
            authorities = generateAuthoritiesFromRoles((Collection<String>) roleList);
        } else {
            authorities = Collections.emptyList();
        }
        String username = jwt.getClaimAsString("preferred_username");
        return new JwtAuthenticationToken(jwt, authorities, username);
    }

    private Collection<GrantedAuthority> generateAuthoritiesFromRoles(Collection<String> roles) {
        return Optional.ofNullable(roles)
                .orElse(Collections.emptyList())
                .stream()
                .map(role -> {
                    boolean isInternalRole = Arrays.stream(InternalRole.values())
                            .anyMatch(r -> StringUtils.pathEquals(r.toString(), "ROLE_" + role));

                    if (isInternalRole) {
                        return new SimpleGrantedAuthority("ROLE_" + role);
                    } else {
                        return new SimpleGrantedAuthority(role);
                    }
                })
                .collect(Collectors.toList());
    }
}
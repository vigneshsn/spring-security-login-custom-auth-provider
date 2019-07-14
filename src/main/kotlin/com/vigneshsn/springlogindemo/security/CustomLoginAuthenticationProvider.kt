package com.vigneshsn.springlogindemo.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User

class CustomLoginAuthenticationProvider: AuthenticationProvider {

    override fun authenticate(token: Authentication?): Authentication {
        println("inside custom provider")
        token!!
        val userName = token.name
        val password = token.credentials

        if(userName == "admin" && password == "test") {
            val user = User(userName, password as String, emptyList())
            return UsernamePasswordAuthenticationToken(user, null)
        }

        throw RuntimeException("unable to authenticate user")
    }

    override fun supports(tokenClass: Class<*>?): Boolean {
        return tokenClass === UsernamePasswordAuthenticationToken::class.java
    }

}
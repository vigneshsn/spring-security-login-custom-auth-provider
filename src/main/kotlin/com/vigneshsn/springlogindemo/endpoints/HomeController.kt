package com.vigneshsn.springlogindemo.endpoints

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @RequestMapping("/home")
    fun greetUser(): String = "Welcome user"
}
package com.olympus.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class MicroSsoUser {

    private String id;

    private String username;

    private String password;

    private List<String> authorities;

}

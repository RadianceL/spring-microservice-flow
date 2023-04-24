package com.olympus.domain;

import com.olympus.logger.user.UserBaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MicroSsoUser extends UserBaseInfo {

    private String id;

    private String username;

    private String password;

    private List<String> authorities;

}

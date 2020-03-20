/**
 *
 */
package com.exa.vuespringboot.entity;

import java.io.Serializable;

/**
 * @author zhiqiang
 *
 */
public class UserAuthorityEntity implements Serializable {

    /**
     *   用户权限
     */
    private static final long serialVersionUID = 300161812220575387L;


    private Integer userId;

    private Long authId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }
}

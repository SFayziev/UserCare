package com.sh.usercare.db.map.user;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;

/**
 * Created by shuhrat on 09.09.2015.
 */
@Entity
@Table(name = "oauthid",  catalog = "usercare")
public class OauthidDTO  extends IntEntity {

    private String access_token;
    private  String provider;



    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JoinColumn(name = "userid")
    private UserDTO userDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

}

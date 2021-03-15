package com.example.testjpa.settings;

import com.example.testjpa.account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class Profile {

    @NotBlank
    private String bio;

    private String url;

    private String occupation;

    private String location;

    private String profileImage;

    public Profile(Account account) {
        this.bio=account.getBio();
        this.url=account.getUrl();
        this.occupation=account.getOccupation();
        this.location=account.getLocation();
        this.profileImage=account.getProfileImage();
    }
}

package vn.ryan.entity.core.dto.edupia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String second;
    private String phone;
    private String code;
    private String timeActiveCode;
    private String codeSmart;
    private String timeActiveCodeSmart;
    private String activated;
    private String codeIntro;
    private String name;
    private String job;
    private String comment;
    private String avatar;
    private String facebookId;
    private String rememberToken;
    private String signupSmIpAddress;
    private String adminIpAddress;
    private String updatedIpAddress;
    private String deletedIpAddress;
    private String signupIpAddress;
    private String signupConfirmationIpAddress;
    private String token;
    private String giftsBought;
    private String parentName;
    private String zaloId;
    private String school;
    private String email;
    private String firebaseToken;
    private String address;
    private String sourceRegister;
    private String url;
    private Long providerId;
    private Long id;
    private String type;
    private Integer courseId;
    private Long birthday;
    private Integer gender;
    private Date deletedAt;
    private Date updatedAt;
    private Date createdAt;
    private String scenarioType;
    private String courseReg;
    private Boolean plus;
}

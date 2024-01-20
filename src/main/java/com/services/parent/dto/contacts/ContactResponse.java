package com.services.parent.dto.contacts;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ContactResponse {
    private String id;
    private String fullName;
    private String email;
    private String phone;
}

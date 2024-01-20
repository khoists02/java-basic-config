package com.services.parent.dto.contacts;

import com.services.parent.dto.common.PageableResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContactsResponse {
    public List<ContactResponse> content;
    public PageableResponse pageable;
}

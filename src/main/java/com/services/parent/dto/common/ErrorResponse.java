package com.services.parent.dto.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Getter
@Setter
public class ErrorResponse {
    private String code;
    private Integer status;
    private Map<String, String> params;
    private String messageKey;
}

package com.services.parent.dto.common;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PageableResponse {
    public Integer page;
    public Integer size;
    public Integer numberOfElements;
    public Integer totalOfElements;
}
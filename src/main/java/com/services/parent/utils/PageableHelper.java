package com.services.parent.utils;

import com.services.parent.dto.common.PageableResponse;
import org.springframework.stereotype.Component;

@Component
public class PageableHelper {
    public PageableHelper() {
    }
    public PageableResponse mapPage(Integer page, Integer size, Integer numberElements, Integer totalElements) {
        PageableResponse pageableRs = new PageableResponse();
        pageableRs.setPage(page);
        pageableRs.setSize(size);
        pageableRs.setNumberOfElements(numberElements);
        pageableRs.setTotalOfElements(totalElements);
        return  pageableRs;
    }
}

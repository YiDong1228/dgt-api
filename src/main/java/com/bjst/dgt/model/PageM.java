package com.bjst.dgt.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/6/13.
 */
@Data
public class PageM {
    private Integer page;
    private Integer size = 10;
}

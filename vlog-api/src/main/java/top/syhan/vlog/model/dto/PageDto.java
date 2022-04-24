package top.syhan.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: vlog-api
 * @description: 分页Dto
 * @author: SYH
 * @create: 2022-04-23 19:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto {
    private int pageNum;
    private int pageSize;
}

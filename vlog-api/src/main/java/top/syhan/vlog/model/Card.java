package top.syhan.vlog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: vlog-api
 * @description: card
 * @author: SYH
 * @create: 2022-04-23 19:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    private Integer id;
    private String title;
    private String bgImg;
    private String content;
}


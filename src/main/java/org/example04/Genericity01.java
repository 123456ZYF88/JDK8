package org.example04;

import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 泛型擦除问题
 * @date 2022/8/6 22:28
 */
public class Genericity01 {
    //村上春树
    public static void main(String[] args) {
    OrderDO orderDO= new OrderDO();
    orderDO.setTags(Arrays.asList("tag1","tag2"));
    OrderDTO orderDTO = new OrderDTO();

    // 0 1 2
     BeanUtils.copyProperties(orderDO,orderDTO);//将给定源 bean 的属性值复制到目标 bean。
     System.out.println(orderDTO.getTags());
     //System.out.println(orderDTO.getTags().get(0));

     }
}

class OrderDO {


    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    /** 
     * 功能描述
     * @author
     * @date 2022/8/12 
     * @param tags
     * @return void
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}


class OrderDTO {
    private List<Integer> tags;

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }
}


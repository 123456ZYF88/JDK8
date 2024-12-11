package org.Test;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author zhangyf
 * @date 2024/11/11 16:10
 */
@Data
public class MqMsgReq {
    //消息ID
    private String msgId;
    //工单号
    private String caseId;
    //操作类型
    private String opType;
    //数据
    private List<Object> data;


}

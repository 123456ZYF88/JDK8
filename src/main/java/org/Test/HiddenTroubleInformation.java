package org.Test;

import lombok.Data;

/**
 * 隐患信息批量保存
 *
 * @author zhangyf
 * @date 2024/7/5 14:23
 */
@Data
public class HiddenTroubleInformation {
    /*├─ id	string	必须		id
├─ hazardCode	string	必须		风险分析对象编码
├─ riskMeasureId	string	必须		管控措施标识
├─ checkRecordId	string	必须		隐患排查记录标识
├─ dangerName	string	必须		隐患名称
├─ dangerLevel	string	必须		隐患等级（一般隐患:0;重大隐患:1)
├─ registTime	string	必须		登记时间(格式：yyyy-MM-dd HH:mm:ss)
├─ registrant	string	必须		登记人姓名
├─ dangerSrc	string	必须		日常排查:1;综合性排查:2;专业性排查:3;季节性排查:4;重点时段及节假日前排查:5;事故类比排查:6;复产复工前排查:7;外聘专家诊断式排查:8;管控措施失效:9;其他:10上报：1,2,3...10
├─ dangerManageType	string	必须		隐患治理类型(即查即改:0;限期整改:1)传 0，1
├─ hazardDangerType	string	必须		隐患类型（安全:1;工艺:2;电气:3;仪表:4;消防: 5;总图:6;设备:7;其他:8 ) 上报：1,2,3...8
├─ dangerDesc	string	必须		隐患描述
├─ dangerReason	string	非必须		原因分析
├─ hazardCategory	number	必须		隐患类别（其他隐患：0；主要负责人登记隐患：1；技术负责人登记隐患：2；操作负责人登记隐患：3）默认为其他隐患：0
├─ controlMeasures	string	非必须		控制措施
├─ cost	string	非必须		整改资金
├─ liablePerson	string	必须		整改责任人
├─ dangerManageDeadline	string	必须		隐患治理期限(格式：yyyy-MM-dd HH:mm:ss)
├─ checkAcceptPerson	string	非必须		验收人姓名(当隐患状态为已验收时，此项必填 )
├─ checkAcceptTime	string	非必须		验收时间 格式：yyyy-MM-dd HH:mm:ss 当隐患状态为已验收时，此项必填
├─ checkAcceptComment	string	非必须		验收情况
├─ dangerState	string	必须		隐患状态（整改中:0;待验收: 1;已验收:9) 上报：0,1,9
├─ deleted	string	必须		删除标志:0 有效 1 无效
├─ createBy	string	必须		创建人
├─ createDate	string	必须		创建时间
├─ updateDate	string	必须		最后修改时间(格式：yyyy-MM-dd HH:mm:ss)
├─ updateBy	string	必须		最后修改人
├─ managementClassification	string	非必须		人物管理分类：1-人的不安全行为；2-物的不安全状态；3-管理上的缺陷
├─ occurrenceLink	string	非必须		发生环节：1-设计；2-产品质量缺陷；3-仓储；4-项目施工；5-开停车；6-使用操作；7-维护保养；8-维修；9-变更；10-运输等
├─ attachments1	string	非必须		隐患照片-隐患的相关图片；图片的base64 编码。图片格式为 PNG 或 JPEG，图片大小不超过 5M。
├─ attachments2	string	非必须		隐患整改照片-隐患的相关图片；图片的base64 编码。图片格式为 PNG 或 JPEG，图片大小不超过 5M。
├─ attachments3	string	非必须		附件的base64 编码。图片格式为 PNG 或 JPEG，图片大小不超过 5M。
├─ attachmentsType	string	非必须		附件的名*/

    //id
    private String id;
    //风险分析对象编码
    private String hazardCode;
    //管控措施标识
    private String riskMeasureId;
    //隐患排查记录标识
    private String checkRecordId;
    //隐患名称
    private String dangerName;
    //隐患等级（一般隐患:0;重大隐患:1)
    private String dangerLevel;
    //登记时间(格式：yyyy-MM-dd HH:mm:ss)
    private String registTime;
    //登记人姓名
    private String registrant;
    //日常排查:1;综合性排查:2;专业性排查:3;季节性排查:4;重点时段及节假日前排查:5;事故类比排查:6; startup:7;外聘专家诊断式排查:8;管控措施失效:9;其他:10
    private String dangerSrc;
    //隐患治理类型(即查即改:0;限期整改:1)传 0，1
    private String dangerManageType;
    //隐患类型（安全:1;工艺:2;电气:3;仪表:4;消防: 5;总图:6;设备:7;其他:8 ) 上报：1,2,3...8
    private String hazardDangerType;
    //隐患描述
    private String dangerDesc;
    //原因分析
    private String dangerReason;
    //隐患类别（其他隐患：0；主要负责人登记隐患：1；技术负责人登记隐患：2；操作负责人登记隐患：3）默认为其他隐患：0
    private Integer hazardCategory;
    //控制措施
    private String controlMeasures;
    //整改资金
    private String cost;
    //整改责任人
    private String liablePerson;
    //隐患治理期限(格式：yyyy-MM-dd HH:mm:ss)
    private String dangerManageDeadline;
    //验收人姓名(当隐患状态为已验收时，此项必填 )
    private String checkAcceptPerson;
    //验收时间 格式：yyyy-MM-dd HH:mm:ss 当隐患状态为已验收时，此项必填
    private String checkAcceptTime;
    //验收情况
    private String checkAcceptComment;
    //隐患状态（整改中:0;待验收: 1;已验收:9) 上报：0,1,9
    private String dangerState;
    //删除标志:0 有效 1 无效
    private String deleted;
    //创建人
    private String createBy;
    //创建时间
    private String createDate;
    //最后修改时间(格式：yyyy-MM-dd HH:mm:ss)
    private String updateDate;
    //最后修改人
    private String updateBy;
    //人物管理分类：1-人的不安全行为；2-物的不安全状态；3-管理上的缺陷
    private String managementClassification;
    //发生环节：1-设计；2-产品质量缺陷；3-仓储；4-项目施工；5-开停车；6-使用操作；7-维护保养；8-维修；9-变更；10-运输等
    private String occurrenceLink;
    //隐患照片-隐患的相关图片；图片的base64 编码。图片格式为 PNG 或 JPEG，图片大小不超过 5M。
    private String attachments1;
    //隐患整改照片-隐患的相关图片；图片的base64 编码。图片格式为 PNG 或 JPEG，图片大小不超过 5M。
    private String attachments2;
    //附件的base64 编码。图片格式为 PNG 或 JPEG，图片大小不超过 5M。
    private String attachments3;
    //附件的名*/
    private String attachmentsType;
}

package pers.lichen.mybatisplus.demo.crm.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 企业信息表
 * </p>
 *
 * @author lichen24
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_cust_comp")
public class CustComp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * SEQ_CUST_COMP
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 业务ID
     */
    @TableField("BID")
    private String bid;

    @TableField("CREATE_ID")
    private Long createId;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @TableField("MODIFY_ID")
    private Long modifyId;

    @TableField("MODIFY_TIME")
    private LocalDateTime modifyTime;

    @TableField("STATUS")
    private Integer status;

    @TableField("VERSION")
    private Integer version;

    /**
     * 客户名称
     */
    @TableField("COMP_NAME")
    private String compName;

    /**
     * 客户状态
     */
    @TableField("COMP_STATUS")
    private Integer compStatus;

    /**
     * 客户简称
     */
    @TableField("SIMP_NAME")
    private String simpName;

    /**
     * 客户编码
     */
    @TableField("COMP_CODE")
    private String compCode;

    /**
     * 客户类型
     */
    @TableField("CUST_TYPE")
    private Integer custType;

    /**
     * 成立时间
     */
    @TableField("SETUP_DATE")
    private LocalDateTime setupDate;

    /**
     * 行业分类大类
     */
    @TableField("BUS_TYPE_BIG")
    private Integer busTypeBig;

    /**
     * 行业分类中类
     */
    @TableField("BUS_TYPE_MIDDLE")
    private Integer busTypeMiddle;

    /**
     * 行业分类小类
     */
    @TableField("BUS_TYPE_SMALL")
    private Integer busTypeSmall;

    /**
     * 注册地址-省
     */
    @TableField("REG_ADDR_PROVINCE")
    private Integer regAddrProvince;

    /**
     * 注册地址-市
     */
    @TableField("REG_ADDR_CITY")
    private Integer regAddrCity;

    /**
     * 注册地址-区
     */
    @TableField("REG_ADDR_DISTRICT")
    private Integer regAddrDistrict;

    /**
     * 注册地址-详细
     */
    @TableField("REG_ADDR_DESC")
    private String regAddrDesc;

    /**
     * 邮编
     */
    @TableField("POST_CODE")
    private String postCode;

    /**
     * 组织机构代码
     */
    @TableField("ORG_CODE")
    private String orgCode;

    /**
     * 营业执照号码
     */
    @TableField("BUS_LICENSE_CODE")
    private String busLicenseCode;

    /**
     * 开户许可证
     */
    @TableField("OPENING_PERMIT")
    private String openingPermit;

    /**
     * 税务登记号
     */
    @TableField("TAX_REG_CER_CODE")
    private String taxRegCerCode;

    /**
     * 是否三证合一
     */
    @TableField("IS_USCC")
    private Integer isUscc;

    /**
     * 统一社会信用代码
     */
    @TableField("USCC_CODE")
    private String usccCode;

    /**
     * 注册资金（万）
     */
    @TableField("REG_CAPITAL")
    private BigDecimal regCapital;

    /**
     * 实收资本（万）
     */
    @TableField("PAIDUP_CAPITAL")
    private BigDecimal paidupCapital;

    /**
     * 主营业务
     */
    @TableField("MAIN_BUS")
    private String mainBus;

    /**
     * 头像文件名
     */
    @TableField("HEAD_PHOTO")
    private String headPhoto;

    /**
     * 法人姓名
     */
    @TableField("LEGAL_NAME")
    private String legalName;

    /**
     * 法人证件类型
     */
    @TableField("LEGAL_IDTYPE")
    private Integer legalIdtype;

    /**
     * 法人证件号码
     */
    @TableField("LEGAL_IDNUM")
    private String legalIdnum;

    /**
     * 法人手机
     */
    @TableField("LEGAL_MOBILE")
    private String legalMobile;

    /**
     * 法人邮箱
     */
    @TableField("LEGAL_EMAIL")
    private String legalEmail;

    /**
     * 是否注册
     */
    @TableField("IS_REG")
    private Integer isReg;

    /**
     * 营业期限
     */
    @TableField("OPER_PERIOD")
    private LocalDateTime operPeriod;

    /**
     * 营业收入
     */
    @TableField("REVENUE")
    private BigDecimal revenue;

    /**
     * 员工人数
     */
    @TableField("EMPLOYEE_NUM")
    private Integer employeeNum;

    /**
     * 资产总额
     */
    @TableField("ASSET_TOTAL")
    private BigDecimal assetTotal;

    /**
     * 登记机关
     */
    @TableField("REG_AUTHORITY")
    private String regAuthority;

    /**
     * 集团内码
     */
    @TableField("JT_CODE")
    private String jtCode;

    /**
     * 上级组织编号
     */
    @TableField("PARENT_CODE")
    private String parentCode;

    @TableField("CREATER")
    private String creater;

    @TableField("CREATE_MOB")
    private String createMob;

    @TableField("MODIFIER")
    private String modifier;

    @TableField("MODIFY_MOB")
    private String modifyMob;

    /**
     * 企业类别
     */
    @TableField("ENTP_TYPE")
    private String entpType;

    /**
     * 企业性质
     */
    @TableField("ENTP_NATURE")
    private String entpNature;

    /**
     * 公司电话
     */
    @TableField("COMP_TEL")
    private String compTel;

    /**
     * 公司传真
     */
    @TableField("COMP_FAX")
    private String compFax;

    /**
     * 经营范围
     */
    @TableField("BUS_SCOPE")
    private String busScope;

    /**
     * 法人性别
     */
    @TableField("LEGAL_GENDER")
    private String legalGender;

    /**
     * 法人固定电话
     */
    @TableField("LEGAL_TEL")
    private String legalTel;

    /**
     * 业务联系人
     */
    @TableField("CONTACT_NAME")
    private String contactName;

    /**
     * 业务联系电话
     */
    @TableField("CONTACT_PHONE")
    private String contactPhone;

    /**
     * 上级组织ID
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 公司邮箱
     */
    @TableField("COMP_EMAIL")
    private String compEmail;

    /**
     * 枚举YesOrNoEnum
     */
    @TableField("IS_LEGAL")
    private Integer isLegal;

    /**
     * 客户等级
     */
    @TableField("CUST_LEVEL")
    private Integer custLevel;

    /**
     * 是否持章
     */
    @TableField("IS_CHAPTER")
    private Integer isChapter;

    /**
     * 是否根节点
     */
    @TableField("IS_ROOT")
    private Integer isRoot;

    /**
     * 境内境外
     */
    @TableField("AREA_TYPE")
    private Integer areaType;

    /**
     * 是否财务公司
     */
    @TableField("IS_FINANCE")
    private Integer isFinance;

    /**
     * 是否收集材料
     */
    @TableField("IS_COLLECT")
    private Integer isCollect;

    /**
     * 客户属性，1-联想供应链，2-一般客户
     */
    @TableField("CLIENT_TYPE")
    private Integer clientType;

    /**
     * 企业ID/组织代码
     */
    @TableField("ORGANIZE_CODE")
    private String organizeCode;


}

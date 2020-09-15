package pers.lichen.mybatisplus.demo.crm.service.impl;

import pers.lichen.mybatisplus.demo.crm.entity.CustComp;
import pers.lichen.mybatisplus.demo.crm.mapper.CustCompMapper;
import pers.lichen.mybatisplus.demo.crm.service.ICustCompService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业信息表 服务实现类
 * </p>
 *
 * @author lichen24
 * @since 2020-09-15
 */
@Service
public class CustCompServiceImpl extends ServiceImpl<CustCompMapper, CustComp> implements ICustCompService {

}

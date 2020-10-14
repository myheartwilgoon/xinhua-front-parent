package com.xh.cms.service;

import com.xh.cms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-10-13
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> selectIndexList();
}

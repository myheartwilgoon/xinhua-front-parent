package com.xh.cms.controller;

import com.xinhua.onlineedu.common.R;
import com.xh.cms.entity.CrmBanner;
import com.xh.cms.service.CrmBannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/cms/crm-banner")
@CrossOrigin //跨域
public class CrmBannerController {
    	@Autowired
	private CrmBannerService bannerService;

	@ApiOperation(value = "获取首页banner")
	@GetMapping("getAllBanner")
	public R index() {
		List<CrmBanner> list = bannerService.selectIndexList();
		return R.ok().data("list",list);
	}

}


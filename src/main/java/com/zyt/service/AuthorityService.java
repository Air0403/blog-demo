package com.zyt.service;

import com.zyt.domain.Authority;

/**
 * Authority 服务接口.
 * 
 * @since 1.0.0 2017年3月18日
 */
public interface AuthorityService {
	 
	
	/**
	 * 根据id获取 Authority
	 * @return
	 */
	Authority getAuthorityById(Long id);
}

/**
 * 
 */
package com.zyt.service.impl;

import com.zyt.domain.Authority;
import com.zyt.repository.AuthorityRepository;
import com.zyt.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Authority 服务.
 * 
 * @since 1.0.0 2017年3月30日
 */
@Service
public class AuthorityServiceImpl  implements AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(Long id) {
		return authorityRepository.findById(id).get();
	}

}

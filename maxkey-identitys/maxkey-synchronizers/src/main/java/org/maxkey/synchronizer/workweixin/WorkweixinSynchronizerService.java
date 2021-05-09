/*
 * Copyright [2021] [MaxKey of copyright http://www.maxkey.top]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 

package org.maxkey.synchronizer.workweixin;

import org.maxkey.synchronizer.ISynchronizerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobao.api.ApiException;

@Service
public class WorkweixinSynchronizerService  implements ISynchronizerService{
	final static Logger _logger = LoggerFactory.getLogger(WorkweixinSynchronizerService.class);
	
	@Autowired
	WorkweixinUsersService workweixinUsersService;
	
	@Autowired
	WorkweixinOrganizationService workweixinOrganizationService;
	

	WorkweixinAccessTokenService workweixinAccessTokenService;
	
	public WorkweixinSynchronizerService() {
		super();
	}

	public void sync() throws Exception {
		_logger.info("Sync ...");
		
		String access_token=workweixinAccessTokenService.requestToken();
		
		workweixinOrganizationService.setAccess_token(access_token);
		workweixinOrganizationService.sync();
		
		workweixinUsersService.setAccess_token(access_token);
		workweixinUsersService.sync();
	}

	public WorkweixinUsersService getWorkweixinUsersService() {
		return workweixinUsersService;
	}

	public void setWorkweixinUsersService(WorkweixinUsersService workweixinUsersService) {
		this.workweixinUsersService = workweixinUsersService;
	}

	public WorkweixinOrganizationService getWorkweixinOrganizationService() {
		return workweixinOrganizationService;
	}

	public void setWorkweixinOrganizationService(WorkweixinOrganizationService workweixinOrganizationService) {
		this.workweixinOrganizationService = workweixinOrganizationService;
	}

	public WorkweixinAccessTokenService getWorkweixinAccessTokenService() {
		return workweixinAccessTokenService;
	}

	public void setWorkweixinAccessTokenService(WorkweixinAccessTokenService workweixinAccessTokenService) {
		this.workweixinAccessTokenService = workweixinAccessTokenService;
	}

}

/*
 * Copyright [2022] [MaxKey of copyright http://www.maxkey.top]
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
 

package org.maxkey.synchronizer.feishu;

import java.util.HashMap;
import java.util.Map;

import org.maxkey.constants.ContentType;
import org.maxkey.synchronizer.entity.AccessToken;
import org.maxkey.util.JsonUtils;
import org.maxkey.web.HttpRequestAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeishuAccessTokenService {
	final static Logger _logger = LoggerFactory.getLogger(FeishuAccessTokenService.class);
	
	String appId;
	
	String appSecret;
	
	public static String TOKEN_URL="https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal";


	public FeishuAccessTokenService() {}
	
	
	public FeishuAccessTokenService(String appId, String appSecret) {
		super();
		this.appId = appId;
		this.appSecret = appSecret;
	}


	public String requestToken() {
		HttpRequestAdapter request =new HttpRequestAdapter(ContentType.APPLICATION_JSON);
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("app_id", appId);
		parameterMap.put("app_secret", appSecret);
		String responseBody = request.post(TOKEN_URL, parameterMap,null);
		
		AccessToken accessToken = JsonUtils.gson2Object(responseBody, AccessToken.class);
		_logger.debug("accessToken " + accessToken);
		if(accessToken.getErrcode()== 0){
			return accessToken.getTenant_access_token();
		}
		return "";
	}
	
	
	public String getAppId() {
		return appId;
	}


	public void setAppId(String appId) {
		this.appId = appId;
	}


	public String getAppSecret() {
		return appSecret;
	}


	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}


	public static void main(String[] args) {

	}

}

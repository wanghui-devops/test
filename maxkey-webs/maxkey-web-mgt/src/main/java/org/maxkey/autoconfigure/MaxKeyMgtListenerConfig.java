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
 

package org.maxkey.autoconfigure;

import org.maxkey.authn.session.SessionManager;
import org.maxkey.configuration.ApplicationConfig;
import org.maxkey.listener.DynamicRolesListenerAdapter;
import org.maxkey.listener.ListenerAdapter;
import org.maxkey.listener.ListenerParameter;
import org.maxkey.listener.SessionListenerAdapter;
import org.maxkey.persistence.service.ConnectorsService;
import org.maxkey.persistence.service.RolesService;
import org.maxkey.provision.thread.ProvisioningRunner;
import org.maxkey.provision.thread.ProvisioningRunnerThread;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@AutoConfiguration
public class MaxKeyMgtListenerConfig  implements InitializingBean {
    private static final  Logger _logger = LoggerFactory.getLogger(MaxKeyMgtListenerConfig.class);
 
    @Bean
    public String  sessionListenerAdapter(
    		Scheduler scheduler,
    		SessionManager sessionManager) throws SchedulerException {
        ListenerAdapter.addListener(
    			SessionListenerAdapter.class,
    			scheduler,
    			new ListenerParameter().add("sessionManager",sessionManager).build(),
    			"0 0/10 * * * ?",//10 minutes
    			SessionListenerAdapter.class.getSimpleName()
    		);
        _logger.debug("Session ListenerAdapter inited .");
    	return "sessionListenerAdapter";
    }
    
    @Bean
    public String  dynamicRolesListenerAdapter(
    		Scheduler scheduler,
            RolesService rolesService,
            @Value("${maxkey.job.cron.schedule}") String cronSchedule
            ) throws SchedulerException {
        
        ListenerAdapter.addListener(
    			DynamicRolesListenerAdapter.class,
    			scheduler,
    			new ListenerParameter().add("rolesService",rolesService).build(),
    			cronSchedule,
    			DynamicRolesListenerAdapter.class.getSimpleName()
    		);
        _logger.debug("DynamicRoles ListenerAdapter inited .");
        return "dynamicRolesListenerAdapter";
    }
    
    @Bean
    public String  provisioningRunnerThread(
    		ConnectorsService connectorsService,
    		JdbcTemplate jdbcTemplate,
    		ApplicationConfig applicationConfig
            ) throws SchedulerException {
        if(applicationConfig.isProvisionSupport()) {
	    	ProvisioningRunner runner = new ProvisioningRunner(connectorsService,jdbcTemplate);
	    	ProvisioningRunnerThread runnerThread = new ProvisioningRunnerThread(runner);
	    	runnerThread.start();
	        _logger.debug("provisioning Runner Thread .");
        }else {
        	_logger.debug("not need init provisioning Runner Thread .");
        }
        return "provisioningRunnerThread";
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        
    }

}

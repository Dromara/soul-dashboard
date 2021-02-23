/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.dromara.soul.springboot.starter.client.sofa;

import org.dromara.soul.client.sofa.SofaServiceBeanPostProcessor;
import org.dromara.soul.register.common.config.SoulRegisterCenterConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sofa type client bean postprocessor.
 *
 * @author tydhot
 */
@Configuration
public class SoulSofaClientConfiguration {
    /**
     * Sofa service bean post processor sofa service bean post processor.
     *
     * @param registerCenterConfig the register center config
     * @return the sofa service bean post processor
     */
    @Bean
    public SofaServiceBeanPostProcessor sofaServiceBeanPostProcessor(final SoulRegisterCenterConfig registerCenterConfig) {
        return new SofaServiceBeanPostProcessor(registerCenterConfig);
    }
    
    /**
     * Soul Register Center Config.
     *
     * @return the Register Center Config
     */
    @Bean
    @ConfigurationProperties(prefix = "soul.client")
    public SoulRegisterCenterConfig soulRegisterCenterConfig() {
        return new SoulRegisterCenterConfig();
    }
}
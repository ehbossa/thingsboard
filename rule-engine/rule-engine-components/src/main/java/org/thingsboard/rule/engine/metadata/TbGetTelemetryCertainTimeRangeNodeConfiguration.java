/**
 * Copyright © 2016-2018 The Thingsboard Authors
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
package org.thingsboard.rule.engine.metadata;

import lombok.Data;
import org.thingsboard.rule.engine.api.NodeConfiguration;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mshvayka on 04.09.18.
 */
@Data
public class TbGetTelemetryCertainTimeRangeNodeConfiguration implements NodeConfiguration<TbGetTelemetryCertainTimeRangeNodeConfiguration> {

    public static final String FETCH_MODE_FIRST = "FIRST";
    public static final String FETCH_MODE_LAST = "LAST";
    public static final String FETCH_MODE_ALL = "ALL";
    public static final int MAX_FETCH_SIZE = 1000;

    private int startInterval;
    private int endInterval;
    private String startIntervalTimeUnit;
    private String endIntervalTimeUnit;
    private String fetchMode; //FIRST, LAST, LATEST

    private List<String> latestTsKeyNames;



    @Override
    public TbGetTelemetryCertainTimeRangeNodeConfiguration defaultConfiguration() {
        TbGetTelemetryCertainTimeRangeNodeConfiguration configuration = new TbGetTelemetryCertainTimeRangeNodeConfiguration();
        configuration.setLatestTsKeyNames(Collections.emptyList());
        configuration.setFetchMode("FIRST");
        configuration.setStartIntervalTimeUnit(TimeUnit.MINUTES.name());
        configuration.setStartInterval(2);
        configuration.setEndIntervalTimeUnit(TimeUnit.MINUTES.name());
        configuration.setEndInterval(1);
        return configuration;
    }
}

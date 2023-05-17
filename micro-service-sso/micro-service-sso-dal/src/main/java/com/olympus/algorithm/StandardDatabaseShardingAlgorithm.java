package com.olympus.algorithm;

import groovy.util.logging.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

/**
 * @author eddie.lys
 * @since 2023/5/17
 */
@Slf4j
@Component(value = "standardDatabaseShardingAlgorithm")
public class StandardDatabaseShardingAlgorithm implements StandardShardingAlgorithm<Long> {

    /**
     * 精确分片
     *
     * @param availableTargetNames 有效的数据源或表的名字。这里就对应配置文件中配置的数据源信息
     * @param shardingValue        包含 逻辑表名、分片列和分片列的值。
     * @return 返回目标结果
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        //分库的规则:时间戳取中间六位数对数据库数量取模 例：1688811155000 --> 811155 % 3
        String timestamp = StringUtils.substring(String.valueOf(shardingValue.getValue()), -9, -3);
        //分库数量
        int dataBaseSize = 3;
        Integer mod = Integer.parseInt(timestamp) % dataBaseSize;
        for (String targetName : availableTargetNames) {
            if (targetName.endsWith(String.valueOf(mod))) {
                return targetName;
            }
        }
        throw new UnsupportedOperationException("route ds" + mod + " is not supported. please check your config");
    }

    /**
     * 范围分片
     *
     * @param availableTargetNames 可用
     * @param rangeShardingValue   包含逻辑表名、分片列和分片列的条件范围。
     * @return 返回目标结果。可以是多个。
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> rangeShardingValue) {
        Collection<String> collect = new ArrayList<>();
        collect.add("db1");
        collect.add("db2");
        collect.add("db3");
        return collect;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public String getType() {
        return "STANDARD_ALGORITHM";
    }

    @Override
    public void init(Properties props) {
        System.out.println(props);
    }
}

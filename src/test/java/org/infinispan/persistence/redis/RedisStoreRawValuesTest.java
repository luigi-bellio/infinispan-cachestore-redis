package org.infinispan.persistence.redis;

import org.infinispan.persistence.BaseStoreTest;
import org.infinispan.persistence.spi.AdvancedLoadWriteStore;
import org.testng.annotations.Test;

@Test(testName = "persistence.redis.RedisStoreRawValuesTest", groups = "functional")
public class RedisStoreRawValuesTest extends BaseStoreTest
{
    @Override
    protected AdvancedLoadWriteStore createStore() throws Exception
    {
        return null;
    }

    @Override
    public void testReplaceExpiredEntry() throws Exception
    {

    }
}

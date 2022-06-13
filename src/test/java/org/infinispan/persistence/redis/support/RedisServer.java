package org.infinispan.persistence.redis.support;

import java.io.IOException;

public class RedisServer extends AbstractRedisServer
{
    private final int SERVER_NUM = 1;
    private final int START_PORT = 6390;
    private final String testPath;
    private Process serverProcess;

    public RedisServer()
    {
        this.testPath = System.getProperty("project.build.testOutputDirectory");
    }

    public void start() throws IOException
    {
        String workingDir = String.format("%s/redis/server%d", this.testPath, SERVER_NUM);
        String configurationFile = String.format("%s/redis/server%d/redis.conf", this.testPath, SERVER_NUM);
        serverProcess = this.startRedisServer(configurationFile, workingDir, START_PORT, "");

        System.out.println("All servers started.");
        this.sleep(5000);
    }

    public void kill()
    {
        super.kill(serverProcess);

        System.out.println("Waiting for all servers to terminate and release file locks");
        this.sleep(5000);

        this.cleanup(this.testPath, "server", SERVER_NUM);
    }
}

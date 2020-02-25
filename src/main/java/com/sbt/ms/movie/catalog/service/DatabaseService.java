package com.sbt.ms.movie.catalog.service;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

public class DatabaseService {

	private static Logger log = LoggerFactory.getLogger(DatabaseService.class);

	/**
	 * Create TCP server for microservice application to access the H2 database
	 * 
	 * @return Server instance
	 * @throws SQLException
	 */
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server startInMemoryH2DatabaseaServer() throws SQLException {
		Server server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "8084").start();
		if (server.isRunning(true)) {
			log.info("H2 db server started and running.");
		} else {
			log.info("H2 db server not started.");
		}
		return server;
	}
}

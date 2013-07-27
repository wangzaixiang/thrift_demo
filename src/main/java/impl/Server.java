package impl;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import tutorial.Calculator;

public class Server {
	
	public static void main(String[] args) throws Exception {
		CalculatorHandler handler = new CalculatorHandler();
		Calculator.Processor<CalculatorHandler> processor = new Calculator.Processor<CalculatorHandler>(handler);
		TServerTransport serverTransport = new TServerSocket(9090);
		TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

		System.out.println("Starting the simple server...");
		server.serve();
	}

}

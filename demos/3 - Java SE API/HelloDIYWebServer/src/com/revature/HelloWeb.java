package com.revature;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import com.sun.net.httpserver.HttpServer;

/*
 * This project is a simple DIY web server. In your project 1, you will be use servets instead of HttpServers
 * to launch your web services.
 * --------------------------------------------
 * What is a web service?
 * -Web services are services spread over the web.
 * 
 * -Enables the communication between application over the web and provides
 * a standart protocol or format for communication.
 * 
 * -Using webservices two different applications designed in different languages
 * can talk to each other share information and exchange data
 * 
 * -Platform independent.
 * 
 * --------------------------------------------
 * HTTP (Hypertext Transfer Protocol) is a application-layer protocol for
 * trasmitting hypermedia documents, such as HTML.
 * 
 * This protocol is used between web clients and servers for sending HTTP requests
 * and receiving HTTP responses.
 * 
 * The typical HTTP request lifecycle:
 * 1. A client (a browser) sends an HTTP request to the web
 * 2. A web server receives the request
 * 3. The server runs an application to process the request
 * 4. The server returns an HTTP response (output) to the browser
 * 5. The client (the browser) receives the response
 * 
 * -----------------------------------------------------
 * URL is an acronym for Uniform Resource Locator and is a reference (an address) 
 * to a resource on the Internet. 
 * 
 * A URL has two main components: 
 *     1) Protocol identifier: For the URL http://example.com , the protocol identifier is http . 
 *     2) Resource name: For the URL http://example.com , the resource name is example.com
 * So what's the difference between an URL and URI?
 * - URL is used to describe the identity of an item. URL links a web page, a component of a web page 
 * or a program on a web page with the help of accessing methods like protocols. 
 * 
 * - URI provides a technique for defining the identity of an item.  URI is used to distinguish one resource 
 * from other regardless of the method used.
 * 
 * We will be talking more about web services next week, but here are the basics for now! ^
 */
public class HelloWeb {
	public static void main(String[] args) {

		try {
			HttpServer webServer = HttpServer.create(new InetSocketAddress(8080), 0);
			webServer.setExecutor(Executors.newFixedThreadPool(5));

			webServer.createContext("/hello", httpExchange -> {
				String payload = "Hello, Web!";
				httpExchange.sendResponseHeaders(200, payload.length());
				httpExchange.getResponseBody().write(payload.getBytes());
			});

			webServer.start();
			System.out.println("Application server started and listening at http://localhost:8080/hello");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

/**
 * @author Devil
 * @date 2016年5月30日 下午2:27:05
 * @version 1.0.0
 *         
 *          同步阻塞IO（JAVA Block IO）： 
 *          服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进行处理，
 *          如果这个连接不做任何事情会造成不必要的线程开销，当然可以通过线程池机制改善。
 */
package com.devil.network.tcp.bio;
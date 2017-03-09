/**
 * @author Devil
 * @date 2016年5月30日 下午2:27:05
 * @version 1.0.0
 *         
 *          异步非阻塞IO（Java Asynchronous IO）:
 *          在此种模式下，用户进程只需要发起一个IO操作然后立即返回，等IO操作真正的完成以后，
 *          应用程序会得到IO操作完成的通知，此时用户进程只需要对数据进行处理就好了，不需要进行实际的IO读写操作，
 *          因为真正的IO读取或者写入操作已经由内核完成了。
 */
package com.devil.network.tcp.aio;
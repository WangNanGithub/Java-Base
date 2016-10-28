/**
 * Guarded Suspension
 * 如果某个接口在某个时刻，瞬间请求量过大，可能会超过服务器本身的即时处理能力，而服务程序又不能丢掉任何一个请求。
 * 最佳方案是让客户端排队请求，一个一个处理。我们将请求放入中间件，在之后从中间件中取出数据处理
 */
package com.devil.effective.concurrent.guarded;
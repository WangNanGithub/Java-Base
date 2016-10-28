/**
 * master-worker模式，一个master管理多个worker，master负责和客户端交互及分配任务，worker则是真正的业务处理者。
 * 这就像nginx的请求分发模式一样。对于Client来说，Master进程会分配任务并立即返回，不会全部处理了再返回，所以Client无需等待
 */
package com.devil.effective.concurrent.worker;
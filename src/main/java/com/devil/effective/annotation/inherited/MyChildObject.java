package com.devil.effective.annotation.inherited;

/**
 * 你不需要在实现类中定义接口方法. 因为使用 @Inherited标记，这些都自动继承了.
 *
 */
@MyParentObj(name = "Child")
public class MyChildObject {

}

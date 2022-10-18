package y2022.m10.day18;

/**
 * @Author: LeahAna
 * @Date: 2022/10/18 14:41
 * @Desc: 阻塞队列：由链表结构组成的有界（但大小默认值为 integer.MAX_VALUE）。
 */

public class LinkedBlockingQueue {

/**
 * ArrayBlockingQueue在插入或删除元素时，不会产生或销毁任何额外的对象实例，而后者则会生成一个额外的
 * Node对象。这在长时间内需要高效并发地处理大批量数据的系统中，其对于GC的影响还是存在一定的区别。而在创建
 * ArrayBlockingQueue 时，我们在可以控制对象的内部锁是否采用公平锁，默认采用非公平锁
 *
 */

/**
 * DelayQueue：使用优先级队列实现的延迟无界阻塞队列
 *
 * PriorityBlockingQueue：支持优先级排序的无界阻塞队列
 *
 * SynchronousQueue: 不储存元素的阻塞队列，也即单个元素队列
 *
 * LinkedTransferQueue：由链表组成的无界阻塞队列
 *
 * LinkedBlockingDeque：由链表组成的双向阻塞队列
 *
 */
}

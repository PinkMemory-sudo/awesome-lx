package delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

        // 添加延时元素到延时队列
        delayQueue.put(new DelayedElement(1000)); // 延时1秒
        delayQueue.put(new DelayedElement(3000)); // 延时3秒
        delayQueue.put(new DelayedElement(2000)); // 延时2秒

        // 从延时队列中获取元素（阻塞方式）
        System.out.println("开始获取延时元素：");
        while (!delayQueue.isEmpty()) {
            DelayedElement element = delayQueue.take(); // 阻塞直到元素可用
            System.out.println("获取元素，延时时间：" + element.getDelay(TimeUnit.MILLISECONDS) + " 毫秒");
        }
    }
}

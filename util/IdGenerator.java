package util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger productId = new AtomicInteger(1000);
    private static final AtomicInteger orderId = new AtomicInteger(5000);

    public static int generateProductId() {
        return productId.incrementAndGet();
    }

    public static int generateOrderId() {
        return orderId.incrementAndGet();
    }
}

class Task extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Task count: " + i);
            
            try {
                Thread.sleep(500); // pause for 0.5 seconds to simulate work
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        }
    }

    public static void main(String[] args) {
        // Create two thread objects
        Task t1 = new Task();
        Task t2 = new Task();

        // Set custom names (optional)
        t1.setName("Worker-1");
        t2.setName("Worker-2");

        // Start both threads
        t1.start();
        t2.start();
    }
}

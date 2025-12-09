class Task extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Task count: " + i);
            
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        }
    }

    public static void main(String[] args) {
        Task t1 = new Task();
        Task t2 = new Task();

        t1.setName("Worker-1");
        t2.setName("Worker-2");

        t1.start();
        t2.start();
    }
}
